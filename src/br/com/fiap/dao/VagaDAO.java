package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.VagaBean;
import br.com.fiap.conexao.ConexaoFactory;

public class VagaDAO {
	private Connection conexao;
	
	public VagaDAO() throws Exception{
		this.conexao = new ConexaoFactory().getConnection();		
	}
	
	public void insert(VagaBean e) throws Exception{
		String sql = "INSERT INTO T_ONG_VAGA " + "(cd_vaga, nm_vaga, nr_vaga, ds_vaga, vl_salario, T_ONG_USUARIO_nr_cpf, T_ONG_EMPRESA_nr_cnpj) VALUES (SQ_T_ONG_VAGA.nextval,?,?,?,?,?,?)";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, e.getNm_vaga());
		estrutura.setInt(2, e.getNr_vaga());
		estrutura.setString(3, e.getDs_vaga());
		estrutura.setDouble(4, e.getVl_salario());
		estrutura.setString(5, e.getT_ONG_USUARIO_nr_cpf());
		estrutura.setString(6, e.getT_ONG_EMPRESA_nr_cnpj());
		estrutura.execute();
		estrutura.close();
	}
	
	public VagaBean search(String cd_vaga) throws Exception{
		String sql = "SELECT * FROM T_ONG_VAGA WHERE cd_vaga LIKE ?";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, cd_vaga);
		ResultSet resultado = estrutura.executeQuery();
		resultado.next();
		VagaBean e = new VagaBean();
		e.setCd_vaga(Integer.parseInt(resultado.getString("cd_vaga")));	
		e.setNm_vaga(resultado.getString("nm_vaga"));
		e.setNr_vaga(Integer.parseInt(resultado.getString("nr_vaga")));
		e.setDs_vaga(resultado.getString("ds_vaga"));
		e.setVl_salario(Double.parseDouble(resultado.getString("vl_salario")));
		e.setT_ONG_USUARIO_nr_cpf(resultado.getString("T_ONG_USUARIO_nr_cpf"));
		e.setT_ONG_EMPRESA_nr_cnpj(resultado.getString("T_ONG_EMPRESA_nr_cnpj"));
		resultado.close();
		estrutura.close();
		return e;
	}
	
	public int update(VagaBean e) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("UPDATE T_ONG_VAGA SET nm_vaga = ?, nr_vaga = ?, ds_vaga = ?, vl_salario = ?, T_ONG_USUARIO_nr_cpf = ?, T_ONG_EMPRESA_nr_cnpj = ? WHERE cd_vaga = ?");		
		estrutura.setString(1, e.getNm_vaga());
		estrutura.setInt(2, e.getNr_vaga());
		estrutura.setString(3, e.getDs_vaga());
		estrutura.setDouble(4, e.getVl_salario());
		estrutura.setString(5, e.getT_ONG_USUARIO_nr_cpf());
		estrutura.setString(6, e.getT_ONG_EMPRESA_nr_cnpj());
		estrutura.setInt(7, e.getCd_vaga());
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	public int delete(String cd_vaga) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("DELETE FROM T_ONG_VAGA WHERE cd_vaga = ?");		
		estrutura.setString(1, cd_vaga);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
}
