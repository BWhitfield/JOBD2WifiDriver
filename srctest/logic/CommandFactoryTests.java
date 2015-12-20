package logic;

import java.io.IOException;

import main.Commands;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import util.ICommander;
import util.IConversion;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommandFactoryTests {

	ICommandFactory _testObject;
	
	@Mock IResponseCleaner _responseCleaner; 
	@Mock ICommander _commander;
	@Mock IConversion _conversion;
	@Mock IMathRouter _router;

	String CLEAN_ECU_HEX = "0101";
	int RAW_SENSOR_VAL = 1111;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		_testObject = new CommandFactory(_commander, _responseCleaner, _conversion, _router);
		String ECU_HEX = "123rt";
		
		when(_commander.obd2(anyString(), anyString())).thenReturn(ECU_HEX);
		when(_responseCleaner.clean(anyString())).thenReturn(CLEAN_ECU_HEX);
		when(_conversion.hexToDecimal(anyString())).thenReturn(RAW_SENSOR_VAL);
	}
	
	@Test
	public void obd2Value_cleans_response() throws Exception{
		String ecuHex = "0x0ff03";
		when(_commander.obd2("01", "temp")).thenReturn(ecuHex);
		
		_testObject.obd2Value("01","temp");
		
		verify(_responseCleaner).clean(ecuHex);
	}

	@Test
	public void obd2ValueRaw_returns_raw() throws Exception{
		String ecuHex = "0x0ff03";
		when(_commander.obd2("mode", "pid")).thenReturn(ecuHex);
		
		String actual = _testObject.obd2ValueRaw("mode","pid");
		
		assertEquals(ecuHex, actual);
	}

	@Test
	public void obd2Value_converts_hex_to_decimal() throws Exception{
		String ecuHex = "0x0ff03";
		String cleanHex = "CLEAN_HEX";

		when(_commander.obd2("01", "temp")).thenReturn(ecuHex);
		when(_responseCleaner.clean(ecuHex)).thenReturn(cleanHex);
		
		_testObject.obd2Value("01","temp");
		
		verify(_conversion).hexToDecimal(cleanHex);
	}
	
	@Test
	public void obd2_routes() throws IOException{
		String expected = "expected";
		when(_router.route(Commands.RPM, RAW_SENSOR_VAL)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01", Commands.RPM);
		
		assertSame(expected, actual);
	}
}
