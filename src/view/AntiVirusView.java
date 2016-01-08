package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.VirusType;

/**
 * Created by victor on 08/01/16.
 */
public class AntiVirusView {
    private ImageView antiVirus;

    public AntiVirusView(VirusType type){
        switch (type){
            case GREEN:
                antiVirus = new ImageView(new Image("file:img/greenAntiVirus.png"));
                antiVirus.setFitWidth(40);
                antiVirus.setFitHeight(40);
                break;
            case GOLD:
                antiVirus = new ImageView(new Image("file:img/goldAntiVirus.png"));
                antiVirus.setFitWidth(40);
                antiVirus.setFitHeight(40);
                break;
            case RED:
                antiVirus = new ImageView(new Image("file:img/redAntiVirus.png"));
                antiVirus.setFitWidth(40);
                antiVirus.setFitHeight(40);
                break;
            case BLUE:
                antiVirus = new ImageView(new Image("file:img/blueAntiVirus.png"));
                antiVirus.setFitWidth(40);
                antiVirus.setFitHeight(40);
                break;
        }

    }

    public ImageView getAntiVirus(){ return antiVirus;}
}
