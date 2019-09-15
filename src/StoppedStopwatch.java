import java.time.LocalTime;
import java.time.OffsetTime;

public class StoppedStopwatch implements State {
    @Override
    public void clickTheButton(Stopwatch stopwatch) {
        System.out.println("Секундомер запущен");
        stopwatch.setStart(LocalTime.now());
        stopwatch.setState(new StartedStopwatch());
    }
}
