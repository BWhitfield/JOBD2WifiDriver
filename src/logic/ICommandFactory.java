package logic;

import java.io.IOException;

public interface ICommandFactory {
	public String obd2Value(String mode, String command) throws IOException;
	public String obd2ValueRaw(String mode, String command) throws IOException;
}
