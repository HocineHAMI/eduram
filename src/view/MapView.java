package view;

import controller.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;

/**
 * Created by victor on 11/12/15.
 */
public class MapView extends Application {
    private Stage stage;
    private Scene windowsScene;
    private Pane windowsGroup, gameViewGroup, commandPanelViewGroup;
    private Label eclosionLabel;
    private VBox passwordBox;
    private HBox antivirusBox;
    private Button buttonDeleteVirus, buttonMove, buttonTP1, buttonAntidote, buttonGivePass;
    private Text textStack, titlePassword, titleAntiVirus;
    private int windowsSizeX, windowsSizeY;
    private Game game;
    private Room selectedRoom;
    private Room selectedTpRoom;
    private Password selectedPass;

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

        buttonDeleteVirus = new Button("Supprimer un virus");
        buttonDeleteVirus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(DeleteVirusControler.deleteVirus(game, selectedRoom))
                System.out.println("supression de virus !! : ");
                draw();
            }
        });

        buttonMove = new Button("Déplacement");
        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MoveControler.move(game, selectedRoom);
                System.out.println("test : "+selectedRoom);
                draw();
            }
        });
        buttonTP1 = new Button("Téléportation");
        buttonTP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                MoveControler.moveTp(game, selectedTpRoom, selectedPass);
                draw();

            }
        });


        buttonGivePass = new Button("Donner un Pass");
        buttonGivePass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GivePassword.give(game);
                System.out.println("give a pass !!");
                draw();
            }
        });


        buttonAntidote = new Button("Créer antidote !");
        buttonAntidote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(CreateAntidoteControler.creerAntidote(game)){
                    commandPanelViewGroup.getChildren().clear();
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(stage);
                    VBox dialogVbox = new VBox(20);
                    dialogVbox.getChildren().add(new Text("Félicitation, vous avez gagné !!!!"));
                    Scene dialogScene = new Scene(dialogVbox, 300, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
                else{draw();}
                System.out.println("Tentative antidote !");
            }
        });
        passwordBox = new VBox();
        antivirusBox = new HBox();
        titleAntiVirus = new Text("Anti-Virus");
        titleAntiVirus.setFont(Font.font("Verdana", 20));
        textStack = new Text("Le paquet de carte est plein");
        titleAntiVirus.setFont(Font.font("Verdana", 20));

        eclosionLabel = new Label("Il y a " + game.getNbPropagation() +" éclosions.");
        eclosionLabel.setFont(Font.font("Verdana", 20));
        gameViewGroup = new AnchorPane();
        gameViewGroup.setStyle("-fx-background-color: DAE6F3;");
        commandPanelViewGroup = new FlowPane();
        commandPanelViewGroup.setPadding(new Insets(20, 15, 20, 15));
        ((FlowPane) commandPanelViewGroup).setVgap(25);
        ((FlowPane) commandPanelViewGroup).setHgap(25);
        commandPanelViewGroup.setStyle("-fx-background-color: DAE6F3;"); //#f9f9f9
        commandPanelViewGroup.getChildren().addAll(eclosionLabel, textStack, buttonDeleteVirus, buttonMove, buttonTP1, buttonAntidote, buttonGivePass, passwordBox, titleAntiVirus, antivirusBox);
        commandPanelViewGroup.setMaxSize(30,30);


        windowsGroup = new AnchorPane();
        windowsGroup.getChildren().addAll(gameViewGroup, commandPanelViewGroup);
        AnchorPane.setLeftAnchor(gameViewGroup, 0.0);
        AnchorPane.setRightAnchor(commandPanelViewGroup, 5.0);
        windowsScene = new Scene(windowsGroup, windowsSizeX, windowsSizeY, Color.BLACK);

        draw();

    }

    public void draw()
    {
        gameViewGroup.getChildren().clear();
        passwordBox.getChildren().clear();
        antivirusBox.getChildren().clear();
        eclosionLabel.setText("Il y a " + game.getNbPropagation() + " éclosions.");
        selectedTpRoom = null;
        for (Building b : this.game.getMap().getBuildings()){
        gameViewGroup.getChildren().add((new BuildingView(b.getPositionX(), b.getPositionY(), b.getColor()).getBuilding()));

            for (Room r : b.getRooms()){
                RoomView tmpRoomView = (new RoomView(r,this ,r.getPositionX(), r.getPositionY(), b.getPositionX(), b.getPositionY()));
                gameViewGroup.getChildren().add(tmpRoomView.getRoom());

                for (Room nr : r.getNeighborsRooms()){
                    Line tmpLine = new Line(r.getPositionX()+30, r.getPositionY()+50, nr.getPositionX()+30, nr.getPositionY()+50);
                    tmpLine.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE.deriveColor(0, 0, 0, 0.75), 25, 0, 10, 10));
                    gameViewGroup.getChildren().add(tmpLine);
                }
                int i = 0;
                for (Virus v : r.getViruses()){
                    gameViewGroup.getChildren().add(new VirusView(i, v.getVirusType(), tmpRoomView.getPositionX(), tmpRoomView.getPositionY()).getVirus());
                    i++;
                }

            }
        }
        //Display all players and selected player
        for (int i = 0; i < game.getNbPlayers(); i++) {
            PlayerView tmpPlayer;
            Player p = game.getPlayers().get(i);
            if (p == game.getCurrentPlayer()){
                tmpPlayer = new PlayerView(i, game, p);
                tmpPlayer = TypePlayerController.chooseTypePlayer(i, game, p, tmpPlayer);
                tmpPlayer.setSelectPlayer();
            }else{
                tmpPlayer = new PlayerView(i, game, p);
                tmpPlayer = TypePlayerController.chooseTypePlayer(i, game, p, tmpPlayer);
                tmpPlayer.unselectedPlayer();
            }
            gameViewGroup.getChildren().add(tmpPlayer.getImagePlayer());
        }

        //Display stack
        textStack.setText("Il reste " + game.getPstack().getPstack().size() + " cartes.");

        //Display password
        titlePassword = new Text("Passwords");
        titlePassword.setFont(Font.font("Verdana", 20));
        passwordBox.getChildren().add(titlePassword);
        for (Password p : game.getCurrentPlayer().getListPassword()){
            passwordBox.getChildren().add((new PasswordView(game, p,this)).getPassView());
        }

        //Draw Antivirus
        if (game.isAntidoteBleu()) antivirusBox.getChildren().add(new AntiVirusView(VirusType.BLUE).getAntiVirus());
        if (game.isAntidoteJaune()) antivirusBox.getChildren().add(new AntiVirusView(VirusType.GOLD).getAntiVirus());
        if (game.isAntidoteRouge()) antivirusBox.getChildren().add(new AntiVirusView(VirusType.RED).getAntiVirus());
        if (game.isAntidoteVert()) antivirusBox.getChildren().add(new AntiVirusView(VirusType.GREEN).getAntiVirus());

        //Defeat gestion
        if(testDefaite()){
            gameOverView();
        }

    }

    private boolean testDefaite() {
        if(game.getPstack().getPstack().size()==0){
            return true;
        }
        if(game.getNbPropagation()>=5){
            return true;
        }
        return false;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    public void gameOverView(){
        stage.hide();
        //commandPanelViewGroup.getChildren().clear();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);
        ImageView gameOVER = new ImageView(new Image("file:img/gameOver.png"));
        gameOVER.setFitHeight(700);
        gameOVER.setFitWidth(800);
        dialogVbox.getChildren().add(gameOVER);
        Scene dialogScene = new Scene(dialogVbox, 800, 700);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    public Room getSelectedTpRoom() {
        return selectedTpRoom;
    }

    public void setSelectedTpRoom(Room selectedTpRoom) {
        this.selectedTpRoom = selectedTpRoom;
    }

    public Password getSelectedPass() {
        return selectedPass;
    }

    public void setSelectedPass(Password selectedPass) {
        this.selectedPass = selectedPass;
    }
}
