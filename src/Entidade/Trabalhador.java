package Entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entidade.enums.LevelTrabalho;

public class Trabalhador {

	private String name;
	private LevelTrabalho levelTrabalho;
	private Double BaseSalario;

	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String name, LevelTrabalho levelTrabalho, Double baseSalario, Departamento departamento,
			List<ContratoHora> contratos) {

		this.name = name;
		this.levelTrabalho = levelTrabalho;
		BaseSalario = baseSalario;
		this.departamento = departamento;
		this.contratos = contratos;
	}

	public Trabalhador(String name, LevelTrabalho levelTrabalho, Double baseSalario, Departamento departamento) {

		this.name = name;
		this.levelTrabalho = levelTrabalho;
		BaseSalario = baseSalario;
		this.departamento = departamento;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LevelTrabalho getLevelTrabalho() {
		return levelTrabalho;
	}

	public void setLevelTrabalho(LevelTrabalho levelTrabalho) {
		this.levelTrabalho = levelTrabalho;
	}

	public Double getBaseSalario() {
		return BaseSalario;
	}

	public void setBaseSalario(Double baseSalario) {
		BaseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double calcularGanho(int ano, int mes) {
		double soma = BaseSalario;

		Calendar cal = Calendar.getInstance();

		for (ContratoHora c : contratos) {
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);

			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotalContrato();
			}

		}
		return soma;

	}

}
