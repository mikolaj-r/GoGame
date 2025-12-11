package com.gogame.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public Client(String serverAddress) {
        try {
            socket = new Socket(serverAddress, 8001);

            this.in = new Scanner(socket.getInputStream());
            this.out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            System.err.println("CANT CONNECT TO SERVER: " + e.getMessage());
            System.exit(1);
        }
    }

    public void play() {
        Thread listener = new Thread(() -> {
            try {
                while (in.hasNextLine()) {
                    String response = in.nextLine();
                    System.out.println("SERVER: " + response);
                }
            } catch (Exception e) {
                System.out.println("LOST CONNECTION");
            }
        });
        listener.start();
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost");
        client.play();
    }
}