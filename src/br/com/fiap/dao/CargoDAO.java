package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cargo;
import br.com.fiap.conexao.ConexaoFactory;
//import br.com.fiap.excecoes.Excecao;
/**
 * 
 * 
 * 
 * @author rm73872
 * @version 0
 * @since 0
 * @see CargoBO
 */
public class CargoDAO {
	private Connection conexao;
	private List<Cargo> lstCargos = new ArrayList<Cargo>();
	
//	public String gravar(Cargo c) throws Excecao{
//		lstCargos.add(c);
//		return "Gravado com Sucesso";
//	}
	
//	public String gravar(String pCargo, String pNivel, double pSalario) throws Excecao{
//		lstCargos.add(new Cargo(pCargo, pNivel, pSalario));
//		return "Gravado com sucesso";
//	}
	
	public CargoDAO() throws Exception{
		this.conexao = new ConexaoFactory().getConnection();
	}
	
	public void gravar(Cargo c) throws Exception{
		String sql = "INSERT INTO TB_CARGO " + "(NM_CARGO, DS_NIVEL, VL_SALARIO) VALUES (?,?,?)";
		PreparedStatement estrutura = conexao.prepareStatement(sql);
		estrutura.setString(1, c.getCargo());
		estrutura.setString(2, c.getNivel());
		estrutura.setDouble(3, c.getSalario());
		estrutura.execute();
		estrutura.close();
	}
	
	public int update(double aumento) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("UPDATE TB_CARGO SET VL_SALARIO = VL_SALARIO*(1+?)");
		estrutura.setDouble(1, aumento);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	public int delete(String nome) throws Exception{
		PreparedStatement estrutura = this.conexao.prepareStatement("DELETE FROM TB_CARGO WHERE NM_CARGO = ?");
		estrutura.setString(1, nome);
		int saida = estrutura.executeUpdate();
		estrutura.close();
		return saida;
	}
	
	public List<Cargo> getLista() throws Exception{
		List<Cargo> lstCargos = new ArrayList<Cargo>();
		PreparedStatement estrutura = this.conexao.prepareStatement("SELECT * FROM TB_CARGO");
		ResultSet resultadoDados = estrutura.executeQuery();
		while(resultadoDados.next()){
			Cargo cargo = new Cargo();
			cargo.setCargo(resultadoDados.getString("NM_CARGO"));
			cargo.setNivel(resultadoDados.getString("DS_NIVEL"));
			cargo.setSalario(resultadoDados.getDouble("VL_SALARIO"));
			lstCargos.add(cargo);
		}
		resultadoDados.close();
		estrutura.close();
		
		return lstCargos;
	}
	
//	CREATE TABLE TB_CARGO
//	(
//	  NM_CARGO VARCHAR2(20),
//	  DS_NIVEL VARCHAR2(20),
//	  VL_SALARIO NUMBER(9,2)
//	);[
	
	public Cargo getPesquisarCargo(String strCargo) throws Exception{
		Cargo cargo = new Cargo();
		PreparedStatement estrutura = this.conexao.prepareStatement("SELECT * FROM TB_CARGO WHERE NM_CARGO = ?");
		estrutura.setString(1, strCargo);
		ResultSet resultadoDados = estrutura.executeQuery();
		if(resultadoDados.next()){
			cargo.setCargo(resultadoDados.getString("NM_CARGO"));
			cargo.setNivel(resultadoDados.getString("DS_NIVEL"));
			cargo.setSalario(resultadoDados.getDouble("VL_SALARIO"));
		}
		resultadoDados.close();
		estrutura.close();
		return cargo;
	}
	
	public String exibir(){
		String strSaida="";
		for (Cargo c : lstCargos) {
			strSaida += c.getCargo() + "-Salário " + c.getSalario() + "\n";
		}
		return strSaida;
	}
	public void exibir(String pCargo){
		for (Cargo c : lstCargos) {
			if (c.getCargo().equals(pCargo)) {			
				System.out.println("\n Nível: "+c.getNivel() + "\n Salário: " + c.getSalario());
			}
		}
	}
	
	public void deletar(String pCargo){
		for (Cargo c : lstCargos) {
			if (c.getCargo().equals(pCargo)) {			
				lstCargos.remove(c);
				System.out.println(c.getCargo() + " - Apagado");
			}
		}		
	}
}
