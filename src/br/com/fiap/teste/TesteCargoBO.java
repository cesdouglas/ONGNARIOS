package br.com.fiap.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cargo;
import br.com.fiap.bo.CargoBO;
import br.com.fiap.excecoes.Excecao;

public class TesteCargoBO {
	public static void main(String[] args) throws Excecao{
		try {
			CargoBO bo = new CargoBO();
			Cargo c = new Cargo();
			do{
				c = new Cargo();
				c.setCargo(JOptionPane.showInputDialog("Digite o cargo"));
				c.setNivel(JOptionPane.showInputDialog("Digite o nivel"));
				c.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o salario")));
				bo.novoCargo(c);				
			}while(JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Teste BO", JOptionPane.YES_NO_OPTION) == 0);
				List<Cargo> lista = bo.listarCargos();
				for(Cargo obj : lista){
					System.out.println(obj.getCargo() + "\n" + obj.getNivel() + "\n" + obj.getSalario());
				}
				String strSearch = JOptionPane.showInputDialog("Digite o cargo que deseja pesquisar");
				c = bo.consultarCargo(strSearch);
				System.out.println(c.getCargo());				
		} catch (Exception e) {
			System.out.println(e);
			throw new Excecao("Falha");
		}
	}
}
