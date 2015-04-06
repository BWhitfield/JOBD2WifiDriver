package logic;

import main.Commands;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MathRouterTests {
	IMathRouter _testObject;
	@Mock IEcuMath _ecuMath;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		_testObject  = new MathRouter(_ecuMath);
	}
	
	@Test
	public void rpm(){
		String expected = "foobar";
		when(_ecuMath.rpm(111)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.RPM,111);

		assertSame(expected, actual);
	}

	@Test
	public void load(){
		String expected = "foobar";
		when(_ecuMath.load(222)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.LOAD,222);
		
		assertSame(expected, actual);
	}

	@Test
	public void maf(){
		String expected = "foobar";
		when(_ecuMath.maf(222)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.MAF,222);
		
		assertSame(expected, actual);
	}

	@Test
	public void fuelPressure(){
		String expected = "foobar";
		when(_ecuMath.fuelPressure(222)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.FUEL_PRESSURE,222);
		
		assertSame(expected, actual);
	}

	@Test
	public void timing_advance(){
		String expected = "foobar";
		when(_ecuMath.timingAdvance(222)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.TIMING_ADVANCE,222);
		
		assertSame(expected, actual);
	}

	@Test
	public void air_intake(){
		String expected = "foobar";
		when(_ecuMath.airIntakeTemp(222)).thenReturn(expected);
		
		String actual = _testObject.route(Commands.INTAKE_AIR_TEMP,222);
		
		assertSame(expected, actual);
	}

	@Test
	public void null_(){
		String actual = _testObject.route(Commands.INTAKE_AIR_TEMP,null);
		assertSame(null, actual);
	}
	
	@Test
	public void default_returns_raw(){
		String actual = _testObject.route("notImplemented",999);
		assertEquals("999", actual);
	}
}
