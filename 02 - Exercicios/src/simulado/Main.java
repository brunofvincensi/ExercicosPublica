package simulado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		final String AUDIO_E_VIDEO = "Áudio e vídeo";
		final String ALIMENTICIO = "Alimenticio";
		final String ELETRODOMESTICOS = "Eletrodomésticos";
		final String INFORMATICA = "Informática";
		final String VESTUARIO = "Vestuário";

		String[][] segmentosImpostos = { { AUDIO_E_VIDEO, "3", "5", "7" }, { ALIMENTICIO, "1", "3", "6" },
				{ ELETRODOMESTICOS, "3", "8", "9" }, {INFORMATICA, "4", "10", "16" },
				{ VESTUARIO, "2", "3", "5" } };

		List<String[]> produtos = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		boolean sair = false;
		while (!sair) {

			System.out.println();
			System.out.println("Sistema de produtos, selecione uma opção");
			System.out.println();
			System.out.println("Cadastrar (1)");
			System.out.println("Listar (2)");
			System.out.println("Listar por segmento (3)");
			System.out.println("Alterar (4)");
			System.out.println("Remover (5)");
			System.out.println("Estatísticas (6)");
			System.out.println("Sair (7)");

			char numSelecionado = sc.next().charAt(0);

			try {
				switch (numSelecionado) {
				case '1' -> {

					System.out.println("Insira o nome: ");
					String nome = sc.next();

					produtos.forEach(p -> {
						if (p[0].equals(nome)) {
							throw new RuntimeException("nome já existe");
						}
					});

					System.out.println("Insira o valor: ");
					double valorSemImpostos = sc.nextDouble();

					System.out.println("Selecione um segmento abaixo: ");
					System.out.println(AUDIO_E_VIDEO + " (1)");
					System.out.println(ALIMENTICIO + " (2)");
					System.out.println(ELETRODOMESTICOS + " (3)");
					System.out.println(INFORMATICA + " (4)");
					System.out.println(VESTUARIO + " (5)");
					String segSelecionado = sc.next();

					int indice = Integer.parseInt(segSelecionado) - 1;
					String segmento = "";

					try {

						segmento = segmentosImpostos[indice][0];

					} catch (Exception e) {
						System.out.println("segmento selecionado não existe");
					}

					double impostoMunicipal = Double.parseDouble(segmentosImpostos[indice][1]);
					double impostoEstadual = Double.parseDouble(segmentosImpostos[indice][2]);
					double impostoFederal = Double.parseDouble(segmentosImpostos[indice][3]);

					double impostoTotal = (impostoMunicipal + impostoEstadual + impostoFederal) / 100;

					double valorComImpostos = valorSemImpostos + (valorSemImpostos * impostoTotal);

					String[] produto = { nome, Double.toString(valorSemImpostos), Double.toString(valorComImpostos),
							segmento };
					produtos.add(produto);
				}
				case '2' -> {
					produtos.forEach(p -> {

						String i1 = "";
						String i2 = "";
						String i3 = "";

						System.out.println("Nome: " + p[0]);
						System.out.println("Valor: R$" + p[2]);
						System.out.println("Segmento: " + p[3]);

						for (String[] si : segmentosImpostos) {
							if (si[0].equals(p[3])) {

								i1 = si[1];
								i2 = si[2];
								i3 = si[3];
							}
						}

						System.out.println("Imposto Municipal: " + i1 + "%");
						System.out.println("Imposto Estadual: " + i2 + "%");
						System.out.println("Imposto Federal: " + i3 + "%");
						System.out.println("Valor sem imposto: R$" + p[1]);
						System.out.println();
						System.out.println("---------------------------------");
						System.out.println();
					});

				}
				case '3' -> {

					System.out.println("Selecione um segmento abaixo: ");
					System.out.println(AUDIO_E_VIDEO + " (1)");
					System.out.println(ALIMENTICIO + " (2)");
					System.out.println(ELETRODOMESTICOS + " (3)");
					System.out.println(INFORMATICA + " (4)");
					System.out.println(VESTUARIO + " (5)");
					String segSelecionado = sc.next();

					int indice = Integer.parseInt(segSelecionado) - 1;

					String segmento = segmentosImpostos[indice][0];

					double somaValor = 0.0;
						
					for(String[] p : produtos) {
						if (segmento.equals(p[3])) {

							System.out.println("Nome: " + p[0]);
							System.out.println("Valor: R$" + p[2]);
							System.out.println();
							somaValor += Double.parseDouble(p[2]);
						}						
						
					}

					double i1 = 0.0;
					double i2 = 0.0;
					double i3 = 0.0;

					for (String[] si : segmentosImpostos) {
						if (si[0].equals(segmento)) {

							i1 = Double.parseDouble(si[1]);
							i2 = Double.parseDouble(si[2]);
							i3 = Double.parseDouble(si[3]);
							
							break;
						}
					}
					
					double valorMunicipal = somaValor * (i1 / 100);
					double valorEstadual = somaValor * (i2 / 100);
					double valorFederal = somaValor * (i3 / 100);
					
					System.out.println("-------------------------------");
					System.out.println("valor dos impostos Municipais: R$" + valorMunicipal);
					System.out.println("valor dos impostos Estaduais: R$" + valorEstadual);
					System.out.println("valor dos impostos Federais: R$" + valorFederal);
				}
				case '4' -> {

					int index = -1;

					System.out.println("Digite o nome do produto a ser alterado");
					String nome = sc.next();

					for (int i = 0; i < produtos.size(); i++) {

						if (produtos.get(i)[0].equals(nome)) {

							index = i;
							break;
						}
					}

					if (index == -1) {
						throw new RuntimeException("Produto não existe");
					}

					System.out.println("Insira o novo nome");
					String novoNome = sc.next();

					produtos.forEach(p -> {
						if (p[0].equals(novoNome) && !p[0].equals(nome)) {
							throw new RuntimeException("nome já existe");
						}
					});

					System.out.println("Insira o novo valor: ");
					double valorSemImpostos = sc.nextDouble();

					System.out.println("Selecione um segmento abaixo: ");
					System.out.println(AUDIO_E_VIDEO + " (1)");
					System.out.println(ALIMENTICIO + " (2)");
					System.out.println(ELETRODOMESTICOS + " (3)");
					System.out.println(INFORMATICA + " (4)");
					System.out.println(VESTUARIO + " (5)");
					String segSelecionado = sc.next();

					int indice = Integer.parseInt(segSelecionado) - 1;
					String segmento = "";

					try {
						segmento = segmentosImpostos[indice][0];

					} catch (Exception e) {
						System.out.println("segmento selecionado não existe");
					}

					double impostoMunicipal = Double.parseDouble(segmentosImpostos[indice][1]);
					double impostoEstadual = Double.parseDouble(segmentosImpostos[indice][2]);
					double impostoFederal = Double.parseDouble(segmentosImpostos[indice][3]);

					double impostoTotal = (impostoMunicipal + impostoEstadual + impostoFederal) / 100;

					double valorComImpostos = valorSemImpostos + (valorSemImpostos * impostoTotal);

					String[] produto = { novoNome, Double.toString(valorSemImpostos), Double.toString(valorComImpostos),
							segmento };

					produtos.set(index, produto);

				}
				case '5' -> {

					System.out.println("Digite o nome do produto a ser excluido");
					String nome = sc.next();

					produtos.forEach(p -> {
						if (p[0].equals(nome)) {
							produtos.remove(p);
						}
					});

				}
				case '6' -> {

					int quantTotal = produtos.size();
					int quantAudio = 0;
					int quantAliment = 0;
					int quantEletro = 0;
					int quantInf = 0;
					int quantVest = 0;

					double mediaMunicipal = 0.0;
					double mediaEstadual = 0.0;
					double mediaFederal = 0.0;

					for (String[] p : produtos) {

						switch (p[3]) {
						case AUDIO_E_VIDEO -> quantAudio++;
						case ALIMENTICIO -> quantAliment++;
						case ELETRODOMESTICOS -> quantEletro++;
						case INFORMATICA -> quantInf++;
						case VESTUARIO -> quantVest++;
						}

						for (int i = 0; i < segmentosImpostos.length; i++) {

							if (p[3].equals(segmentosImpostos[i][0])) {

								mediaMunicipal += Double.parseDouble(segmentosImpostos[i][1]);
								mediaEstadual += Double.parseDouble(segmentosImpostos[i][2]);
								mediaFederal += Double.parseDouble(segmentosImpostos[i][3]);

								break;
							}

						}

					}

					mediaMunicipal /= quantTotal;
					mediaEstadual /= quantTotal;
					mediaFederal /= quantTotal;

					System.out.println("Quantidade total de cadastros: " + quantTotal);
					System.out.println("Quantidade de cadastrao do segmento Áudio e vídeo: " + quantAudio);
					System.out.println("Quantidade de cadastrao do segmento Alimentício: " + quantAliment);
					System.out.println("Quantidade de cadastrao do segmento Eletrodomésticos: " + quantEletro);
					System.out.println("Quantidade de cadastrao do segmento Informática: " + quantInf);
					System.out.println("Quantidade de cadastrao do segmento Vestuário: " + quantVest);
					System.out.println("Media imposto municipal: " + mediaMunicipal);
					System.out.println("Media imposto estadual: " + mediaEstadual);
					System.out.println("Media imposto federal: " + mediaFederal);

				}
				case '7' -> sair = true;

				default -> throw new IllegalArgumentException("Numero inválido: " + numSelecionado);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		System.out.println("Programa finalizado");

		sc.close();

	}

}
