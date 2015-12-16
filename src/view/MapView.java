package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        root = new Group();
        scene = new Scene(root, 1500, 800, Color.LIGHTYELLOW);
        int i = 0;
        int j= 0;
        for (Building b : map.getBuildings()){
            i=0;
            for (Room r : b.getRooms()){
                Circle cercle = new Circle();
                cercle.setCenterX(100+i*60);
                cercle.setCenterY(100+j*50);
                cercle.setRadius(20);
                cercle.setFill(Color.YELLOW);
                cercle.setStroke(Color.ORANGE);
                cercle.setStrokeWidth(5);
                root.getChildren().add(cercle);
                i++;
            }
            j++;
        }
    }
}
