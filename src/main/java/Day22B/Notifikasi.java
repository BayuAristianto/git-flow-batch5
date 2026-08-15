package Day22B;

public interface Notifikasi {
    void kirim(String pesan);
}

class EmailNotifikasi implements  Notifikasi {

    @Override
    public void kirim(String pesan) {
        System.out.println("Email : " + pesan);
    }
}


