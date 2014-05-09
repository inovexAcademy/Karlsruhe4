package de.inovex.academy.csd.legacy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FieldCreatorTest {
	@Test
	public void testFieldCreator() {
		FieldCreator fieldCreator = new FieldCreator();
		assertThat(fieldCreator.getFieldByName("Country"), instanceOf(ComboBox.class));
		assertThat(fieldCreator.getFieldByName("Name"), instanceOf(TextField.class));

	}
	
}
