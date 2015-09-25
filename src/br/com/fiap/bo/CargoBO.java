package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Cargo;
import br.com.fiap.dao.CargoDAO;
import br.com.fiap.excecoes.Excecao;

public class CargoBO {
	
	public void novoCargo(Cargo c) throws Exception{
		if(c.getCargo().length()<2){
			throw new Excecao("Caracteres insuficientes no Cargo");
		}
		if(c.getSalario()<700){
			throw new Excecao("Salário não pode ser menor que 700");
		}
		c.setCargo(c.getCargo().toUpperCase());
		c.setCargo(c.getNivel().toUpperCase());
		new CargoDAO().gravar(c);
	}
	public List<Cargo> listarCargos() throws Exception{
		return new CargoDAO().getLista();
	}
	public Cargo consultarCargo(String pCargo) throws Exception{
		return new CargoDAO().getPesquisarCargo(pCargo.toUpperCase());
	}
	public int apagar(String nome) throws Exception{		
		return new CargoDAO().delete(nome);
	}
	public int atualizar(double aumento) throws Exception{		
		return new CargoDAO().update(aumento);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	CargoDAO dao = new CargoDAO();
//
//	public void incluir(String pCargo, String pNivel, double dblSalario)
//			throws Excecao {
//		if (pCargo.length() < 2) {
//			throw new Excecao("Carecteres insuficientes no Cargo");
//		}
//		if (dblSalario < 700) {
//			throw new Excecao("Saário não pode ser menor que 700");
//		}
//		Cargo objeto = new Cargo(pCargo.toUpperCase(), pNivel.toUpperCase(),
//				dblSalario);
//		System.out.println(dao.gravar(objeto));
//		
//	}
//		public void consultar() throws Excecao{
//			System.out.println(dao.exibir());
//		}
//		
//		public void consultarCargo(String pCargo) throws Excecao{
//			dao.exibir(pCargo.toUpperCase());
//		}
//		
//		public void apagar(String pCargo) throws Excecao{
//			dao.deletar(pCargo);			
//			System.out.println(pCargo + "Gravado");
//		}
	
	
		
}
