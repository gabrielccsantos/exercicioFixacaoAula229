package services;

public class PaypalService implements OnlinePaymentService{
    private static final Double FEE = 0.02;
    private static final Double SIMPLE_INTEREST = 0.01;

    @Override
    public Double paymentFee(Double amount) {
        return amount * FEE;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * SIMPLE_INTEREST * months;
    }
}
