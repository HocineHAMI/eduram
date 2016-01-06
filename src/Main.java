import model.Game;
import view.MapView;

/**
 * Created by victor on 15/12/15.
 */
public class Main {
    public static void main (String[] args) throws Exception {
        Game game = new Game(3);
        MapView test = new MapView(game);
        test.launchWindows();
    }
}
