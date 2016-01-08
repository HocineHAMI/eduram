package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Virus;
import model.VirusType;

import java.util.Random;

/**
 * Created by victor on 27/12/15.
 */
public class VirusView {
    private ImageView virus;

    public VirusView(int i, VirusType type, int positionX, int positionY){
        switch (type){
            case GREEN:
                virus = new ImageView(new Image("file:img/greenVirus.png"));
                virus.setFitWidth(25);
                virus.setFitHeight(30);
                virus.setX(positionX-10+i*30);
                virus.setY(positionY-22);
                break;
            case GOLD:
                virus = new ImageView(new Image("file:img/goldVirus.png"));
                virus.setFitWidth(30);
                virus.setFitHeight(30);
                virus.setX(positionX-12+i*30);
                virus.setY(positionY-22);
                break;
            case RED:
                virus = new ImageView(new Image("file:img/redVirus.png"));
                virus.setFitWidth(30);
                virus.setFitHeight(30);
                virus.setX(positionX-12+i*30);
                virus.setY(positionY-22);
                break;
            case BLUE:
                virus = new ImageView(new Image("file:img/blueVirus.png"));
                virus.setFitWidth(25);
                virus.setFitHeight(30);
                virus.setX(positionX-10+i*30);
                virus.setY(positionY-22);
                break;
        }

    }

    public ImageView getVirus(){ return virus;}
}
