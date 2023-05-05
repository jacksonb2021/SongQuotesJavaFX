package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;


/**
 * JavaFX App
 */
public class App extends Application {
    Quotes q = new Quotes();

    BorderPane everything = new BorderPane();
    TableViewQuotes tableview;
    @Override
    public void start(Stage stage) {
        input();
        tableview = new TableViewQuotes(q);
        everything.setCenter(tableview);

        var scene = new Scene(everything, 860, 600);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            q.save();
        });
        stage.show();
    }







    private void input(){
        Button submit = new Button("Submit");
        submit.setFont(new Font("Ariel",16));

        Label song = new Label("Song Title:");
        song.setFont(new Font("Ariel",14));
        song.setMinWidth(70);
        song.setAlignment(Pos.CENTER);
        song.setPadding(new Insets(5,5,5,5));


        Label quote = new Label("Quote:");
        quote.setMinWidth(70);
        quote.setAlignment(Pos.CENTER);
        quote.setPadding(new Insets(5,5,5,5));
        quote.setFont(new Font("Ariel",14));


        Label artist = new Label("Artist:");
        artist.setMinWidth(70);
        artist.setAlignment(Pos.CENTER);
        artist.setPadding(new Insets(5,5,5,5));
        artist.setFont(new Font("Ariel",14));

        TextField songInput = new TextField("Song Title");
        songInput.setMinWidth(600);
        songInput.setPadding(new Insets(5,5,5,5));

        TextField quoteInput = new TextField("Quote");
        quoteInput.setMinWidth(600);
        quoteInput.setPadding(new Insets(5,5,5,5));

        TextField artistInput = new TextField("Artist");
        artistInput.setMinWidth(600);
        artistInput.setPadding(new Insets(5,5,5,5));

        HBox artists = new HBox();
        artists.getChildren().addAll(artist,artistInput);
        artists.setAlignment(Pos.CENTER);
        artists.setPadding(new Insets(5,5,5,5));

        HBox songs = new HBox();
        songs.getChildren().addAll(song, songInput);
        songs.setAlignment(Pos.CENTER);
        songs.setPadding(new Insets(5,5,5,5));

        HBox quotes = new HBox();
        quotes.getChildren().addAll(quote, quoteInput);
        quotes.setAlignment(Pos.CENTER);
        quotes.setPadding(new Insets(5,5,5,5));


        VBox inputs = new VBox();
        inputs.getChildren().addAll(songs,artists,quotes,submit);
        inputs.setAlignment(Pos.CENTER);
        HBox bothButtons = new HBox();
        Button remove = new Button("Remove");
        remove.setAlignment(Pos.CENTER);
        remove.setFont(new Font("Ariel",16));

        bothButtons.getChildren().addAll(inputs,remove);
        bothButtons.setAlignment(Pos.CENTER);



        class ButtonHandler implements EventHandler<ActionEvent> {


            @Override
            public void handle(ActionEvent event) {
                String songstr = capitalize(songInput.getText().strip());

                String quotestr =quoteInput.getText().strip();
                String artiststr =  capitalize(artistInput.getText().strip());
                q.addQuote(songstr, artiststr,quotestr);
                songInput.clear();
                quoteInput.clear();
                artistInput.clear();
                tableview.refresh();
                songInput.requestFocus();
                TableView<?> theTable = tableview.getTable();
                theTable.getSelectionModel().select(tableview.getObservableList().indexOf(q.getQuote(songstr,
                        artiststr, quotestr)));
            }
        }
        songInput.addEventFilter(KeyEvent.KEY_PRESSED, k->{
            if(k.getCode().toString().equals("ENTER")) {
                artistInput.requestFocus();
            }
        });
        artistInput.addEventFilter(KeyEvent.KEY_PRESSED, k->{
            if(k.getCode().toString().equals("ENTER")) {
                quoteInput.requestFocus();
            }
        });
        quoteInput.addEventFilter(KeyEvent.KEY_PRESSED,k->{
            if(k.getCode().toString().equals("ENTER")) {
                String songstr = capitalize(songInput.getText().strip());
                String quotestr = quoteInput.getText().strip();
                String artiststr = capitalize(artistInput.getText().strip());
                q.addQuote(songstr, artiststr, quotestr);
                TableView<?> theTable = tableview.getTable();
                songInput.clear();
                quoteInput.clear();
                artistInput.clear();
                tableview.refresh();
                theTable.getSelectionModel().select(tableview.getObservableList().indexOf(q.getQuote(songstr,
                        artiststr, quotestr)));
                songInput.requestFocus();
            }
        });



        //songInput.setOnAction(new ButtonHandler());
        submit.setOnAction(new ButtonHandler());
        remove.setOnAction(k ->{
            TableView<?> theTable;
            theTable = tableview.getTable();
            Quote tableSelect = (Quote) theTable.getSelectionModel().getSelectedItem();
            artistInput.setText(tableSelect.getArtist());
            songInput.setText(tableSelect.getSong());
            quoteInput.setText(tableSelect.getQuote());
            q.deleteQuote(tableSelect);
            tableview.refresh();

        });

        everything.setBottom(bothButtons);

    }

    private String capitalize(String str){
        String ans = "";
        for(String s : str.split(" ")){
            try {
                ans += s.substring(0, 1).toUpperCase();
                ans += s.substring(1);
                ans += " ";
            }catch (Exception e){
                ans += s+= " ";
            }
        }
        ans = ans.strip();
        return ans;
    }



    public static void main(String[] args) {
        launch();
    }




}