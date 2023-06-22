import java.util.Random;
// Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

public class DZ3 {
    public static void main(String[] args) {
    LinkedList lst = new LinkedList();
    Random rnd = new Random();

    for (int i = 0; i < 10; i++) {
        lst.add(rnd.nextInt(100));
    }

    lst.print();
    lst.reverce(); // Разворот списка
    lst.print();


    }
}
