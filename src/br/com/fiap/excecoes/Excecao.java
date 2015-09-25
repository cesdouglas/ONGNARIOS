package br.com.fiap.excecoes;

public class Excecao extends Exception{
	public Excecao(Exception e) {
		if (e.getClass().toString()
				.equals("class java.lang.NumberFormatException")) {
			System.out.println("Número inválido");
		} else if (e.getClass().toString()
				.equals("class java.lang.ArrayIndexOfBound")) {
			System.out.println("Limite excedido");
		} else {
			System.out.println("Erro desconhecido");
			e.printStackTrace();
		}
	}
	public Excecao (String x){
		System.out.println(x);
	}
}
