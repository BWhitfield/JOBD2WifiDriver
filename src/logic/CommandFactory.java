package logic;
import java.io.IOException;

import main.Commands;
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

		if(command == Commands.RPM) //I don't like this, but apparently you can only switch on enums & ints
			return _ecuMath.rpm(cleanEcuHex);
		else if(command == Commands.LOAD)
			return _ecuMath.load(cleanEcuHex);
		else if(command == Commands.MAF)
			return _ecuMath.maf(cleanEcuHex);
		
		return null;
	}
}
