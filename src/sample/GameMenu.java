package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.TicTacToe.TicTacToeGame;

/**
 * Created by augustus on 4/12/16.
 */
public class GameMenu {
    public static void showGameMenu(){
        VBox vBox = new VBox(5);
        Scene scene = new Scene(vBox, 150, 250);
        Stage stage = new Stage();
        stage.setTitle("Pick A Game");

        HBox ticTacBox = new HBox();
        ticTacBox.setAlignment(Pos.CENTER);
        Label ticTacToe = new Label("Tic-Tac-Toe");
        ticTacBox.getChildren().add(ticTacToe);

        ticTacBox.setOnMouseEntered(event -> {
            ticTacToe.setStyle("-fx-text-fill: red");
        });
        ticTacBox.setOnMouseExited(event -> {
            ticTacToe.setStyle("-fx-text-fill: black");
        });

        ticTacBox.setOnMouseClicked(event -> {
            Main.outGlobal.println("StartGame - TicTacToe");
            TicTacToeGame.showGame();
        });


        vBox.getChildren().add(ticTacBox);

        stage.setScene(scene);
        stage.show();
    }
}
