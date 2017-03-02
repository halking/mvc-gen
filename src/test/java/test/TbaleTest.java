package test;

import org.apache.commons.lang3.StringUtils;

public class TbaleTest {
	public static void main(String[] args) {
		String str = "ORDER_LINE";
		str = str.toLowerCase();
		int sepIndex = str.indexOf("_");
//		System.out.println(sepIndex);
		String first = str.substring(0, 1);
		first = first.toUpperCase();
		String sepAfter = str.substring(sepIndex,sepIndex+1);
		sepAfter.toUpperCase();
		
		char[] up = str.toCharArray();
		up[0] -=32;
		System.out.println(String.valueOf(up));
		
		System.out.println(org.mvc.util.StringUtils.letterUpper(str));
	}
}
