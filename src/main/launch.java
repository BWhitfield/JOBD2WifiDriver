package main;

import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import util.Commander;
import util.ICommander;

public class launch {

	public static void main(String[] args) {
		ICommander commander = new Commander();
//		Logger logger = LogManager.getLogger("Driver"); //create an application wide driver
//		
//		IDefaultInformation di = new DefaultInformation(commander, logger);
//		di.print();
		
		
		try {
			System.out.println("turn off echo: " + commander.at("E0"));// turn off the echo
			System.out.println("Interface version" + commander.at("I"));
			while (true) {
				getRpms(commander);
				getLoad(commander);
				getMAF(commander);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getRpms(ICommander commander) throws IOException {
		String response = commander.obd2("01", "0C");
		response = response.replace("41", "");
		response = response.replace("0C", "");
		response = response.replace(" " , "");
		if (response.length() > 0 && !response.contains("SEARCH")) {
			int decVal = Integer.parseInt(response, 16);
			int rpm = decVal / 4;
			System.out.println("RPM: " + rpm);// get rpms
		}
	}
	
	private static void getLoad(ICommander commander) throws IOException {
		String response = commander.obd2("01", "04");
		response = response.replace("41", "");
		response = response.replace("04", "");
		response = response.replace(" " , "");
		if (response.length() > 0 && !response.contains("SEARCH")) {
			int decVal = Integer.parseInt(response, 16);
			double loadPercent = (decVal * 100) / 255;
			System.out.println("Load: " + loadPercent + "%");// get load
		}
	}
	
	private static void getMAF(ICommander commander) throws IOException {
		String response = commander.obd2("01", "10");
		response = response.replace("41", "");
		response = response.replace("10", "");
		response = response.replace(" " , "");
		if (response.length() > 0 && !response.contains("SEARCH")) {
			int decVal = Integer.parseInt(response, 16);
			double mafGramPerSec = decVal / 100;
			System.out.println("MAF: " + mafGramPerSec + " gram/sec");// get load
		}
	}
}
