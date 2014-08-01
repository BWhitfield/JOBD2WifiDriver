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
	
	public CommandFactory(ICommander commander){
		this(new EcuMath(),commander,new ResponseCleaner());
	}

	public String obd2Value(String mode, String command) throws IOException {
		String rawVal = _commander.obd2(mode, command);
		String cleanEcuHex = _responseCleaner.clean(rawVal);
		
		if (mode == "03") { //test this
			return rawVal;
		}
		
		//hexToDecimal needs to go here. If there is an exception parsing, then set to null and step over the if/else blocks
		
		if(cleanEcuHex != null && !cleanEcuHex.isEmpty()){
			if(command == Commands.RPM) //I don't like this, but apparently you can only switch on enums & ints
				return _ecuMath.rpm(cleanEcuHex);
			else if(command == Commands.LOAD)
				return _ecuMath.load(cleanEcuHex);
			else if(command == Commands.MAF)
				return _ecuMath.maf(cleanEcuHex);
			else if(command == Commands.FUEL_PRESSURE)
				return _ecuMath.fuelPressure(cleanEcuHex);
			else if(command == Commands.TIMING_ADVANCE)
				return _ecuMath.timingAdvance(cleanEcuHex);
			else if(command == Commands.INTAKE_AIR_TEMP)
				return _ecuMath.airIntakeTemp(cleanEcuHex);
			else if(command == Commands.PIDS_1_20)
				return rawVal;// _ecuMath.pids1_20(cleanEcuHex);
		}
		return null;
	}
}
