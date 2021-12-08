package app.event;

import app.eventgenerator.Position;
import app.skkm.alarmStates.FireAlarm;

public class FireEvent implements IEvent {

    @Override
    public int handle() {
        return new FireAlarm().handle();
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
