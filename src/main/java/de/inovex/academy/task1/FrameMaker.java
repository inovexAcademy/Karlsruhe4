package de.inovex.academy.task1;

import java.util.ArrayList;
import java.util.List;

public class FrameMaker {
	
	private static final char CHAR = '*';
	private static final int BORDER_WIDTH = 1;

	public List<String> makeFrame(List<String> lines) {
		List<String> result = new ArrayList<String>();
		
		int length = getWidth(lines);
		
		String header = getHeader(length + BORDER_WIDTH * 2);
		
		result.add(header);
		
		for (String line : lines)
			result.add(getDisplayLine(line, length));
		
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
		return repeatCharacter(CHAR, width);
	}
	
	public String repeatCharacter(char c, int count){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < count; i++)
			sb.append(c);
		
		return sb.toString();
	}

	public String getDisplayLine(String line, int width) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(CHAR);
		sb.append(line);
		
		sb.append(repeatCharacter(' ', width - line.length()));
		
		sb.append(CHAR);
		
		return sb.toString();
	}
	
}
