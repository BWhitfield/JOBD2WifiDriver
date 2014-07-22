package logic;

public class ResponseCleaner implements IResponseCleaner {

	public String clean(String ecuHex) {
		ecuHex = ecuHex.replace(" " , "");
		ecuHex = ecuHex.replace("SEARCH" , "");
		return ecuHex.substring(4);
	}

}
