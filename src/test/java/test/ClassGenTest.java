package test;

import java.io.File;
import java.sql.JDBCType;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class ClassGenTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FieldSpec first = FieldSpec.builder(String.class, "first").addModifiers(Modifier.PUBLIC).build();

		ParameterSpec parameterSpec = ParameterSpec.builder(String.class, "args1",null).build();

		MethodSpec main = MethodSpec.methodBuilder("startPoet").addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(void.class)
				.addParameter(parameterSpec).addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!").build();

		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld").addField(first).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addMethod(main).build();

		JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld).build();
		
		String path = ClassGenTest.class.getResource("/").getPath().toString();
		System.out.println(path);
		System.out.println(JDBCType.ARRAY.getName());
		 javaFile.writeTo(new File(path));
		javaFile.writeTo(System.out);
	}

}
