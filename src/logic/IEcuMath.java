package logic;

public interface IEcuMath {

	String rpm(String ecuHex);
	String load(String cleanEcuHex);
	String maf(String cleanEcuHex);
	String fuelPressure(String cleanEcuHex);
	String timingAdvance(String cleanEcuHex);
	String airIntakeTemp(String cleanEcuHex);
	String pids1_20(String cleanEcuHex);

}
