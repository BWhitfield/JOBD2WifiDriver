package util;

public class Conversion implements IConversion {

	public Integer hexToDecimal(String hex) {
		try {
			return Integer.parseInt(hex, 16);
		} catch (NumberFormatException e) {
			return null;
		} 
	}
}
