package org.mvc.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ReflectUtil {
	
	public static Class[] getAllClasses(String pkgName) {
		List<Class<Object>> classes = new ArrayList<Class<Object>>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		VerdictUtil.checkNotNull(classLoader, "classloader is null", new Object[0]);
		String path = pkgName.replace('.', '/');
		try {
			Enumeration<URL> enumerations = classLoader.getResources(path);
			List<File> dirs = new ArrayList<File>();
			while (enumerations.hasMoreElements()) {
				URL url = (URL) enumerations.nextElement();
				dirs.add(new File(url.getFile()));
			}
			for (File file : dirs) {
				classes.addAll(findClass(file, pkgName));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes.toArray(new Class<?>[classes.size()]);
	}

	public static List<Class<Object>> findClass(File directory, String pkgName) {
		List<Class<Object>> classes = new ArrayList<Class<Object>>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				boolean flag = file.getName().contains(".");
				VerdictUtil.checkArgument(!flag, "File is not finally a directory node", new Object[0]);
				classes.addAll(findClass(file, pkgName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				try {
					classes.add((Class<Object>) Class.forName(pkgName + "." + file.getName().substring(0, file.getName().length() - 6)));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return classes;
	}
}
