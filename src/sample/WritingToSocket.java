package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by augustus on 4/11/16.
 */
public class WritingToSocket implements Runnable {
    public Socket socket;
    public PrintWriter out;
    public String name;

    public WritingToSocket(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error with assigning socket output");
        }
        // store parameter for later user
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {


            String inputLine;
            while((inputLine = scanner.nextLine()) != null){
                out.println(inputLine);
            }


            out.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String SendToSocket(String str){
        return str;
    }
}
