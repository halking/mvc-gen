## **MvcGen** ##

MvcGen is a code generator of mvc pattern. It use [JavaPoet](https://github.com/square/javapoet/tree/master) to generate field,
method,parameter,class and `.java` file.
baseconf.properties is base configurated file.

When using `MvcGen`, please modify the corresponding conf in baseconf.properties. 

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

1、Building alternative module
---------

Of course, you can build alternative module by setting the ignores and flag value of the class `PoetApply`.
```java
String root = System.getProperty("user.dir");
File file = new File(root + "/src/main/java/baseconf.properties");
try {
	PropertyFactory factory = new PropertyFactory(file);
	boolean flag = true;
	String[] ignores ={"CountryCodeMapping","Export","LocalModel",
	"LocalModelLabel","LocalModelOverwrite","LocalModelLabel"};
	Set<String> noreSet = Arrays.stream(ignores).collect(Collectors.toSet());
	PoetApply apply = PoetApply.codeBuilder(factory,flag).build();
	apply.buildAllDefault(noreSet);
} catch (Exception e) {
	e.printStackTrace();
}
```
The set of ignores is the unbuild module, and
the flag set up true and will open the feature that ignore module in ignores set.

2、Building custom method
---------

Setting up the list value `methodSpecs` and call static method `buildAllManual` in class `PoetApply` , which is able to build custom method.
```java
public static List<MethodSpec> addMethod() {
ParameterSpec parameterSpec = ParameterSpec.builder(String.class,"order").build();
List<MethodSpec> methodList = new ArrayList<MethodSpec>();
for (String method:MethodConstant.methods) {
	MethodSpec methodDesc = MethodSpec.methodBuilder(method).addModifiers(Modifier.PUBLIC)
	.returns(Integer.class)
	.addParameter(parameterSpec).addStatement("return null").build();
	methodList.add(methodDesc);
}
return methodList;
}

 List<MethodSpec> methodList = addMethod();
 PoetApply apply = PoetApply.codeBuilder(factory,methodList).build();
 apply.buildAllManual(noreSet);
```

Combine first and second article, which can build custom method and alternative module.

```java
String root = System.getProperty("user.dir");
File file = new File(root + "/src/main/java/baseconf.properties");
try {
	PropertyFactory factory = new PropertyFactory(file);
	boolean flag = true;
	String[] ignores ={"CountryCodeMapping","Export","LocalModel",
	"LocalModelLabel","LocalModelOverwrite","LocalModelLabel"};
	Set<String> noreSet = Arrays.stream(ignores).collect(Collectors.toSet());
	List<MethodSpec> methodList = addMethod();
	PoetApply apply = PoetApply.codeBuilder(factory,methodList).defaultFlag(flag).build();
	apply.buildAllManual(noreSet);
} catch (Exception e) {
	e.printStackTrace();
}
```
DownLoad
------
Download the [latest.jar](https://github.com/halking/mvc-gen/releases) or depend via maven

```xml
<dependency>
  <groupId>com.github.halking</groupId>
  <artifactId>mvc-gen</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```
