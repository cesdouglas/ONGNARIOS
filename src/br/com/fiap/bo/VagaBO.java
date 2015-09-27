package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.VagaBean;
import br.com.fiap.dao.VagaDAO;

public class VagaBO {
	private VagaDAO dao;
	
	public VagaBO() throws Exception{
		dao = new VagaDAO();
	}
	
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
	
	public int deletar(String cd_vaga) throws Exception{
		return dao.delete(cd_vaga);
	}
	
	public List<VagaBean> carregarTodas() throws Exception{
		return dao.all();
	}
	
	public List<VagaBean> buscar(String nome) throws Exception{
		return dao.search(nome);
	}
	
	public boolean insereCPF(String cpf) throws Exception{
		try{
			dao.insertCPF(cpf);
			return true;
		}catch (Exception f) {
			return false;
		}		
	}
}
