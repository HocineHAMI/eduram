package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.Building;
import model.Map;
import model.Room;
import model.Virus;

import java.util.ArrayList;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene scene;
    private Group root;
    private ButtonBar buttonInfection;

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

        buttonInfection = new ButtonBar("Infection");
        root.getChildren().add(buttonInfection);
        int prevPositionX = 100;
        int prevPositionY = 100;

        for (Building b : map.getBuildings()){
            root.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY()).getBuilding()));
            prevPositionX = b.getPositionX()-60;
            prevPositionY = b.getPositionY()+30;
            for (Room r : b.getRooms()){
                RoomView tmpRoomView = (new RoomView(r.getPositionX(), r.getPositionY(), b.getPositionX(), b.getPositionY()));
                root.getChildren().add(tmpRoomView.getRoom());

                prevPositionX = tmpRoomView.getPositionX();
                prevPositionY = tmpRoomView.getPositionY();

                for (Room nr : r.getNeighboorsRooms()){

                    root.getChildren().add(new Line(r.getPositionX()+30, r.getPositionY()+50, nr.getPositionX()+30, nr.getPositionY()+50));
                }
                for (Virus v : r.getViruses()){
                    root.getChildren().add(new VirusView(r.getViruses().size(), tmpRoomView.getPositionX(), tmpRoomView.getPositionY()).getVirus());

                }
            }
        }
    }
}
