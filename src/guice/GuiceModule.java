package guice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.*;
import logic.*;
import main.DefaultInformation;
import main.IDefaultInformation;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
	@Override
	protected void configure() {

		bind(ICommandFactory.class).to(CommandFactory.class);
		bind(IEcuMath.class).to(EcuMath.class);
		bind(IMathRouter.class).to(MathRouter.class);
		bind(IResponseCleaner.class).to(ResponseCleaner.class);

		bind(IDefaultInformation.class).to(DefaultInformation.class);
		bind(IConversion.class).to(Conversion.class);
		bind(ICommander.class).to(Commander.class);

		bind(Logger.class).toInstance(LogManager.getLogger());
	}
}
