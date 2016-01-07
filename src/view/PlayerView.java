package view;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
    public void setSelectPlayer(){
        player.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE.deriveColor(0, 0, 0, 0.75), 25, 0, 10, 10));
    }
    public void unselectedPlayer(){
        player.setEffect(new GaussianBlur(15));
    }
    public ImageView getPlayer(){
        return player;
    }
}
