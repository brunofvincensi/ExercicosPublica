package Ex05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class LivroDAO {

	final static String LIVROS_TXT = "C:\\Users\\publica\\Desktop\\livros.txt";

	public static void gravarLivro(Livro livro) throws IOException {

		try (FileWriter fw = new FileWriter(LIVROS_TXT, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.print(livro.getNome() + "," + livro.getNumPaginas() + "," + livro.getPreco() + ";");

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static List<Livro> lerLivros() throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(LIVROS_TXT));

		List<Livro> livros = new ArrayList<>();

		String linha;

		while ((linha = bf.readLine()) != null) {

			String[] livrosTXT = linha.split(";");

			for (String livro : livrosTXT) {

				String[] dados = livro.split(",");

				livros.add(new Livro(dados[0], Integer.parseInt(dados[1]), Double.parseDouble(dados[2])));
			}

		}
		
		bf.close();
		return livros;

	}

	public static void alterarLivro(String nome, Livro novoLivro) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(LIVROS_TXT));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(LIVROS_TXT, true)));

		String linha;

		String arquivo = "";

		while ((linha = bf.readLine()) != null) {

			String[] livrosTXT = linha.split(";");

			for (String livroTXT : livrosTXT) {

				String[] dados = livroTXT.split(",");

				if (dados[0].equals(nome)) {

					dados[0] = novoLivro.getNome();
					dados[1] = Integer.toString(novoLivro.getNumPaginas());
					dados[2] = Double.toString(novoLivro.getPreco());

				}

				livroTXT = dados[0] + "," + dados[1] + "," + dados[2];

				arquivo = (livroTXT + ";") + arquivo;
			}

		}

		PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(LIVROS_TXT)));

		pw2.write(arquivo);

		pw2.close();
		pw.close();
		bf.close();

	}

	public static void deletarLivro(String nome) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(LIVROS_TXT));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(LIVROS_TXT, true)));

		String linha;

		String arquivo = "";

		while ((linha = bf.readLine()) != null) {

			String[] livrosTXT = linha.split(";");

			for (String livroTXT : livrosTXT) {

				String[] dados = livroTXT.split(",");

				if (!dados[0].equals(nome)) {

					livroTXT = dados[0] + "," + dados[1] + "," + dados[2];
					arquivo = (livroTXT + ";") + arquivo;
				}

			}

		}

		PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(LIVROS_TXT)));

		pw2.write(arquivo);

		pw2.close();
		pw.close();
		bf.close();

	}

	public static boolean livroExiste(String nome) throws IOException {

		boolean existe = false;

		List<Livro> livros = lerLivros();

		for (int i = 0; i < livros.size(); i++) {

			if (livros.get(i).getNome().equals(nome)) {

				existe = true;
			}
		}

		return existe;
	}

}
