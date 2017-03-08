package org.mvc.gen;

import java.util.Collections;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.mvc.api.AbstractBaseSpec;
import org.mvc.util.VerdictUtil;

public class MethodDesc extends AbstractBaseSpec{
	
	public MethodDesc(Builder builder) {
		// TODO Auto-generated constructor stub
		this.name = builder.name;
		this.returnType = builder.returnType;
		this.modifiers = VerdictUtil.immutableSet(builder.modifiers);
	}
	 
	public static Builder builder(String name,String returnType,Modifier... modifier) {
		VerdictUtil.checkNotNull(name, "variable name is null", new Object[0]);
		VerdictUtil.checkNotNull(returnType, "variable name is null", new Object[0]);
		return new Builder(name,returnType).addModifiers(modifier);
	}
	
	static class Builder{
		public  String name;
		public  String returnType;
		public Set<Modifier> modifiers;
		
		private   Builder(String name,String returnType) {
			this.name = name;
			this.returnType = returnType;
		}
		public  Builder addModifiers(Modifier[] modifiers){
			Collections.addAll(this.modifiers, modifiers);
			return this;
		}
		public MethodDesc build() {
			return new MethodDesc(this);
		}
	}
}
