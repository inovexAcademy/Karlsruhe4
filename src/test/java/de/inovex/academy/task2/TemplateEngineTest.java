package de.inovex.academy.task2;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static java.util.Arrays.asList;

public class TemplateEngineTest {
	
	private TemplateEngine engine;

	@Before
	public void setup() {
		this.engine = new TemplateEngine();
	}

	@Test
	public void renderTemplate() {
		assertThat(engine.render(new HashMap<String, String>()), is("Hallo"));
	}
}
