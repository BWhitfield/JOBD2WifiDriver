package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EcuMathTests {

	IEcuMath _testObject;
	
	@Before
	public void setup(){
		_testObject = new EcuMath();
	}
	
	@Test
	public void rpm(){
		String actual = _testObject.rpm("0101");
		
		assertEquals("64.25",actual);
	}

	@Test
	public void rpm_null(){
		String actual = _testObject.rpm(null);
		
		assertEquals("",actual);
	}

	@Test
	public void rpm_empty(){
		String actual = _testObject.rpm("");
		
		assertEquals("",actual);
	}

	@Test
	public void load(){
		String actual = _testObject.load("0A");
		
		assertEquals("3.92",actual);
	}
	
	@Test
	public void load_null(){
		String actual = _testObject.load(null);
		
		assertEquals("",actual);
	}
	
	@Test
	public void load_empty(){
		String actual = _testObject.load("");
		
		assertEquals("",actual);
	}
	
	@Test
	public void maf(){
		String actual = _testObject.maf("0A0C");
		
		assertEquals("25.72",actual);
	}
	
	@Test
	public void maf_null(){
		String actual = _testObject.maf(null);
		
		assertEquals("",actual);
	}
	
	@Test
	public void maf_empty(){
		String actual = _testObject.maf("");
		
		assertEquals("",actual);
	}
}
