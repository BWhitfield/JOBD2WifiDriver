package logic;

import org.junit.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class DTCTests {

	IDTC _testObject;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		_testObject = new DTC();
	}
	
	@Test
	public void getPrefix_P0() throws Exception{
		String actual = _testObject.getPrefix("0");
		assertEquals("P0", actual);
	}

	@Test
	public void getPrefix_P1() throws Exception{
		String actual = _testObject.getPrefix("1");
		assertEquals("P1", actual);
	}
	
	@Test
	public void getPrefix_P2() throws Exception{
		String actual = _testObject.getPrefix("2");
		assertEquals("P2", actual);
	}
	
	@Test
	public void getPrefix_P3() throws Exception{
		String actual = _testObject.getPrefix("3");
		assertEquals("P3", actual);
	}
	
	@Test
	public void getPrefix_C0() throws Exception{
		String actual = _testObject.getPrefix("4");
		assertEquals("C0", actual);
	}
	
	@Test
	public void getPrefix_C1() throws Exception{
		String actual = _testObject.getPrefix("5");
		assertEquals("C1", actual);
	}

	@Test
	public void getPrefix_C2() throws Exception{
		String actual = _testObject.getPrefix("6");
		assertEquals("C2", actual);
	}
	
	@Test
	public void getPrefix_C3() throws Exception{
		String actual = _testObject.getPrefix("7");
		assertEquals("C3", actual);
	}
	
	@Test
	public void getPrefix_B0() throws Exception{
		String actual = _testObject.getPrefix("8");
		assertEquals("B0", actual);
	}
	
	@Test
	public void getPrefix_B1() throws Exception{
		String actual = _testObject.getPrefix("9");
		assertEquals("B1", actual);
	}
	
	@Test
	public void getPrefix_B2() throws Exception{
		String actual = _testObject.getPrefix("A");
		assertEquals("B2", actual);
	}
	
	@Test
	public void getPrefix_B3() throws Exception{
		String actual = _testObject.getPrefix("B");
		assertEquals("B3", actual);
	}
	
	@Test
	public void getPrefix_U0() throws Exception{
		String actual = _testObject.getPrefix("C");
		assertEquals("U0", actual);
	}
	
	@Test
	public void getPrefix_U1() throws Exception{
		String actual = _testObject.getPrefix("D");
		assertEquals("U1", actual);
	}
	
	@Test
	public void getPrefix_Default() throws Exception{
		String actual = _testObject.getPrefix("J");
		assertEquals("Unknown DTC", actual);
	}
	
	@Test
	public void getPrefix_Default_2() throws Exception{
		String actual = _testObject.getPrefix("10");
		assertEquals("Unknown DTC", actual);
	}
}
