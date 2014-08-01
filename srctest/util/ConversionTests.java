package util;

import static org.junit.Assert.*;

import org.junit.*;

public class ConversionTests {

	IConversion _testObject;
	
	@Before
	public void setup(){
		_testObject = new Conversion();
	}
	
	@Test
	public void hexToDecimal_one(){
		int actual = _testObject.hexToDecimal("0101");
		
		assertEquals(257, actual);
	}

	@Test
	public void hexToDecimal_ten(){
		int actual = _testObject.hexToDecimal("0A");
		
		assertEquals(10, actual);
	}

	@Test
	public void hexToDecimal_test(){
		int actual = _testObject.hexToDecimal("0A");
		
		assertEquals(10, actual);
	}

	@Test
	public void hexToDecimal_return_null_on_error(){
		Integer actual = _testObject.hexToDecimal("NOT HEX CODE");
		
		assertEquals(null, actual);
	}
}
