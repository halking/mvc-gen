## **MvcGen** ##
MvcGen is a code generator of mvc pattern. It use JavaPoet to generate field,
method,parameter,class and .java file.
baseconf.properties is base configurted file.

Example:
     		String root = System.getProperty("user.dir");
		File file = new File(root + "/src/main/java/baseconf.properties");
		try {
			PropertyFactory factory = new PropertyFactory(file);
			PoetApply apply = PoetApply.codeBuilder(factory).build();
			apply.buildAllDefault(null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
