# mvc-gen
a code generator of mvc pattern.

Example:

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
