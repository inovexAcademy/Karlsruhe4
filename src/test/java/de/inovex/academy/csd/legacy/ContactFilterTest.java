package de.inovex.academy.csd.legacy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

import mockit.Cascading;
import mockit.NonStrictExpectations;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class ContactFilterTest {
	
	@Cascading Item item;
	
	@Test
	public void testContactFilter() {
		ContactFilter filter = new ContactFilter("");
		
		new NonStrictExpectations() {
			{
				item.getItemProperty(anyString).getValue(); times = 3; result = "Hallo";
			}
		};
		
		assertTrue(filter.passesFilter(null, item));
	}
	
}
