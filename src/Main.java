import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(":Виберіть дію");
        System.out.println("1. Через консоль");
        System.out.println("2. Через потік виведення помилок");
        System.out.println("3. Через файл формату txt");
        switch (scanner.nextInt()) {
            case 1:
                printMessage(scanner.next(), new Printable() {
                    @Override
                    public void print(String msg) {
                        System.out.println("Введіть повідомлення" + msg);
                    }
                });
                break;
            case 2:
                printMessage(scanner.next(), (msg) -> System.out.println(msg));
                break;
            case 3:
                printMessage(scanner.next(), Main::printToFile);
                break;
        }

    }

    static void printMessage(String msg, Printable p) {
        p.print(msg);
    }

    private static void printToFile(String msg) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("text.txt"))) {
            writer.println("Повідомлення: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}