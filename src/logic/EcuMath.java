package logic;

public class EcuMath implements IEcuMath {

	public String rpm(String ecuHex) {
		if (ecuHex != null && !ecuHex.isEmpty()){
			int decVal = Integer.parseInt(ecuHex, 16);
			return String.valueOf(decVal / 4.0);
		}
		return "";
	}

	public String load(String cleanEcuHex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String maf(String cleanEcuHex) {
		// TODO Auto-generated method stub
		return null;
	}

}
