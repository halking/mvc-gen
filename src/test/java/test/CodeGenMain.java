package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.mvc.conf.MethodConstant;
import org.mvc.conf.PropertyFactory;
import org.mvc.gen.MethodDesc;
import org.mvc.gen.ParameterDesc;
import org.mvc.poet.PoetApply;

public class CodeGenMain {

	public static void main(String[] args) {
		
		String root = System.getProperty("user.dir");
		File file = new File(root + "/src/main/java/baseconf.properties");
		try {
			PropertyFactory factory = new PropertyFactory(file);
			ParameterDesc parameterDesc = ParameterDesc.builder("order", String.class).build();
			List<MethodDesc> methodList = new ArrayList<MethodDesc>();
			for (String method:MethodConstant.methods) {
				MethodDesc methodDesc = MethodDesc.builder(method, Integer.class).addModifiers(Modifier.PUBLIC)
						.addParameters(parameterDesc).build();
				methodList.add(methodDesc);
			}
			PoetApply apply = PoetApply.codeBuilder(factory,methodList).build();
			apply.buildAll(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
