package Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by andrei.filip on 1/25/2018.
 */
public class ClientSocket {
    private Socket socket;
    private Scanner scanner;
    private ClientSocket(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) throws Exception {
        ClientSocket client = new ClientSocket(
                InetAddress.getByName(args[0]),
                Integer.parseInt(args[1]));

        System.out.println("\r\nConnected to: " + client.socket.getInetAddress());
        client.start();
    }
    private void start() throws IOException {
        String input;
        while (true) {
            input = scanner.nextLine();
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }
}
