package view;

import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
import model.Password;

/**
 * Created by victor on 07/01/16.
 */
public class PasswordView {
    private Hyperlink passView;
    private Password password;

    public PasswordView(Password currentPass){
        password = currentPass;
        passView = new Hyperlink(password.getPassword());
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
