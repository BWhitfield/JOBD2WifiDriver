package logic;
import java.io.IOException;

import main.Commands;
import util.Conversion;
import util.ICommander;
import util.IConversion;

public class CommandFactory implements ICommandFactory {

	private IResponseCleaner _responseCleaner;
	private ICommander _commander;
	private IEcuMath _ecuMath;
	private IConversion _conversion;

	public CommandFactory(IEcuMath ecuMath, ICommander commander, IResponseCleaner responseCleaner, IConversion conversion) {
		_ecuMath = ecuMath;
		_commander = commander;
		_responseCleaner = responseCleaner;
		_conversion = conversion;
	}
	
	public CommandFactory(ICommander commander){
		this(new EcuMath(),commander,new ResponseCleaner(), new Conversion());
	}

	public String obd2Value(String mode, String command) throws IOException {
		String rawVal = _commander.obd2(mode, command);
		String cleanEcuHex = _responseCleaner.clean(rawVal);
		
		int rawIntVal = _conversion.hexToDecimal(cleanEcuHex);
		
//		if (mode == "03") { //test this
//			return rawVal;
//		}
		
		//hexToDecimal needs to go here. If there is an exception parsing, then set to null and step over the if/else blocks
		
		if(cleanEcuHex != null && !cleanEcuHex.isEmpty()){
			if(command == Commands.RPM) //I don't like this, but apparently you can only switch on enums & ints
				return _ecuMath.rpm(rawIntVal);
			else if(command == Commands.LOAD)
				return _ecuMath.load(rawIntVal);
			else if(command == Commands.MAF)
				return _ecuMath.maf(rawIntVal);
			else if(command == Commands.FUEL_PRESSURE)
				return _ecuMath.fuelPressure(rawIntVal);
			else if(command == Commands.TIMING_ADVANCE)
				return _ecuMath.timingAdvance(rawIntVal);
			else if(command == Commands.INTAKE_AIR_TEMP)
				return _ecuMath.airIntakeTemp(rawIntVal);
			else if(command == Commands.PIDS_1_20)
				return rawVal;// _ecuMath.pids1_20(cleanEcuHex);
		}
		return null;
	}
}
