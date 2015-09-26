package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.beans.UsuarioBean;
import br.com.fiap.conexao.ConexaoFactory;

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO() throws Exception{
		this.conexao = new ConexaoFactory().getConnection();		
	}
	
	public void insert(UsuarioBean e) throws Exception{
		String sql = "INSERT INTO T_ONG_USUARIO " + "(nr_cpf, nm_usuario, nr_telefone, nr_ddd, ds_email, ds_senha) VALUES (?,?,?,?,?,?)";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, e.getNr_cpf());
		estrutura.setString(2, e.getNm_usuario());
		estrutura.setInt(3, e.getNr_telefone());
		estrutura.setInt(4, e.getNr_ddd());
		estrutura.setString(5, e.getDs_email());
		estrutura.setString(6, e.getDs_senha());
		estrutura.execute();
		estrutura.close();
	}
	
	public UsuarioBean search(String cpf) throws Exception{
		String sql = "SELECT * FROM T_ONG_USUARIO WHERE nr_cnpj LIKE ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, cpf);
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
		return e;
	}
	
	public int update(UsuarioBean e) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("UPDATE T_ONG_USUARIO SET nm_usuario = ?, nr_telefone = ?, nr_ddd = ?, ds_email = ?, ds_senha = ? WHERE nr_cpf = ?");		
		estrutura.setString(1, e.getNm_usuario());
		estrutura.setInt(2, e.getNr_telefone());
		estrutura.setInt(3, e.getNr_ddd());
		estrutura.setString(4, e.getDs_email());
		estrutura.setString(5, e.getDs_senha());
		estrutura.setString(6, e.getNr_cpf());
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}

	public int delete(String cpf) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("DELETE FROM T_ONG_USUARIO WHERE nr_cpf = ?");		
		estrutura.setString(1, cpf);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
//	public UsuarioBean login(String cpf, String senha) throws Exception{	
//		String sql = "SELECT * FROM T_ONG_USUARIO WHERE nr_cpf LIKE ? AND ds_senha = ?";
//		PreparedStatement estrutura = conexao.prepareStatement(sql);
//		estrutura.setString(1, cpf);
//		estrutura.setString(2, senha);
//		ResultSet resultado = estrutura.executeQuery();
//		UsuarioBean e = new UsuarioBean();		
//		e.setNr_cpf(resultado.getString("nr_cpf"));
//		e.setNm_usuario(resultado.getString("nm_usuario"));
//		e.setNr_telefone(Integer.parseInt(resultado.getString("nr_telefone")));
//		e.setNr_ddd(Integer.parseInt(resultado.getString("nr_ddd")));
//		e.setDs_email(resultado.getString("ds_email"));
//		e.setDs_senha(resultado.getString("ds_senha"));	
//		resultado.close();
//		estrutura.close();
//		return e;
//	}
	
	
}
