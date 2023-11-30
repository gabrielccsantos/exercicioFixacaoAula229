package services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        double installmentValue = contract.getTotalValue() / months;
        for(int i = 0; i < months;i++){
            LocalDate date = contract.getDate().plusMonths(i);
            double fee = onlinePaymentService.paymentFee(installmentValue);
            double interst = onlinePaymentService.interest(fee, months);
            double totalValue = installmentValue + fee + interst;

            contract.addInstallment(new Installment(date, totalValue));
        }
    }
}
