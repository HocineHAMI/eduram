package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Created by victor on 27/12/15.
 */
public class VirusView {
    private ImageView virus;

    public VirusView(int nbrViruses, int positionX, int positionY){
        switch (nbrViruses){
            case 1:
                virus = new ImageView(new Image("file:img/greenVirus.png"));
                virus.setFitWidth(50);
                virus.setFitHeight(50);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
            case 2:
                virus = new ImageView(new Image("file:img/goldVirus.png"));
                virus.setFitWidth(50);
                virus.setFitHeight(30);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
            case 3:
                virus = new ImageView(new Image("file:img/redVirus.png"));
                virus.setFitWidth(60);
                virus.setFitHeight(40);
                virus.setX(positionX);
                virus.setY(positionY);
                break;
        }

    }

    public ImageView getVirus(){ return virus;}
}
