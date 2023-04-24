package view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import java.util.ArrayList;

public class Unit extends VBox {

    public Unit(String key, ArrayList<String> values){
        Label keytxt = new Label(key);
        keytxt.setFont(new Font("comic sans ms",30));
        this.getChildren().add(keytxt);
        for(String s : values){
            this.getChildren().add(new Label(s));
        }

    }
}
