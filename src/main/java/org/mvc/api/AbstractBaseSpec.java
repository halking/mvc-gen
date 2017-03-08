package org.mvc.api;

import java.util.Set;

import javax.lang.model.element.Modifier;

public abstract class AbstractBaseSpec implements BaseSpec {
		public  String name;
		public  String returnType;
		public  String parameter;
		public  String parameterType;
		public Set<Modifier> modifiers;
		
		public Set<Modifier> getModifiers() {
			return modifiers;
		}
		public void setModifiers(Set<Modifier> modifiers) {
			this.modifiers = modifiers;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getReturnType() {
			return returnType;
		}
		public void setReturnType(String returnType) {
			this.returnType = returnType;
		}
		public String getParameter() {
			return parameter;
		}
		public void setParameter(String parameter) {
			this.parameter = parameter;
		}
		public String getParameterType() {
			return parameterType;
		}
		public void setParameterType(String parameterType) {
			this.parameterType = parameterType;
		}
		
		
}
