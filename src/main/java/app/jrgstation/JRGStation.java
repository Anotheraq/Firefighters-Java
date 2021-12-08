package app.jrgstation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.eventgenerator.Position;
import app.car.Car;
import app.event.IEvent;

public class JRGStation implements IJRGstation {

    private final String jrgId;
    private final Position position;
    private List<Car> availableCars = new ArrayList<>();

    public JRGStation(final String id, final Position position) {
        this.jrgId = id;
        this.position = position;

        for (int i = 0; i < 5; i++) {
            availableCars.add(new Car());
        }
    }

    public int getFreeCars() {
        return (int) availableCars.stream()
                .filter(car -> car.getState().getState().equals("FREE"))
                .count();
    }

    @Override
    public void update(final IEvent event, int cars) {
        boolean isFake = new Random().nextInt(100) < 5;

        for (Car car : availableCars) {
            if (cars == 0) {
                break;
            }
            if (car.getState().getState().equals("FREE")) {
                car.setBusy();
                cars--;
                System.out.println("Car " + car.getId() + " is in active situation");
                new Thread(() -> car.create(isFake)).start();
            }
        }
    }

    @Override
    public String getId() {
        return this.jrgId;
    }
    @Override
    public Position getPosition() {
        return this.position;
    }
    @Override
    public int getAvailableCars() {
        return this.getFreeCars();
    }
}
