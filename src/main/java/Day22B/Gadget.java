package Day22B;

public class Gadget {

    int ukuranLayar = 0;

    public void functionStart(){
        System.out.println("Menyala");
    }
}
class Handphone extends Gadget{
    int megaPixel;

    public void cekrek(){
        System.out.println("Take a Picture");
    }
}
class Contoh {
    public static void main(String[] args) {
        Gadget gadget1 = new Gadget();
        Handphone hp1 = new Handphone();
        gadget1.functionStart();
        hp1.cekrek();
    }
}