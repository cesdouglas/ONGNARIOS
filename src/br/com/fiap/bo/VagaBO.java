package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.VagaBean;
import br.com.fiap.dao.VagaDAO;

//Classe BO que abrange as regras de negocio
public class VagaBO {
	private VagaDAO dao;
	
	public VagaBO() throws Exception{
		dao = new VagaDAO();
	}
	
	//Verica se a vaga foi inserida
	public boolean inserir(VagaBean e) throws Exception{
		try{
			dao.insert(e);
			return true;
		}catch (Exception f) {
			return false;
		}
	}
	
	public int atualizar(VagaBean e) throws Exception{
		return dao.update(e);
	}
	
	public int deletar(int cd_vaga) throws Exception{
		return dao.delete(cd_vaga);
	}
	
	public List<VagaBean> carregarTodas() throws Exception{
		return dao.all();
	}
	
	public List<VagaBean> buscar(String nome) throws Exception{		
		return dao.search(nome);
	}
	
	//Insere CPF do usuario na Vaga e faz a verificacao
	public boolean insereCPF(String cpf) throws Exception{
		try{
			dao.insertCPF(cpf);
			return true;
		}catch (Exception f) {
			return false;
		}		
	}
}
