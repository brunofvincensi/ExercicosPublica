package implementations;

import interfaces.Command;

public class LogMensagemComando implements Command {

	private String mensagem;

	public LogMensagemComando(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void execute() {
		System.out.println("Log: " + mensagem);
	
	}

}
