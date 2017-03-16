package test;

import java.util.ArrayList;
import java.util.List;

import org.mvc.util.ReflectUtil;

public class TbaleTest {
	public static void main(String[] args) {
		String str = "ORDER_LINE_INFORMATION";
		str = str.toLowerCase();
		int sepIndex = str.indexOf("_");
		System.out.println(sepIndex);
//		System.out.println(sepIndex);
		char[] up = str.toCharArray();
		up[0] -=32;
		System.out.println(String.valueOf(up));
		
		System.out.println(org.mvc.util.StringUtils.letterUpper(str));
		String name = "deciaml(10,1)";
		int preInd = name.indexOf("(");
		int end = name.indexOf(")");
//		int a = Integer.valueOf(name.substring(preInd+1, end));
		System.out.println(name.substring(0, preInd));
		System.out.println(String.class);
		List<String> aList = new ArrayList<String>();
		aList.add("a");
		aList.add("b");
		System.out.println(aList.get(1));
		Class<Object>[] classes = ReflectUtil.getAllClasses("org.mvc.util");
		for (Class<Object> class1 : classes) {
			System.out.println(class1);
		}
	}
}
