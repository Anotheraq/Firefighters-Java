package app.skkm;

import app.event.IEvent;
import app.jrgstation.IJRGstation;

public interface ISkkm {
    void save(IJRGstation ijrGstation);

    void delete(IJRGstation ijrGstation);

    boolean notifyAll(IEvent event);

    boolean notifySkkm();
}
