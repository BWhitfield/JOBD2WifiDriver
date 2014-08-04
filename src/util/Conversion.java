package util;

public class Conversion implements IConversion {

	public Integer hexToDecimal(String hex) {
		try {
			return Integer.parseInt(hex, 16);
		} catch (NumberFormatException e) {
			return null; //Not sure if I want to log here...
		} 
	}
	
	public String hexToBinary(String hex) {
		Integer i = hexToDecimal(hex);
		if (i != null) {
			String Bin = Integer.toBinaryString(i);
			while(Bin.length() % (hex.length() * 4) != 0)
			{
				Bin = "0" + Bin;
			}
			return Bin;
		}
		return null;
	}
}
