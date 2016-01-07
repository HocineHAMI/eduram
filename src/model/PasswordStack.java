package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kwidz on 13/12/15.
 */
public class PasswordStack {
    private ArrayList<Password> pstack;

    public ArrayList<Password> getPstack() {
        return pstack;
    }

    public PasswordStack(Map m){
        pstack = new ArrayList<Password>();
        for (Building b : m.getBuildings()){
            for (Room r : b.getRooms()){
                pstack.add(new Password(r, b.colorOfVirus));
            }
        }
        Collections.shuffle(pstack);
    }
    public Password getOnePass(){
        Password tmpPass = pstack.get(0);
        pstack.remove(0);
        return tmpPass;
    }
    public boolean isEmpty(){
        return pstack.isEmpty();
    }
}
