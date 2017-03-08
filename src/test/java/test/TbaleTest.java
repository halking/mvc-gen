package test;


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
		String name = "int(10)";
		int preInd = name.indexOf("(");
		int end = name.indexOf(")");
		int a = Integer.valueOf(name.substring(preInd+1, end));
		System.out.println(a);
	}
}
