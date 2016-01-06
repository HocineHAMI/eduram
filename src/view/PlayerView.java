package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Player;

/**
 * Created by victor on 06/01/16.
 */
public class PlayerView {
    private ImageView player;

    public PlayerView(Player crtPlayer){
        player = new ImageView(new Image("file:img/gamePlayer.png"));
        player.setFitWidth(40);
        player.setFitHeight(50);
        player.setX(crtPlayer.getPositionRoom().getPositionX());
        player.setY(crtPlayer.getPositionRoom().getPositionY());
    }
    public ImageView getPlayer(){
        return player;
    }
}
