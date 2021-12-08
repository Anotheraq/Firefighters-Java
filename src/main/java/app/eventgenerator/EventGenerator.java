package app.eventgenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import app.event.FireEvent;
import app.event.IEvent;
import app.event.LocalEvent;

import static app.eventgenerator.Constants.FIRE_PROBABILITY;
import static app.eventgenerator.Constants.MAXIMUM_RANGE_X;
import static app.eventgenerator.Constants.MAXIMUM_RANGE_Y;
import static app.eventgenerator.Constants.MINIMUM_RANGE_X;
import static app.eventgenerator.Constants.MINIMUM_RANGE_Y;

public class EventGenerator {

    private static final Random random = new Random();

    public static Position generatePosition() {
        double x = ThreadLocalRandom.current().nextDouble(MINIMUM_RANGE_X, MAXIMUM_RANGE_X);
        double y = ThreadLocalRandom.current().nextDouble(MAXIMUM_RANGE_Y, MINIMUM_RANGE_Y);
        return new Position(x, y);
    }

    public static IEvent generateEvent() {
        if (random.nextInt(FIRE_PROBABILITY) < 3) {
            return new FireEvent();
        }
        return new LocalEvent();
    }
}
