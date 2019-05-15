package ir.maktab;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author mohammad hashemi
 *
 */

public class ServerMain {
    public static void main(String[] args) {
        //Port of the server that each client should connect to.
        int port = 8818;
        //Use the main thread to accept connection from clients
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println();
                System.out.println("About to accept client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                //Use another thread to handle the communication with the established client's connection.
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
