package logic;
public class DTC implements IDTC{

	public String getPrefix(String hex) {
		switch(hex){
		case "0": return "P0";
		case "1": return "P1";
		case "2": return "P2";
		case "3": return "P3";
		case "4": return "C0";
		case "5": return "C1";
		case "6": return "C2";
		case "7": return "C3";
		case "8": return "B0";
		case "9": return "B1";
		case "A": return "B2";
		case "B": return "B3";
		case "C": return "U0";
		case "D": return "U1";
		case "E": return "U2";
		case "F": return "U3";
		default: return "Unknown DTC";
		}
	}
}