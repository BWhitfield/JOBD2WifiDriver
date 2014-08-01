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
		String actual = _testObject.rpm(257);
		
		assertEquals("64.25",actual);
	}

	@Test
	public void airIntakeTemp(){
		String actual = _testObject.airIntakeTemp(268);
		
		assertEquals("514.4",actual); // C * 1.8 + 32
	}

	@Test
	public void timingAdvance(){
		String actual = _testObject.timingAdvance(268);
		
		assertEquals("70.0",actual);
	}

	@Test
	public void fuelPressure(){
		String actual = _testObject.fuelPressure(268);
		
		assertEquals("804.0",actual);
	}

	@Test
	public void load(){
		String actual = _testObject.load(10);
		
		assertEquals("3.92",actual);
	}
	
	@Test
	public void maf(){
		String actual = _testObject.maf(2572);
		
		assertEquals("25.72",actual);
	}
}
