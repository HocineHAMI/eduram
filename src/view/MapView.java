package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.Building;
import model.Map;
import model.Room;
import model.Virus;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene windowsScene;
    private Pane windowsGroup, gameViewGroup, commandPanelViewGroup;
    private Button buttonInfection, buttonAction1, buttonAction2, buttonAction3, buttonAction4;
    private int windowsSizeX, windowsSizeY;
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
        stage.setScene(windowsScene);
        stage.show();
    }

    @Override
    public void init() throws Exception{
        //Size of the windows
        windowsSizeX = 1500;
        windowsSizeY = 800;

        buttonInfection = new Button("Infection");
        buttonAction1 = new Button("Action1");
        buttonAction2 = new Button("Action2");
        buttonAction3 = new Button("Action3");
        buttonAction4 = new Button("Action4");

        gameViewGroup = new AnchorPane();
        gameViewGroup.setStyle("-fx-background-color: DAE6F3;");
        commandPanelViewGroup = new FlowPane();
        commandPanelViewGroup.setStyle("-fx-background-color: #efca0e;");
        commandPanelViewGroup.getChildren().addAll(buttonInfection, buttonAction1, buttonAction2, buttonAction3, buttonAction4);
        FlowPane.getMargin(commandPanelViewGroup);

        windowsGroup = new AnchorPane();
        windowsGroup.getChildren().addAll(gameViewGroup, commandPanelViewGroup);
        AnchorPane.setLeftAnchor(gameViewGroup, 0.0);
        AnchorPane.setBottomAnchor(commandPanelViewGroup, 0.0);
        windowsScene = new Scene(windowsGroup, windowsSizeX, windowsSizeY, Color.BLACK);

        int prevPositionX = 100;
        int prevPositionY = 100;

        for (Building b : map.getBuildings()){
            gameViewGroup.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY()).getBuilding()));
            prevPositionX = b.getPositionX()-60;
            prevPositionY = b.getPositionY()+30;
            for (Room r : b.getRooms()){
                RoomView tmpRoomView = (new RoomView(r.getPositionX(), r.getPositionY(), b.getPositionX(), b.getPositionY()));
                gameViewGroup.getChildren().add(tmpRoomView.getRoom());

                prevPositionX = tmpRoomView.getPositionX();
                prevPositionY = tmpRoomView.getPositionY();

                for (Room nr : r.getNeighboorsRooms()){

                    gameViewGroup.getChildren().add(new Line(r.getPositionX()+30, r.getPositionY()+50, nr.getPositionX()+30, nr.getPositionY()+50));
                }
                for (Virus v : r.getViruses()){
                    gameViewGroup.getChildren().add(new VirusView(r.getViruses().size(), tmpRoomView.getPositionX(), tmpRoomView.getPositionY()).getVirus());

                }
            }
        }
    }
}
