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
	public boolean inserir(String nome, String descricao, String salario, String cnpj) throws Exception{
		try{
			VagaBean v = new VagaBean();
			v.setNm_vaga(nome.toUpperCase());
			v.setDs_vaga(descricao.toUpperCase());
			salario = salario.replaceAll(",", ".");
			v.setVl_salario(Double.parseDouble(salario));
			v.setT_ONG_EMPRESA_nr_cnpj(cnpj);
			dao.insert(v);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public int atualizar(String nome, String descricao, String salario, String cnpj, int codigo) throws Exception{
		VagaBean v = new VagaBean();
		v.setNm_vaga(nome.toUpperCase());
		v.setDs_vaga(descricao.toUpperCase());
		salario = salario.replaceAll(",", ".");
		v.setVl_salario(Double.parseDouble(salario));
		v.setT_ONG_EMPRESA_nr_cnpj(cnpj);
		v.setCd_vaga(codigo);
		return dao.update(v);
	}
	
	public int deletar(int cd_vaga) throws Exception{
		return dao.delete(cd_vaga);
	}
	
	public List<VagaBean> carregarTodas() throws Exception{
		return dao.all();
	}
	
	public List<VagaBean> buscar(String nome) throws Exception{		
		return dao.search(nome.toUpperCase());
	}
	
	//Insere CPF do usuario na Vaga e faz a verificacao
	public boolean insereCPF(String cpf, int id) throws Exception{
		try{
			dao.insertCPF(cpf, id);
			return true;
		}catch (Exception f) {
			return false;
		}		
	}
}
