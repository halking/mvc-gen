package org.mvc.gen;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

public class InnerMethod {
	private List<Method> methods;

	public boolean isEmpty() {
		return methods.isEmpty();
	}

	public boolean add(Method e) {
		return methods.add(e);
	}

	public boolean addAll(Collection<? extends Method> c) {
		return methods.addAll(c);
	}

	public List<Method> getMethods() {
		return methods;
	}
}
