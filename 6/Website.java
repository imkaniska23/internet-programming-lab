import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Java program to connect  a website and Server using
 * ServerSocket and Socket class.
 * 
 * Name: Revanth Reddy 
 * Roll: 16CS8027
 * 
 * Run the program using 'java Website' and visit http://localhost:8080/
 */
public class Website {

    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Welcome to my Website and today is " +today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }

}
