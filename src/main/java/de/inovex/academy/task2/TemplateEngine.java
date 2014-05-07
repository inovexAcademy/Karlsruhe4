package de.inovex.academy.task2;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {
	
	private String template;

	public TemplateEngine(String template) {
		this.template = template;
	}
	
	public String render(Map<String, String> vars) throws PlaceHolderException {
		for (String var : vars.keySet()) {
			
			if (!containsPlaceHolder(var)) {
				throw new PlaceHolderException();
			}
			
			template = template.replace("${" + var + "}", vars.get(var));
		}
		
		return template;
	}
	
	public boolean containsPlaceHolder(String placeholder) {
		return template.contains("${" + placeholder + "}");
	}

}
