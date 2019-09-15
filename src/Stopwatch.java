import java.time.LocalTime;
import java.util.Queue;


public class Stopwatch {
    private State state;
    private LocalTime start;
    private LocalTime finish;
    private LocalTime overall;
    private LocalTime[] checkpoints = new LocalTime[3];

    public LocalTime[] getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(LocalTime[] checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public LocalTime getOverall() {
        return overall;
    }

    public void setOverall(LocalTime overall) {
        this.overall = overall;
    }

    public void clickTheButton () {
        state.clickTheButton(this);
    }



}
