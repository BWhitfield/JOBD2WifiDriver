package logic;

import java.io.IOException;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import util.ICommander;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommandFactoryTests {

	ICommandFactory _testObject;
	
	@Mock IResponseCleaner _responseCleaner; 
	@Mock IEcuMath _ecuMath;
	@Mock ICommander _commander;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		_testObject = new CommandFactory(_ecuMath, _commander, _responseCleaner);
	}
	
	@Test
	public void obd2Value_cleans_response() throws Exception{
		String ecuHex = "0x0ff03";
		when(_commander.obd2("01", "temp")).thenReturn(ecuHex);
		
		_testObject.obd2Value("01","temp");
		
		verify(_responseCleaner).clean(ecuHex);
	}
	
	@Test
	public void obd2Value_RPM() throws Exception{
		String ecuHex = "0x0ff03";
		String cleanEcuHex = "010C";
		String expected = "1234";

		when(_commander.obd2("01", "0C")).thenReturn(ecuHex);
		when(_responseCleaner.clean(ecuHex)).thenReturn(cleanEcuHex);
		when(_ecuMath.rpm(cleanEcuHex)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01","0C");
		
		verify(_responseCleaner).clean(ecuHex);
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_Load() throws Exception{
		String ecuHex = "0x0ff03";
		String cleanEcuHex = "010C";
		String expected = "1234";
		
		when(_commander.obd2("01", "04")).thenReturn(ecuHex);
		when(_responseCleaner.clean(ecuHex)).thenReturn(cleanEcuHex);
		when(_ecuMath.load(cleanEcuHex)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01","04");
		
		verify(_responseCleaner).clean(ecuHex);
		assertEquals(expected, actual);
	}
}
