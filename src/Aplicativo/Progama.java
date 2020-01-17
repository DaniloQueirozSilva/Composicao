package Aplicativo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidade.ContratoHora;
import Entidade.Departamento;
import Entidade.Trabalhador;
import Entidade.enums.LevelTrabalho;

public class Progama {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Sálario base: ");
		Double salarioTrabalhador = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, LevelTrabalho.valueOf(nivelTrabalhador), salarioTrabalhador, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos terá esse trabalhor? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do contrato #"+i);
			System.out.print("Digite a data(DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Digite o valor por hora do contrato: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Digite a duração do contrato em horas: ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);  
			trabalhador.addContrato(contrato);
			
		}
		
		System.out.println();
		System.out.print("Digite o mês e ano para calcular o salario (MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0,2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Nome: " + trabalhador.getName());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Ganhou nesse mes " + mesEano+": " + String.format("%.2f", trabalhador.calcularGanho(ano, mes)));
		System.out.println("");
		
		
		
		
		
		
		
		
		sc.close();
		
	}

}
