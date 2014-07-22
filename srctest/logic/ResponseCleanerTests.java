package logic;

import static org.junit.Assert.*;
import main.Commands;

import org.junit.Before;
import org.junit.Test;

public class ResponseCleanerTests {

	IResponseCleaner _testObject;
	
	@Before
	public void setup(){
		_testObject = new ResponseCleaner();
	}
	
	@Test
	public void clean(){
		String actual = _testObject.clean("41 0C 123 456");
		assertEquals("123456",actual);
	}
	
	@Test
	public void clean_duplicate_command(){
		String actual = _testObject.clean("41 0C 0C 123");
		assertEquals("0C123",actual);
	}

	@Test
	public void clean_duplicate_mode(){
		String actual = _testObject.clean("41 0C 41 0C");
		assertEquals("410C",actual);
	}

	@Test
	public void clean_removes_search(){
		String actual = _testObject.clean("41 0C SEARCH 41 0C");
		assertEquals("410C",actual);
	}
}
