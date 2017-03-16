## **MvcGen** ##

MvcGen is a code generator of mvc pattern. It use JavaPoet to generate field,
method,parameter,class and .java file.
baseconf.properties is base configurted file.

Example:
----
Here's a demo that build default class and method.
```java
String root = System.getProperty("user.dir");
File file = new File(root + "/src/main/java/baseconf.properties");
try {
PropertyFactory factory = new PropertyFactory(file);
PoetApply apply = PoetApply.codeBuilder(factory).build();
apply.buildAllDefault(null);
} catch (Exception e) {
e.printStackTrace();
}
```
Which builds codes of entity,dao,service,controller.

Of course, you can build alternative module by setting the ignores and flag value of the `PoetApply`.
```java
String root = System.getProperty("user.dir");
File file = new File(root + "/src/main/java/baseconf.properties");
try {
	PropertyFactory factory = new PropertyFactory(file);
	boolean flag = true;
	String[] ignores ={"CountryCodeMapping","Export","LocalModel","LocalModelLabel","LocalModelOverwrite","LocalModelLabel"};
	Set<String> noreSet = Arrays.stream(ignores).collect(Collectors.toSet());
	PoetApply apply = PoetApply.codeBuilder(factory,flag).build();
	apply.buildAllDefault(noreSet);
} catch (Exception e) {
	e.printStackTrace();
}
```
The set of ignores is the unbuild module, and
the flag set up true and will open the feature that ignore module in ignores set.
