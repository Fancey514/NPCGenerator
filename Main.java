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
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Open UI
    public static void main(String[] args) {
        launch(args);
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Set UI
    @Override
    public void start(Stage primaryStage) {

        playerNumLabel = new Label("Number of Players");                              // Set Number of Players controls
        playerNum = new TextField();
        playerNum.setMaxWidth(25);
        HBox numPlayers = new HBox(10, playerNumLabel, playerNum);                    // Set Number of Players HBox
        numPlayers.setAlignment(Pos.CENTER_RIGHT);

        playerLevelLabel = new Label("Player Level");                                 // Set Player Level controls
        playerLevel = new TextField();
        playerLevel.setMaxWidth(25);
        HBox levelPlayer = new HBox(10, playerLevelLabel, playerLevel);               // Set Player Level HBox
        levelPlayer.setAlignment(Pos.CENTER_RIGHT);

        VBox players = new VBox(10, numPlayers, levelPlayer);                         // Assign number of players and player level to VBox
        players.setAlignment(Pos.CENTER);

        numLevelSelect = new ToggleGroup();                                           // Set toggle group for level radio buttons
        NPCLevel = new Label("NPC Level");                                            // Set Level label
        randLevel = new RadioButton("Random");                                        // Assign Random and Set to toggle group
        randLevel.setSelected(true);
        randLevel.setToggleGroup(numLevelSelect);
        setLevel = new RadioButton("Set");
        setLevel.setToggleGroup(numLevelSelect);
        NPCLevelField = new TextField();                                              // Set Level field is Set radio button is selected
        NPCLevelField.setMaxWidth(30);
        NPCLevelField.setVisible(false);
        setLevel.setOnAction(e -> {                                                   // Reveal Level field if Set is selected
            NPCLevelField.setVisible(true);
        });
        randLevel.setOnAction(e -> {                                                  // Hide Level field if Random is selected
            NPCLevelField.setVisible(false);
        });
        HBox setLevelBox = new HBox(10, setLevel, NPCLevelField);                     // Create HBox for set level controls
        setLevelBox.setAlignment(Pos.CENTER);
        VBox levelVB = new VBox(10, NPCLevel, randLevel, setLevelBox);                // Create VBox for level controls and include set level HBox
        levelVB.setAlignment(Pos.CENTER_LEFT);

        numQuantitySelect = new ToggleGroup();                                        // Set Toggle Group for the Quantity options
        NPCQuantity = new Label("NPC Quantity");
        randQuantity = new RadioButton("Random");                                     // Set radio button for random quantity
        randQuantity.setSelected(true);                                               // Make the random option selected by default
        randQuantity.setToggleGroup(numQuantitySelect);                               // Assign random quantity radio button to quantity toggle group
        setQuantity = new RadioButton("Set");                                         // Set radio button for user selection
        setQuantity.setToggleGroup(numQuantitySelect);                                // Assign set quantity to quantity toggle group
        quantityField = new TextField();                                              // Set text field for user to enter quantity value
        quantityField.setMaxWidth(30);
        quantityField.setVisible(false);                                              // Hide set quantity text field
        setQuantity.setOnAction(e -> {
            quantityField.setVisible(true);                                           // Make set quantity text field visible if set quantity radio button is selected
        });
        randQuantity.setOnAction(e -> {
            quantityField.setVisible(false);                                          // Hide set quantity text field if random quantity is selected
        });
        HBox setQuantityBox = new HBox(10, setQuantity, quantityField);               // Set HBox for user selected quantity controls
        setQuantityBox.setAlignment(Pos.CENTER);
        VBox quantityVB = new VBox(10, NPCQuantity, randQuantity, setQuantityBox);    // Set VBox for quantity controls
        quantityVB.setAlignment(Pos.CENTER_LEFT);

        HBox radioHB = new HBox(50, players, quantityVB, levelVB);                    // Create HBox and assign players, quantityVB and levelVB VBoxes
        radioHB.setAlignment(Pos.CENTER);

        GenerateNPCs = new Button("Generate NPC(s)");                                 // Set button to generate NPCs
        GenerateNPCs.setOnAction(new GenerateNPCsClickHandler());
        HBox runHB = new HBox(GenerateNPCs);                                          // Create HBox and assign GenerateNPCs button
        runHB.setAlignment(Pos.CENTER);

        // Player stats

        // HP stat
        hpLabel = new Label("HP");
        hpField = new TextField();
        hpField.setEditable(false);
        hpField.setMaxWidth(25);
        VBox hpBox = new VBox(10, hpLabel, hpField);
        hpBox.setAlignment(Pos.CENTER);

        // Character Level
        levelLabel = new Label("Level");
        levelField = new TextField();
        levelField.setEditable(false);
        levelField.setMaxWidth(30);
        VBox levelBox = new VBox(10, levelLabel, levelField);
        levelBox.setAlignment(Pos.CENTER);

        // Character Origin
        originLabel = new Label("Origin");
        originField = new TextField();
        originField.setEditable(false);
        VBox originBox = new VBox(10, originLabel, originField);
        originBox.setAlignment(Pos.CENTER);

        // Character Role
        roleLabel = new Label("Role");
        roleField = new TextField();
        roleField.setEditable(false);
        VBox roleBox = new VBox(10, roleLabel, roleField);
        roleBox.setAlignment(Pos.CENTER);

        // Character Sub-Role
        subRoleLabel = new Label("Sub-Role");
        subRoleField = new TextField();
        subRoleField.setEditable(false);
        VBox subRoleBox = new VBox(10, subRoleLabel, subRoleField);
        roleBox.setAlignment(Pos.CENTER);

        // HP, Level, Origin, Role, and Sub-Role HBox
        HBox topInfo = new HBox(25, hpBox, levelBox, originBox, roleBox, subRoleBox);
        topInfo.setAlignment(Pos.CENTER);

        // Strength Stat
        strengthLabel = new Label("Strength");
        strengthLabel.setFont(Font.font(16));
        strengthField = new TextField();
        strengthField.setEditable(false);
        strengthField.setMaxWidth(40);
        HBox strengthBox = new HBox(10, strengthLabel, strengthField);
        strengthBox.setAlignment(Pos.CENTER_RIGHT);

        // Toughness Stat
        toughLabel = new Label("Toughness");
        toughLabel.setFont(Font.font(14));
        toughField = new TextField();
        toughField.setEditable(false);
        toughField.setMaxWidth(40);
        HBox toughBox = new HBox(10, toughLabel, toughField);
        toughBox.setAlignment(Pos.CENTER_RIGHT);

        // Athletics Stat
        athLabel = new Label("Athletics");
        athField = new TextField();
        athField.setEditable(false);
        athField.setMaxWidth(40);
        HBox athleticsBox = new HBox(10, athLabel, athField);
        athleticsBox.setAlignment(Pos.CENTER_RIGHT);

        // Brawl Stat
        brawLabel = new Label("Brawn");
        brawField = new TextField();
        brawField.setEditable(false);
        brawField.setMaxWidth(40);
        HBox brawnBox = new HBox(10, brawLabel, brawField);
        brawnBox.setAlignment(Pos.CENTER_RIGHT);

        // Conditioning Stat
        condLabel = new Label("Conditioning");
        condField = new TextField();
        condField.setEditable(false);
        condField.setMaxWidth(50);
        HBox condBox = new HBox(10, condLabel, condField);
        brawnBox.setAlignment(Pos.CENTER_RIGHT);

        // Intimidation Stat
        intLabel = new Label("Intimidation");
        intField = new TextField();
        intField.setEditable(false);
        intField.setMaxWidth(40);
        HBox intimidationBox = new HBox(10, intLabel, intField);
        intimidationBox.setAlignment(Pos.CENTER_RIGHT);

        // Might Stat
        migLabel = new Label("Might");
        migField = new TextField();
        migField.setEditable(false);
        migField.setMaxWidth(40);
        HBox mightBox = new HBox(10, migLabel, migField);
        mightBox.setAlignment(Pos.CENTER_RIGHT);

        // Strength Stats VBox
        VBox streEssBox = new VBox(10, strengthBox, toughBox, athleticsBox, brawnBox, condBox, intimidationBox, mightBox);
        streEssBox.setAlignment(Pos.TOP_CENTER);

        // Speed Stat
        speedLabel = new Label("Speed");
        speedLabel.setFont(Font.font(16));
        speedField = new TextField();
        speedField.setEditable(false);
        speedField.setMaxWidth(40);
        HBox speedBox = new HBox(10, speedLabel, speedField);
        speedBox.setAlignment(Pos.CENTER_RIGHT);

        // Evasion Stat
        evaLabel = new Label("Evasion");
        evaLabel.setFont(Font.font(14));
        evaField = new TextField();
        evaField.setEditable(false);
        evaField.setMaxWidth(40);
        HBox evadeBox = new HBox(10, evaLabel, evaField);
        evadeBox.setAlignment(Pos.CENTER_RIGHT);

        // Athletics Stat
        acroLabel = new Label("Acrobatics");
        acroField = new TextField();
        acroField.setEditable(false);
        acroField.setMaxWidth(40);
        HBox acrobaticsBox = new HBox(10, acroLabel, acroField);
        acrobaticsBox.setAlignment(Pos.CENTER_RIGHT);

        // Driving Stat
        drivLabel = new Label("Driving");
        drivField = new TextField();
        drivField.setEditable(false);
        drivField.setMaxWidth(40);
        HBox drivingBox = new HBox(10, drivLabel, drivField);
        drivingBox.setAlignment(Pos.CENTER_RIGHT);

        // Finesse Stat
        finLabel = new Label("Finesse");
        finField = new TextField();
        finField.setEditable(false);
        finField.setMaxWidth(40);
        HBox finesseBox = new HBox(10, finLabel, finField);
        finesseBox.setAlignment(Pos.CENTER_RIGHT);

        // Infiltration Stat
        infLabel = new Label("Infiltration");
        infField = new TextField();
        infField.setEditable(false);
        infField.setMaxWidth(40);
        HBox infiltrationBox = new HBox(10, infLabel, infField);
        infiltrationBox.setAlignment(Pos.CENTER_RIGHT);

        // Initiative Stat
        initLabel = new Label("Initiative");
        initField = new TextField();
        initField.setEditable(false);
        initField.setMaxWidth(40);
        HBox initiativeBox = new HBox(10, initLabel, initField);
        initiativeBox.setAlignment(Pos.CENTER_RIGHT);

        // Targeting Stat
        targLabel = new Label("Targeting");
        targField = new TextField();
        targField.setEditable(false);
        targField.setMaxWidth(40);
        HBox targetingBox = new HBox(10, targLabel, targField);
        targetingBox.setAlignment(Pos.CENTER_RIGHT);

        // Speed Stats VBox
        VBox speEssBox = new VBox(10, speedBox, evadeBox, acrobaticsBox, drivingBox, finesseBox, infiltrationBox, initiativeBox, targetingBox);
        speEssBox.setAlignment(Pos.TOP_CENTER);

        // Smarts Stat
        smartsLabel = new Label("Smarts");
        smartsLabel.setFont(Font.font(16));
        smartsField = new TextField();
        smartsField.setEditable(false);
        smartsField.setMaxWidth(40);
        HBox smartsBox = new HBox(10, smartsLabel, smartsField);
        smartsBox.setAlignment(Pos.CENTER_RIGHT);

        // Willpower Stat
        willpowLabel = new Label("Willpower");
        willpowLabel.setFont(Font.font(14));
        willpowField = new TextField();
        willpowField.setEditable(false);
        willpowField.setMaxWidth(40);
        HBox willpowerBox = new HBox(10, willpowLabel, willpowField);
        willpowerBox.setAlignment(Pos.CENTER_RIGHT);

        // Alertness Stat
        alerLabel = new Label("Alertness");
        alerField = new TextField();
        alerField.setEditable(false);
        alerField.setMaxWidth(40);
        HBox alertnessBox = new HBox(10, alerLabel, alerField);
        alertnessBox.setAlignment(Pos.CENTER_RIGHT);

        // Culture Stat
        culLabel = new Label("Culture");
        culField = new TextField();
        culField.setEditable(false);
        culField.setMaxWidth(40);
        HBox cultureBox = new HBox(10, culLabel, culField);
        cultureBox.setAlignment(Pos.CENTER_RIGHT);

        // Science Stat
        sciLabel = new Label("Science");
        sciField = new TextField();
        sciField.setEditable(false);
        sciField.setMaxWidth(40);
        HBox scienceBox = new HBox(10, sciLabel, sciField);
        scienceBox.setAlignment(Pos.CENTER_RIGHT);

        // Survival Stat
        surLabel = new Label("Survival");
        surField = new TextField();
        surField.setEditable(false);
        surField.setMaxWidth(40);
        HBox survivalBox = new HBox(10, surLabel, surField);
        survivalBox.setAlignment(Pos.CENTER_RIGHT);

        // Technology Stat
        techLabel = new Label("Technology");
        techField = new TextField();
        techField.setEditable(false);
        techField.setMaxWidth(40);
        HBox technologyBox = new HBox(10, techLabel, techField);
        technologyBox.setAlignment(Pos.CENTER_RIGHT);

        // Smarts Stats VBox
        VBox smaEssBox = new VBox(10, smartsBox, willpowerBox, alertnessBox, cultureBox, scienceBox, survivalBox, technologyBox);
        smaEssBox.setAlignment(Pos.TOP_CENTER);

        // Social Stat
        socialLabel = new Label("Social");
        socialLabel.setFont(Font.font(16));
        socialField = new TextField();
        socialField.setEditable(false);
        socialField.setMaxWidth(40);
        HBox socialBox = new HBox(10, socialLabel, socialField);
        socialBox.setAlignment(Pos.CENTER_RIGHT);

        // Cleverness Stat
        clevLabel = new Label("Cleverness");
        clevLabel.setFont(Font.font(14));
        clevField = new TextField();
        clevField.setEditable(false);
        clevField.setMaxWidth(40);
        HBox clevernessBox = new HBox(10, clevLabel, clevField);
        clevernessBox.setAlignment(Pos.CENTER_RIGHT);

        // Animal Handling Stat
        anHandLabel = new Label("Animal Handling");
        anHandField = new TextField();
        anHandField.setEditable(false);
        anHandField.setMaxWidth(40);
        HBox animalHandlingBox = new HBox(10, anHandLabel, anHandField);
        animalHandlingBox.setAlignment(Pos.CENTER_RIGHT);

        // Deception Stat
        decLabel = new Label("Deception");
        decField = new TextField();
        decField.setEditable(false);
        decField.setMaxWidth(40);
        HBox deceptionBox = new HBox(10, decLabel, decField);
        deceptionBox.setAlignment(Pos.CENTER_RIGHT);

        // Performance Stat
        perfLabel = new Label("Performance");
        perfField = new TextField();
        perfField.setEditable(false);
        perfField.setMaxWidth(40);
        HBox performanceBox = new HBox(10, perfLabel, perfField);
        performanceBox.setAlignment(Pos.CENTER_RIGHT);

        // Persuasion Stat
        persLabel = new Label("Persuasion");
        persField = new TextField();
        persField.setEditable(false);
        persField.setMaxWidth(40);
        HBox persuasionBox = new HBox(10, persLabel, persField);
        persuasionBox.setAlignment(Pos.CENTER_RIGHT);

        // Streetwise Stat
        streLabel = new Label("Streetwise");
        streField = new TextField();
        streField.setEditable(false);
        streField.setMaxWidth(40);
        HBox streetwiseBox = new HBox(10, streLabel, streField);
        streetwiseBox.setAlignment(Pos.CENTER_RIGHT);

        // Social Stats VBox
        VBox socEssBox = new VBox(10, socialBox, clevernessBox, animalHandlingBox, deceptionBox, performanceBox, persuasionBox, streetwiseBox);
        socEssBox.setAlignment(Pos.TOP_CENTER);

        // Combined stats HBox
        HBox essenceBox = new HBox(50,streEssBox, speEssBox, smaEssBox, socEssBox);
        essenceBox.setAlignment(Pos.CENTER);

        previous = new Button("Previous");                                            // Create Previous Button
        previous.setDisable(true);                                                    // Disable while at the beginning or no data exists
        previous.setOnAction(new PreviousClickHandler());                             // Execute Previous action handler once pressed
        currentLabel = new Label();                                                   // Create a label for active character
        next = new Button("Next");                                                    // Create New Button
        next.setDisable(true);                                                        // Disable until characters are generated
        next.setOnAction(new NextClickHandler());                                     // Execute Next action handler once pressed
        HBox prevNextHB = new HBox(25, previous, currentLabel, next);                 // Create HBox and assign previous, current character, and next
        prevNextHB.setAlignment(Pos.CENTER);

        clear = new Button("Clear List");                                             // Create button to clear the list
        clear.setDisable(true);                                                       // Disable until character generation
        clear.setOnAction(new ClearClickHandler());                                   // Execute Clear action handler once pressed
        writeToFile = new Button("Write to File & Clear");                            // Create button to write data to file and clear the list
        writeToFile.setDisable(true);                                                 // Disable until character generation
        writeToFile.setOnAction(new WriteToFileClickHandler());                       // Execute writeToFile action handler once pressed
        HBox clearWrite = new HBox(40, clear, writeToFile);                           // Create HBox and assign clear and Write-to-file buttons
        clearWrite.setAlignment(Pos.CENTER);

        // VBox to contain all HBoxes to set the scene
        VBox TotalVB = new VBox(30, radioHB, runHB, topInfo, essenceBox, prevNextHB, clearWrite);
        TotalVB.setAlignment(Pos.CENTER);

        Scene scene = new Scene(TotalVB, 700, 700);                                   // Set the scene with the TotalVB VBox, a height of 700 ad a width of 700
        primaryStage.setScene(scene);
        primaryStage.setTitle("NPC Generator");
        primaryStage.show();                                                          // Display the scene
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Clear List method
    public void clearList() {
        NPCLinkedList.resetList();                               // Set LinkedList to beginning
        while (!NPCLinkedList.isEmpty()) {
            NPCLinkedList.removeAt(0);                           // Remove the first NPC until the list is empty
        }
        
        hpField.setText("");                                     // Clear the textfields
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
        
        previous.setDisable(true);                               // Disable all buttons except the Generate NPCs button
        next.setDisable(true);
        clear.setDisable(true);
        writeToFile.setDisable(true);
        
        totalBot = 0;                                            // Set totalBot variable to 0
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Method for determining dice level for the skills
    public String diceSetter(int points) {
        String dieSet = "";
        // The more points in a skill, the bigger the dice size
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
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Button to generate the NPC(s)
    class GenerateNPCsClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            // Declare variables and arrays
            String origin, role, subRole;
            int[] strengthStats, speedStats, smartsStats, socialStats;
            int temp = 0, hp;
            String diceTemp;
            
            Alert tooLow = new Alert(Alert.AlertType.ERROR);                                                                        // Set an alert for any entered value that's lower than 1                                          
            tooLow.setContentText("Entered values must be higher than 0");
            Alert tooHigh = new Alert(Alert.AlertType.ERROR);                                                                       // Set an alert for any level value that's higher than 20
            tooHigh.setContentText("Entered values must be lower than 21");
            try {
                if (setQuantity.isSelected()) {
                    quantity = Integer.parseInt(quantityField.getText());                                                           // Set quantity to user-entered value if set quantity is selected
                    if (quantity < 1) {
                        tooLow.show();                                                                                              // If the user-selected quantity is below 1, show tooLow error message
                    }
                } else if (randQuantity.isSelected()) {
                    quantity = randVal.nextInt(5) + 1;                                                                              // Use number generator to set quantity of NPCs
                }
                if (setLevel.isSelected()) {
                    level = Integer.parseInt(NPCLevelField.getText());                                                              // Set level to value entered by the user if set level is selected
                    if (level < 1) {
                        tooLow.show();                                                                                              // If the user-selected level is below 1, show the tooLow error message
                    }
                    if (level > 20) {
                        tooHigh.show();                                                                                             // If the user-selected level is over 20, show the tooHigh error message
                    }
                } else if (randLevel.isSelected()) {
                    if (Integer.parseInt(playerLevel.getText()) < 1 | Integer.parseInt(playerNum.getText()) < 1) {                  // Check if the entered player values are above 0 if random level is selected
                        tooLow.show();
                    }
                    temp = Integer.parseInt(playerLevel.getText()) * Integer.parseInt(playerNum.getText());                         // Multiply the player level by the amount of players to use to get the random level
                    level = temp / quantity;                                                                                        // Divide the product by the amount of NPCs will be created for the NPC level
                    if (level == 0) {
                        level++;                                                                                                    // Set the level to 1 if the quotient is 0
                    }
                }
                if (quantity > 0 && level > 0) {                                                                                    // Verify that the quantity and level are valid
                    for (int i = 0; i < quantity; i++) {                                                                            // Loop the quantity
                        charNum++;                                                                                                  // Increase the number of characters were created
                        if (i == quantity - 1 && newQuantity) {                                                                     // Check if it's the second last loop and if a new quantity is waiting
                            level = extraLevel;                                                                                     // Change the level to the extra level value
                            newQuantity = false;                                                                                    // Set newQuantity to false
                        }
                        if (level > 20 && !newQuantity) {                                                                           // Check if the level is higher than 20
                            quantity++;                                                                                             // If it is, add one to the quantity
                            // TODO: Add a boolean to make sure that anything over 20 for the added NPC doesn't cause too many extra NPCs
                            extraLevel = (level - 20) * (quantity - 1);                                                             // Set extraLevel to the level minus 20 then multiplied by the difference of quantity minus 1
                            level = 20;                                                                                             // Set the level to 20
                            newQuantity = true;                                                                                     // Set newQuantity to true to trigger the previous if statement
                        }
                        NPCSelect = new Selections(level);                                                                          // Create a new Selections class, then retrieve values
                        origin = NPCSelect.getNewOrigin();
                        role = NPCSelect.getNewRole();
                        subRole = NPCSelect.getNewSubRole();
                        strengthStats = NPCSelect.getStrength();
                        speedStats = NPCSelect.getSpeed();
                        smartsStats = NPCSelect.getSmarts();
                        socialStats = NPCSelect.getSocial();
                        hp = NPCSelect.getHP();
                        newNPC = new NPC(origin, role, subRole, strengthStats, speedStats, smartsStats, socialStats, hp, level);    // Create a new NPC using the selections made in the Selections class
                        NPCLinkedList.add(newNPC);                                                                                  // Add the new NPC to the LinkedList
                        hp = 0;                                                                                                     // Set the HP to 0
                        if (charNum > 1) {
                            next.setDisable(false);                                                                                 // Make the "next" button visible if there's more than 1 NPC
                        }
                    }
                }
                totalBot += quantity;                                                                                               // Increase the total amount of bots by the quantity
                NPCLinkedList.resetList();                                                                                          // Reset the LinkedList to the start
                newNPC = new NPC();                                                                                                 // Create a new NPC then make it a copy of the first NPC in the LinkedList
                newNPC = NPCLinkedList.getNextItem();
                origin = newNPC.getOrigin();                                                                                        // Set variables to NPC values
                role = newNPC.getRole();
                subRole = newNPC.getSubRole();
                hp = newNPC.getHP();
                level = newNPC.getLevel();
                strengthStats = newNPC.getStrength();
                speedStats = newNPC.getSpeed();
                smartsStats = newNPC.getSmarts();
                socialStats = newNPC.getSocial();
                hpField.setText(String.valueOf(hp));                                                                                // Set non-dice related textfields to NPC values
                levelField.setText(String.valueOf(level));
                originField.setText(origin);
                roleField.setText(role);
                subRoleField.setText(subRole);
                temp = strengthStats[0] + strengthStats[1] + strengthStats[2] + strengthStats[3] + strengthStats[4];                // Add stats for grouping stat
                strengthField.setText(String.valueOf(temp));
                temp += 10;
                toughField.setText(String.valueOf(temp));                                                                            // Add 10 to group stat for defense stat
                temp = strengthStats[0];                                                                                             // Get individual stats and send them to the dice setter to get the required dice for each skill
                diceTemp = diceSetter(temp);
                athField.setText(diceTemp);
                temp = strengthStats[1];
                diceTemp = diceSetter(temp);
                brawField.setText(diceTemp);
                temp = strengthStats[2];                                                                                             // For Conditioning, add the value in "+_HP"
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
                currentBot = 1;                                                                                                      // Set currentBot to 1
                xOfX = String.format("%d of %d", currentBot, totalBot);                                                              // Set the xOfX string to currentBot of totalBot then set it to the currentLabel
                currentLabel.setText(xOfX);
                clear.setDisable(false);                                                                                             // Make the Clear button visible
                writeToFile.setDisable(false);                                                                                       // Make the Write to File button visible
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);                                                                      // If required numbers aren't entered, display an alert
                alert.setContentText("Please enter values where needed.");
                alert.show();
            } catch (NullPointerException e2) {
                tooLow.show();
            }

        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Actions for the Next button
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
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    class ClearClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            clearList();
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    class WriteToFileClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent clicked) {
            try {
                String tempString, inputString, writeOrigin, writeRole, writeSubRole, writeAth, writeBraw, writeAcro,
                        writeDriv, writeFin, writeInf, writeInit, writeTarg, writeAlert, writeCul, writeSci, writeSur,
                        writeTech, writeCond, writeInt, writeMig, writeAniHand, writeDec, writePerf, writePers,
                        writeStre;
                int[] writeStrength, writeSpeed, writeSmarts, writeSocial;
                int queueTotal = 0, writeHP, writeLevel, statTemp, writeStrengthStat, writeSpeedStat,
                        writeSmartsStat, writeSocialStat, writeToughness, writeEvasion,
                        writeWillpower, writeCleverness;
                NPCQueue<String> writeQueue = new NPCQueue<String>();
                // Open file and declare Scanner
                File file = new File("GeneratedNPCs.txt");
                if (file.exists()) {
                    Scanner scnr = new Scanner(file);
                    int readIn = 0;
                    // Loop through txt file and save to county arrays
                    while (scnr.hasNext()) {
                        tempString = scnr.nextLine();
                        writeQueue.enqueue(tempString);
                        readIn++;
                    }
                    queueTotal += readIn;
                }

                NPCLinkedList.resetList();

                while (!NPCLinkedList.atEnd()) {
                    NPC StringNPC = new NPC();
                    StringNPC = NPCLinkedList.getNextItem();
                    writeOrigin = StringNPC.getOrigin();
                    writeRole = StringNPC.getRole();
                    writeSubRole = StringNPC.getSubRole();
                    writeHP = StringNPC.getHP();
                    writeLevel = StringNPC.getLevel();
                    writeStrength = StringNPC.getStrength();
                    writeSpeed = StringNPC.getSpeed();
                    writeSmarts = StringNPC.getSmarts();
                    writeSocial = StringNPC.getSocial();
                    
                    writeStrengthStat = writeStrength[0] + writeStrength[1] + writeStrength[2] + writeStrength[3] + writeStrength[4];
                    writeToughness = writeStrengthStat + 10;
                    statTemp = writeStrength[0];
                    if (statTemp == 0) {
                        writeAth = "N/A";
                    }
                    else {
                        writeAth = diceSetter(statTemp);
                    }
                    statTemp = writeStrength[1];
                    if (statTemp == 0) {
                        writeBraw = "N/A";
                    }
                    else {
                        writeBraw = diceSetter(statTemp);
                    }
                    writeCond = "+" + writeStrength[2] + "HP";
                    statTemp = writeStrength[3];
                    if (statTemp == 0) {
                        writeInt = "N/A";
                    }
                    else {
                        writeInt = diceSetter(statTemp);
                    }
                    statTemp = writeStrength[4];
                    if (statTemp == 0) {
                        writeMig = "N/A";
                    }
                    else {
                        writeMig = diceSetter(statTemp);
                    }
                    writeSpeedStat = writeSpeed[0] + writeSpeed[1] + writeSpeed[2] + writeSpeed[3] + writeSpeed[4] + writeSpeed[5];
                    writeEvasion = writeSpeedStat + 10;
                    statTemp = writeSpeed[0];
                    if (statTemp == 0) {
                        writeAcro = "N/A";
                    }
                    else {
                        writeAcro = diceSetter(statTemp);
                    }
                    statTemp = writeSpeed[1];
                    if (statTemp == 0) {
                        writeDriv = "N/A";
                    }
                    else {
                        writeDriv = diceSetter(statTemp);
                    }
                    statTemp = writeSpeed[2];
                    if (statTemp == 0) {
                        writeFin = "N/A";
                    }
                    else {
                        writeFin = diceSetter(statTemp);
                    }
                    statTemp = writeSpeed[3];
                    if (statTemp == 0) {
                        writeInf = "N/A";
                    }
                    else {
                        writeInf = diceSetter(statTemp);
                    }
                    statTemp = writeSpeed[4];
                    if (statTemp == 0) {
                        writeInit = "N/A";
                    }
                    else {
                        writeInit = diceSetter(statTemp);
                    }
                    statTemp = writeSpeed[5];
                    if (statTemp == 0) {
                        writeTarg = "N/A";
                    }
                    else {
                        writeTarg = diceSetter(statTemp);
                    }
                    writeSmartsStat = writeSmarts[0] + writeSmarts[1] + writeSmarts[2] + writeSmarts[3] + writeSmarts[4];
                    writeWillpower = writeSmartsStat + 10;
                    statTemp = writeSmarts[0];
                    if (statTemp == 0) {
                        writeAlert = "N/A";
                    }
                    else {
                        writeAlert = diceSetter(statTemp);
                    }
                    statTemp = writeSmarts[1];
                    if (statTemp == 0) {
                        writeCul = "N/A";
                    }
                    else {
                        writeCul = diceSetter(statTemp);
                    }
                    statTemp = writeSmarts[2];
                    if (statTemp == 0) {
                        writeSci = "N/A";
                    }
                    else {
                        writeSci = diceSetter(statTemp);
                    }
                    statTemp = writeSmarts[3];
                    if (statTemp == 0) {
                        writeSur = "N/A";
                    }
                    else {
                        writeSur = diceSetter(statTemp);
                    }
                    statTemp = writeSmarts[4];
                    if (statTemp == 0) {
                        writeTech = "N/A";
                    }
                    else {
                        writeTech = diceSetter(statTemp);
                    }
                    writeSocialStat = writeSocial[0] + writeSocial[1] + writeSocial[2] + writeSocial[3] + writeSocial[4];
                    writeCleverness = writeSocialStat + 10;
                    statTemp = writeSocial[0];
                    if (statTemp == 0) {
                        writeAniHand = "N/A";
                    }
                    else {
                        writeAniHand = diceSetter(statTemp);
                    }
                    statTemp = writeSocial[1];
                    if (statTemp == 0) {
                        writeDec = "N/A";
                    }
                    else {
                        writeDec = diceSetter(statTemp);
                    }
                    statTemp = writeSocial[2];
                    if (statTemp == 0) {
                        writePerf = "N/A";
                    }
                    else {
                        writePerf = diceSetter(statTemp);
                    }
                    statTemp = writeSocial[3];
                    if (statTemp == 0) {
                        writePers = "N/A";
                    }
                    else {
                        writePers = diceSetter(statTemp);
                    }
                    statTemp = writeSocial[4];
                    if (statTemp == 0) {
                        writeStre = "N/A";
                    }
                    else {
                        writeStre = diceSetter(statTemp);
                    }
                    inputString = String.format("Origin: %s, Role: %s, SubRole: %s, HP: %s, Level: %s, Strength: %d, " +
                                    "Toughness: %d, Athletics: %s, Brawn: %s, Conditioning: %s, Intimidation: %s, " +
                                    "Might: %s, Speed: %d, Evasion: %d, Acrobatics: %s, Driving: %S, Finesse: %s, " +
                                    "Infiltration: %s, Initiative: %s, Targeting: %s, Smarts: %d, Willpower: %d, " +
                                    "Alertness: %s, Culture: %s, Science: %s, Survival: %s, Technology: %s, Social: %d, " +
                                    "Cleverness: %d, Animal Handling: %s, Deception: %s, Performance: %s, " +
                                    "Persuasion: %s, Streetwise: %s", writeOrigin, writeRole, writeSubRole, writeHP,
                            writeLevel, writeStrengthStat, writeToughness, writeAth, writeBraw, writeCond, writeInt,
                            writeMig, writeSpeedStat, writeEvasion, writeAcro, writeDriv, writeFin, writeInf,
                            writeInit, writeTarg, writeSmartsStat, writeWillpower, writeAlert, writeCul, writeSci,
                            writeSur, writeTech, writeSocialStat, writeCleverness, writeAniHand, writeDec, writePerf,
                            writePers, writeStre);
                    writeQueue.enqueue(inputString);
                    queueTotal++;
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
            clearList();
        }
    }
}
