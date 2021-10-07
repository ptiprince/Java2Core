package Lesson6.socketApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Example of Server's side of Client-Server app. Created with training purpose.
public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)){
            System.out.println("Server is running, waiting for connection!");
            Socket socket = serverSocket.accept();
            System.out.println("Client has connected! ");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true){
                String data = dataInputStream.readUTF();
                if (data.equals("end")) break;
                System.out.println("Message from client received: " + data);
                dataOutputStream.writeUTF("Message sent: " + data);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
