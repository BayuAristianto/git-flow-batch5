package Day22B;

public class Pembayaran {

    public void prosesBayar(){
        System.out.println("Proses Bayar");
    }

}
class EWallet extends Pembayaran{
        @Override public void prosesBayar(){
            System.out.println("Memproses via QRIS/E-Wallet");
        }
}

class TransferBank extends Pembayaran{
    @Override public void prosesBayar(){
        System.out.println("Memproses via Transfer Bank");
    }
}

class Bayar {
    public static void main(String[] args) {
        Pembayaran viaEWallet = new EWallet();
        Pembayaran viaTransfer = new TransferBank();

        viaEWallet.prosesBayar();
        viaTransfer.prosesBayar();
    }
}
