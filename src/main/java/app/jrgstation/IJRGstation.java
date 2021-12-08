package app.jrgstation;

import app.eventgenerator.Position;
import app.event.IEvent;

public interface IJRGstation {
    void update(final IEvent event, final int cars);

    String getId();

    Position getPosition();

    int getAvailableCars();
}
