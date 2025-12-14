package com.gogame.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Game {
    Player currentPlayer;

    public Game() {
        // Inicjacja planszy
    }

    class Player extends Thread {
        int mark;
        Socket socket;
        Scanner input;
        PrintWriter output;

        public Player(Socket socket, int mark) {
            this.socket = socket;
            this.mark = mark;
        }

        @Override
        public void run() {
            try {
                setup();
                while (true) {
                    if (input.hasNextLine()) {
                        String command = input.nextLine();
                        // Pozniej tu bedzie obsluga komend
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR FOR " + mark + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("ERROR IN CLOSING: " + e);
                }
            }
        }

        private void setup() throws IOException {
            input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);

            output.println("CONNECTED. YOU PLAY AS: " + (mark == 1 ? "BLACK" : "WHITE"));
        }
    }
}