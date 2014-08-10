package main;

import guice.GuiceModule;

import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import logic.CommandFactory;
import logic.ICommandFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.inject.Guice;
import com.google.inject.Injector;

import util.Commander;
import util.ICommander;

public class launch {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(); //create ROOT logger
		logger.info("JOBD2WifiDriver - Begin");

	    Injector injector = Guice.createInjector(new GuiceModule());

	    ICommandFactory cf = injector.getInstance(CommandFactory.class);
//	    IDefaultInformation di = injector.getInstance(DefaultInformation.class);
		
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
}
