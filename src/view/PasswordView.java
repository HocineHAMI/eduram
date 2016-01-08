package view;

import controller.PasswordSelectControler;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Game;
import model.Password;

/**
 * Created by victor on 07/01/16.
 */
public class PasswordView {
    private Hyperlink passView;
    private Password password;
    private Game game;


    public PasswordView(Game sgame, Password currentPass){

        password = currentPass;
        this.game=sgame;
        passView = new Hyperlink(password.getPassword());
        passView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PasswordSelectControler.selectPass(game);
            }
        });
        switch (currentPass.getPassType()){
            case GREEN:
                passView.setTextFill(Color.GREEN);
                break;
            case GOLD:
                passView.setTextFill(Color.GOLD);
                break;
            case RED:
                passView.setTextFill(Color.RED);
                break;
            case BLUE:
                passView.setTextFill(Color.BLUE);
                break;
        }
    }

    public Hyperlink getPassView(){return passView;}
}
