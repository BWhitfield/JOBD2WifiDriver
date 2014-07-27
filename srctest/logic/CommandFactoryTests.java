package logic;

import java.io.IOException;

import main.Commands;

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
	String CLEAN_ECU_HEX = "0101";
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		_testObject = new CommandFactory(_ecuMath, _commander, _responseCleaner);
		String ECU_HEX = "123rt";
		
		when(_commander.obd2(anyString(), anyString())).thenReturn(ECU_HEX);
		when(_responseCleaner.clean(anyString())).thenReturn(CLEAN_ECU_HEX);
	}
	
	@Test
	public void obd2Value_cleans_response() throws Exception{
		String ecuHex = "0x0ff03";
		when(_commander.obd2("01", "temp")).thenReturn(ecuHex);
		
		_testObject.obd2Value("01","temp");
		
		verify(_responseCleaner).clean(ecuHex);
	}
	
	@Test
	public void obd2Value_null() throws Exception{
		String ecuHex = "0x0ff03";
		String cleanEcuHex = null;
		String expected = null;

		when(_commander.obd2("01", Commands.RPM)).thenReturn(ecuHex);
		when(_responseCleaner.clean(ecuHex)).thenReturn(cleanEcuHex);
		
		String actual = _testObject.obd2Value("01",Commands.RPM);
		
		verify(_ecuMath, times(0)).rpm(cleanEcuHex);
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_empty_string() throws Exception{
		String ecuHex = "0x0ff03";
		String cleanEcuHex = "";
		String expected = null;
		
		when(_commander.obd2("01", Commands.RPM)).thenReturn(ecuHex);
		when(_responseCleaner.clean(ecuHex)).thenReturn(cleanEcuHex);
		
		String actual = _testObject.obd2Value("01",Commands.RPM);
		
		verify(_ecuMath, times(0)).rpm(cleanEcuHex);
		assertEquals(expected, actual);
	}
	
	@Test
	public void obd2Value_RPM() throws Exception{
		String expected = "1234";

		when(_ecuMath.rpm(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.RPM);
		
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_Load() throws Exception{
		String expected = "1234";
		
		when(_ecuMath.load(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.LOAD);
		
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_maf() throws Exception{
		String expected = "1234";
		
		when(_ecuMath.maf(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.MAF);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void obd2Value_fuel_pressure() throws Exception{
		String expected = "1234";
		
		when(_ecuMath.fuelPressure(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.FUEL_PRESSURE);
		
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_timing_advance() throws Exception{
		String expected = "1234";
		
		when(_ecuMath.timingAdvance(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.TIMING_ADVANCE);
		
		assertEquals(expected, actual);
	}

	@Test
	public void obd2Value_air_intake_temp() throws Exception{
		String expected = "1234";
		
		when(_ecuMath.airIntakeTemp(CLEAN_ECU_HEX)).thenReturn(expected);
		
		String actual = _testObject.obd2Value("01",Commands.INTAKE_AIR_TEMP);
		
		assertEquals(expected, actual);
	}
}
