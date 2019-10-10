package me.merhlim;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Game {
    String runType;

    public void initialise(){
        if (this.runType.equals("host")) {
            BlockingQueue queue = new ArrayBlockingQueue(1024);
            Server server = new Server(queue);
            Sui ui = new Sui(queue);
            server.start();
            ui.start();
        } else if (this.runType.equals("join")) {
            Client client = new Client();
            Cui ui = new Cui();
            client.start();
            ui.start();
        }

    }
}
