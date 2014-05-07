package de.inovex.academy.task2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static java.util.Arrays.asList;

public class TemplateEngineTest {
	
	public TemplateEngine getTemplateEngine(String template) {
		return new TemplateEngine(template);
	}

	@Test
	public void renderTemplate() {
		assertThat(getTemplateEngine("Hallo").render(new HashMap<String, String>()), is("Hallo"));
		
		assertThat(getTemplateEngine("Hallo ${name}").render(Collections.singletonMap("name", "Klaus")), is("Hallo Klaus"));
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("vorname", "Klaus");
		vars.put("nachname", "Meyer");
		
		assertThat(getTemplateEngine("Hallo ${vorname} ${nachname}").render(vars), is("Hallo Klaus Meyer"));
	}
	
	@Test
	public void testContainsPlaceHolder() {
		String template = "Hallo ${vorname} ${nachname}";
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("vorname", "Klaus");
		vars.put("nachname", "Meyer");
		vars.put("geschlecht", "nix");
		
		assertThat(getTemplateEngine("Hallo ${vorname} ${nachname}").containsPlaceHolder("geschlecht"), is(false));
	}
	
	@Test(expected = PlaceHolderException.class)
	public void testPlaceHolderExceptionIsThrownWhenPlaceholderNotFound() {
		Map<String, String> vars = new HashMap<String, String>();

		vars.put("vorname", "Klaus");
		vars.put("nachname", "Meyer");
		vars.put("geschlecht", "nix");
		
		getTemplateEngine("Hallo ${vorname} ${nachname}").render(vars);
	}
	
}
