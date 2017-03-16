package org.mvc.poet;

import static org.mvc.util.StringUtils.letterSecondUpper;
import static org.mvc.util.StringUtils.letterUpper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.conf.MethodConstant;
import org.mvc.conf.PropertiesConstant;
import org.mvc.conf.PropertyFactory;
import org.mvc.conf.TableDesc;
import org.mvc.util.ReflectUtil;
import org.mvc.util.VerdictUtil;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class PoetApply {

	private PropertyFactory factory;
	private List<MethodSpec> methodSpecs;
	private List<ParameterSpec> parameterSpecs;
	//Ignoring set of unbuliding mudule
	private Set<String> ignores;    
	// If it is true, starting ignore module feature
	private boolean ignoreFlag = false;  

	public PoetApply(PropertyFactory factory) {
		this.factory = factory;
	}

	private PoetApply(Builder builder) {
		this.factory = builder.factory;
		this.methodSpecs = builder.methodSpecs;
		this.parameterSpecs = builder.parameterSpecs;
		this.ignores = builder.ignores;
		this.ignoreFlag = builder.ignoreFlag;
	}

	public void buildEntity(String table, List<String> columns, List<TableDesc> tableDescs) {
		try {
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
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildDao(String table, List<MethodSpec> methodSpecs) {
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

	public void buildService(String table, List<MethodSpec> methodSpecs) {
		try {
			TypeSpec typeSpec = TypeSpec.classBuilder(table + PropertiesConstant.SERVICE_SUFFIX).addModifiers(Modifier.PUBLIC)
					.addMethods(methodSpecs).build();
			JavaFile javaFile = JavaFile.builder(factory.getProperty("service.pkg"), typeSpec).build();
			javaFile.writeTo(new File(factory.getProperty("project.dir")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buildController(String table, List<MethodSpec> methodSpecs) {
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

	public void buildAllDefault(Set<String> ignores) {
		try {
			Class<Object>[] classes = ReflectUtil.getAllClasses(factory.getProperty("entity.pkg"));
			for (Class<Object> object : classes) {
				String className = object.getSimpleName();
				if (this.ignoreFlag == true && ignores != null && ignores.contains(className)) 
					continue;
				this.methodSpecs = addMethod(object);
				buildDao(className, this.methodSpecs);
				buildService(className, this.methodSpecs);
				buildController(className, this.methodSpecs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void buildAllManual(Set<String> ignores) {
		try {
			Class<Object>[] classes = ReflectUtil.getAllClasses(factory.getProperty("entity.pkg"));
			for (Class<Object> object : classes) {
				String className = object.getSimpleName();
				if (this.ignoreFlag == true && ignores != null && ignores.contains(className)) 
					continue;
				buildDao(className, this.methodSpecs);
				buildService(className, this.methodSpecs);
				buildController(className, this.methodSpecs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void buildModuleInterface(String... params) {

	}

	private static List<MethodSpec> addMethod(Class<Object> clazz) {
		List<MethodSpec> methodSpecs = new ArrayList<MethodSpec>();
		String objectResult = "$T result = new $T()";
		String listResult = "$T result = new $T<>()";
		try {
			String param = letterSecondUpper(clazz.getSimpleName());
			ClassName classObject = ClassName.get(clazz);
			ClassName list = ClassName.get("java.util", "List");
			ClassName arrayList = ClassName.get("java.util", "ArrayList");
			TypeName listOfObject = ParameterizedTypeName.get(list, classObject);
			for (String method : MethodConstant.methods) {
				if (method.startsWith("delete") || method.trim().startsWith("update")) {
					ParameterSpec parameterSpec = ParameterSpec.builder(String.class, "id").build();
					MethodSpec methodSpec = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(Integer.class)
							.addParameter(parameterSpec).addStatement("return null").build();
					methodSpecs.add(methodSpec);
				}
				if (method.equals(MethodConstant.FIND_ENTITY)) {
					ParameterSpec parameterSpec = ParameterSpec.builder(classObject, param).build();
					MethodSpec methodSpec = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(classObject)
							.addParameter(parameterSpec).addStatement(objectResult, classObject, classObject).addStatement("return result")
							.build();
					methodSpecs.add(methodSpec);
				}
				if (method.equals(MethodConstant.FIND_ENTITY_LIST)) {
					ParameterSpec parameterSpec = ParameterSpec.builder(classObject, param).build();
					MethodSpec methodSpec = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(listOfObject)
							.addParameter(parameterSpec).addStatement(listResult, listOfObject, arrayList).addStatement("return result")
							.build();
					methodSpecs.add(methodSpec);
				}
				if (method.equalsIgnoreCase(MethodConstant.INSERT_ENTITY)) {
					ParameterSpec parameterSpec = ParameterSpec.builder(String.class, "id").build();
					MethodSpec methodSpec = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(Integer.class)
							.addParameter(parameterSpec).addStatement("return null").build();
					methodSpecs.add(methodSpec);
				}
				if (method.equalsIgnoreCase(MethodConstant.INSERT_LIST)) {
					ParameterSpec parameterSpec = ParameterSpec.builder(listOfObject, param + "s").build();
					MethodSpec methodSpec = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(Integer.class)
							.addParameter(parameterSpec).addStatement("return null").build();
					methodSpecs.add(methodSpec);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return methodSpecs;
	}

	public static Builder codeBuilder(PropertyFactory factory, MethodSpec... methodSpec) {
		return new Builder(factory).addMethodDesc(methodSpec);
	}

	public static Builder codeBuilder(PropertyFactory factory, List<MethodSpec> methodSpecs) {
		return new Builder(factory).addMethodDescs(methodSpecs);
	}

	public static Builder codeBuilder(PropertyFactory factory) {
		return new Builder(factory);
	}
	public static Builder codeBuilder(PropertyFactory factory,boolean flag) {
		return new Builder(factory,flag);
	}
	public PoetApply addMethodDescs(Iterable<MethodSpec> methodSpecs) {
		VerdictUtil.checkNotNull(methodSpecs, "methodSpec==null", new Object[0]);
		for (MethodSpec methodSpec : methodSpecs) {
			this.methodSpecs.add(methodSpec);
		}
		return this;
	}

	public static class Builder {
		private PropertyFactory factory = new PropertyFactory();
		private List<MethodSpec> methodSpecs = new ArrayList<MethodSpec>();
		private List<ParameterSpec> parameterSpecs = new ArrayList<ParameterSpec>();
		private Set<String> ignores = new HashSet<String>();
		private boolean ignoreFlag;

		private Builder(PropertyFactory factory) {
			this.factory = factory;
		}
		private Builder(PropertyFactory factory,boolean flag) {
			this.factory = factory;
			this.ignoreFlag =flag;
		}
		public Builder addMethodDesc(MethodSpec[] methodSpec) {
			Collections.addAll(this.methodSpecs, methodSpec);
			return this;
		}

		public Builder addMethodDescs(Iterable<MethodSpec> methodSpecs) {
			VerdictUtil.checkNotNull(methodSpecs, "methodSpec==null", new Object[0]);
			for (MethodSpec methodSpec : methodSpecs) {
				this.methodSpecs.add(methodSpec);
			}
			return this;
		}

		public Builder addParameterDesc(ParameterSpec[] parameterSpecs) {
			Collections.addAll(this.parameterSpecs, parameterSpecs);
			return this;
		}

		public Builder addIgnoresModel(Set<String> ignores) {
			this.ignores = ignores;
			return this;
		}
		public Builder defaultFlag(boolean flag) {
			this.ignoreFlag = flag;
			return this;
		}
		public PoetApply build() {
			return new PoetApply(this);
		}
	}
}
