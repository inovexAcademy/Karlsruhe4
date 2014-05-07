package de.inovex.academy.task2;

import java.util.HashMap;

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
	}
}
