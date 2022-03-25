package interfaces;

import concrets.Application;
import concrets.Editor;

public abstract class Command {

	 protected Application app;
	    protected Editor editor;
	    protected String backup;

	   public Command(Application app, Editor editor) {
	        this.app = app;
	        this.editor = editor;
	   }
	    // Faz um backup do estado do editor.
	    public void saveBackup() {
	        backup = editor.text;
	    }
	    // Restaura o estado do editor.
	    public void undo() {
	        editor.text = backup;
	    }
	    // O método de execução é declarado abstrato para forçar
	    // todos os comandos concretos a fornecer suas próprias
	    // implementações. O método deve retornar verdadeiro ou
	    // falso dependendo se o comando muda o estado do editor.
	    public abstract void execute();
}
