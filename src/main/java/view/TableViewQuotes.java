package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Quote;
import model.Quotes;

import java.util.ArrayList;

public class TableViewQuotes extends BorderPane {

    private TableView<Quote> table;
    private static ObservableList<Quote> observableList = FXCollections.observableArrayList();
    private Quotes quotes;

    TableColumn<Quote, String> quote;
    TableColumn<Quote, String> song ;
    TableColumn<Quote,String> artist;


    public TableViewQuotes(Quotes quotes){
        this.quotes = quotes;
        table = new TableView<Quote>();
        quote = new TableColumn<>("Quote");
        song = new TableColumn<>("Song");
        artist = new TableColumn<>("Artist");
        song.setCellValueFactory(new PropertyValueFactory<Quote, String>("Song"));
        quote.setCellValueFactory(new PropertyValueFactory<Quote, String>("Quote"));
        artist.setCellValueFactory(new PropertyValueFactory<Quote,String>("Artist"));
        quote.setMinWidth(500);

        table.setItems(observableList);
        table.getColumns().addAll(song, artist, quote);
        observableList.addAll(quotes.getList());
        table.getSortOrder().add(song);
        this.setCenter(table);



    }

    public void refresh(){

        observableList = FXCollections.observableArrayList();
        observableList.addAll(quotes.getList());
        table.setItems(observableList);
        table.refresh();
        table.getSortOrder().add(song);
        table.sort();
        this.setCenter(table);
    }

    public TableView<Quote> getTable(){
        return table;
    }


}
