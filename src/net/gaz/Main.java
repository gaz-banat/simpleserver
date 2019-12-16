package net.gaz;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        connectToServer();

    }



    public static void connectToServer() {
        try(ServerSocket serverSocket = new ServerSocket(9991)) {
            Socket connectionSocket = serverSocket.accept();

            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, "UTF-8");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputFromServer, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter (outputStreamWriter, true);

            serverPrintOut.println("Hello World! Enter Peace to exit.");

            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.toLowerCase().trim().equals("peace")) {
                    done = true;
                    continue;
                } else {
                    String capLine = line.toUpperCase();
                    serverPrintOut.println("Capitilized echo from Gazzez Server: " + capLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
