package logic;

public interface IEcuMath {

	String rpm(int rawVal);
	String airIntakeTemp(int rawVal);
	String timingAdvance(int rawVal);
	String fuelPressure(int rawVal);
	String load(int rawVal);
	String maf(int rawVal);

}
