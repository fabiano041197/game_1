/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.gamepong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author 40717
 */

public class Cliente {
    
    private int porta;
    private String ip;     

    private static final long serialVersionUID = 1L;
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;

    public Cliente(int porta, String ip){
        this.porta = porta;
        this.ip = ip;
    }
    
    public void conectar() {
        try{        
            socket = new Socket(ip, porta);
            ou = socket.getOutputStream();
            ouw = new OutputStreamWriter(ou);
            bfw = new BufferedWriter(ouw);
            bfw.flush();
        }
        catch(Exception e){
            //
        }
    }

    public void enviarMensagem(String msg) {

        try{
            if (msg.equals("Sair")) {
                bfw.write("Desconectado \r\n");            
            } else {
                bfw.write(msg + "\r\n");            
            }
            bfw.flush();   
        }
        catch(Exception e){
            //
        }
    }

    public String escutar()  {
        String msg = "";
        try{
            InputStream in = socket.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader bfr = new BufferedReader(inr);
            

            ///while (!"Sair".equalsIgnoreCase(msg)) {
                if (bfr.ready()) {
                    msg = bfr.readLine();
                    if (msg.equals("out")) {
                        //texto.append("Servidor caiu! \r\n");
                        System.out.println("servidor caiu!");
                    } else {
                        //texto.append(msg + "\r\n");
                    }
                }
            //}            
        }
        catch(Exception e){
            //
        }
        return msg;
    }

    public void sair() {
        int[] aux = new int[0];
        try{
            enviarMensagem("Sair");
            bfw.close();
            ouw.close();
            ou.close();
            socket.close();
        }
        catch(Exception e){
            //
        }
                
    }   

}
