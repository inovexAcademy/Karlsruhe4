package de.inovex.academy.csd.legacy;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

import java.util.Arrays;

public class FieldCreator {
	public Field<?> getFieldByName(String fieldName) {
		if ("Country".equals(fieldName)) {
			return new ComboBox(fieldName, Arrays.asList("Germany", "USA"));
		} else {
			return new TextField(fieldName);
		}
	}
}
 