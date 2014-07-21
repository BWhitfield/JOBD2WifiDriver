package main;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import util.ICommander;
import static org.mockito.Mockito.*;

public class DefaultInformationTests {

	IDefaultInformation _testObject;
	@Mock ICommander _commander;
	@Mock Logger _logger;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		_testObject = new DefaultInformation(_commander, _logger);
	}
	
	@Test
	public void print_turns_off_echo() throws Exception{
		_testObject.print();
		
		verify(_commander, times(1)).at("E0");
	}

	@Test
	public void print_logs_interface_version() throws Exception{
		String interfaceVersion = "Elm Foo Bar";
		when(_commander.at("I")).thenReturn(interfaceVersion);
		
		_testObject.print();
		
		verify(_commander).at("I");
		verify(_logger).info(interfaceVersion);
	}
	
	@Test
	public void print_turns_off_echo_error() throws Exception{
		IOException ioException = mock(IOException.class);

		when(ioException.getMessage()).thenReturn("foo");
		when(_commander.at("E0")).thenThrow(ioException);
		
		_testObject.print();
		
		verify(_logger).error("Failed to turn off echo or print interface version");
		verify(_logger).error("foo");
	}
}
