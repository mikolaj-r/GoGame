package com.gogame.server;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(8001)) {
            System.out.println("SERVER IS WORKING");
            while (true) {
                Game game = new Game();

                Game.Player playerX = game.new Player(listener.accept(), 1); // BLACK
                System.out.println("PLAYER 1 JOINED");

                Game.Player playerO = game.new Player(listener.accept(), 2); // WHITE
                System.out.println("PLAYER 2 JOINED");

                game.currentPlayer = playerX;

                playerX.start();
                playerO.start();
            }
        }
    }
}