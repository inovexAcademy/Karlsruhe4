package de.inovex.academy.task1;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static java.util.Arrays.asList;

public class FrameMakerTest {
	
	public FrameMaker getFrameMaker() {
		return new FrameMaker();
	}
	
	@Test
	public void testMakeFrame() {
		FrameMaker maker = getFrameMaker();

		assertThat(maker.makeFrame(asList("x")),
				equalTo(asList("***", "*x*", "***")));
		
		assertThat(maker.makeFrame(asList("x", "y")),
				equalTo(asList("***", "*x*", "*y*", "***")));
	}
	
	@Test
	public void calculateLineWidth() {
		FrameMaker maker = getFrameMaker();
		
		assertThat(maker.getWidth(asList("Hallo", "schoene, neue", "Welt")), equalTo(13));
	}
	
	@Test
	public void testHeader(){
		FrameMaker maker = getFrameMaker();
		
		assertThat(maker.getHeader(5), equalTo("*****"));
	}
	
	@Test
	public void testDisplayLine(){
		FrameMaker maker = getFrameMaker();
		
		assertThat(maker.getDisplayLine("Hallo", 12), equalTo("*Hallo       *"));
		assertThat(maker.getDisplayLine("Welt", 12), equalTo("*Welt        *"));
	}
	
	@Test
	public void testRepeatCharacter(){
		FrameMaker maker = getFrameMaker();
		
		assertThat(maker.repeatCharacter('g', 6), equalTo("gggggg"));
		assertThat(maker.repeatCharacter('*', 3), equalTo("***"));
	}
	
	@Test
	public void testBigThing(){
		FrameMaker maker = getFrameMaker();
		
		assertThat(maker.makeFrame(asList("Hallo", "schoene, neue", "Welt")), equalTo(asList(maker.repeatCharacter('*', 15), "*Hallo        *", "*schoene, neue*", "*Welt         *", maker.repeatCharacter('*', 15))));
	}

}
