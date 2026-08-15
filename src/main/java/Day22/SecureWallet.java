package Day22;

public class SecureWallet {
    private String owner;
    private double initialBalance;


    SecureWallet(String owner, double initialBalance) {
        if (initialBalance < 0) {this.initialBalance = 0.0;}
        else this.initialBalance = initialBalance;


        if (owner.trim().isEmpty()) {this.owner = "Anonymous";}
        else this.owner = owner;
    }


    public String getOwner() {return this.owner;}
    public double getBalance() {return this.initialBalance;}
    public void setOwner(String newOwner) {
//        if (newOwner.trim().isEmpty() || newOwner == null) {
//        }
//        else this.owner = newOwner;


        if (!(newOwner.trim().isEmpty() || newOwner == null)) {
            this.owner = newOwner;
        }
    }


    public boolean deposit(double amount) {
        if (amount > 0) {
            this.initialBalance += amount;
            return true;
        }
        else {
            return false;
        }
    }


    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.initialBalance) {
            this.initialBalance -= amount;
            return true;
        }
        else {
            return false;
        }
    }
}


class Atm {
    public static void main(String[] args) {
        SecureWallet wallet = new SecureWallet("Alice", 100.0);
        wallet.deposit(50.0);       // Output: true  (Saldo jadi 150.0)
        wallet.withdraw(30.0);      // Output: true  (Saldo jadi 120.0)
        wallet.withdraw(200.0);     // Output: false (Gagal, saldo tidak cukup)
        wallet.setOwner("");        // Nama tetap "Alice" karena input kosong
        System.out.println(wallet.getOwner());          // Output: "Alice"
        System.out.println(wallet.getBalance());        // Output: 120.0
    }
}
