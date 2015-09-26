package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.UsuarioBean;
import br.com.fiap.conexao.ConexaoFactory;

public class TesteConexao {
	public static void main(String[] args) throws Exception {
		Connection conexao = new ConexaoFactory().getConnection();	
		try{
			
		String sql = "SELECT * FROM T_ONG_USUARIO WHERE nr_cnpj LIKE ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, "1");
		ResultSet resultado = estrutura.executeQuery();
		UsuarioBean e = new UsuarioBean();
		e.setNr_cpf(resultado.getString("nr_cpf"));
		e.setNm_usuario(resultado.getString("nm_usuario"));
		e.setNr_telefone(Integer.parseInt(resultado.getString("nr_telefone")));
		e.setNr_ddd(Integer.parseInt(resultado.getString("nr_ddd")));
		e.setDs_email(resultado.getString("ds_email"));
		e.setDs_senha(resultado.getString("ds_senha"));	
		resultado.close();
		estrutura.close();
		
		}catch (Exception e){
			System.out.println(e);
		}
		
	}
}
