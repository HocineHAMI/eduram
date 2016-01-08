package model;

/**
 * Created by victor on 08/12/15.
 */
public class AdminSys extends Player {
    public AdminSys(Room position, PasswordStack passwordStack, Game g) {
        super(position, passwordStack, g);
    }

    public boolean move(Room next){
            this.position = next;

            System.out.println("Deplacement Terminé !");
            return true;
        }
    }

