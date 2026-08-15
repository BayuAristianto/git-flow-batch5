package Day22;

public class Student {
    String name = "Bayu";
    int age = 0;

    public void introduce(){
        System.out.println("Hii.. my name is " + name);
    }
}

class main{
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.introduce();
        student2.name = "Pandu";
        student1.introduce();
        student2.introduce();
    }
}