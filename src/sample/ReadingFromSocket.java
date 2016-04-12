package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by augustus on 4/11/16.
 */
public class ReadingFromSocket implements Runnable {
    public Socket socket;
    public VBox vBox;
    public String name;

    public ReadingFromSocket(Socket socket, VBox vbox, String name){
        this.name = name;
        this.socket = socket;
        this.vBox = vbox;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while((inputLine = in.readLine()) != null){
                Label label = new Label("Them: " + inputLine);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        vBox.getChildren().add(label);
                    }
                });

            }

            in.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }    }
}
