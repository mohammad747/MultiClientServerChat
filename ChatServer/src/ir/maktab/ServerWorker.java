package ir.maktab;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * author mohammad hashemi
 *
 */
public class ServerWorker extends Thread {
    //Client Socket
    private final Socket cliectSocket;

    /**
     *
     * @param clientSocket witch accepting each client
     */
    public ServerWorker(Socket clientSocket) {

        this.cliectSocket = clientSocket;
    }

    /**
     * Do the thread works
     */
    @Override
    public void run() {
        handleClientSocket();
    }

    private void handleClientSocket(){
        try {
            InputStream inputStream = cliectSocket.getInputStream();
            OutputStream outputStream = cliectSocket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
