package main;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import util.ICommander;

public class DefaultInformation implements IDefaultInformation {

	private ICommander _commander;
	private Logger _logger;

	@Inject
	public DefaultInformation(ICommander commander, Logger logger) {
		_commander = commander;
		_logger = logger;
	}

	public void print() {
		try {
			_commander.at("E0");
			_logger.info(_commander.at("I"));
		} catch (IOException e) {
			_logger.error("Failed to turn off echo or print interface version");
			_logger.error(e.getMessage());
			return;
		} 
	}

}
