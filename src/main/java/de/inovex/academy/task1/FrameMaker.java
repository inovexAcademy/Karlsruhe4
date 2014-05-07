package de.inovex.academy.task1;

import java.util.ArrayList;
import java.util.List;

public class FrameMaker {
	
	public List<String> makeFrame(List<String> lines) {
		List<String> result = new ArrayList<String>();
		
		int length = getWidth(lines);
		
		String header = getHeader(length + 2);
		
		result.add(header);
		
		for (String line : lines) {
			result.add("*" + line + "*");
		}
		
		result.add(header);
		
		return result;
	}
	
	public int getWidth(List<String> lines) {
		int maxLength = 0;
		
		for (String line : lines) {
			maxLength = Math.max(maxLength, line.length());
		}
		
		return maxLength;
	}
	
	public String getHeader(int width){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < width; i++)
			sb.append('*');
		
		return sb.toString();
	}

	public String getDisplayLine(String line, int width) {
		StringBuilder sb = new StringBuilder();
		
		sb.append('*');
		sb.append(line);
		
		for(int i = 0; i < width - line.length(); i++)
			sb.append(' ');
		
		sb.append('*');
		
		return sb.toString();
	}
	
}
