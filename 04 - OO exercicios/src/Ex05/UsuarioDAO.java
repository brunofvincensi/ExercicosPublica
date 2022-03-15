package Ex05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioDAO {

	final static String USUARIOS_TXT = "C:\\Users\\publica\\Desktop\\mds.txt";
	final static String LIVROS_TXT = "C:\\Users\\publica\\Desktop\\livros.txt";

	public static void gravarUsuario(Usuario usuario) throws IOException {

		try (FileWriter fw = new FileWriter(USUARIOS_TXT, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.print(usuario.getLogin() + "," + usuario.getSenha() + "," + usuario.getRole() + ";");

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static List<Usuario> lerUsuarios() throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(USUARIOS_TXT));

		List<Usuario> usuarios = new ArrayList<>();

		String linha;

		while ((linha = bf.readLine()) != null) {

			String[] usuariosTXT = linha.split(";");

			for (String usuarioTXT : usuariosTXT) {

				String[] dados = usuarioTXT.split(",");

				usuarios.add(new Usuario(dados[0], dados[1], Integer.parseInt(dados[2])));
			}

		}
		
		bf.close();

		return usuarios;

	}

	public static void alterarUsuario(String login, Usuario usuario) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(USUARIOS_TXT));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT, true)));

		String linha;

		String arquivo = "";

		while ((linha = bf.readLine()) != null) {

			String[] usuariosTXT = linha.split(";");

			for (String usuarioTXT : usuariosTXT) {

				String[] dados = usuarioTXT.split(",");

				if (dados[0].equals(login)) {

					dados[0] = usuario.getLogin();
					dados[1] = usuario.getSenha();
					dados[2] = Integer.toString(usuario.getRole());

				}

				usuarioTXT = dados[0] + "," + dados[1] + "," + dados[2];

				arquivo = (usuarioTXT + ";") + arquivo;
			}

		}

		PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT)));

		pw2.write(arquivo);

		pw2.close();
		pw.close();
		bf.close();

	}

	public static int logar(String login, String senha) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(USUARIOS_TXT));

		String linha;

		int adm = -1;

		while ((linha = bf.readLine()) != null) {

			String[] usuarios = linha.split(";");

			for (String usuario : usuarios) {

				String[] dados = usuario.split(",");

				if (dados[0].equals(login)) {

					if (!dados[1].equals(senha)) {
						throw new RuntimeException("Senha incorreta");
					}

					adm = Integer.parseInt(dados[2]);
					break;

				}

			}

		}
		
		bf.close();

		return adm;

	}
	
	
	public static void deletarUsuario(String login) throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader(USUARIOS_TXT));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT, true)));

		String linha;

		String arquivo = "";

		while ((linha = bf.readLine()) != null) {

			String[] usuariosTXT = linha.split(";");

			for (String usuarioTXT : usuariosTXT) {

				String[] dados = usuarioTXT.split(",");

				if (!dados[0].equals(login)) {
				usuarioTXT = dados[0] + "," + dados[1] + "," + dados[2];
				arquivo = (usuarioTXT + ";") + arquivo;
				}
			}

		}

		PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT)));

		pw2.write(arquivo);

		pw2.close();
		pw.close();
		bf.close();
	}
	
	public static void alterarSenha(String login, String novaSenha) throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader(USUARIOS_TXT));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT, true)));

		String linha;

		String arquivo = "";

		while ((linha = bf.readLine()) != null) {

			String[] usuariosTXT = linha.split(";");

			for (String usuarioTXT : usuariosTXT) {

				String[] dados = usuarioTXT.split(",");

				if (dados[0].equals(login)) {
				
					dados[1] = novaSenha;
				}
				
				usuarioTXT = dados[0] + "," + dados[1] + "," + dados[2];
				arquivo = (usuarioTXT + ";") + arquivo;
			}

		}

		PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(USUARIOS_TXT)));

		pw2.write(arquivo);

		pw2.close();
		pw.close();
		bf.close();
	}


}
