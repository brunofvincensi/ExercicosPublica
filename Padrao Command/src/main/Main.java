package main;

import java.util.ArrayList;
import java.util.List;
import executor.Executor;
import implementations.LogEmailComando;
import implementations.LogMensagemComando;
import implementations.SalvarRegistroComando;
import interfaces.Command;

public class Main {

	public static void main(String[] args) {
		List<Command> comandos = new ArrayList<>();
		
		comandos.add(new LogMensagemComando("Log realizado"));
		comandos.add(new LogEmailComando("Email através de comando"));
		comandos.add(new SalvarRegistroComando(1));
		comandos.add(new SalvarRegistroComando(3));
	
		Executor executor = new Executor();
		executor.executar(comandos);
	}

}
