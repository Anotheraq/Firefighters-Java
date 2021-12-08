package app.event;

import app.eventgenerator.Position;

public interface IEvent {
    int handle();

    Position getPosition();
}
