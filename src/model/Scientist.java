package model;

import controller.CreateAntidoteControler;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public class Scientist extends Player {
    public Scientist(Room position, PasswordStack passwordStack, Game g) {
        super(position, passwordStack, g);
    }

    public boolean createAntidote(){
        int nbRouge=0;
        int nbJaune=0;
        int nbVert=0;
        int nbBleu=0;
        for(Password p: game.getCurrentPlayer().getListPassword()){

            if(p.getPassType()== VirusType.RED){
                nbRouge++;
            }
            if(p.getPassType()==VirusType.BLUE){
                nbBleu++;
            }
            if(p.getPassType()==VirusType.GREEN){
                nbVert  ++;
            }
            if(p.getPassType()==VirusType.GOLD){
                nbJaune++;
            }
        }

        int i=0;
        ArrayList<Password> l = new ArrayList<Password>();
        if(nbBleu >= 2 && !game.isAntidoteBleu()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.BLUE){
                    l.add(p);
                    i++;
                    if(i == 2) {
                        for(Password p1 : l){
                            game.getCurrentPlayer().getListPassword().remove(p1);
                        }
                        game.setAntidoteBleu(true);
                        if(game.isAntidoteBleu()&&game.isAntidoteJaune()&&game.isAntidoteVert()&&game.isAntidoteRouge())
                            return true;
                        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
                        if(game.getCurrentPlayer().getNbActions()>=4) {
                            game.getCurrentPlayer().setNbActions(0);
                            game.nextTurn();
                        }
                        break;

                    }
                }
            }
        }else
        if(nbRouge >= 2 && !game.isAntidoteRouge()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.RED){
                    l.add(p);;
                    i++;
                    if(i == 2) {
                        for(Password p1 : l){
                            game.getCurrentPlayer().getListPassword().remove(p1);
                        }
                        game.setAntidoteRouge(true);
                        if(game.isAntidoteBleu()&&game.isAntidoteJaune()&&game.isAntidoteVert()&&game.isAntidoteRouge())
                            return true;
                        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
                        if(game.getCurrentPlayer().getNbActions()>=4) {
                            game.getCurrentPlayer().setNbActions(0);
                            game.nextTurn();
                        }
                        break;
                    }
                }
            }
        }

        else
        if(nbVert >= 2 && !game.isAntidoteVert()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.GREEN){
                    l.add(p);
                    i++;
                    if(i == 2) {
                        for(Password p1 : l){
                            game.getCurrentPlayer().getListPassword().remove(p1);
                        }
                        game.setAntidoteVert(true);
                        if(game.isAntidoteBleu()&&game.isAntidoteJaune()&&game.isAntidoteVert()&&game.isAntidoteRouge())
                            return true;
                        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
                        if(game.getCurrentPlayer().getNbActions()>=4) {
                            game.getCurrentPlayer().setNbActions(0);
                            game.nextTurn();
                        }
                        break;
                    }
                }
            }
        }

        else
        if(nbJaune >= 2 && !game.isAntidoteJaune()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.GOLD){
                    l.add(p);
                    i++;
                    if(i == 2) {
                        for(Password p1 : l){
                            game.getCurrentPlayer().getListPassword().remove(p1);
                        }

                        game.setAntidoteJaune(true);
                        if(game.isAntidoteBleu()&&game.isAntidoteJaune()&&game.isAntidoteVert()&&game.isAntidoteRouge())
                            return true;
                        game.getCurrentPlayer().setNbActions(game.getCurrentPlayer().getNbActions()+1);
                        if(game.getCurrentPlayer().getNbActions()>=4) {
                            game.getCurrentPlayer().setNbActions(0);
                            game.nextTurn();
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
}
