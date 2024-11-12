package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author rahulxxl
 */
public class Client {
    public static final String hostname = "localhost";

    public static void main(String[] args) {
        try {
            // Throws UnknownHostException
            Socket s = new Socket(hostname, Main.port);
            
            // Setting up Streams for Reading from the socket stream
            InputStreamReader inReader = new InputStreamReader(s.getInputStream());
            BufferedReader in = new BufferedReader(inReader);
            
            // Setting up Streams for Writting to the socket stream
            OutputStreamWriter outWriter = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(outWriter, true);
            
            // Reading from keyboard.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to the Server");
            String userInput;
            while ((userInput = keyboard.readLine()) != null) {
                // This will send the message to server
                out.println(userInput);
                // This will recieve the resposne from the server
                String response = in.readLine();
                System.out.println("Server :: " + response);
            }
            // Closing the Streams
            in.close();
            inReader.close();
            out.close();
            outWriter.close();
            keyboard.close();
            
        } catch(UnknownHostException ex){
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
