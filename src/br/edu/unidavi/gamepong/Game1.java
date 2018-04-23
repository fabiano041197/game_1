package br.edu.unidavi.gamepong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javaPlay.GameEngine;

/**
 * Classe que define a incialização do Game Pong
 *
 * @author marcondes
 */
public class Game1 {

    public static void main(String[] args) throws IOException {        
        GameEngine.getInstance().addGameStateController(0, new Player());
        GameEngine.getInstance().setStartingGameStateController(0);
        GameEngine.getInstance().run();
    }

}
