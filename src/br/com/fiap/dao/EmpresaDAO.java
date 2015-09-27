package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.conexao.ConexaoFactory;

//Classe DAO para comunicação com o Banco de dados
public class EmpresaDAO {
	private Connection conexao;
	
	public EmpresaDAO() throws Exception{
		this.conexao = new ConexaoFactory().getConnection();		
	}
	
	//Insere os dados da Empresa
	public void insert(EmpresaBean e) throws Exception{
		String sql = "INSERT INTO T_ONG_EMPRESA " + "(nr_cnpj, nm_empresa, ds_endereco, nr_telefone, nr_ddd, ds_email, ds_senha) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, e.getNr_cnpj());
		estrutura.setString(2, e.getNm_empresa());
		estrutura.setString(3, e.getDs_endereco());
		estrutura.setInt(4, e.getNr_telefone());
		estrutura.setInt(5, e.getNr_ddd());
		estrutura.setString(6, e.getDs_email());
		estrutura.setString(7, e.getDs_senha());
		estrutura.execute();
		estrutura.close();		
	}
	
	//Procura empresa pelo CNPJ
	public EmpresaBean search(String cnpj) throws Exception{
		String sql = "SELECT * FROM T_ONG_EMPRESA WHERE nr_cnpj LIKE ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, cnpj);
		ResultSet resultado = estrutura.executeQuery();
		resultado.next();
		EmpresaBean e = new EmpresaBean();
		e.setNr_cnpj(resultado.getString("nr_cnpj"));
		e.setNm_empresa(resultado.getString("nm_empresa"));
		e.setDs_endereco(resultado.getString("ds_endereco"));
		e.setNr_telefone(Integer.parseInt(resultado.getString("nr_telefone")));
		e.setNr_ddd(Integer.parseInt(resultado.getString("nr_ddd")));
		e.setDs_email(resultado.getString("ds_email"));
		e.setDs_senha(resultado.getString("ds_senha"));	
		resultado.close();
		estrutura.close();
		return e;
	}
	
	//Atualiza dados da empresa
	public int update(EmpresaBean e) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("UPDATE T_ONG_EMPRESA SET nm_empresa = ?, ds_endereco = ?, nr_telefone = ?, nr_ddd = ?, ds_email = ?, ds_senha = ? WHERE nr_cnpj = ?");		
		estrutura.setString(1, e.getNm_empresa());
		estrutura.setString(2, e.getDs_endereco());
		estrutura.setInt(3, e.getNr_telefone());
		estrutura.setInt(4, e.getNr_ddd());
		estrutura.setString(5, e.getDs_email());
		estrutura.setString(6, e.getDs_senha());
		estrutura.setString(7, e.getNr_cnpj());
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	//Deleta empresa
	public int delete(String cnpj) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("DELETE FROM T_ONG_EMPRESA WHERE nr_cnpj = ?");		
		estrutura.setString(1, cnpj);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	//Verifica se a senha e o login são iguais aos digitados no front
	public EmpresaBean login(String cnpj, String senha) throws Exception{	
		String sql = "SELECT * FROM T_ONG_EMPRESA WHERE nr_cnpj LIKE ? AND ds_senha = ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, cnpj);
		estrutura.setString(2, senha);
		ResultSet resultado = estrutura.executeQuery();
		resultado.next();
		EmpresaBean e = new EmpresaBean();		
		e.setNr_cnpj(resultado.getString("nr_cnpj"));
		e.setNm_empresa(resultado.getString("nm_empresa"));
		e.setDs_endereco(resultado.getString("ds_endereco"));
		e.setNr_telefone(Integer.parseInt(resultado.getString("nr_telefone")));
		e.setNr_ddd(Integer.parseInt(resultado.getString("nr_ddd")));
		e.setDs_email(resultado.getString("ds_email"));
		e.setDs_senha(resultado.getString("ds_senha"));	
		resultado.close();
		estrutura.close();
		return e;
	}
}
