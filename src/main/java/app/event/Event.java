package app.event;

import app.eventgenerator.EventGenerator;
import app.eventgenerator.Position;

public class Event implements IEvent{
    private final IEvent iEvent;
    private final Position position;

    public Event() {
        this.position = EventGenerator.generatePosition();
        this.iEvent = EventGenerator.generateEvent();
    }

    @Override
    public int handle() {
        return this.iEvent.handle();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}
