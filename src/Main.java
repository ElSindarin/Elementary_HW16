import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        initStopwatch();
    }

    public static void initStopwatch () {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setOverall(LocalTime.of(0,0,0));
        stopwatch.setState(new StoppedStopwatch());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Нажмите 1, чтобы нажать кнопку на секундомере. Нажмите 0, чтобы сбросить показания секундомера.");
            byte indicator = sc.nextByte();
            while (indicator != 0 && indicator != 1) {
                System.out.println("Недопустимый ввод, повторите");
                indicator = sc.nextByte();
            }
            if (indicator == 0) {
                System.out.println("Показания секундомера сброшены. Программа завершена");
                return;
            }
            else {
                stopwatch.clickTheButton();
            }
        }
    }
}
