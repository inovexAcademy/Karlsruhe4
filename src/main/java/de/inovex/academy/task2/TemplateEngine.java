package de.inovex.academy.task2;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {
	
	private String template;

	public TemplateEngine(String template) {
		this.template = template;
	}
	
	public String render(Map<String, String> vars) throws PlaceHolderException, UnmatchedPlaceholderException {
		
		if(!validate(vars))
			throw new UnmatchedPlaceholderException();
		
		for (String var : vars.8keySet()) {
			
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
	
	public boolean validate(Map<String, String> vars){
		
		
		
		
	}
	
	public Set<String> parsePlaceholderFromTemplate(){
		
		Pattern pattern = Pattern.compile("\\${(.+?)}");
		
		Matcher matcher = pattern.matcher(template);
		
		while (matcher.find()) {
			
		}
		
	}

}
