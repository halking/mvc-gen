package org.mvc.api;

import java.util.Properties;

public abstract class PropertyHolder {
	private Properties properties;

	public PropertyHolder() {
		this.properties = new Properties();
	}

	public void addProperties(String name, String value) {
		properties.setProperty(name, value);
	}

	public String getProperty(String name) {
		return this.getProperties().getProperty(name);
	}

	public Properties getProperties() {
		if (this.properties == null) {
			this.properties = new Properties();
		}
		return this.properties;
	}

}
