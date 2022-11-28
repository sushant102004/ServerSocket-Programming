import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        try {
            int PORT = 3000;
            String HOST = "192.168.78.246";

            Socket socket = new Socket(HOST, PORT);

            System.out.println("Client Connected");
            System.out.println("Host: " + HOST);
            System.out.println("Port: " + socket.getPort());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Waiting for input......");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String str = null;

            do{
                str = keyboard.readLine();
                out.println(str);

                str = in.readLine();
                System.out.println("From Server: " + str);
            } while(str.equalsIgnoreCase("exit"));
        } catch (Exception e){
            System.out.println(e);
        }
    }
}