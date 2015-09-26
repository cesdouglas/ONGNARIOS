package br.com.fiap.beans;

public class VagaBean {
	private int cd_vaga;
	private String nm_vaga;
	private int nr_vaga;
	private String ds_vaga;
	private double vl_salario;
	private String T_ONG_USUARIO_nr_cpf;
	private String T_ONG_EMPRESA_nr_cnpj;
	
	public VagaBean(int cd_vaga, String nm_vaga, int nr_vaga, String ds_vaga,
			double vl_salario, String t_ONG_USUARIO_nr_cpf,
			String t_ONG_EMPRESA_nr_cnpj) {
		super();
		this.cd_vaga = cd_vaga;
		this.nm_vaga = nm_vaga;
		this.nr_vaga = nr_vaga;
		this.ds_vaga = ds_vaga;
		this.vl_salario = vl_salario;
		T_ONG_USUARIO_nr_cpf = t_ONG_USUARIO_nr_cpf;
		T_ONG_EMPRESA_nr_cnpj = t_ONG_EMPRESA_nr_cnpj;
	}

	public VagaBean() {
		super();
	}

	public int getCd_vaga() {
		return cd_vaga;
	}

	public void setCd_vaga(int cd_vaga) {
		this.cd_vaga = cd_vaga;
	}

	public String getNm_vaga() {
		return nm_vaga;
	}

	public void setNm_vaga(String nm_vaga) {
		this.nm_vaga = nm_vaga;
	}

	public int getNr_vaga() {
		return nr_vaga;
	}

	public void setNr_vaga(int nr_vaga) {
		this.nr_vaga = nr_vaga;
	}

	public String getDs_vaga() {
		return ds_vaga;
	}

	public void setDs_vaga(String ds_vaga) {
		this.ds_vaga = ds_vaga;
	}

	public double getVl_salario() {
		return vl_salario;
	}

	public void setVl_salario(double vl_salario) {
		this.vl_salario = vl_salario;
	}

	public String getT_ONG_USUARIO_nr_cpf() {
		return T_ONG_USUARIO_nr_cpf;
	}

	public void setT_ONG_USUARIO_nr_cpf(String t_ONG_USUARIO_nr_cpf) {
		T_ONG_USUARIO_nr_cpf = t_ONG_USUARIO_nr_cpf;
	}

	public String getT_ONG_EMPRESA_nr_cnpj() {
		return T_ONG_EMPRESA_nr_cnpj;
	}

	public void setT_ONG_EMPRESA_nr_cnpj(String t_ONG_EMPRESA_nr_cnpj) {
		T_ONG_EMPRESA_nr_cnpj = t_ONG_EMPRESA_nr_cnpj;
	}	
	
}
