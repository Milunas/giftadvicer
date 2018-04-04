package milunas.giftadvicer.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class MyServer {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("LISTENING FOR PORT: 8080");
        while (true) {
            Socket client = server.accept();
            /*InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line); line = reader.readLine();
            }*/
            System.out.println("CONNECTED WITH CLIENT");
            Date today = new Date();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
            client.getOutputStream().write(httpResponse.getBytes("UTF-8"));


        }
    }
}
