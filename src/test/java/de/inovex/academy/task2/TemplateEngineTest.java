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
	
	private String defaultTemplate;
	private Map<String, String> defaultVars;
	
	public TemplateEngineTest() {
		defaultVars = new HashMap<String, String>();
		
		defaultVars.put("vorname", "Klaus");
		defaultVars.put("nachname", "Meyer");
		defaultVars.put("geschlecht", "nix");
		
		defaultTemplate = "Hallo ${vorname} ${nachname}";
	}
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
		
		assertThat(getTemplateEngine(defaultTemplate).render(vars), is("Hallo Klaus Meyer"));
	}
	
	@Test
	public void testContainsPlaceHolder() {
		assertThat(getTemplateEngine(defaultTemplate).containsPlaceHolder("geschlecht"), is(false));
	}
	
	@Test(expected = PlaceHolderException.class)
	public void testPlaceHolderExceptionIsThrownWhenPlaceholderNotFound() {
		getTemplateEngine(defaultTemplate).render(defaultVars);
	}
	
}
