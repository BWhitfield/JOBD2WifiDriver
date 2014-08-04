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
		Logger logger = LogManager.getLogger(); //create ROOT logger
		logger.info("JOBD2WifiDriver - Begin");
		
		ICommander commander = new Commander();
		ICommandFactory cf = new CommandFactory(commander);
		try {
			IDefaultInformation di = new DefaultInformation(commander, logger);
			di.print();
			while (true) {
				logger.info("RPM: " + cf.obd2Value("01", Commands.RPM));
//				logger.info("pids: " + cf.obd2Value("01", Commands.PIDS_1_20));
//				logger.info("errors: " + cf.obd2Value("03", ""));
//				logger.info("LOAD: " + cf.obd2Value("01", Commands.LOAD));
				logger.info("MAF: " + cf.obd2Value("01", Commands.MAF));
//				logger.info("FUEL: " + cf.obd2Value("01", Commands.FUEL_PRESSURE));
//				logger.info("TIME: " + cf.obd2Value("01", Commands.TIMING_ADVANCE));
//				logger.info("INTAKE_AIR: " + cf.obd2Value("01", Commands.INTAKE_AIR_TEMP));
			}
				//BE3FB813 410080000001 this is bit encoded
				//
				//
				//errors: 4300
			/*
			    String HexToBinary(String Hex) {
    				int i = Integer.parseInt(Hex, 16);
    				String Bin = Integer.toBinaryString(i);
    				return Bin;
				}
			 * */
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
}
