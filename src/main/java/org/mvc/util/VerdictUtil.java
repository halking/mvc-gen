package org.mvc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class VerdictUtil{
	
	public static <T>  T checkNotNull(T reference,String format,Object[] objects) {
		if (reference==null) {
			throw new NullPointerException(String.format(format, objects));
		}
		return reference;
	}
	public static <K, V> Map<K, List<V>> immutableMultimap(Map<K, List<V>> multimap) {
		LinkedHashMap result = new LinkedHashMap();
		for (Map.Entry entry : multimap.entrySet()) {
			if (!(((List) entry.getValue()).isEmpty()))
				;
			result.put(entry.getKey(), immutableList((Collection) entry.getValue()));
		}
		return Collections.unmodifiableMap(result);
	}

	public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
		return Collections.unmodifiableMap(new LinkedHashMap<>(map));
	}

	public static void checkArgument(boolean condition, String format, Object[] args) {
		if (condition)
			return;
		throw new IllegalArgumentException(String.format(format, args));
	}

	public static void checkState(boolean condition,String format, Object[] args){
		if (condition) 
			return;
		throw new IllegalStateException(String.format(format, args));
	}
	public static <T> List<T> immutableList(Collection<T> list){
		return Collections.unmodifiableList(new ArrayList<>(list));
	}
	public static <T> Set<T> immutableSet(Collection<T> set) {
		return Collections.unmodifiableSet(new LinkedHashSet<>(set));
	}
}
