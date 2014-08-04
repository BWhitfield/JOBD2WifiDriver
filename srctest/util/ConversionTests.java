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

	@Test
	public void hexToDecimal_return_null_on_empty_string(){
		Integer actual = _testObject.hexToDecimal("");
		
		assertEquals(null, actual);
	}
	
	@Test
	public void hexToBinary_three(){
		String actual = _testObject.hexToBinary("3");
		
		assertEquals("0011", actual);
	}
	
	@Test
	public void hexToBinary_five(){
		String actual = _testObject.hexToBinary("5");
		
		assertEquals("0101", actual);
	}
	
	@Test
	public void hexToBinary_complex(){
		String actual = _testObject.hexToBinary("43");
		
		assertEquals("01000011", actual);
	}
	
	@Test
	public void hexToBinary_return_null_on_error(){
		String actual = _testObject.hexToBinary("NOT HEX CODE");
		
		assertEquals(null, actual);
	}

	@Test
	public void hexToBinary_return_null_on_empty_string(){
		String actual = _testObject.hexToBinary("");
		
		assertEquals(null, actual);
	}
}
