import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main extends Application {

    // Declare UI controls
    private RadioButton randLevel, setLevel, randQuantity, setQuantity;
    private TextField playerNum, playerLevel, quantityField, NPCLevelField;
    private TextField hpField, levelField, originField, roleField, subRoleField;
    private TextField strengthField, toughField, athField, brawField, condField, intField, migField;
    private TextField speedField, evaField, acroField, drivField, finField, infField, initField, targField;
    private TextField smartsField, willpowField, alerField, culField, sciField, surField, techField;
    private TextField socialField, clevField, anHandField, decField, perfField, persField, streField;
    private Label playerNumLabel, playerLevelLabel, NPCQuantity, NPCLevel;
    private Label hpLabel, levelLabel, originLabel, roleLabel, subRoleLabel;
    private Label strengthLabel, toughLabel, athLabel, brawLabel, condLabel, intLabel, migLabel;
    private Label speedLabel, evaLabel, acroLabel, drivLabel, finLabel, infLabel, initLabel, targLabel;
    private Label smartsLabel, willpowLabel, alerLabel, culLabel, sciLabel, surLabel, techLabel;
    private Label socialLabel, clevLabel, anHandLabel, decLabel, perfLabel, persLabel, streLabel;
    private Label currentLabel;
    private ToggleGroup numLevelSelect, numQuantitySelect;
    private Button GenerateNPCs, previous, next, clear, writeToFile;

    // Declare Classes and Variables
    Random randVal = new Random();
    public Selections NPCSelect;
    public NPC newNPC;
    public LinkedList<NPC> NPCLinkedList = new LinkedList<NPC>();
    public int quantity = 0, NPCid = 0, level, extraLevel, charNum = 0, currentBot, totalBot = 0;
    public boolean newQuantity = false;
    public String xOfX;

    // Open UI
    public static void main(String[] args) {
        launch(args);
    }

    // Set UI
    @Override
    public void start(Stage primaryStage) {

        playerNumLabel = new Label("Number of Players");                    // Set Number of Players controls
        playerNum = new TextField();
        playerNum.setMaxWidth(25);
        HBox numPlayers = new HBox(10, playerNumLabel, playerNum);       // Set Number of Players HBox
        numPlayers.setAlignment(Pos.CENTER_RIGHT);

        playerLevelLabel = new Label("Player Level");                       // Set Player Level controls
        playerLevel = new TextField();
        playerLevel.setMaxWidth(25);
        HBox levelPlayer = new HBox(10, playerLevelLabel, playerLevel);  // Set Player Level HBox
        levelPlayer.setAlignment(Pos.CENTER_RIGHT);

        VBox players = new VBox(10, numPlayers, levelPlayer);            // Assign number of players and player level to VBox
        players.setAlignment(Pos.CENTER);

        numLevelSelect = new ToggleGroup();                                     // Set toggle group for level radio buttons
        NPCLevel = new Label("NPC Level");                                 // Set Level label
        randLevel = new RadioButton("Random");                             // Assign Random and Set to toggle group
        randLevel.setSelected(true);
        randLevel.setToggleGroup(numLevelSelect);
        setLevel = new RadioButton("Set");
        setLevel.setToggleGroup(numLevelSelect);
        NPCLevelField = new TextField();                                        // Set Level field is Set radio button is selected
        NPCLevelField.setMaxWidth(30);
        NPCLevelField.setVisible(false);
        setLevel.setOnAction(e -> {                                             // Reveal Level field if Set is selected
            NPCLevelField.setVisible(true);
        });
        randLevel.setOnAction(e -> {                                            // Hide Level field if Random is selected
            NPCLevelField.setVisible(false);
        });
        HBox setLevelBox = new HBox(10, setLevel, NPCLevelField);
        setLevelBox.setAlignment(Pos.CENTER);
        VBox levelVB = new VBox(10, NPCLevel, randLevel, setLevelBox);
        levelVB.setAlignment(Pos.CENTER_LEFT);

        numQuantitySelect = new ToggleGroup();
        NPCQuantity = new Label("NPC Quantity");
        randQuantity = new RadioButton("Random");
        randQuantity.setSelected(true);
        randQuantity.setToggleGroup(numQuantitySelect);
        setQuantity = new RadioButton("Set");
        setQuantity.setToggleGroup(numQuantitySelect);
        quantityField = new TextField();
        quantityField.setMaxWidth(30);
        quantityField.setVisible(false);
        setQuantity.setOnAction(e -> {
            quantityField.setVisible(true);
        });
        randQuantity.setOnAction(e -> {
            quantityField.setVisible(false);
        });
        HBox setQuantityBox = new HBox(10, setQuantity, quantityField);
        setQuantityBox.setAlignment(Pos.CENTER);
        VBox quantityVB = new VBox(10, NPCQuantity, randQuantity, setQuantityBox);
        quantityVB.setAlignment(Pos.CENTER_LEFT);

        HBox radioHB = new HBox(50, players, quantityVB, levelVB);
        radioHB.setAlignment(Pos.CENTER);

        GenerateNPCs = new Button("Generate NPC(s)");
        GenerateNPCs.setOnAction(new GenerateNPCsClickHandler());
        HBox runHB = new HBox(GenerateNPCs);
        runHB.setAlignment(Pos.CENTER);


        hpLabel = new Label("HP");
        hpField = new TextField();
        hpField.setEditable(false);
        hpField.setMaxWidth(25);
        VBox hpBox = new VBox(10, hpLabel, hpField);
        hpBox.setAlignment(Pos.CENTER);

        levelLabel = new Label("Level");
        levelField = new TextField();
        levelField.setEditable(false);
        levelField.setMaxWidth(30);
        VBox levelBox = new VBox(10, levelLabel, levelField);
        levelBox.setAlignment(Pos.CENTER);

        originLabel = new Label("Origin");
        originField = new TextField();
        originField.setEditable(false);
        VBox originBox = new VBox(10, originLabel, originField);
        originBox.setAlignment(Pos.CENTER);

        roleLabel = new Label("Role");
        roleField = new TextField();
        roleField.setEditable(false);
        VBox roleBox = new VBox(10, roleLabel, roleField);
        roleBox.setAlignment(Pos.CENTER);

        subRoleLabel = new Label("SubRole");
        subRoleField = new TextField();
        subRoleField.setEditable(false);
        VBox subRoleBox = new VBox(10, subRoleLabel, subRoleField);
        roleBox.setAlignment(Pos.CENTER);

        HBox topInfo = new HBox(25, hpBox, levelBox, originBox, roleBox, subRoleBox);
        topInfo.setAlignment(Pos.CENTER);

        strengthLabel = new Label("Strength");
        strengthLabel.setFont(Font.font(16));
        strengthField = new TextField();
        strengthField.setEditable(false);
        strengthField.setMaxWidth(40);
        HBox strengthBox = new HBox(10, strengthLabel, strengthField);
        strengthBox.setAlignment(Pos.CENTER_RIGHT);

        toughLabel = new Label("Toughness");
        toughLabel.setFont(Font.font(14));
        toughField = new TextField();
        toughField.setEditable(false);
        toughField.setMaxWidth(40);
        HBox toughBox = new HBox(10, toughLabel, toughField);
        toughBox.setAlignment(Pos.CENTER_RIGHT);

        athLabel = new Label("Athletics");
        athField = new TextField();
        athField.setEditable(false);
        athField.setMaxWidth(40);
        HBox athleticsBox = new HBox(10, athLabel, athField);
        athleticsBox.setAlignment(Pos.CENTER_RIGHT);

        brawLabel = new Label("Brawn");
        brawField = new TextField();
        brawField.setEditable(false);
        brawField.setMaxWidth(40);
        HBox brawnBox = new HBox(10, brawLabel, brawField);
        brawnBox.setAlignment(Pos.CENTER_RIGHT);

        condLabel = new Label("Conditioning");
        condField = new TextField();
        condField.setEditable(false);
        condField.setMaxWidth(50);
        HBox condBox = new HBox(10, condLabel, condField);
        brawnBox.setAlignment(Pos.CENTER_RIGHT);

        intLabel = new Label("Intimidation");
        intField = new TextField();
        intField.setEditable(false);
        intField.setMaxWidth(40);
        HBox intimidationBox = new HBox(10, intLabel, intField);
        intimidationBox.setAlignment(Pos.CENTER_RIGHT);

        migLabel = new Label("Might");
        migField = new TextField();
        migField.setEditable(false);
        migField.setMaxWidth(40);
        HBox mightBox = new HBox(10, migLabel, migField);
        mightBox.setAlignment(Pos.CENTER_RIGHT);

        VBox streEssBox = new VBox(10, strengthBox, toughBox, athleticsBox, brawnBox, condBox, intimidationBox, mightBox);
        streEssBox.setAlignment(Pos.TOP_CENTER);

        speedLabel = new Label("Speed");
        speedLabel.setFont(Font.font(16));
        speedField = new TextField();
        speedField.setEditable(false);
        speedField.setMaxWidth(40);
        HBox speedBox = new HBox(10, speedLabel, speedField);
        speedBox.setAlignment(Pos.CENTER_RIGHT);

        evaLabel = new Label("Evasion");
        evaLabel.setFont(Font.font(14));
        evaField = new TextField();
        evaField.setEditable(false);
        evaField.setMaxWidth(40);
        HBox evadeBox = new HBox(10, evaLabel, evaField);
        evadeBox.setAlignment(Pos.CENTER_RIGHT);

        acroLabel = new Label("Acrobatics");
        acroField = new TextField();
        acroField.setEditable(false);
        acroField.setMaxWidth(40);
        HBox acrobaticsBox = new HBox(10, acroLabel, acroField);
        acrobaticsBox.setAlignment(Pos.CENTER_RIGHT);

        drivLabel = new Label("Driving");
        drivField = new TextField();
        drivField.setEditable(false);
        drivField.setMaxWidth(40);
        HBox drivingBox = new HBox(10, drivLabel, drivField);
        drivingBox.setAlignment(Pos.CENTER_RIGHT);

        finLabel = new Label("Finesse");
        finField = new TextField();
        finField.setEditable(false);
        finField.setMaxWidth(40);
        HBox finesseBox = new HBox(10, finLabel, finField);
        finesseBox.setAlignment(Pos.CENTER_RIGHT);

        infLabel = new Label("Infiltration");
        infField = new TextField();
        infField.setEditable(false);
        infField.setMaxWidth(40);
        HBox infiltrationBox = new HBox(10, infLabel, infField);
        infiltrationBox.setAlignment(Pos.CENTER_RIGHT);

        initLabel = new Label("Initiative");
        initField = new TextField();
        initField.setEditable(false);
        initField.setMaxWidth(40);
        HBox initiativeBox = new HBox(10, initLabel, initField);
        initiativeBox.setAlignment(Pos.CENTER_RIGHT);

        targLabel = new Label("Targeting");
        targField = new TextField();
        targField.setEditable(false);
        targField.setMaxWidth(40);
        HBox targetingBox = new HBox(10, targLabel, targField);
        targetingBox.setAlignment(Pos.CENTER_RIGHT);

        VBox speEssBox = new VBox(10, speedBox, evadeBox, acrobaticsBox, drivingBox, finesseBox, infiltrationBox, initiativeBox, targetingBox);
        speEssBox.setAlignment(Pos.TOP_CENTER);

        smartsLabel = new Label("Smarts");
        smartsLabel.setFont(Font.font(16));
        smartsField = new TextField();
        smartsField.setEditable(false);
        smartsField.setMaxWidth(40);
        HBox smartsBox = new HBox(10, smartsLabel, smartsField);
        smartsBox.setAlignment(Pos.CENTER_RIGHT);

        willpowLabel = new Label("Willpower");
        willpowLabel.setFont(Font.font(14));
        willpowField = new TextField();
        willpowField.setEditable(false);
        willpowField.setMaxWidth(40);
        HBox willpowerBox = new HBox(10, willpowLabel, willpowField);
        willpowerBox.setAlignment(Pos.CENTER_RIGHT);

        alerLabel = new Label("Alertness");
        alerField = new TextField();
        alerField.setEditable(false);
        alerField.setMaxWidth(40);
        HBox alertnessBox = new HBox(10, alerLabel, alerField);
        alertnessBox.setAlignment(Pos.CENTER_RIGHT);

        culLabel = new Label("Culture");
        culField = new TextField();
        culField.setEditable(false);
        culField.setMaxWidth(40);
        HBox cultureBox = new HBox(10, culLabel, culField);
        cultureBox.setAlignment(Pos.CENTER_RIGHT);

        sciLabel = new Label("Science");
        sciField = new TextField();
        sciField.setEditable(false);
        sciField.setMaxWidth(40);
        HBox scienceBox = new HBox(10, sciLabel, sciField);
        scienceBox.setAlignment(Pos.CENTER_RIGHT);

        surLabel = new Label("Survival");
        surField = new TextField();
        surField.setEditable(false);
        surField.setMaxWidth(40);
        HBox survivalBox = new HBox(10, surLabel, surField);
        survivalBox.setAlignment(Pos.CENTER_RIGHT);

        techLabel = new Label("Technology");
        techField = new TextField();
        techField.setEditable(false);
        techField.setMaxWidth(40);
        HBox technologyBox = new HBox(10, techLabel, techField);
        technologyBox.setAlignment(Pos.CENTER_RIGHT);

        VBox smaEssBox = new VBox(10, smartsBox, willpowerBox, alertnessBox, cultureBox, scienceBox, survivalBox, technologyBox);
        smaEssBox.setAlignment(Pos.TOP_CENTER);

        socialLabel = new Label("Social");
        socialLabel.setFont(Font.font(16));
        socialField = new TextField();
        socialField.setEditable(false);
        socialField.setMaxWidth(40);
        HBox socialBox = new HBox(10, socialLabel, socialField);
        socialBox.setAlignment(Pos.CENTER_RIGHT);

        clevLabel = new Label("Cleverness");
        clevLabel.setFont(Font.font(14));
        clevField = new TextField();
        clevField.setEditable(false);
        clevField.setMaxWidth(40);
        HBox clevernessBox = new HBox(10, clevLabel, clevField);
        clevernessBox.setAlignment(Pos.CENTER_RIGHT);

        anHandLabel = new Label("Animal Handling");
        anHandField = new TextField();
        anHandField.setEditable(false);
        anHandField.setMaxWidth(40);
        HBox animalHandlingBox = new HBox(10, anHandLabel, anHandField);
        animalHandlingBox.setAlignment(Pos.CENTER_RIGHT);

        decLabel = new Label("Deception");
        decField = new TextField();
        decField.setEditable(false);
        decField.setMaxWidth(40);
        HBox deceptionBox = new HBox(10, decLabel, decField);
        deceptionBox.setAlignment(Pos.CENTER_RIGHT);

        perfLabel = new Label("Performance");
        perfField = new TextField();
        perfField.setEditable(false);
        perfField.setMaxWidth(40);
        HBox performanceBox = new HBox(10, perfLabel, perfField);
        performanceBox.setAlignment(Pos.CENTER_RIGHT);

        persLabel = new Label("Persuasion");
        persField = new TextField();
        persField.setEditable(false);
        persField.setMaxWidth(40);
        HBox persuasionBox = new HBox(10, persLabel, persField);
        persuasionBox.setAlignment(Pos.CENTER_RIGHT);

        streLabel = new Label("Streetwise");
        streField = new TextField();
        streField.setEditable(false);
        streField.setMaxWidth(40);
        HBox streetwiseBox = new HBox(10, streLabel, streField);
        streetwiseBox.setAlignment(Pos.CENTER_RIGHT);

        VBox socEssBox = new VBox(10, socialBox, clevernessBox, animalHandlingBox, deceptionBox, performanceBox, persuasionBox, streetwiseBox);
        socEssBox.setAlignment(Pos.TOP_CENTER);

        HBox essenceBox = new HBox(50,streEssBox, speEssBox, smaEssBox, socEssBox);
        essenceBox.setAlignment(Pos.CENTER);

        previous = new Button("Previous");
        previous.setDisable(true);
        previous.setOnAction(new PreviousClickHandler());
        currentLabel = new Label();
        next = new Button("Next");
        next.setDisable(true);
        next.setOnAction(new NextClickHandler());
        HBox prevNextHB = new HBox(25, previous, currentLabel, next);
        prevNextHB.setAlignment(Pos.CENTER);

        clear = new Button("Clear List");
        clear.setDisable(true);
        clear.setOnAction(new ClearClickHandler());
        writeToFile = new Button("Write to File & Clear");
        writeToFile.setDisable(true);
        writeToFile.setOnAction(new WriteToFileClickHandler());
        HBox clearWrite = new HBox(40, clear, writeToFile);
        clearWrite.setAlignment(Pos.CENTER);

        VBox TotalVB = new VBox(30, radioHB, runHB, topInfo, essenceBox, prevNextHB, clearWrite);
        TotalVB.setAlignment(Pos.CENTER);

        Scene scene = new Scene(TotalVB, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NPC Generator");
        primaryStage.show();
    }

    class GenerateNPCsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            String origin, role, subRole;
            int[] strengthStats, speedStats, smartsStats, socialStats;
            int temp = 0, hp;
            String diceTemp;
            Alert tooLow = new Alert(Alert.AlertType.ERROR);
            tooLow.setContentText("Entered values must be higher than 0");
            Alert tooHigh = new Alert(Alert.AlertType.ERROR);
            tooHigh.setContentText("Entered values must be lower than 21");
            try {
                if (setQuantity.isSelected()) {
                    quantity = Integer.parseInt(quantityField.getText());
                    if (quantity < 1) {
                        tooLow.show();
                    }
                } else if (randQuantity.isSelected()) {
                    quantity = randVal.nextInt(5) + 1;
                }
                if (Integer.parseInt(playerLevel.getText()) < 1 | Integer.parseInt(playerNum.getText()) < 1) {
                    tooLow.show();
                }
                temp = Integer.parseInt(playerLevel.getText()) * Integer.parseInt(playerNum.getText());
                if (setLevel.isSelected()) {
                    level = Integer.parseInt(NPCLevelField.getText());
                    if (level < 1) {
                        tooLow.show();
                    }
                    if (level > 20) {
                        tooHigh.show();
                    }
                } else if (randLevel.isSelected()) {
                    level = temp / quantity;
                    if (level == 0) {
                        level++;
                    }
                }
                if (quantity > 0 && level > 0) {
                    for (int i = 0; i < quantity; i++) {
                        charNum++;
                        if (i == quantity - 1 && newQuantity) {
                            level = extraLevel;
                            newQuantity = false;
                        }
                        if (level > 20 && !newQuantity) {
                            quantity++;
                            extraLevel = (level - 20) * (quantity - 1);
                            level = 20;
                            newQuantity = true;
                        }
                        NPCSelect = new Selections(level);
                        origin = NPCSelect.getNewOrigin();
                        role = NPCSelect.getNewRole();
                        subRole = NPCSelect.getNewSubRole();
                        strengthStats = NPCSelect.getStrength();
                        speedStats = NPCSelect.getSpeed();
                        smartsStats = NPCSelect.getSmarts();
                        socialStats = NPCSelect.getSocial();
                        hp = NPCSelect.getHP();
                        newNPC = new NPC(origin, role, subRole, strengthStats, speedStats, smartsStats, socialStats, hp, level);
                        NPCLinkedList.add(newNPC);
                        hp = 0;
                        if (charNum > 1) {
                            next.setDisable(false);
                        }
                    }
                }
                totalBot += quantity;
                NPCLinkedList.resetList();
                newNPC = new NPC();
                newNPC = NPCLinkedList.getNextItem();
                origin = newNPC.getOrigin();
                role = newNPC.getRole();
                subRole = newNPC.getSubRole();
                hp = newNPC.getHP();
                level = newNPC.getLevel();
                strengthStats = newNPC.getStrength();
                speedStats = newNPC.getSpeed();
                smartsStats = newNPC.getSmarts();
                socialStats = newNPC.getSocial();
                hpField.setText(String.valueOf(hp));
                levelField.setText(String.valueOf(level));
                originField.setText(origin);
                roleField.setText(role);
                subRoleField.setText(subRole);
                temp = strengthStats[0] + strengthStats[1] + strengthStats[2] + strengthStats[3] + strengthStats[4];
                strengthField.setText(String.valueOf(temp));
                temp += 10;
                toughField.setText(String.valueOf(temp));
                temp = strengthStats[0];
                diceTemp = diceSetter(temp);
                athField.setText(diceTemp);
                temp = strengthStats[1];
                diceTemp = diceSetter(temp);
                brawField.setText(diceTemp);
                temp = strengthStats[2];
                if (temp == 0) {
                    diceTemp = "N/A";
                }
                else {
                    diceTemp = "+" + temp + " HP";
                }
                condField.setText(diceTemp);
                temp = strengthStats[3];
                diceTemp = diceSetter(temp);
                intField.setText(diceTemp);
                temp = strengthStats[4];
                diceTemp = diceSetter(temp);
                migField.setText(diceTemp);
                temp = speedStats[0] + speedStats[1] + speedStats[2] + speedStats[3] + speedStats[4] + speedStats[5];
                speedField.setText(String.valueOf(temp));
                temp += 10;
                evaField.setText(String.valueOf(temp));
                temp = speedStats[0];
                diceTemp = diceSetter(temp);
                acroField.setText(diceTemp);
                temp = speedStats[1];
                diceTemp = diceSetter(temp);
                drivField.setText(diceTemp);
                temp = speedStats[2];
                diceTemp = diceSetter(temp);
                finField.setText(diceTemp);
                temp = speedStats[3];
                diceTemp = diceSetter(temp);
                infField.setText(diceTemp);
                temp = speedStats[4];
                diceTemp = diceSetter(temp);
                initField.setText(diceTemp);
                temp = speedStats[5];
                diceTemp = diceSetter(temp);
                targField.setText(diceTemp);
                temp = smartsStats[0] + smartsStats[1] + smartsStats[2] + smartsStats[3] + smartsStats[4];
                smartsField.setText(String.valueOf(temp));
                temp += 10;
                willpowField.setText(String.valueOf(temp));
                temp = smartsStats[0];
                diceTemp = diceSetter(temp);
                alerField.setText(diceTemp);
                temp = smartsStats[1];
                diceTemp = diceSetter(temp);
                culField.setText(diceTemp);
                temp = smartsStats[2];
                diceTemp = diceSetter(temp);
                sciField.setText(diceTemp);
                temp = smartsStats[3];
                diceTemp = diceSetter(temp);
                surField.setText(diceTemp);
                temp = smartsStats[4];
                diceTemp = diceSetter(temp);
                techField.setText(diceTemp);
                temp = socialStats[0] + socialStats[1] + socialStats[2] + socialStats[3] + socialStats[4];
                socialField.setText(String.valueOf(temp));
                temp += 10;
                clevField.setText(String.valueOf(temp));
                temp = socialStats[0];
                diceTemp = diceSetter(temp);
                anHandField.setText(diceTemp);
                temp = socialStats[1];
                diceTemp = diceSetter(temp);
                decField.setText(diceTemp);
                temp = socialStats[2];
                diceTemp = diceSetter(temp);
                perfField.setText(diceTemp);
                temp = socialStats[3];
                diceTemp = diceSetter(temp);
                persField.setText(diceTemp);
                temp = socialStats[4];
                diceTemp = diceSetter(temp);
                streField.setText(diceTemp);
                currentBot = 1;
                xOfX = String.format("%d of %d", currentBot, totalBot);
                currentLabel.setText(xOfX);
                clear.setDisable(false);
                writeToFile.setDisable(false);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter values where needed.");
                alert.show();
            } catch (NullPointerException e2) {
                tooLow.show();
            }

        }
    }

    class NextClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {

            int temp;
            String diceTemp;

            newNPC = new NPC();
            newNPC = NPCLinkedList.getNextItem();
            String origin = newNPC.getOrigin();
            String role = newNPC.getRole();
            String subRole = newNPC.getSubRole();
            int hp = newNPC.getHP();
            int level = newNPC.getLevel();
            int[] strengthStats = newNPC.getStrength();
            int[] speedStats = newNPC.getSpeed();
            int[] smartsStats = newNPC.getSmarts();
            int[] socialStats = newNPC.getSocial();
            hpField.setText(String.valueOf(hp));
            levelField.setText(String.valueOf(level));
            originField.setText(origin);
            roleField.setText(role);
            subRoleField.setText(subRole);
            temp = strengthStats[0] + strengthStats[1] + strengthStats[2] + strengthStats[3] + strengthStats[4];
            strengthField.setText(String.valueOf(temp));
            temp += 10;
            toughField.setText(String.valueOf(temp));
            temp = strengthStats[0];
            diceTemp = diceSetter(temp);
            athField.setText(diceTemp);
            temp = strengthStats[1];
            diceTemp = diceSetter(temp);
            brawField.setText(diceTemp);
            temp = strengthStats[2];
            if (temp == 0) {
                diceTemp = "N/A";
            }
            else {
                diceTemp = "+" + temp + " HP";
            }
            condField.setText(diceTemp);
            temp = strengthStats[3];
            diceTemp = diceSetter(temp);
            intField.setText(diceTemp);
            temp = strengthStats[4];
            diceTemp = diceSetter(temp);
            migField.setText(diceTemp);
            temp = speedStats[0] + speedStats[1] + speedStats[2] + speedStats[3] + speedStats[4] + speedStats[5];
            speedField.setText(String.valueOf(temp));
            temp += 10;
            evaField.setText(String.valueOf(temp));
            temp = speedStats[0];
            diceTemp = diceSetter(temp);
            acroField.setText(diceTemp);
            temp = speedStats[1];
            diceTemp = diceSetter(temp);
            drivField.setText(diceTemp);
            temp = speedStats[2];
            diceTemp = diceSetter(temp);
            finField.setText(diceTemp);
            temp = speedStats[3];
            diceTemp = diceSetter(temp);
            infField.setText(diceTemp);
            temp = speedStats[4];
            diceTemp = diceSetter(temp);
            initField.setText(diceTemp);
            temp = speedStats[5];
            diceTemp = diceSetter(temp);
            targField.setText(diceTemp);
            temp = smartsStats[0] + smartsStats[1] + smartsStats[2] + smartsStats[3] + smartsStats[4];
            smartsField.setText(String.valueOf(temp));
            temp += 10;
            willpowField.setText(String.valueOf(temp));
            temp = smartsStats[0];
            diceTemp = diceSetter(temp);
            alerField.setText(diceTemp);
            temp = smartsStats[1];
            diceTemp = diceSetter(temp);
            culField.setText(diceTemp);
            temp = smartsStats[2];
            diceTemp = diceSetter(temp);
            sciField.setText(diceTemp);
            temp = smartsStats[3];
            diceTemp = diceSetter(temp);
            surField.setText(diceTemp);
            temp = smartsStats[4];
            diceTemp = diceSetter(temp);
            techField.setText(diceTemp);
            temp = socialStats[0] + socialStats[1] + socialStats[2] + socialStats[3] + socialStats[4];
            socialField.setText(String.valueOf(temp));
            temp += 10;
            clevField.setText(String.valueOf(temp));
            temp = socialStats[0];
            diceTemp = diceSetter(temp);
            anHandField.setText(diceTemp);
            temp = socialStats[1];
            diceTemp = diceSetter(temp);
            decField.setText(diceTemp);
            temp = socialStats[2];
            diceTemp = diceSetter(temp);
            perfField.setText(diceTemp);
            temp = socialStats[3];
            diceTemp = diceSetter(temp);
            persField.setText(diceTemp);
            temp = socialStats[4];
            diceTemp = diceSetter(temp);
            streField.setText(diceTemp);

            NPCid++;
            currentBot++;
            xOfX = String.format("%d of %d", currentBot, totalBot);
            currentLabel.setText(xOfX);
            if (NPCLinkedList.atEnd()) {
                next.setDisable(true);
            }
            previous.setDisable(false);
        }
    }
    class PreviousClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            int temp;
            String diceTemp;
            NPCid--;
            newNPC = new NPC();
            NPCLinkedList.resetList();
            for (int j = 0; j < NPCid; j++){
                NPCLinkedList.getNextItem();
            }
            newNPC = NPCLinkedList.getNextItem();
            String origin = newNPC.getOrigin();
            String role = newNPC.getRole();
            String subRole = newNPC.getSubRole();
            int[] strengthStats = newNPC.getStrength();
            int[] speedStats = newNPC.getSpeed();
            int[] smartsStats = newNPC.getSmarts();
            int[] socialStats = newNPC.getSocial();
            int hp = newNPC.getHP();
            int level = newNPC.getLevel();
            hpField.setText(String.valueOf(hp));
            levelField.setText(String.valueOf(level));
            originField.setText(origin);
            roleField.setText(role);
            subRoleField.setText(subRole);
            temp = strengthStats[0] + strengthStats[1] + strengthStats[2] + strengthStats[3] + strengthStats[4];
            strengthField.setText(String.valueOf(temp));
            temp += 10;
            toughField.setText(String.valueOf(temp));
            temp = strengthStats[0];
            diceTemp = diceSetter(temp);
            athField.setText(diceTemp);
            temp = strengthStats[1];
            diceTemp = diceSetter(temp);
            brawField.setText(diceTemp);
            temp = strengthStats[2];
            if (temp == 0) {
                diceTemp = "N/A";
            }
            else {
                diceTemp = "+" + temp + " HP";
            }
            condField.setText(diceTemp);
            temp = strengthStats[3];
            diceTemp = diceSetter(temp);
            intField.setText(diceTemp);
            temp = strengthStats[4];
            diceTemp = diceSetter(temp);
            migField.setText(diceTemp);
            temp = speedStats[0] + speedStats[1] + speedStats[2] + speedStats[3] + speedStats[4] + speedStats[5];
            speedField.setText(String.valueOf(temp));
            temp += 10;
            evaField.setText(String.valueOf(temp));
            temp = speedStats[0];
            diceTemp = diceSetter(temp);
            acroField.setText(diceTemp);
            temp = speedStats[1];
            diceTemp = diceSetter(temp);
            drivField.setText(diceTemp);
            temp = speedStats[2];
            diceTemp = diceSetter(temp);
            finField.setText(diceTemp);
            temp = speedStats[3];
            diceTemp = diceSetter(temp);
            infField.setText(diceTemp);
            temp = speedStats[4];
            diceTemp = diceSetter(temp);
            initField.setText(diceTemp);
            temp = speedStats[5];
            diceTemp = diceSetter(temp);
            targField.setText(diceTemp);
            temp = smartsStats[0] + smartsStats[1] + smartsStats[2] + smartsStats[3] + smartsStats[4];
            smartsField.setText(String.valueOf(temp));
            temp += 10;
            willpowField.setText(String.valueOf(temp));
            temp = smartsStats[0];
            diceTemp = diceSetter(temp);
            alerField.setText(diceTemp);
            temp = smartsStats[1];
            diceTemp = diceSetter(temp);
            culField.setText(diceTemp);
            temp = smartsStats[2];
            diceTemp = diceSetter(temp);
            sciField.setText(diceTemp);
            temp = smartsStats[3];
            diceTemp = diceSetter(temp);
            surField.setText(diceTemp);
            temp = smartsStats[4];
            diceTemp = diceSetter(temp);
            techField.setText(diceTemp);
            temp = socialStats[0] + socialStats[1] + socialStats[2] + socialStats[3] + socialStats[4];
            socialField.setText(String.valueOf(temp));
            temp += 10;
            clevField.setText(String.valueOf(temp));
            temp = socialStats[0];
            diceTemp = diceSetter(temp);
            anHandField.setText(diceTemp);
            temp = socialStats[1];
            diceTemp = diceSetter(temp);
            decField.setText(diceTemp);
            temp = socialStats[2];
            diceTemp = diceSetter(temp);
            perfField.setText(diceTemp);
            temp = socialStats[3];
            diceTemp = diceSetter(temp);
            persField.setText(diceTemp);
            temp = socialStats[4];
            diceTemp = diceSetter(temp);
            streField.setText(diceTemp);
            currentBot--;
            xOfX = String.format("%d of %d", currentBot, totalBot);
            currentLabel.setText(xOfX);
            if (NPCid == 0) {
                previous.setDisable(true);
            }
            next.setDisable(false);
        }
    }

    public String diceSetter(int points) {
        String dieSet = "";

        if (points == 0) {
            dieSet = "N/A";
        }
        else if (points == 1) {
            dieSet = "D2";
        }
        else if (points == 2) {
            dieSet = "D4";
        }
        else if (points == 3) {
            dieSet = "D6";
        }
        else if (points == 4) {
            dieSet = "D8";
        }
        else if (points == 5) {
            dieSet = "D10";
        }
        else if (points == 6) {
            dieSet = "D12";
        }
        return dieSet;
    }

    class ClearClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            NPCLinkedList.resetList();
            while (!NPCLinkedList.isEmpty()) {
                NPCLinkedList.removeAt(0);
            }
            hpField.setText("");
            levelField.setText("");
            originField.setText("");
            roleField.setText("");
            subRoleField.setText("");
            strengthField.setText("");
            toughField.setText("");
            athField.setText("");
            brawField.setText("");
            condField.setText("");
            intField.setText("");
            migField.setText("");
            speedField.setText("");
            evaField.setText("");
            acroField.setText("");
            drivField.setText("");
            finField.setText("");
            infField.setText("");
            initField.setText("");
            targField.setText("");
            smartsField.setText("");
            willpowField.setText("");
            alerField.setText("");
            culField.setText("");
            sciField.setText("");
            surField.setText("");
            techField.setText("");
            socialField.setText("");
            clevField.setText("");
            anHandField.setText("");
            decField.setText("");
            perfField.setText("");
            persField.setText("");
            streField.setText("");
            currentLabel.setText("");
            previous.setDisable(true);
            next.setDisable(true);
            clear.setDisable(true);
            writeToFile.setDisable(true);
            totalBot = 0;
            NPCLinkedList.resetList();
        }
    }

    class WriteToFileClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            try {
                String tempString, inputString, writeOrigin, writeRole, writeSubRole,
                        writeStrengthStat, writeSpeedStat, writeSmartsStat, writeSocialStat,
                        writeToughness, writeEvasion, writeWillpower, writeCleverness, writeAth,
                        writeBraw;
                int[] writeStrength, writeSpeed, writeSmarts, writeSocial;
                int queueTotal = 0, writeHP, writeLevel, statTemp;
                NPCQueue<String> writeQueue = new NPCQueue<String>();
                // Open file and declare Scanner
                File file = new File("GeneratedNPCs.txt");
                Scanner scnr = new Scanner(file);
                if (file.exists()) {
                    int readIn = 0;
                    // Loop through txt file and save to county arrays
                    while (scnr.hasNext()) {
                        tempString = scnr.nextLine();
                        writeQueue.enqueue(tempString);
                        readIn++;
                    }
                    queueTotal += readIn;
                }
                // TODO: Pull NPCs from Linked List, convert to String, add to Queue
                while (!NPCLinkedList.atEnd()) {
                    NPC StringNPC = new NPC();
                    StringNPC = NPCLinkedList.getNextItem();
                    /*
                    writeOrigin = newNPC.getOrigin();
                    writeRole = newNPC.getRole();
                    writeSubRole = newNPC.getSubRole();
                    writeHP = newNPC.getHP();
                    writeLevel = newNPC.getLevel();
                    writeStrength = newNPC.getStrength();
                    writeSpeed = newNPC.getSpeed();
                    writeSmarts = newNPC.getSmarts();
                    writeSocial = newNPC.getSocial();
                    writeStrengthStat = writeStrength[0] + writeStrength[1] + writeStrength[2] + writeStrength[3] + writeStrength[4];
                    writeToughness = writeStrengthStat + 10;
                    statTemp = strengthStats[0];
                    if (statTemp == 0) {
                        writeAth = "N/A";
                    }
                    else {
                        writeAth = diceSetter(statTemp);
                    }
                    statTemp = strengthStats[1];
                    if (statTemp == 0) {
                        writeBraw = "N/A";
                    }
                    else {
                        writeBraw = diceSetter(statTemp);
                    }
                    writeCond = "+" + strengthStats[2] + "HP";
                    statTemp = strengthStats[3];
                    if (statTemp == 0) {
                        writeInt = "N/A";
                    }
                    else {
                        writeInt = diceSetter(statTemp);
                    }
                    statTemp = strengthStats[4];
                    if (statTemp == 0) {
                        writeMig = "N/A";
                    }
                    else {
                        writeMig = diceSetter(statTemp);
                    }
                    writeSpeedStat = speedStats[0] + speedStats[1] + speedStats[2] + speedStats[3] + speedStats[4] + speedStats[5];
                    writeEvasion = writeSpeedStat + 10;
                    statTemp = speedStats[0];
                    if (statTemp == 0) {
                        writeAcro = "N/A";
                    }
                    else {
                        writeAcro = diceSetter(statTemp);
                    }
                    statTemp = speedStats[1];
                    if (statTemp == 0) {
                        writeDriv = "N/A";
                    }
                    else {
                        writeDriv = diceSetter(statTemp);
                    }
                    statTemp = speedStats[2];
                    if (statTemp == 0) {
                        writeFin = "N/A";
                    }
                    else {
                        writeFin = diceSetter(statTemp);
                    }
                    statTemp = speedStats[3];
                    if (statTemp == 0) {
                        writeInf = "N/A";
                    }
                    else {
                        writeInf = diceSetter(statTemp);
                    }
                    statTemp = speedStats[4];
                    if (statTemp == 0) {
                        writeInit = "N/A";
                    }
                    else {
                        writeInit = diceSetter(statTemp);
                    }
                    statTemp = speedStats[5];
                    if (statTemp == 0) {
                        writeTarg = "N/A";
                    }
                    else {
                        writeTarg = diceSetter(statTemp);
                    }
                    writeSmartsStat = smartsStats[0] + smartsStats[1] + smartsStats[2] + smartsStats[3] + smartsStats[4];
                    writeWillpower = writeSmartsStat + 10;
                    statTemp = smartsStats[0];
                    if (statTemp == 0) {
                        writeAlert = "N/A";
                    }
                    else {
                        writeAlert = diceSetter(statTemp);
                    }
                    statTemp = smartsStats[1];
                    if (statTemp == 0) {
                        writeCul = "N/A";
                    }
                    else {
                        writeCul = diceSetter(statTemp);
                    }
                    statTemp = smartsStats[2];
                    if (statTemp == 0) {
                        writeSci = "N/A";
                    }
                    else {
                        writeSci = diceSetter(statTemp);
                    }
                    statTemp = smartsStats[3];
                    if (statTemp == 0) {
                        writeSur = "N/A";
                    }
                    else {
                        writeSur = diceSetter(statTemp);
                    }
                    statTemp = smartsStats[4];
                    if (statTemp == 0) {
                        writeTech = "N/A";
                    }
                    else {
                        writeTech = diceSetter(statTemp);
                    }
                    writeSocialStat = socialStats[0] + socialStats[1] + socialStats[2] + socialStats[3] + socialStats[4];
                    writeCleverness = writeSocialStat + 10;
                    statTemp = socialStats[0];
                    if (statTemp == 0) {
                        writeAniHand = "N/A";
                    }
                    else {
                        writeAniHand = diceSetter(statTemp);
                    }
                    statTemp = socialStats[1];
                    if (statTemp == 0) {
                        writeDec = "N/A";
                    }
                    else {
                        writeDec = diceSetter(statTemp);
                    }
                    statTemp = socialStats[2];
                    if (statTemp == 0) {
                        writePerf = "N/A";
                    }
                    else {
                        writePerf = diceSetter(statTemp);
                    }
                    statTemp = socialStats[3];
                    if (statTemp == 0) {
                        writePers = "N/A";
                    }
                    else {
                        writePers = diceSetter(statTemp);
                    }
                    statTemp = socialStats[4];
                    if (statTemp == 0) {
                        writeStre = "N/A";
                    }
                    else {
                        writeStre = diceSetter(statTemp);
                    }
                    inputString = String.format("Origin: %s, Role: %s, SubRole: %s, HP: %s, Level: %s, Strength: %s, 
                        Toughness: %s, Athletics: %s, Brawn: %s, Conditioning: %s, Intimidation: %s, Might: %s, 
                        Speed: %s, Evasion: %s, Acrobatics: %s, Driving: %S, Finesse: %s, Infiltration: %s, 
                        Initiative: %s, Targeting: %s, Smarts: %s, Willpower: %s, Alertness: %s, Culture: %s, 
                        Science: %s, Survival: %s, Technology: %s, Social: %s, Cleverness: %s, Animal Handling: %s, 
                        Deception: %s, Performance: %s, Persuasion: %s, Streetwise: %s", writeOrigin, writeRole, 
                        writeSubRole, writeHP, writeLevel, writeStrengthStat, writeToughness, writeAth, writeBraw, 
                        writeCond, writeInt, writeMig, writeSpeedStat, writeEvasion, writeAcro, writeDriv, writeFin, 
                        writeInf, writeInit, writeTarg, writeSmartsStat, writeWillpower, writeAlert, writeCul, writeSci, 
                        writeSur, writeTech, writeSocialStat, writeCleverness, writeAniHand, writeDec, writePerf, 
                        writePers, writeStre)
                    // TODO: Add to queue
                    // TODO: Continue Here
                    */
                }

                PrintWriter writeFile = new PrintWriter("GeneratedNPCs.txt");
                for (int i = 0; i < queueTotal; i++)
                {   // Write to the file in the same format the data was read in.
                    while (!writeQueue.isEmpty()) {
                        tempString = writeQueue.dequeue();
                        writeFile.println(tempString);
                    }
                }
                writeFile.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            // TODO: Clear list
        }
    }
}
