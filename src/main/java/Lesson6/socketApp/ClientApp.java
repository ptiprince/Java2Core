package Lesson6.socketApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
//Example of Client's side of Client-Server app. Created with training purpose.
public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 1234)){
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true){
                System.out.println("Enter new message to send to server");
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                if (message.equals("end")) break;
                System.out.println(dataInputStream.readUTF());
            }
    } catch (UnknownHostException exception){
            exception.printStackTrace();
        } catch (IOException e){
        e.printStackTrace();
    }
    }
}
