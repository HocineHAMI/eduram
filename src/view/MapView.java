package view;

import controller.DeleteVirusControler;
import controller.MoveControler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.*;

import javafx.event.ActionEvent;

import java.util.ArrayList;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene windowsScene;
    private Pane windowsGroup, gameViewGroup, commandPanelViewGroup;
    private Label eclosionLabel;
    private VBox passwordBox;
    private Button buttonDeleteVirus, buttonMove, buttonAction2, buttonAction3, buttonAction4;
    private int windowsSizeX, windowsSizeY;
    private Game game;
    private Room selectedRoom;

    public MapView(){
        super();
        this.game = new Game(3);

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

        buttonDeleteVirus = new Button("DeleteVirus");
        buttonDeleteVirus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteVirusControler.deleteVirus(game, selectedRoom);
                System.out.println("supression de virus !! : ");
                draw();
            }
        });

        buttonMove = new Button("Move");
        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MoveControler.move(game, selectedRoom);
                System.out.println("test : "+selectedRoom);
                draw();
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
        commandPanelViewGroup.setPadding(new Insets(10, 5, 10, 5));
        ((FlowPane) commandPanelViewGroup).setVgap(30);
        ((FlowPane) commandPanelViewGroup).setHgap(30);
        commandPanelViewGroup.setStyle("-fx-background-color: DAE6F3;"); //#f9f9f9
        commandPanelViewGroup.getChildren().addAll(eclosionLabel, buttonDeleteVirus, buttonMove, buttonAction2, buttonAction3, buttonAction4, passwordBox);
        commandPanelViewGroup.setMaxSize(30,30);
        FlowPane.setMargin(commandPanelViewGroup, new Insets(100,100,100,100));


        windowsGroup = new AnchorPane();
        windowsGroup.getChildren().addAll(gameViewGroup, commandPanelViewGroup);
        AnchorPane.setLeftAnchor(gameViewGroup, 0.0);
        AnchorPane.setRightAnchor(commandPanelViewGroup, 5.0);
        windowsScene = new Scene(windowsGroup, windowsSizeX, windowsSizeY, Color.BLACK);

        /*for (Password pwd : player.getListPassword()){
            passwordBox.getChildren().add();
        }
        commandPanelViewGroup.getChildren().add(passwordBox);*/
        draw();

    }

    public void draw()
    {
        gameViewGroup.getChildren().removeAll();
        for (Building b : this.game.getMap().getBuildings()){
            gameViewGroup.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY()).getBuilding()));

            for (Room r : b.getRooms()){
                RoomView tmpRoomView = (new RoomView(r,this ,r.getPositionX(), r.getPositionY(), b.getPositionX(), b.getPositionY()));
                gameViewGroup.getChildren().add(tmpRoomView.getRoom());
                /*r.infect(new Virus(r, VirusType.GOLD));
                r.infect(new Virus(r, VirusType.RED));*/

                for (Room nr : r.getNeighborsRooms()){
                    gameViewGroup.getChildren().add(new Line(r.getPositionX()+30, r.getPositionY()+50, nr.getPositionX()+30, nr.getPositionY()+50));
                }
                for (Virus v : r.getViruses()){
                    gameViewGroup.getChildren().add(new VirusView(v.getVirusType(), tmpRoomView.getPositionX(), tmpRoomView.getPositionY()).getVirus());

                }

            }
        }
        for (int i = 0; i < game.getNbPlayers(); i++) {
            Player p = game.getPlayers().get(i);
            gameViewGroup.getChildren().add(new PlayerView(p).getPlayer());
        }

        //Display Player
        gameViewGroup.getChildren().add(new PlayerView(game.getCurrentPlayer()).getPlayer());

        //Display password
        for (Password p : game.getCurrentPlayer().getListPassword()){
            passwordBox.getChildren().add(new Hyperlink(p.getPassword()));
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
}
