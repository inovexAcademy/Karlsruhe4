package de.inovex.academy.csd.legacy;

import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;

/*
 * A custom filter for searching names and companies in the
 * contactContainer.
 */
public class ContactFilter implements Filter {
	private static final String FNAME = "First Name";
	private static final String LNAME = "Last Name";
	private static final String COMPANY = "Company";

	
	private String needle;

	public ContactFilter(String needle) {
		this.needle = needle.toLowerCase();
	}

	public boolean passesFilter(Object itemId, Item item) {
		String haystack = ("" + item.getItemProperty(FNAME).getValue()
				+ item.getItemProperty(LNAME).getValue() + item
				.getItemProperty(COMPANY).getValue()).toLowerCase();
		return haystack.contains(needle);
	}

	public boolean appliesToProperty(Object id) {
		return true;
	}
}
