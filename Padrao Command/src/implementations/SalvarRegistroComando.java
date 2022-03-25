package implementations;

import interfaces.Command;

public class SalvarRegistroComando implements Command {

	private long codigo;

	public SalvarRegistroComando(long codigo) {
		this.codigo = codigo;
	}

	@Override
	public void execute() {
		System.out.println("Registro salvo: " + codigo);
		
	}
}
