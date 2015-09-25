package br.com.fiap.beans;

public class Cargo implements Comparable<Cargo> {

	private String cargo;
	private String nivel;
	private double salario;

	public String getTudo() {
		return cargo + " -  Nível: " + nivel + " - Salário: " + salario;   
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Cargo(String cargo, String nivel, double salario) {
		super();
		this.cargo = cargo;
		this.nivel = nivel;
		this.salario = salario;
	}
	public Cargo() {
		super();
	}
	public int compareTo(Cargo outro) {
		return this.cargo.compareTo(outro.cargo);
	}
	
//	public int compareTo(Cargo outro) {
//		if (this.salario < outro.salario){
//			return -1;
//		}
//		if (this.salario > outro.salario){
//			return 1;
//		}
//		return 0;
//	}

}
