package org.mvc.poet;

import javax.lang.model.element.Modifier;

import org.mvc.api.BaseSpec;
import org.mvc.api.PropertyHolder;
import org.mvc.conf.PropertyFactory;
import org.mvc.conf.TableDesc;
import org.mvc.gen.MethodDesc;
import org.mvc.gen.ParameterDesc;
import org.mvc.util.VerdictUtil;

import static org.mvc.util.StringUtils.letterSecondUpper;
import static org.mvc.util.StringUtils.letterUpper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Table;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class PoetApply {

	private PropertyFactory factory;
	private Set<MethodDesc> methodDescs;
	private Set<ParameterDesc> parameterDescs;
	private Object[] ignores;
	private static List<String> tables = new ArrayList<String>();
	public PoetApply(Builder builder) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.methodDescs = builder.methodDescs;
		this.parameterDescs=builder.parameterDescs;
		this.ignores = ignores;
	}
	public static void transTable(List<String> table) {
		tables = table;
	}
	public static void buildEntity(String table, List<String> columns,List<TableDesc> tableDescs) {
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
			MethodSpec getMethod = MethodSpec.methodBuilder("get" + methodName).addModifiers(Modifier.PUBLIC).returns(String.class)
					.addStatement("return $N", field).build();
			fieldSpecs.add(fieldSpec);
			setMethods.add(setMethod);
			getMethods.add(getMethod);
		}

		typeSpec = TypeSpec.classBuilder(table).addModifiers(Modifier.PUBLIC).addFields(fieldSpecs).addMethods(setMethods)
				.addMethods(getMethods).build();
		JavaFile javaFile = JavaFile.builder("org.mvc.poet", typeSpec).build();
		try {
			javaFile.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void buildDao(String table,Object[] ignores) {
		
	}

	public static void buildService(String table,Object[] ignores) {

	}

	public static void buildController(String table,Object[] ignores) {

	}

	public static void buildCommonInterface(String... params) {

	}
	public static void BuildAll() {
		List<MethodSpec> daoList = new ArrayList<MethodSpec>();
		List<MethodSpec> serviceList = new ArrayList<MethodSpec>();
		List<MethodSpec> conList = new ArrayList<MethodSpec>();
		for (int i = 0; i < tables.size(); i++) {
			
		}
	}
	public static void buildModuleInterface(String... params) {

	}
	public static Builder codeBuilder(PropertyFactory factory,MethodDesc[] methodDesc,ParameterDesc[] parameterDesc) {
		return new Builder(factory).addMethodDesc(methodDesc).addParameterDesc(parameterDesc);
	}
	static class Builder{
		private PropertyFactory factory;
		private Set<MethodDesc> methodDescs;
		private Set<ParameterDesc> parameterDescs;
		private Object[] ignores;
		
		public Builder(PropertyFactory factory) {
			VerdictUtil.checkNotNull(factory,"factory is null",new Object[0]);
			this.factory = factory;
		}
		public  Builder addMethodDesc(MethodDesc[] methodDesc){
			Collections.addAll(this.methodDescs, methodDesc);
			return this;
		}
		public  Builder addParameterDesc(ParameterDesc[] parameterDescs){
			Collections.addAll(this.parameterDescs, parameterDescs);
			return this;
		}
		public  Builder addIgnoresModel(Object[] ignores){
			this.ignores =ignores;
			return this;
		}
		public PoetApply built(){
			return new PoetApply(this);
		}
	}
}
