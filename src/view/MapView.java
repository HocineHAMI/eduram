package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Building;
import model.Map;
import model.Room;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene scene;
    private Group root;

    private int windowsSizeX;
    private int windowsSizeY;
    private Map map;

    public MapView(){
        map = new Map();
    }
    public void launchWindows(){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception{
        windowsSizeX = 1500;
        windowsSizeY = 800;
        root = new Group();
        scene = new Scene(root, windowsSizeX, windowsSizeY, Color.LIGHTYELLOW);
        int i = 0;
        int j= 0;
        for (Building b : map.getBuildings()){
            i=0;
            root.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY()).getBuilding()));
            for (Room r : b.getRooms()){
                root.getChildren().add((new RoomView(windowsSizeX, windowsSizeY, i, j)).getRoom());
                i++;
            }
            j++;
        }
    }
}
