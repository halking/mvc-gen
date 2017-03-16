package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import org.mvc.conf.MethodConstant;
import org.mvc.conf.PropertyFactory;
import org.mvc.poet.PoetApply;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;

public class CodeGenMain {

	public static void main(String[] args) {
		
		String root = System.getProperty("user.dir");
		File file = new File(root + "/src/main/java/baseconf.properties");
		try {
			PropertyFactory factory = new PropertyFactory(file);
			boolean flag = true;
			String[] ignores ={"CountryCodeMapping","Export","LocalModel","LocalModelLabel","LocalModelOverwrite","LocalModelLabel"};
			Set<String> noreSet = Arrays.stream(ignores).collect(Collectors.toSet());
//			List<MethodSpec> methodList = addMethod();
//			PoetApply apply = PoetApply.codeBuilder(factory,methodList).build();
//			PoetApply apply = PoetApply.codeBuilder(factory,methodList).defaultFlag(flag).build();
//			PoetApply apply = PoetApply.codeBuilder(factory).build();
			PoetApply apply = PoetApply.codeBuilder(factory,flag).build();
			apply.buildAllDefault(null);
//			apply.buildAllDefault(noreSet);
//			apply.buildAllManual(noreSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<MethodSpec> addMethod() {
		ParameterSpec parameterSpec = ParameterSpec.builder(String.class,"order").build();
		List<MethodSpec> methodList = new ArrayList<MethodSpec>();
		for (String method:MethodConstant.methods) {
			MethodSpec methodDesc = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC).returns(Integer.class)
					.addParameter(parameterSpec).addStatement("return null").build();
			methodList.add(methodDesc);
		}
		return methodList;
	}
}
