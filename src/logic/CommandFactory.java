package logic;
import java.io.IOException;

import util.ICommander;

public class CommandFactory implements ICommandFactory {

	private IResponseCleaner _responseCleaner;
	private ICommander _commander;
	private IEcuMath _ecuMath;

	public CommandFactory(IEcuMath ecuMath, ICommander commander, IResponseCleaner responseCleaner) {
		_ecuMath = ecuMath;
		_commander = commander;
		_responseCleaner = responseCleaner;
	}

	public String obd2Value(String mode, String command) throws IOException {
		String cleanEcuHex = _responseCleaner.clean(_commander.obd2(mode, command));
		return _ecuMath.rpm(cleanEcuHex);
	}
}
