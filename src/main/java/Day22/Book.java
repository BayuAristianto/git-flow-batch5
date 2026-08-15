package Day22;

public class Book {
    String title;
    String author;

    Book(){
        title = "Unknown";
        author = "Unknown";
    }

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}

class Books {
    public static void main(String[] args) {
        Book s1 = new Book();
        Book s2 = new Book("King of Jungle", "Bayu");

        System.out.println("Judul " + s1.title + "Penulis " + s1.author);
        System.out.println("Judul " + s2.title + "Penulis " + s2.author);

    }
}
