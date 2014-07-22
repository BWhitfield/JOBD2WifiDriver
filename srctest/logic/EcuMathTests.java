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
}
