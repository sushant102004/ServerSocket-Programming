import java.net.*;
import java.io.*;

class Server {
    public static void main(String args[]) {
        try {
            int PORT = 3000;
            
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started");
            System.out.println("Listening on port: " + serverSocket.getLocalPort());

            serverSocket.setSoTimeout(10000);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String str = null;

            do {
                str = in.readLine();
                System.out.println("From Client: " + str);

                str = keyboard.readLine();
                out.println(str);
            } while (str.equalsIgnoreCase("exit"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}