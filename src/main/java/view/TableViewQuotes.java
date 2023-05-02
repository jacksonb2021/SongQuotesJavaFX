package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Quote;
import model.Quotes;

import java.util.ArrayList;

public class TableViewQuotes extends BorderPane {

    private TableView<Quote> table;
    private static ObservableList<Quote> observableList = FXCollections.observableArrayList();
    private Quotes quotes;
    private TableColumn<Quote, String> song;
    private TableColumn<Quote,String> artist;





    public TableViewQuotes(Quotes quotes){
        TableColumn<Quote, String> quote = new TableColumn<>("Quote");

        song = new TableColumn<>("Song");




        this.quotes = quotes;
        table = new TableView<Quote>();
        artist = new TableColumn<>("Artist");
        song.setCellValueFactory(new PropertyValueFactory<Quote, String>("Song"));
        quote.setCellValueFactory(new PropertyValueFactory<Quote, String>("Quote"));
        artist.setCellValueFactory(new PropertyValueFactory<Quote,String>("Artist"));

        ArrayList<TableColumn<Quote,String>> columns = new ArrayList<>();
        columns.add(song);
        columns.add(quote);
        columns.add(artist);
        for(TableColumn<Quote,String> column: columns){
            column.setCellFactory(tc -> {
                TableCell<Quote, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(column.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                text.setFont(new Font("lato",14));
                return cell ;
            });
        }


        quote.setMinWidth(600);
        artist.setMinWidth(110);
        song.setMinWidth(110);

        table.setItems(observableList);
        table.getColumns().addAll(song, artist, quote);
        observableList.addAll(quotes.getList());
        table.getSortOrder().add(artist);
        this.setCenter(table);



    }

    public void refresh(){

        observableList = FXCollections.observableArrayList();
        observableList.addAll(quotes.getList());
        table.setItems(observableList);
        table.refresh();
        table.getSortOrder().add(artist);
        table.sort();
        this.setCenter(table);
        quotes.save();
    }

    public TableView<Quote> getTable(){
        return table;
    }


}
