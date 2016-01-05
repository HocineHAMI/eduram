package view;

import controller.MoveControler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.*;

import javafx.event.ActionEvent;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene windowsScene;
    private Pane windowsGroup, gameViewGroup, commandPanelViewGroup;
    private Label eclosionLabel;
    private VBox passwordBox;
    private Button buttonInfection, buttonMove, buttonAction2, buttonAction3, buttonAction4;
    private int windowsSizeX, windowsSizeY;
    private Map map;
    private Player player;
    private Room selectedRoom;

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
        buttonMove = new Button("Move");
        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MoveControler.move(player, selectedRoom);
            }
        });
        buttonAction2 = new Button("Action2");
        buttonAction3 = new Button("Action3");
        buttonAction4 = new Button("Action4");

        passwordBox = new VBox();
        eclosionLabel = new Label("Il y a " + 0 +" éclosions.");
        gameViewGroup = new AnchorPane();
        gameViewGroup.setStyle("-fx-background-color: DAE6F3;");
        commandPanelViewGroup = new FlowPane();
        commandPanelViewGroup.setStyle("-fx-background-color: DAE6F3;"); //#f9f9f9
        commandPanelViewGroup.getChildren().addAll(eclosionLabel, buttonInfection, buttonMove, buttonAction2, buttonAction3, buttonAction4);
        commandPanelViewGroup.setMaxSize(30,30);
        FlowPane.setMargin(commandPanelViewGroup, new Insets(100,100,100,100));


        windowsGroup = new AnchorPane();
        windowsGroup.getChildren().addAll(gameViewGroup, commandPanelViewGroup);
        AnchorPane.setLeftAnchor(gameViewGroup, 0.0);
        AnchorPane.setRightAnchor(commandPanelViewGroup, 5.0);
        windowsScene = new Scene(windowsGroup, windowsSizeX, windowsSizeY, Color.BLACK);


        for (Building b : map.getBuildings()){
            gameViewGroup.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY()).getBuilding()));

            for (Room r : b.getRooms()){
                RoomView tmpRoomView = (new RoomView(r.getPositionX(), r.getPositionY(), b.getPositionX(), b.getPositionY()));
                gameViewGroup.getChildren().add(tmpRoomView.getRoom());
                r.infect(new Virus(r, VirusType.GOLD));
                r.infect(new Virus(r, VirusType.RED));

                for (Room nr : r.getNeighborsRooms()){
                    gameViewGroup.getChildren().add(new Line(r.getPositionX()+30, r.getPositionY()+50, nr.getPositionX()+30, nr.getPositionY()+50));
                }
                for (Virus v : r.getViruses()){
                    gameViewGroup.getChildren().add(new VirusView(v.getVirusType(), tmpRoomView.getPositionX(), tmpRoomView.getPositionY()).getVirus());

                }
            }
        }
        player = new Player(map.getBuildings().get(2).getRoomsTmp());
        /*for (Password pwd : player.getListPassword()){
            passwordBox.getChildren().add();
        }
        commandPanelViewGroup.getChildren().add(passwordBox);*/


    }
}
