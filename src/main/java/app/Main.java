package app;

import app.eventgenerator.Position;
import app.event.Event;
import app.jrgstation.JRGStation;
import app.jrgstation.IJRGstation;
import app.skkm.ISkkm;
import app.skkm.Skkm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Main {
    public static void main(String[] args) {
        List<IJRGstation> stations = List.of(
                new JRGStation("1", new Position(50.060026506499206, 19.942913687967124)),
                new JRGStation("2", new Position(50.03381017495707, 19.937377226612714)),
                new JRGStation("3", new Position(50.084966689684386, 19.863450590629313)),
                new JRGStation("4", new Position(50.0378530292807, 20.005756855014358)),
                new JRGStation("5", new Position(50.09234339349529, 19.922380485906324)),
                new JRGStation("6", new Position(50.0164523302028, 20.017011360064917)),
                new JRGStation("7", new Position(50.09411730070909, 19.977544822836308)),
                new JRGStation("8", new Position(50.07841255948872, 20.036627991006)),      //SA
                new JRGStation("9", new Position(49.99067039026655, 19.736245522102028)),   //Skawina
                new JRGStation("10", new Position(50.08267540079839, 19.813889338168238))   //LSP
        );
        ISkkm skkm = new Skkm(new ArrayList<>());
        stations.forEach(skkm::save);

        while (true) {
            try {
                if (skkm.notifySkkm()) {
                    TimeUnit.SECONDS.sleep(1);
                }
                if (!skkm.notifyAll(new Event())) {
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
