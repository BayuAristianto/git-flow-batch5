package Day22;

public class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance < 0 ){
            System.out.println("Balance tidak boleh negatif");
            return;
        }
        this.balance = balance;
    }
}

class Main {

}