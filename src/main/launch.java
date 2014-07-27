package main;

import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import logic.CommandFactory;
import logic.ICommandFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import util.Commander;
import util.ICommander;

public class launch {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(); //create an application wide driver
//		ICommander commander = new Commander();
//		ICommandFactory cf = new CommandFactory(commander);
		logger.error("printing things");
//		try {
//			IDefaultInformation di = new DefaultInformation(commander, logger);
//			di.print();
//			while (true) {
//				cf.obd2Value("01", Commands.RPM);
//				cf.obd2Value("01", Commands.LOAD);
//				cf.obd2Value("01", Commands.MAF);
////				getRpms(commander);
////				getLoad(commander);
////				getMAF(commander);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
