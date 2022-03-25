package executor;

import java.util.List;

import interfaces.Command;

public class Executor {
	public void executar(List<Command> comandos) {
		for (Command c : comandos) {
			c.execute();
		}
	}
}
