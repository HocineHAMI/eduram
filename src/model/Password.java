package model;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by victor on 08/12/15.
 */
public class Password {
    private String pass;
    private Room bond;

    public Password(Room currentBond){
        bond = currentBond;
        pass = new BigInteger(40, new SecureRandom()).toString();
    }

    public String getPassword(){return pass;}

}
