package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Quotes;


/**
 * JavaFX App
 */
public class App extends Application {
    Quotes q = new Quotes();

    BorderPane everything = new BorderPane();
    TextArea text = new TextArea();
    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();

        input();
        text.setText(q.toString());
        everything.setCenter(text);
        setupScene();

        var scene = new Scene(everything, 640, 480);
        stage.setScene(scene);
        stage.show();
    }



    private void setupScene(){


    }

    private void update(){
    }


    private void input(){
        Button submit = new Button("Submit");
        Label song = new Label("Song Title:");
        Label quote = new Label("Quote:");
        TextField songInput = new TextField("Song Title");
        TextField quoteInput = new TextField("Quote");
        HBox songs = new HBox();
        songs.getChildren().addAll(song, songInput);
        HBox quotes = new HBox();
        quotes.getChildren().addAll(quote, quoteInput);
        VBox inputs = new VBox();
        inputs.getChildren().addAll(songs,quotes,submit);




        submit.setOnAction(e -> {
            String songstr = songInput.getText().strip();
            String quotestr = quoteInput.getText().strip();
            q.addQuote(songstr, quotestr);
            songInput.clear();
            quoteInput.clear();
            text.setText(q.toString());
            q.save();
        });
        everything.setBottom(inputs);

    }



    public static void main(String[] args) {
        launch();
    }

}