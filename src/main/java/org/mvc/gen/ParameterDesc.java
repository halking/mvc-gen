package org.mvc.gen;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.util.StringUtils;
import org.mvc.util.VerdictUtil;

public class ParameterDesc {

	private String name;
	private Class<?> returnType;
	private Set<Modifier> modifiers;

	public ParameterDesc(Builder builder) {
		// TODO Auto-generated constructor stub
		this.name = builder.name;
		this.returnType = builder.returnType;
		this.modifiers = builder.modifiers;
	}

	public static Builder builder(String name, Class<?> returnType,Modifier...modifiers) {
		
		 VerdictUtil.checkArgument(StringUtils.isNotEmpty(name),"Variable name is not valid:%s", new Object[]{name});
		 VerdictUtil.checkNotNull(returnType,"Variable name is not valid:%s", new Object[]{returnType});
		return new Builder(name, returnType).addModifiers(modifiers);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getReturnType() {
		return returnType;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public Set<Modifier> getModifiers() {
		return modifiers;
	}

	public void setModifiers(Set<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

	public static class Builder {
		public String name;
		public Class<?> returnType;
		public Set<Modifier> modifiers = new HashSet<Modifier>();

		private Builder(String name, Class<?> returnType) {
			this.name = name;
			this.returnType = returnType;
		}

		public Builder addModifiers(Modifier... modifiers) {
			Collections.addAll(this.modifiers, modifiers);
			return this;
		}

		public ParameterDesc build() {
			return new ParameterDesc(this);
		}
	}
}
