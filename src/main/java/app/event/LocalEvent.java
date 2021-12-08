package app.event;

import app.eventgenerator.Position;
import app.skkm.alarmStates.LocalAlarm;

public class LocalEvent implements IEvent {

    @Override
    public int handle() {
        return new LocalAlarm().handle();
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
