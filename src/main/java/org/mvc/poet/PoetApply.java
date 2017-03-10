package org.mvc.poet;

import static org.mvc.util.StringUtils.letterSecondUpper;
import static org.mvc.util.StringUtils.letterUpper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.conf.PropertiesConstant;
import org.mvc.conf.PropertyFactory;
import org.mvc.conf.TableDesc;
import org.mvc.gen.MethodDesc;
import org.mvc.gen.ParameterDesc;
import org.mvc.util.VerdictUtil;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class PoetApply {

	private PropertyFactory factory;
	private Set<MethodDesc> methodDescs = new HashSet<MethodDesc>();
	private List<ParameterDesc> parameterDescs = new ArrayList<ParameterDesc>();
	private Object[] ignores;
	private static List<String> tables = new ArrayList<String>();

	public PoetApply(PropertyFactory factory) {
		this.factory = factory;
	}

	private PoetApply(Builder builder) {
		this.factory = builder.factory;
		this.methodDescs = builder.methodDescs;
		this.parameterDescs = builder.parameterDescs;
		this.ignores = builder.ignores;
	}

	public static void transTable(List<String> table) {
		tables = table;
	}

	public void buildEntity(String table, List<String> columns, List<TableDesc> tableDescs) {
		TypeSpec typeSpec = null;
		List<FieldSpec> fieldSpecs = new ArrayList<FieldSpec>();
		List<MethodSpec> setMethods = new ArrayList<MethodSpec>();
		List<MethodSpec> getMethods = new ArrayList<MethodSpec>();
		for (int i = 0; i < tableDescs.size(); i++) {
			String field = letterSecondUpper(columns.get(i));
			String methodName = letterUpper(columns.get(i));
			Class<?> clazz = ColumnMap.resolveColumnType(tableDescs.get(i));
			FieldSpec fieldSpec = FieldSpec.builder(clazz, field, Modifier.PRIVATE).build();
			ParameterSpec parameterSpec = ParameterSpec.builder(clazz, field).build();
			MethodSpec setMethod = MethodSpec.methodBuilder("set" + methodName).addModifiers(Modifier.PUBLIC).returns(void.class)
					.addParameter(parameterSpec).addStatement("this.$N = $N", field, field).build();
			MethodSpec getMethod = null;
			if (clazz == boolean.class) {
				getMethod = MethodSpec.methodBuilder("is" + methodName).addModifiers(Modifier.PUBLIC).returns(clazz)
						.addStatement("return $N", field).build();
			} else {
				getMethod = MethodSpec.methodBuilder("get" + methodName).addModifiers(Modifier.PUBLIC).returns(clazz)
						.addStatement("return $N", field).build();
			}

			fieldSpecs.add(fieldSpec);
			setMethods.add(setMethod);
			getMethods.add(getMethod);
		}

		typeSpec = TypeSpec.classBuilder(table).addModifiers(Modifier.PUBLIC).addFields(fieldSpecs).addMethods(setMethods)
				.addMethods(getMethods).build();
		JavaFile javaFile = JavaFile.builder(factory.getProperty("entity.pkg"), typeSpec).build();
		try {
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildDao(String table, List<MethodSpec> methodSpecs, Object[] ignores) {
		try {
			TypeSpec typeSpec = TypeSpec.classBuilder(table + PropertiesConstant.DAO_SUFFIX).addModifiers(Modifier.PUBLIC)
					.addMethods(methodSpecs).build();
			JavaFile javaFile = JavaFile.builder(factory.getProperty("dao.pkg"), typeSpec).build();
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
			// javaFile.writeTo(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buildService(String table, List<MethodSpec> methodSpecs, Object[] ignores) {
		try {
			TypeSpec typeSpec = TypeSpec.classBuilder(table + PropertiesConstant.SERVICE_SUFFIX).addModifiers(Modifier.PUBLIC)
					.addMethods(methodSpecs).build();
			JavaFile javaFile = JavaFile.builder(factory.getProperty("service.pkg"), typeSpec).build();
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buildController(String table, List<MethodSpec> methodSpecs, Object[] ignores) {
		try {
			TypeSpec typeSpec = TypeSpec.classBuilder(table + PropertiesConstant.CONTROLLER_SUFFIX).addModifiers(Modifier.PUBLIC)
					.addMethods(methodSpecs).build();
			JavaFile javaFile = JavaFile.builder(factory.getProperty("controller.pkg"), typeSpec).build();
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildCommonInterface(String... params) {

	}

	public void buildAll(Object[] ignores) {
		List<MethodSpec> methodList = new ArrayList<MethodSpec>();
		for (MethodDesc methodDesc : methodDescs) {
			MethodSpec methodSpec = null;
			if (methodDesc.getParameterDescs().size() < 1) {
				ParameterDesc parameterDesc = methodDesc.getParameterDescs().get(0);
				ParameterSpec parameterSpec = ParameterSpec.builder(parameterDesc.getReturnType(), parameterDesc.getName()).build();
				if (methodDesc.getReturnType() == void.class) {
					methodSpec = MethodSpec.methodBuilder(methodDesc.getName()).addModifiers(Modifier.PUBLIC)
							.returns(methodDesc.getReturnType()).addParameter(parameterSpec).build();
				} else {
					methodSpec = MethodSpec.methodBuilder(methodDesc.getName()).addModifiers(Modifier.PUBLIC)
							.returns(methodDesc.getReturnType()).addParameter(parameterSpec).addStatement("return null").build();
				}
				methodList.add(methodSpec);
			} else {
				List<ParameterSpec> paramList = new ArrayList<ParameterSpec>();
				List<ParameterDesc> parameterDescs = methodDesc.getParameterDescs();
				for (ParameterDesc parameterDesc : parameterDescs) {
					ParameterSpec parameterSpec = ParameterSpec.builder(parameterDesc.getReturnType(), parameterDesc.getName()).build();
					paramList.add(parameterSpec);
				}
				if (methodDesc.getReturnType() == void.class) {
					methodSpec = MethodSpec.methodBuilder(methodDesc.getName()).addModifiers(Modifier.PUBLIC)
							.returns(methodDesc.getReturnType()).addParameters(paramList).build();
				} else {
					methodSpec = MethodSpec.methodBuilder(methodDesc.getName()).addModifiers(Modifier.PUBLIC)
							.returns(methodDesc.getReturnType()).addParameters(paramList).addStatement("return null").build();
				}
				methodList.add(methodSpec);
			}
		}
		for (String table : tables) {
			table = letterUpper(table);
			buildDao(table, methodList, ignores);
			buildService(table, methodList, ignores);
			buildController(table, methodList, ignores);
		}
	}

	public static void buildModuleInterface(String... params) {

	}

	public static Builder codeBuilder(PropertyFactory factory, MethodDesc... methodDesc) {
		return new Builder(factory).addMethodDesc(methodDesc);
	}

	public static Builder codeBuilder(PropertyFactory factory, List<MethodDesc> methodDescs) {
		return new Builder(factory).addMethodDescs(methodDescs);
	}

	public static class Builder {
		private PropertyFactory factory = new PropertyFactory();
		private Set<MethodDesc> methodDescs = new HashSet<MethodDesc>();
		private List<ParameterDesc> parameterDescs = new ArrayList<ParameterDesc>();
		private Object[] ignores;

		private Builder(PropertyFactory factory) {
			this.factory = factory;
		}

		public Builder addMethodDesc(MethodDesc[] methodDesc) {
			Collections.addAll(this.methodDescs, methodDesc);
			return this;
		}

		public Builder addMethodDescs(Iterable<MethodDesc> methodDescs) {
			VerdictUtil.checkNotNull(methodDescs, "methodDesc==null", new Object[0]);
			for (MethodDesc methodDesc : methodDescs) {
				this.methodDescs.add(methodDesc);
			}
			return this;
		}

		public Builder addParameterDesc(ParameterDesc[] parameterDescs) {
			Collections.addAll(this.parameterDescs, parameterDescs);
			return this;
		}

		public Builder addIgnoresModel(Object[] ignores) {
			this.ignores = ignores;
			return this;
		}

		public PoetApply build() {
			return new PoetApply(this);
		}
	}
}
