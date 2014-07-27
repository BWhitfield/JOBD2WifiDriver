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
				logger.info("LOAD: " + cf.obd2Value("01", Commands.LOAD));
				logger.info("MAF: " + cf.obd2Value("01", Commands.MAF));
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
}
