package Day22B;

// Interface
interface Refundable {
    boolean processRefund(double amount);
}

// Abstract Class
abstract class PaymentMethod {
    protected String transactionId;
    protected double balance;

    public PaymentMethod(String transactionId, double balance) {
        this.transactionId = transactionId;
        this.balance = balance;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getBalance() {
        return balance;
    }

    // Abstract Method
    public abstract boolean pay(double amount);
}

// Concrete Class 1
class CreditCardPayment extends PaymentMethod implements Refundable {
    private double creditLimit;

    public CreditCardPayment(String transactionId, double balance, double creditLimit) {
        super(transactionId, balance);
        // Tulis kode di sini
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean pay(double amount) {
        // Tulis kode di sini
        if (amount > 0 && amount <= (balance + creditLimit)) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                double sisaKekurangan = amount - balance;
                balance = 0.0;
                creditLimit -= sisaKekurangan;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean processRefund(double amount) {
        // Tulis kode di sini
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Concrete Class 2
class EWalletPayment extends PaymentMethod {
    private double cashbackRate;

    public EWalletPayment(String transactionId, double balance, double cashbackRate) {
        super(transactionId, balance);
        // Tulis kode di sini
        this.cashbackRate = cashbackRate;
    }

    @Override
    public boolean pay(double amount) {
        // Tulis kode di sini
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            balance += (amount * cashbackRate);
            return true;
        }
        return false;
    }
}

class danaRefund{
    public static void main(String[] args) {
        // Credit Card Test
        CreditCardPayment cc = new CreditCardPayment("TXN-01", 100.0, 500.0); // Total dana tersedia = 600.0
        System.out.println(cc.pay(200.0)); // Output: true (Gunakan 100 saldo + 100 credit limit)
        System.out.println(cc.getBalance()); // Output: 0.0
        System.out.println(cc.processRefund(50.0)); // Output: true (Saldo bertambah jadi 50.0)

        // E-Wallet Test
        EWalletPayment wallet = new EWalletPayment("TXN-02", 100.0, 0.10); // Saldo 100, Cashback 10%
        System.out.println(wallet.pay(50.0)); // Output: true (Bayar 50 -> saldo sisa 50 + cashback 5 = 55.0)
        System.out.println(wallet.getBalance()); // Output: 55.0

        // Interface Type Checking
        System.out.println(cc instanceof Refundable);     // Output: true
        System.out.println(wallet instanceof Refundable); // Output: false

    }
}

