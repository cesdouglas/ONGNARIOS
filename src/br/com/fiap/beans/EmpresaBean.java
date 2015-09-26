package br.com.fiap.beans;

public class EmpresaBean {
	private String nr_cnpj;
	private String nm_empresa;
	private String ds_endereco;
	private int nr_telefone;
	private int nr_ddd;
	private String ds_email;
	private String ds_senha;
	
	public EmpresaBean(String nr_cnpj, String nm_empresa, String ds_endereco,
			int nr_telefone, int nr_ddd, String ds_email, String ds_senha) {
		super();
		this.nr_cnpj = nr_cnpj;
		this.nm_empresa = nm_empresa;
		this.ds_endereco = ds_endereco;
		this.nr_telefone = nr_telefone;
		this.nr_ddd = nr_ddd;
		this.ds_email = ds_email;
		this.ds_senha = ds_senha;
	}

	public EmpresaBean() {
		super();
	}

	public String getNr_cnpj() {
		return nr_cnpj;
	}

	public void setNr_cnpj(String nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}

	public String getNm_empresa() {
		return nm_empresa;
	}

	public void setNm_empresa(String nm_empresa) {
		this.nm_empresa = nm_empresa;
	}

	public String getDs_endereco() {
		return ds_endereco;
	}

	public void setDs_endereco(String ds_endereco) {
		this.ds_endereco = ds_endereco;
	}

	public int getNr_telefone() {
		return nr_telefone;
	}

	public void setNr_telefone(int nr_telefone) {
		this.nr_telefone = nr_telefone;
	}

	public int getNr_ddd() {
		return nr_ddd;
	}

	public void setNr_ddd(int nr_ddd) {
		this.nr_ddd = nr_ddd;
	}

	public String getDs_email() {
		return ds_email;
	}

	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}

	public String getDs_senha() {
		return ds_senha;
	}

	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}
	
	
}
