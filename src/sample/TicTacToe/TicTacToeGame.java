package sample.TicTacToe;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Main;

import java.awt.*;
import java.awt.Label;

/**
 * Created by augustus on 4/12/16.
 */
public class TicTacToeGame {
    public static Boolean rect1 = false;
    public static Boolean rect2 = false;
    public static Boolean rect3 = false;
    public static Boolean rect4 = false;
    public static Boolean rect5 = false;
    public static Boolean rect6 = false;
    public static Boolean rect7 = false;
    public static Boolean rect8 = false;
    public static Boolean rect9 = false;

    public static Rectangle rectangle1;
    public static Rectangle rectangle2;
    public static Rectangle rectangle3;
    public static Rectangle rectangle4;
    public static Rectangle rectangle5;
    public static Rectangle rectangle6;
    public static Rectangle rectangle7;
    public static Rectangle rectangle8;
    public static Rectangle rectangle9;

    public static char mychar = '-';
    public static boolean myTurn = false;
    public static javafx.scene.control.Label label = new javafx.scene.control.Label("");


    public static void showGame(){
        int recSize = 150;
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(label);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(hBox, gridPane);
        Scene scene = new Scene(vBox, 500, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();



        Graphics2D graphics2D;


        TicTacToeGame.rectangle1 = new Rectangle(recSize, recSize);
        rectangle1.setFill(Paint.valueOf("White"));
        rectangle1.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle1, 0, 0);
        rectangle1.setOnMouseClicked(event -> {
            if(myTurn && rectangle1.getFill().toString().equals("0xffffffff")) {
                Main.outGlobal.println("0 0 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }

        });

         rectangle2 = new Rectangle(recSize, recSize);
        rectangle2.setFill(Paint.valueOf("White"));
        rectangle2.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle2, 0, 1);
        rectangle2.setOnMouseClicked(event -> {
            if(myTurn && rectangle2.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("1 0 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle3 = new Rectangle(recSize, recSize);
        rectangle3.setFill(Paint.valueOf("White"));
        rectangle3.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle3, 0, 2);
        rectangle3.setOnMouseClicked(event -> {
            if(myTurn && rectangle3.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("2 0 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle4 = new Rectangle(recSize, recSize);
        rectangle4.setFill(Paint.valueOf("White"));
        rectangle4.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle4, 1, 0);
        rectangle4.setOnMouseClicked(event -> {
            if(myTurn && rectangle4.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("0 1 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle5 = new Rectangle(recSize, recSize);
        rectangle5.setFill(Paint.valueOf("White"));
        rectangle5.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle5, 1, 1);
        rectangle5.setOnMouseClicked(event -> {
            if(myTurn && rectangle5.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("1 1 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle6 = new Rectangle(recSize, recSize);
        rectangle6.setFill(Paint.valueOf("White"));
        rectangle6.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle6, 1, 2);
        rectangle6.setOnMouseClicked(event -> {
            if(myTurn && rectangle6.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("2 1 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle7 = new Rectangle(recSize, recSize);
        rectangle7.setFill(Paint.valueOf("White"));
        rectangle7.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle7, 2, 0);
        rectangle7.setOnMouseClicked(event -> {
            if(myTurn && rectangle7.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("0 2 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle8 = new Rectangle(recSize, recSize);
        rectangle8.setFill(Paint.valueOf("White"));
        rectangle8.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle8, 2, 1);
        rectangle8.setOnMouseClicked(event -> {
            if(myTurn && rectangle8.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("1 2 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });

         rectangle9 = new Rectangle(recSize, recSize);
        rectangle9.setFill(Paint.valueOf("White"));
        rectangle9.setStroke(Paint.valueOf("Black"));
        gridPane.add(rectangle9, 2, 2);
        rectangle9.setOnMouseClicked(event -> {
            if(myTurn && rectangle9.getFill().toString().equals("0xffffffff")){
                Main.outGlobal.println("2 2 " + mychar);
                myTurn = false;
                TicTacToeGame.label.setText("Player " + TicTacToeGame.mychar + ":");
            }
        });
    }
}
