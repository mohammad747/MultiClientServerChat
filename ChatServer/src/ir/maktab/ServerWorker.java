package ir.maktab;

import java.io.*;
import java.net.Socket;
/**
 * author mohammad hashemi
 *
 */
public class ServerWorker extends Thread {

    //Client Socket
    private final Socket cliectSocket;

    /**
     * Constructor
     *
     * @param clientSocket witch it is each client's socket
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

    /**
     * Handle what has to be done on each client's socket
     */
    private void handleClientSocket(){
        try (cliectSocket) {
            //Create inputStream and OutputStream
            InputStream inputStream = cliectSocket.getInputStream();
            OutputStream outputStream = cliectSocket.getOutputStream();

            //Create reader and writer to read from client's socket
            //and write on it.
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            //Read from client
            String line;
            while( (line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                String msg = "You typed " + line + "\n";
                writer.write(msg);
                writer.flush();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
