import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class StartedStopwatch implements State {
    @Override
    public void clickTheButton(Stopwatch stopwatch) {
        System.out.println("Секундомер остановлен");
        stopwatch.setFinish(LocalTime.now());
        stopwatch.setOverall(stopwatch.getOverall().plus(Duration.between(stopwatch.getStart(), stopwatch.getFinish())));
        System.out.println("Показания секундомера: " + stopwatch.getOverall().getMinute() + ":" + stopwatch.getOverall().getSecond() + ":" + stopwatch.getOverall().getNano());
        refreshCheckpoints(stopwatch);
        selectCheckpoint(stopwatch);
        stopwatch.setState(new StoppedStopwatch());
    }

    private void refreshCheckpoints (Stopwatch stopwatch) {
        stopwatch.getCheckpoints()[0] = stopwatch.getCheckpoints()[1];
        stopwatch.getCheckpoints()[1] = stopwatch.getCheckpoints()[2];
        stopwatch.getCheckpoints()[2] = stopwatch.getOverall();
        for (int i = 0; i < stopwatch.getCheckpoints().length; i++) {
            if(stopwatch.getCheckpoints()[i] != null) {
                System.out.println("Показания " + (i + 1) + "-й точки сохранения: " + stopwatch.getCheckpoints()[i].getMinute() + ":" + stopwatch.getCheckpoints()[i].getSecond() + ":" + stopwatch.getCheckpoints()[i].getNano());
            }
        }
    }

    private void selectCheckpoint (Stopwatch stopwatch) {
        System.out.println("С какой точки сохранения начнём в следуюдий раз? Введите 1, 2 или 3");
        Scanner sc = new Scanner(System.in);
        String reply = sc.nextLine();
        switch (Byte.valueOf(reply)) {
            case 1: {
                stopwatch.setOverall(stopwatch.getCheckpoints()[0]);
                break;
            }
            case 2: {
                stopwatch.setOverall(stopwatch.getCheckpoints()[1]);
                break;
            }
            case 3: {
                stopwatch.setOverall(stopwatch.getCheckpoints()[2]);
                break;
            }
            default: {
                System.out.println("Неверный ввод!");
                selectCheckpoint(stopwatch);
            }
        }
    }
}
