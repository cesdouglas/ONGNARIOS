package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.VagaBean;
import br.com.fiap.conexao.ConexaoFactory;

//Classe DAO para comunicação com o Banco de dados
public class VagaDAO {
	private Connection conexao;
	
	public VagaDAO() throws Exception{
		this.conexao = new ConexaoFactory().getConnection();		
	}
	
	//Insere uma vaga no banco de dados
	public void insert(VagaBean e) throws Exception{
		String sql = "INSERT INTO T_ONG_VAGA " + "(cd_vaga, nm_vaga, ds_vaga, vl_salario, T_ONG_USUARIO_nr_cpf, T_ONG_EMPRESA_nr_cnpj) VALUES (SQ_T_ONG_VAGA.nextval,?,?,?,?,?)";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, e.getNm_vaga());
		estrutura.setString(2, e.getDs_vaga());
		estrutura.setDouble(3, e.getVl_salario());
		estrutura.setString(4, e.getT_ONG_USUARIO_nr_cpf());
		estrutura.setString(5, e.getT_ONG_EMPRESA_nr_cnpj());
		estrutura.execute();
		estrutura.close();
	}
	
	//Procura uma vaga no bando de dados pelo nome
	public List<VagaBean> search(String nome) throws Exception{
		String sql = "SELECT * FROM T_ONG_VAGA WHERE nm_vaga LIKE ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, nome);
		ResultSet resultado = estrutura.executeQuery();
		List<VagaBean> lista = new ArrayList<VagaBean>();
		while(resultado.next()){
			VagaBean e = new VagaBean();
			e.setCd_vaga(Integer.parseInt(resultado.getString("cd_vaga")));	
			e.setNm_vaga(resultado.getString("nm_vaga"));
			e.setDs_vaga(resultado.getString("ds_vaga"));
			e.setVl_salario(Double.parseDouble(resultado.getString("vl_salario")));
			e.setT_ONG_USUARIO_nr_cpf(resultado.getString("T_ONG_USUARIO_nr_cpf"));
			e.setT_ONG_EMPRESA_nr_cnpj(resultado.getString("T_ONG_EMPRESA_nr_cnpj"));
			lista.add(e);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
	
	//Atualiza os dados da vaga
	public int update(VagaBean e) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("UPDATE T_ONG_VAGA SET nm_vaga = ?, ds_vaga = ?, vl_salario = ?, T_ONG_EMPRESA_nr_cnpj = ? WHERE cd_vaga = ?");		
		estrutura.setString(1, e.getNm_vaga());
		estrutura.setString(2, e.getDs_vaga());
		estrutura.setDouble(3, e.getVl_salario());
		estrutura.setString(4, e.getT_ONG_EMPRESA_nr_cnpj());
		estrutura.setInt(5, e.getCd_vaga());
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	//Deleta uma vaga
	public int delete(int cd_vaga) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("DELETE FROM T_ONG_VAGA WHERE cd_vaga = ?");		
		estrutura.setInt(1, cd_vaga);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	//Retorna uma lista com todas as vagas
	public List<VagaBean> all() throws Exception{
		String sql = "SELECT * FROM T_ONG_VAGA";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		ResultSet resultado = estrutura.executeQuery();
		List<VagaBean> lista = new ArrayList<VagaBean>();
		while(resultado.next()){
			VagaBean e = new VagaBean();
			e.setCd_vaga(Integer.parseInt(resultado.getString("cd_vaga")));	
			e.setNm_vaga(resultado.getString("nm_vaga"));
			e.setDs_vaga(resultado.getString("ds_vaga"));
			e.setVl_salario(Double.parseDouble(resultado.getString("vl_salario")));
			e.setT_ONG_USUARIO_nr_cpf(resultado.getString("T_ONG_USUARIO_nr_cpf"));
			e.setT_ONG_EMPRESA_nr_cnpj(resultado.getString("T_ONG_EMPRESA_nr_cnpj"));
			lista.add(e);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
	
	//Insere CPF do Usuario no Banco de dados
	public void insertCPF(String cpf, int id) throws Exception{
		String sql = "UPDATE T_ONG_VAGA SET T_ONG_USUARIO_nr_cpf = ? WHERE CD_VAGA = ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, cpf);
		estrutura.setInt(2, id);
		estrutura.execute();
		estrutura.close();
	}
	
}
