package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author rahulxxl
 */
public class Main {
    public static final int port = 15000;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for Client...");
            Socket socket = ss.accept();
            System.out.println("New Client Connected");
            
            // Shortcut way to create the Reader and Writer Streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            
            String message;
            while((message = in.readLine()) != null){
                System.out.println("Received :: " + message);
                out.println("Hello Friend! You sent :: " + message);
            }
            
            // Closing the Streams
            in.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
