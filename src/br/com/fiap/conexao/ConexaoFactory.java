package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

//Classe para conexao no Banco de Dados
public class ConexaoFactory {
	//DriverManager Instancindo a Connection
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL", "OPS$RM73872", "290992");
		
	}
}
