package view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import java.util.ArrayList;

public class Unit extends VBox {

    public Unit(String key, ArrayList<String> values){
        Label keytxt = new Label(key);
        keytxt.setFont(new Font("comic sans ms",25));
        this.getChildren().add(keytxt);
        for(String s : values){
            Label l = new Label(s);
            l.setFont(new Font("comic sans ms",20));
            this.getChildren().add(l);
        }
        //this.setBorder(new Border(new BorderStroke()));
        this.setMaxHeight(150);
        this.setMaxWidth(100);

    }


}
