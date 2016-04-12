package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Collections;
import java.util.Enumeration;

public class Main extends Application {
    public PrintWriter outGlobal = new PrintWriter(System.out);


    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
        VBox vBox = new VBox(3);
        ScrollPane sp = new ScrollPane(vBox);

        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Label label = new Label("Enter Port");
        gridPane.add(label, 0,0);

        TextField textField = new TextField();
        gridPane.add(textField, 0, 1);

        Label label2 = new Label("Enter IP");
        gridPane.add(label2, 0,2);

        TextField textField2 = new TextField();
        gridPane.add(textField2, 0, 3);

        CheckBox checkBox = new CheckBox("Server?");
        gridPane.add(checkBox, 0, 5);

        Button button = new Button("Connect");
        gridPane.add(button, 0, 6);

        Label status = new Label();
        gridPane.add(status, 0 ,8);

        TextField textField3 = new TextField();
        Button send = new Button("Send");
        Button clear = new Button("clear");
        HBox hBox = new HBox(25, send, clear);




        checkBox.selectedProperty().bindBidirectional(textField2.disableProperty());


        button.setOnAction(event -> {
            if(checkBox.isSelected() && !textField.getText().equals("")){
                if(connectServerWithInfo(textField.getText(), status, vBox)){
                    gridPane.getChildren().clear();
                    HBox hBox1 = new HBox(new Label("Chat"));
                    hBox1.setAlignment(Pos.CENTER);
                    gridPane.add(hBox1, 0,0);
                    gridPane.add(sp, 0, 2);
                    gridPane.add(textField3, 0, 3);
                    gridPane.add(hBox, 0, 5);
                    sp.setPrefHeight(400);
                    sp.setPrefWidth(250);
                    primaryStage.setHeight(475);
                    scene.setOnKeyPressed(event2 -> {
                        switch (event2.getCode()){
                            case ENTER:
                                send.fire();
                        }
                    });
                    send.setOnAction(event1 -> {
                        outGlobal.println(textField3.getText());
                        vBox.getChildren().add(new Label("You: " + textField3.getText()));
                        textField3.setText("");
                    });
                }

            }else{
                if(!textField.getText().equals("") && !textField2.getText().equals("")){
                    if(connectClientWithInfo(textField.getText(), textField2.getText(), status, vBox)){
                        gridPane.getChildren().clear();
                        HBox hBox1 = new HBox(new Label("Chat"));
                        hBox1.setAlignment(Pos.CENTER);
                        gridPane.add(hBox1, 0,0);
                        gridPane.add(sp, 0, 2);
                        gridPane.add(textField3, 0, 3);
                        gridPane.add(hBox, 0, 5);
                        sp.setPrefHeight(400);
                        sp.setPrefWidth(250);
                        primaryStage.setHeight(475);
                        scene.setOnKeyPressed(event2 -> {
                            switch (event2.getCode()){
                                case ENTER:
                                    send.fire();
                            }
                        });
                        send.setOnAction(event1 -> {
                            outGlobal.println(textField3.getText());
                            vBox.getChildren().add(new Label("You: " + textField3.getText()));
                            textField3.setText("");

                        });
                    }
                }
            }
        });

        clear.setOnAction(event1 -> textField3.setText(""));

        primaryStage.setOnCloseRequest(event -> System.exit(0));



        //Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

        //for (NetworkInterface net: Collections.list(nets)) {
        //    displayInterfaceInformation(net);
        //}

        //System.out.println(InetAddress.getLocalHost().getHostAddress());

    }

    private Boolean connectClientWithInfo(String port, String ip, Label status, VBox vBox) {
        int portNum = Integer.parseInt(port);

        try {
            Socket socket = new Socket(ip, portNum);

            WritingToSocket writingToSocket = new WritingToSocket(socket, "Client");
            ReadingFromSocket readingFromSocket = new ReadingFromSocket(socket, vBox, "Client");



            Thread thread = new Thread(writingToSocket);
            thread.start();
            Thread thread2 = new Thread(readingFromSocket);
            thread2.start();
            outGlobal = writingToSocket.out;

        } catch (IOException e) {
            status.setText("Error with thread yo");
            return false;
        }

        return true;
    }

    private Boolean connectServerWithInfo(String port, Label status, VBox vBox) {
        int portNum = Integer.parseInt(port);



        try {
            ServerSocket serverSocket = new ServerSocket(portNum);
            Socket socket = serverSocket.accept();
            status.setText("Connection Successful");

            WritingToSocket writingToSocket = new WritingToSocket(socket, "Server");
            ReadingFromSocket readingFromSocket = new ReadingFromSocket(socket, vBox, "Server");

            Thread thread = new Thread(writingToSocket);
            thread.start();
            Thread thread2 = new Thread(readingFromSocket);
            thread2.start();
            outGlobal = writingToSocket.out;

        } catch (IOException e) {
            status.setText("Error with socket yo");
            return false;
        }

        return true;
    }


    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        System.out.printf("Display name: %s\n", netint.getDisplayName());
        System.out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
