package logic;

public class ResponseCleaner implements IResponseCleaner {

	public String clean(String ecuHex) {
		if (ecuHex != null && !ecuHex.isEmpty()) {
			ecuHex = ecuHex.replace(" " , "");
			ecuHex = ecuHex.replace("SEARCH" , "");
			return ecuHex.substring(4);
		}
		return "";
	}

}
