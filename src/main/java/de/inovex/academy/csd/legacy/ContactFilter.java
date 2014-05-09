package de.inovex.academy.csd.legacy;

import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;

/*
 * A custom filter for searching names and companies in the
 * contactContainer.
 */
public class ContactFilter implements Filter {
	public static final String FNAME = "First Name";
	public static final String LNAME = "Last Name";
	public static final String COMPANY = "Company";

	
	private String needle;

	public ContactFilter(String needle) {
		this.needle = needle.toLowerCase();
	}

	public boolean passesFilter(Object itemId, Item item) {
		StringBuilder haystack = new StringBuilder();
		for(String fieldName : AddressbookUI.fieldNames) {
			haystack.append(item.getItemProperty(fieldName).getValue());
		}
		
		return haystack.toString().contains(needle);
	}

	public boolean appliesToProperty(Object id) {
		return true;
	}
}
