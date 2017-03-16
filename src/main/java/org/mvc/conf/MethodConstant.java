package org.mvc.conf;

import java.util.ArrayList;
import java.util.List;

public class MethodConstant {
		public final static String UPDATE_BY_ID="updateById";
		public final static String DELETE="delete";
		public final static String FIND_ENTITY_LIST="findEntityList";
		public final static String FIND_ENTITY="findEntity";
		public final static String INSERT_ENTITY="insertEntity";
		public final static String INSERT_LIST="insertEntityList";
		public static	List<String> methods = new ArrayList<String>();
		static{
			methods.add(UPDATE_BY_ID);
			methods.add(DELETE);
			methods.add(FIND_ENTITY);
			methods.add(FIND_ENTITY_LIST);
			methods.add(INSERT_ENTITY);
			methods.add(INSERT_LIST);
		}
}
