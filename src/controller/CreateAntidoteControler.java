package controller;

import model.Game;
import model.Password;
import model.VirusType;

import java.util.ArrayList;

/**
 * Created by kwidz on 07/01/16.
 */
public class CreateAntidoteControler {
    public static boolean creerAntidote(Game game) {
        int nbRouge=0;
        int nbJaune=0;
        int nbVert=0;
        int nbBleu=0;
        for(Password p: game.getCurrentPlayer().getListPassword()){

            if(p.getPassType()== VirusType.RED){
                nbRouge++;
            }
            if(p.getPassType()==VirusType.BLUE){
                nbVert++;
            }
            if(p.getPassType()==VirusType.GOLD){
                nbJaune++;
            }
        }

        int i=0;
        ArrayList<Password> l = new ArrayList<Password>();
        if(nbBleu>=3&&!game.isAntidoteBleu()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.BLUE){
                    l.add(p);
                    i++;
                    if(i==4) {
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
            if(nbRouge>=3&&!game.isAntidoteRouge()){
                for(Password p: game.getCurrentPlayer().getListPassword()){
                    if(p.getPassType()==VirusType.RED){
                        l.add(p);;
                        i++;
                        if(i==4) {
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
            if(nbVert>=3&&!game.isAntidoteVert()){
                for(Password p: game.getCurrentPlayer().getListPassword()){
                    if(p.getPassType()==VirusType.GREEN){
                        l.add(p);
                        i++;
                        if(i==4) {
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
            if(nbJaune>=3&&!game.isAntidoteJaune()){
                for(Password p: game.getCurrentPlayer().getListPassword()){
                    if(p.getPassType()==VirusType.GOLD){
                        l.add(p);
                        i++;
                        if(i==4) {
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
