package logic;

public interface IEcuMath {

	String rpm(int rawVal);
	String airIntakeTemp(int rawVal);
	String timingAdvance(int rawVal);
	String fuelPressure(int rawVal);
	String load(int rawVal);
	String maf(int rawVal);

	String rpm(String cleanEcuHex);
	String load(String cleanEcuHex);
	String maf(String cleanEcuHex);
	String fuelPressure(String cleanEcuHex);
	String timingAdvance(String cleanEcuHex);
	String airIntakeTemp(String cleanEcuHex);
	String pids1_20(String cleanEcuHex);

}
