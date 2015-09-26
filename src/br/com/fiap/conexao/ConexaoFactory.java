package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.Driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:/:@192.168.60.15:1521:ORCL", "OPS$RM73872", "290992");
	}
}
