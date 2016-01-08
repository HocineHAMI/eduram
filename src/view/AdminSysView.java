package view;

import controller.PlayerSelectControler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Game;
import model.Player;

/**
 * Created by victor on 08/01/16.
 */
public class AdminSysView extends PlayerView{
    public AdminSysView(int i, Game g, Player crtPlayer){
        super(i, g, crtPlayer);

        imagePlayer = new ImageView(new Image("file:img/sysAdminPlayer.png"));
        imagePlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayerSelectControler.selectPlayer(game, player);
            }
        });
        imagePlayer.setFitWidth(32);
        imagePlayer.setFitHeight(40);

        imagePlayer.setX(crtPlayer.getPositionRoom().getPositionX()+i*20);
        imagePlayer.setY(crtPlayer.getPositionRoom().getPositionY()+10);
    }
}
