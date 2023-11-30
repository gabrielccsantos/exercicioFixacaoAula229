package application;

import model.entities.Contract;
import model.entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = read.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(read.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valueContract = read.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        int installment = read.nextInt();

        Contract contract = new Contract(number, date, valueContract);
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installment);
        System.out.println("Parcelas");
        for(Installment installment1 : contract.getInstallment()){
            System.out.println(installment1);
        }
        read.close();
    }
}