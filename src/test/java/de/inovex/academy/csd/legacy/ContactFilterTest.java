package de.inovex.academy.csd.legacy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Cascading;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.data.Item;
import com.vaadin.data.Property;

@RunWith(JMockit.class)
public class ContactFilterTest {
	
	@Cascading Item item;
	
	@Test
	public void testContactFilterFound() {
		ContactFilter filter = new ContactFilter("");
		
		new NonStrictExpectations() {
			{
				item.getItemProperty(ContactFilter.FNAME); times = 1;
				item.getItemProperty(ContactFilter.LNAME); times = 1;
				item.getItemProperty(ContactFilter.COMPANY); times = 1;
			}
		};
		
		filter.passesFilter(null, item);
	}
	
	@Test
	public void testContactilterNotFound() {
		ContactFilter filter = new ContactFilter("Foo");
		
		new NonStrictExpectations() {
			{
				for (String field : AddressbookUI.fieldNames) {
					item.getItemProperty(field); times = 1;	
				}
				
			}
		};
		
		filter.passesFilter(null, item);
	}
	
}
