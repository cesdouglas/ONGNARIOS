package br.com.fiap.beans;

//Classe Bean Usuario
public class UsuarioBean {
	private String nr_cpf;
	private String nm_usuario;
	private int nr_telefone;
	private int nr_ddd;
	private String ds_email;
	private String ds_senha;
	
	public UsuarioBean(String nr_cpf, String nm_usuario, int nr_telefone,
			int nr_ddd, String ds_email, String ds_senha) {
		super();
		this.nr_cpf = nr_cpf;
		this.nm_usuario = nm_usuario;
		this.nr_telefone = nr_telefone;
		this.nr_ddd = nr_ddd;
		this.ds_email = ds_email;
		this.ds_senha = ds_senha;
	}

	public UsuarioBean() {
		super();
	}

	public String getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
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
