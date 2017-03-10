package org.mvc.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.util.VerdictUtil;

public class MethodDesc {

	private String name;
	private Class<?> returnType;
	private Set<Modifier> modifiers;
	private List<ParameterDesc> parameterDescs;

	private MethodDesc(Builder builder) {
		// TODO Auto-generated constructor stub
		this.name = builder.name;
		this.returnType = builder.returnType;
		this.modifiers = VerdictUtil.immutableSet(builder.modifiers);
		this.parameterDescs = VerdictUtil.immutableList(builder.parameterDescs);
	}

	public static Builder builder(String name, Class<?> returnType) {
		VerdictUtil.checkNotNull(name, "variable name is null", new Object[0]);
		VerdictUtil.checkNotNull(returnType, "variable name is null", new Object[0]);
		return new Builder(name, returnType);
	}

	public List<ParameterDesc> getParameterDescs() {
		return parameterDescs;
	}

	public void setParameterDescs(List<ParameterDesc> parameterDescs) {
		this.parameterDescs = parameterDescs;
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

	public final static class Builder {
		private String name;
		private Class<?> returnType;
		private Set<Modifier> modifiers = new HashSet<Modifier>();
		private List<ParameterDesc> parameterDescs = new ArrayList<ParameterDesc>();

		private Builder(String name, Class<?> returnType) {
			this.name = name;
			this.returnType = returnType;
		}

		public Builder addModifiers(Modifier... modifiers) {
			Collections.addAll(this.modifiers, modifiers);
			return this;
		}

		public Builder addParameters(ParameterDesc... parameterDescs) {
			Collections.addAll(this.parameterDescs, parameterDescs);
			return this;
		}

		public MethodDesc build() {
			return new MethodDesc(this);
		}
	}
}
