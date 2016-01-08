package view;

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

    public PasswordView(Game game, Password currentPass){
        this.game = game;
        password = currentPass;
        passView = new Hyperlink(password.getPassword());
        passView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                game.setSelectedPass(password);
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
