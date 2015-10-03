package br.com.fiap.excecoes;

public class Excecao extends Exception{
	public Excecao(Exception e) {
		if (e.getClass().toString()
				.equals("class java.lang.NumberFormatException")) {
			System.out.println("Número inválido");
		} else if (e.getClass().toString()
				.equals("class java.lang.ArrayIndexOfBound")) {
			System.out.println("Limite excedido");
		}else if(e.getClass().toString()
				.equals("class java.lang.ArithmeticException")){
			System.out.println("Erro Aritimético");
		}else if(e.getClass().toString()
				.equals("class java.lang.IllegalArgumentException")){
			System.out.println("Parâmetro fornecido fora dos padrões estabelecidos");
		}
		else {
			System.out.println("Erro desconhecido");
			e.printStackTrace();
		}
	}
}
