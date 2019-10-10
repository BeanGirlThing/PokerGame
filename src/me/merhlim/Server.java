package me.merhlim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Server extends Thread {
    BlockingQueue queue;
    int port = 42069;
    ServerSocket server;
    ArrayList clients;

    public Server (BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        try {
            this.queue.put("Sconn");
            sleep(100);
            if(this.queue.take().equals("Cconn")){
                System.out.println("Ser Blocking Queue Connection Established");

            }
            System.out.println(this.queue);
            try {
                this.server = new ServerSocket(this.port);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Port in use, Exiting");
                System.exit(0);
            }
            int connectionsMade = 0;
            while (this.clients.size() <= 3) {
                try {
                    Socket tmpClient = this.server.accept();
                    PrintWriter out = new PrintWriter(tmpClient.getOutputStream(),true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(tmpClient.getInputStream()));
                    ArrayList client = new ArrayList();
                    client.add(tmpClient);
                    client.add(out);
                    client.add(in);
                    this.clients.add(client);
                    connectionsMade++;
                } catch (IOException e) {
                    continue;
                } finally {
                    this.queue.put(connectionsMade);
                }
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("There has been an issue with the blocking queue");
            System.exit(1);

        }
    }
}
