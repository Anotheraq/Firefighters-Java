package app.car;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car {
    private String id;
    private State state;

    public Car() {
        this.id = IdGen.getId();
        this.state = State.FREE;
    }

    public void create(final boolean isFake) {
        setBusy();
        Random random = new Random();

        try {
            int skip = random.nextInt(4);
            TimeUnit.SECONDS.sleep(skip);

            if (!isFake) {
                TimeUnit.SECONDS.sleep(random.nextInt(20) + 5);
            }
            TimeUnit.SECONDS.sleep(skip);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Car " + getId() + " is now can answer the call");
        setFree();
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setFree() {
        this.state = State.FREE;
    }

    public void setBusy() {
        this.state = State.BUSY;
    }
}
