package de.inovex.academy.task2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

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
	public void renderTemplate() throws PlaceHolderException, UnmatchedPlaceholderException {
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
	public void testPlaceHolderExceptionIsThrownWhenPlaceholderNotFound() throws PlaceHolderException, UnmatchedPlaceholderException {
		getTemplateEngine(defaultTemplate).render(defaultVars);
	}
	
	@Test
	public void testParsing(){
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("vorname");
		expectedSet.add("nachname");
		assertThat(getTemplateEngine(defaultTemplate).parsePlaceholderFromTemplate(), equalTo(expectedSet));
	}
	
}
