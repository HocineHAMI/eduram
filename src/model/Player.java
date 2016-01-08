package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by victor on 08/12/15.
 */
public /*abstract*/ class Player {
    protected Game game;
    protected Room position;
    protected ArrayList<Password> passwords;
    protected int nbActions=0;


    public Player(Room position, PasswordStack passStack, Game game){
        this.game=game;
        passwords = new ArrayList<Password>();
        getCardFromStack(passStack);
        System.out.println("Creation Player !!!!!");
        this.position = position;
    }

    public boolean move(Room next){

        if(this.position.isNeighbor(next)){
            this.position = next;

            System.out.println("Deplacement Terminé !");
            return true;
        }
        else{
            System.out.println("we can't move here !");

        }
        return false;

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
        if(nbBleu>=3&&!game.isAntidoteBleu()){
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()==VirusType.BLUE){
                    l.add(p);
                    i++;
                    if(i==3) {
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
                    if(i==3) {
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
                    if(i==3) {
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
                    if(i==3) {
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

    public boolean moveTP(Room next, Password pass){

        if(next==null)
            return false;
            this.position = next;
            this.passwords.remove(pass);
        System.out.println(next);
            System.out.println("Deplacement Terminé !");
            return true;

    }

    public void addPassword(Password givePass){
        this.passwords.add(givePass);
    }
    public void lostPassword(Password lostPass){
        this.passwords.remove(lostPass);
    }

    public void getCardFromStack(PasswordStack pstack){
        if (!pstack.isEmpty()){
            passwords.add(pstack.getOnePass());
        }
    }
    public boolean delVirus(Room r)
    {

        if((r.getViruses().size()!=0)&&(this.position==r))
        {
            switch (r.getViruses().get(0).getVirusType()){
                case GREEN:
                    if(game.isAntidoteVert()){
                        r.deleteAllVirus(VirusType.GREEN);
                        return true;
                    }
                case GOLD:
                    if(game.isAntidoteJaune()){
                        r.deleteAllVirus(VirusType.GOLD);
                        return true;
                    }
                case RED:
                    if(game.isAntidoteRouge()){
                        r.deleteAllVirus(VirusType.RED);
                        return true;
                    }
                case BLUE:
                    if(game.isAntidoteBleu()){
                        r.deleteAllVirus(VirusType.BLUE);
                        return true;
                    }
            }
            System.out.println("appel Supression "+r);
            r.delVirus();
            return true;
        }
        return false;
    }

    public ArrayList<Password> getListPassword(){ return passwords;}
    public Room getPositionRoom(){ return position;}

    public int getNbActions() {
        return nbActions;
    }

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }
}
