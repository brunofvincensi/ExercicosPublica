package controller.service;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class CarrinhoService {

	public static List<Produto> produtosCarrinho = new ArrayList<>();
	
	public static Double getTotalPrice() {
		Double cont = 0.0;

		for (Produto p : produtosCarrinho) {
			
			System.out.println(p);
			
			cont = cont + (p.getValor() * p.getQuantidade());
		}
		return cont;
	}
	
	public static void adicionar(Produto produto) {
		boolean jaExiste = false;
		
		for(Produto p : produtosCarrinho) {
			if(p.getCodigo() == produto.getCodigo()) {
				jaExiste = true;							
				p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
				break;
			}
		}
		
		if(!jaExiste) {
			produtosCarrinho.add(produto);
		}

	}
	
	public static int getQtdItens() {
		int cont = 0;
		for(Produto p : produtosCarrinho) {
			cont += p.getQuantidade();
		}
		
		return cont;
	}	

}
