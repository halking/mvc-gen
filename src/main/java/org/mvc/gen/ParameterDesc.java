package org.mvc.gen;

import java.util.Collections;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.api.AbstractBaseSpec;
import org.mvc.util.StringUtils;
import org.mvc.util.VerdictUtil;

public class ParameterDesc extends AbstractBaseSpec {
	public ParameterDesc(Builder builder) {
		// TODO Auto-generated constructor stub
		this.name = builder.name;
		this.returnType = builder.returnType;
		this.modifiers = VerdictUtil.immutableSet(builder.modifiers);
	}
	 
	public static Builder builder(String name,String returnType,Modifier... modifier) {
		VerdictUtil.checkArgument(StringUtils.isNotEmpty(name), "Variable name is not valid:%s", new Object[]{name});
		VerdictUtil.checkArgument(StringUtils.isNotEmpty(returnType), "Variable name is not valid:%s", new Object[]{returnType});
		return new Builder(name,returnType).addModifiers(modifier);
	}
	
	static class Builder{
		public  String name;
		public  String returnType;
		public Set<Modifier> modifiers;
		
		private  Builder(String name,String returnType) {
			this.name = name;
			this.returnType = returnType;
		}
		public  Builder addModifiers(Modifier[] modifiers){
			Collections.addAll(this.modifiers, modifiers);
			return this;
		}
		public ParameterDesc build() {
			return new ParameterDesc(this);
		}
	}
}
