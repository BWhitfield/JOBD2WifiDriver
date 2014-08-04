package logic;

import main.Commands;

public class MathRouter implements IMathRouter {

	private IEcuMath _ecuMath;

	public MathRouter(IEcuMath ecuMath) {
		_ecuMath = ecuMath;
	}

	public MathRouter() {
		this(new EcuMath());
	}

	public String route(String command, Integer rawIntVal) {
		if(rawIntVal != null){
			if(command == Commands.RPM) 
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
		}
		return null;
	}
}
