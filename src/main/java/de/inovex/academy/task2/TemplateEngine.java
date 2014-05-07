package de.inovex.academy.task2;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {
	
	private String template;

	public TemplateEngine(String template) {
		this.template = template;
	}
	
	public String render(Map<String, String> vars) {
		for (String var : vars.keySet()) {
			template = template.replace("${" + var + "}", vars.get(var));
		}
		
		return template;
	}

}
