package main;

import guice.GuiceModule;
import logic.CommandFactory;
import logic.ICommandFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class launch {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(); //create ROOT logger
		logger.info("JOBD2WifiDriver - Begin");

	    Injector injector = Guice.createInjector(new GuiceModule());

	    ICommandFactory cf = injector.getInstance(CommandFactory.class);
	    IDefaultInformation di = injector.getInstance(DefaultInformation.class);
		
		try {
			di.print();
//			while (true) {
//				logger.info("RPM: " + cf.obd2Value("01", Commands.RPM));
				logger.info("O2" + cf.obd2Value("01", "18"));
				logger.info("O2 raw" + cf.obd2ValueRaw("01", "18"));
				
//				String o2raw = cf.obd2ValueRaw("03", "");
//				logger.info(o2raw);
//				
//				String clearErrors = cf.obd2ValueRaw("04", "");
//				logger.info(clearErrors);
				
//				Integer o2format = Integer.parseInt(o2raw);
//				logger.info(o2format);
//				double o2 = (o2format-128) * 100/128;// o2format/200.00;//  - 40191
//				logger.info(o2);
//				
//				logger.info("pids: " + cf.obd2Value("01", Commands.PIDS_1_20));
//				logger.info("errors: " + cf.obd2Value("06", "0101"));
//				logger.info("LOAD: " + cf.obd2Value("01", Commands.LOAD));
//				logger.info("MAF: " + cf.obd2Value("01", Commands.MAF));
//				logger.info("FUEL: " + cf.obd2Value("01", Commands.FUEL_PRESSURE));
//				logger.info("TIME: " + cf.obd2Value("01", Commands.TIMING_ADVANCE));
//				logger.info("INTAKE_AIR: " + cf.obd2Value("01", Commands.INTAKE_AIR_TEMP));
//			}
		} catch (Exception e) {
			logger.error("fail",e);
		}
	}
}
