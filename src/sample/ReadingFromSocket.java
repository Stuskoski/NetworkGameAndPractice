package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import sample.TicTacToe.TicTacToeGame;

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
                System.out.println(inputLine);
                switch (inputLine){
                    case "Start game - Tic Tac Toe":
                        Platform.runLater(TicTacToeGame::showGame);
                        break;
                    case "Tic Tac Toe - Player O":{
                        TicTacToeGame.mychar = 'O';
                        Platform.runLater(() -> {
                            TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ": ");
                            TicTacToeGame.label.setStyle("-fx-text-fill: blue");
                        });
                        break;
                    }
                    case "Tic Tac Toe - Player X":{
                        TicTacToeGame.mychar = 'X';
                        Platform.runLater(() -> {
                            TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ": ");
                            TicTacToeGame.label.setStyle("-fx-text-fill: red");
                        });
                        break;
                    }
                    case "Tic Tac Toe - Your turn":{
                        TicTacToeGame.myTurn = true;
                        Platform.runLater(() -> TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ": Your Turn"));

                        break;
                    }
                    case "0 0 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle1.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "0 1 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle4.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "0 2 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle7.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "1 0 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle2.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "1 1 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle5.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "1 2 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle8.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "2 0 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle3.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "2 1 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle6.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "2 2 red":{
                        Platform.runLater(() -> TicTacToeGame.rectangle9.setFill(Paint.valueOf("Red")));
                        break;
                    }
                    case "0 0 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle1.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "0 1 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle4.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "0 2 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle7.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "1 0 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle2.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "1 1 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle5.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "1 2 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle8.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "2 0 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle3.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "2 1 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle6.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    case "2 2 blue":{
                        Platform.runLater(() -> TicTacToeGame.rectangle9.setFill(Paint.valueOf("Blue")));
                        break;
                    }
                    default:
                        Label label = new Label("Them: " + inputLine);
                        Platform.runLater(() -> vBox.getChildren().add(label));
                        break;
                }


            }

            in.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }    }
}
