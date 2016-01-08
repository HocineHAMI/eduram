package model;

/**
 * Created by victor on 08/12/15.
 */
public class Technician extends Player {
    public Technician(Room position, PasswordStack passwordStack, Game g) {
        super(position, passwordStack, g);
    }

    public boolean delVirus(Room r)
    {
        if((r.getViruses().size() != 0) && (this.position==r))
        {
            VirusType mostColor = null;
            int[] nbColor = new int[4];
            int tmpMax=0;
            for(Password p: game.getCurrentPlayer().getListPassword()){
                if(p.getPassType()== VirusType.RED){
                    nbColor[0]++;
                }
                else if(p.getPassType()==VirusType.BLUE){
                    nbColor[1]++;

                }
                else if(p.getPassType()==VirusType.GREEN){
                    nbColor[2]++;

                }
                else if(p.getPassType()==VirusType.GOLD){
                    nbColor[3]++;

                }
            }

            for (int i=0; i < 3; i++){
                if (nbColor[i] > tmpMax){
                    tmpMax = nbColor[i];
                    switch (i){
                        case 0:
                            mostColor = VirusType.RED;
                            break;
                        case 1:
                            mostColor = VirusType.BLUE;
                            break;
                        case 2:
                            mostColor = VirusType.GREEN;
                            break;
                        case 3:
                            mostColor = VirusType.GOLD;
                            break;
                    }
                }
            }
            r.deleteAllVirus(mostColor);
            System.out.println("Super pouvoir Technician ");
            return true;
        }
        return false;
    }
}
