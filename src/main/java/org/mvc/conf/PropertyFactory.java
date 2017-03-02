package org.mvc.conf;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.mvc.api.PropertyHolder;
import org.mvc.util.JdbcUtil;
import org.xml.sax.InputSource;

public class PropertyFactory extends PropertyHolder {
	public PropertyFactory() {
		super();
	}

	public PropertyFactory(File file) throws IOException {
		super();
		this.parseConfiguration(file);
	}

	public PropertyFactory(String path) throws IOException {
		super();
		File file = new File(path);
		this.parseConfiguration(file);
	}

	public void parseConfiguration(File file) throws IOException {
		FileReader reader = new FileReader(file);
		this.parseConfiguration(reader);
	}

	public void parseConfiguration(InputStream stream) {

	}

	public void parseConfiguration(Reader reader) throws IOException {
		this.getProperties().load(reader);
		JdbcUtil.initialize(this);
	}

	public void parseConfiguration(InputSource source) {
		// todo
	}
}
