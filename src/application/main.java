package application;


import JDBC.sqlJava;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label intro = new Label("Emy");
        Font font = Font.font("Veranda", FontWeight.EXTRA_BOLD, 30);
        intro.setFont(font);

        Label intro0 = new Label("\nWelcome to Emy\n\n");

        Label label = new Label("Username");
        TextField input = new TextField(); input.setPrefWidth(stage.getWidth() / 10);
        input.setPromptText("username");
        VBox vbox = new VBox(label, input);
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);

        Label lbl = new Label("First Name");
        TextField plot = new TextField(); input.setPrefWidth(stage.getWidth() / 4);
        plot.setPromptText("first name");
        VBox cop = new VBox(lbl, plot);
        cop.setSpacing(5);
        cop.setAlignment(Pos.CENTER);

        Label lbl1 = new Label("Last Name");
        TextField plot1 = new TextField(); input.setPrefWidth(stage.getWidth() / 4);
        plot1.setPromptText("last name");
        VBox cop1 = new VBox(lbl1, plot1);
        cop1.setSpacing(5);
        cop1.setAlignment(Pos.CENTER);

        HBox copPane = new HBox(cop, cop1);
        copPane.setSpacing(10);
        copPane.setAlignment(Pos.CENTER);

        Label label0 = new Label("Email address");
        TextField input0 = new TextField();
        input0.setPromptText("email address e.g. example@gmail.com/example@yahoo.com");
        VBox vbox0 = new VBox(label0, input0);
        vbox0.setSpacing(5);
        vbox0.setAlignment(Pos.CENTER);

        Label label1 = new Label("Password");
        PasswordField pw = new PasswordField();
        String text = pw.getText();
        pw.setPromptText("password");
        VBox vbox1 = new VBox(label1, pw);
        vbox1.setSpacing(5);
        vbox1.setAlignment(Pos.CENTER);

        Label label2 = new Label("Confirm Password");
        PasswordField pw1 = new PasswordField();
        String text1 = pw1.getText();
        pw1.setPromptText("confirm password");
        VBox vbox2 = new VBox(label2, pw1);
        vbox2.setSpacing(5);
        vbox2.setAlignment(Pos.CENTER);

        TextField[] allInput = {input, plot, plot1, input0, pw, pw1};

        Button button = new Button("Create Account");
        Font font1 = Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16);
        button.setFont(font1);
        button.setStyle("-fx-color: Green");
        button.setOnAction(actionEvent -> {

            sqlJava store = new sqlJava();
            Connection conn = sqlJava.getConnection();

            PreparedStatement pst = null;
            String sql = "INSERT INTO accountemy VALUES(?, ?, ?, ?, ?, ?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, input.getText());
                pst.setString(2, plot.getText());
                pst.setString(3, plot1.getText());
                pst.setString(4, input0.getText());
                pst.setString(5, pw.getText());
                pst.setString(6, pw1.getText());

                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });



        VBox mainPane = new VBox();
        mainPane.getChildren().addAll(intro, intro0, copPane, vbox, vbox0, vbox1, vbox2, button);
        mainPane.setSpacing(15);
        mainPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainPane);



        stage.setTitle("Login Emy");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();

    }
}