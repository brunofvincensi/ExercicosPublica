package implementations;

import interfaces.Command;

public class LogEmailComando implements Command {

	private String email;

	public LogEmailComando(String email) {
		this.email = email;
	}

	@Override
	public void execute() {
		System.out.println("Email: " + email);
		
	}
}
