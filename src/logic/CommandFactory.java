package logic;
import java.io.IOException;

import com.google.inject.Inject;

import util.ICommander;
import util.IConversion;

public class CommandFactory implements ICommandFactory {

	private IResponseCleaner _responseCleaner;
	private ICommander _commander;
	private IConversion _conversion;
	private IMathRouter _router;

	@Inject
	public CommandFactory(ICommander commander, IResponseCleaner responseCleaner, IConversion conversion, IMathRouter router) {
		_commander = commander;
		_responseCleaner = responseCleaner;
		_conversion = conversion;
		_router = router;
	}
	
	public String obd2Value(String mode, String command) throws IOException {
		String rawVal = _commander.obd2(mode, command);
		String cleanEcuHex = _responseCleaner.clean(rawVal);
		Integer rawIntVal = _conversion.hexToDecimal(cleanEcuHex);
		
		return _router.route(command, rawIntVal);
	}
	public String obd2ValueRaw(String mode, String command) throws IOException {
		return _commander.obd2(mode, command);
	}
}
