package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Quote;
import model.Quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * JavaFX App
 */
public class testUnit extends Application {
    Quotes q = new Quotes();

    BorderPane everything = new BorderPane();
    GridPane grid = new GridPane();
    TextArea text = new TextArea();
    //HashMap<String, ArrayList<String>> hm;
    ArrayList<Quote> hm;

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
        hm = q.getList();
        everything = new BorderPane();
        grid = new GridPane();
        setupTest();
        everything.setCenter(grid);
        var scene = new Scene(everything, 640, 480);
        stage.setScene(scene);
        stage.show();
    }


    private void setupTest(){
//        for(int i = 1 ; i<5 ; i++){
//            for(int j = 1; j<4  ; j++){
//                Unit u = new Unit
//            }
//        }
        int size = q.size();
//        for(int i=0;i<size;i++){
//            int x = i%size;
//            int y = i/size;
//            Unit u = new Unit()
//        }
        ArrayList<Quote> hm = q.getList();
        int counter = 1;
//        for(Map.Entry<String,ArrayList<String>> entry : hm.entrySet()){
//            int x = counter%size;
//            int y = counter/size;
//            Unit u = new Unit(entry.getKey(),entry.getValue());
//            grid.add(u,x,y);
//            counter ++;
//
//        }
    }






    public static void main(String[] args) {
        launch();
    }

}