package org.mvc.poet;

import javax.lang.model.element.Modifier;

import static org.mvc.util.StringUtils.letterSecondUpper;
import static org.mvc.util.StringUtils.letterUpper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class PoetApply {

	public static void buildEntity(String table, List<String> columns) {
		TypeSpec typeSpec = null;
		List<FieldSpec> fieldSpecs = new ArrayList<FieldSpec>();
		List<MethodSpec> setMethods = new ArrayList<MethodSpec>();
		List<MethodSpec> getMethods = new ArrayList<MethodSpec>();
		for (String column : columns) {
			String field = letterSecondUpper(column);
			String methodName = letterUpper(column);
			FieldSpec fieldSpec = FieldSpec.builder(String.class, field, Modifier.PRIVATE).build();
			ParameterSpec parameterSpec = ParameterSpec.builder(String.class, field).build();
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

	public static void buildDao(String... params) {

	}

	public static void buildService(String... params) {

	}

	public static void buildController(String... params) {

	}
}
