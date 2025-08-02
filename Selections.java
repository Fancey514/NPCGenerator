import java.util.Random;

public class Selections {

    // Declare variables and arrays
    private String[] Origin = {"Armory Call", "Behemoth", "Carapaced", "Champion", "Charger", "Climber/Nimble", "Cutter",
            "Drone", "Flora", "Flyer", "Fuzor", "Insecticon", "Lookout", "Many-Armed", "Mini-Con", "Monolith", "Monstrosity",
            "Outrider", "Pillar", "Pretender", "Primate", "Quadruped", "Rainmaker", "Salvaged", "Saurian", "Seeker",
            "Slitherer", "Speaker", "Support", "Swimmer"};
    private String[] Role = {"Analyst", "Field Commander", "Gunner", "Modemaster", "Raider", "Scientist", "Scout", "Warrior"};
    private String[] analystSubRole = {"Corruptor", "Hub", "Inquisitor", "Manipulator", "Spec Ops"};
    private String[] fieldCommanderSubRole = {"Ambassador", "Mastermind", "Strategist", "Team Leader", "Tyrant"};
    private String[] gunnerSubRole = {"Cannonade", "Cannoneer", "Gunslinger", "Sharpshooter", "Triggerbot"};
    private String[] modemasterSubRole = {"Bonded Master", "Component Ace", "Microlinked", "Mimic", "Minion Master", "Triple Changer"};
    private String[] raiderSubRole = {"Acquisition Expert", "Siegemaster"};
    private String[] scientistSubRole = {"Councillor", "Cyber Engineer", "Elementalist", "Gadgeteer", "Medical Officer"};
    private String[] scoutSubRole = {"Demolitionist", "Outrider", "Prowler", "Surveyor", "Tracker"};
    private String[] warriorSubRole = {"Brute", "Pugilist", "Sentinel", "Shredder", "Wrecker"};
    private int[] Strength = {0, 0, 0, 0, 0};
    private int[] Speed = {0, 0, 0, 0, 0, 0};
    private int[] Smarts = {0, 0, 0, 0, 0};
    private int[] Social = {0, 0, 0, 0, 0};
    private String newOrigin, newRole, newSubRole = "";
    private int temp = 0, tempPoints = 0, tempPointscompare = 0, tempSkill = 0, characterLevel = 0, MMTrack, MMFocus, HP;
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Set Constructor
    public Selections(int lvlIn) {
        characterLevel = lvlIn;        // Take Character level from parameter
        originDecide();                // Execute originDecide method
        roleDecide();                  // Execute roleDecide  method
        subRoleDecide();               // Execute subRoleDecide method
        statSetting();                 // Execute statSetting method
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Method to select the origin
    public void originDecide() {

        // Initialize a randomizer
        Random randNum = new Random();               // Assign a randomizer for selecting an Origin

        temp = randNum.nextInt(Origin.length);       // Set the temp variable to a random number within the amount or elements in the Origin array
        newOrigin = Origin[temp];                    // Set the Origin to the corresponding element in the Origin array
        Random randVal = new Random();               // Assign a randomizer to select 
        if (temp == 0) {                             // Set HP and stat point for Armory Call origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;                         // Increase Survival
            }
            else {
                Smarts[4]++;                         // Increase Technology
            }
        }
        else if (temp == 1) {                        // Set HP and stat point for Behemoth origin
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;                       // Increase Brawn
            }
            else {
                Strength[4]++;                       // Increase Might
            }
        }
        else if (temp == 2) {                        // Set HP and stat point for Carapaced origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;                       // Increase Brawn
            }
            else {
                Strength[2]++;                       // Increase Conditioning
            }
        }
        else if (temp == 3) {                        // Set HP and stat point for Champion origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Social[3]++;                         // Increase Persuasion
            }
            else {
                Social[4]++;                         // Increase Streetwise
            }
        }
        else if (temp == 4) {                        // Set HP and stat point for Charger origin
            HP = 3;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Strength[0]++;                       // Increase Athletics
            }
            else if (tempPoints == 2){
                Strength[1]++;                       // Increase Brawn
            }
            else if (tempPoints == 3){
                Speed[1]++;                          // Increase Driving
            }
            else {
                Speed[4]++;                          // Increase Initiative
            }
        }
        else if (temp == 5) {                        // Set HP and stat point for Climber/Nimble origin
            HP = 2;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[2]++;                          // Increase Finesse
            }
            else if (tempPoints == 2){
                Speed[3]++;                          // Increase Infiltration
            }
            else if (tempPoints == 3){
                Smarts[0]++;                         // Increase Alertness
            }
            else {
                Smarts[1]++;                         // Increase Culture
            }
        }
        else if (temp == 6) {                        // Set HP and stat point for Cutter origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;                       // Increase Athletics
            }
            else {
                Strength[4]++;                       // Increase Might
            }
        }
        else if (temp == 7 || temp == 10) {          // Set HP and stat point for Drone or Fuzor origin
            HP = 3;
            tempPoints = randVal.nextInt(21) + 1;
            if (tempPoints == 1) {
                Strength[0]++;                       // Increase Athletics
            }
            else if (tempPoints == 2){
                Strength[1]++;                       // Increase Brawn
            }
            else if (tempPoints == 3){
                Strength[2]++;                       // Increase Conditioning
            }
            else if (tempPoints == 4){
                Strength[3]++;                       // Increase Intimidation
            }
            else if (tempPoints == 5){
                Strength[4]++;                       // Increase Might
            }
            else if (tempPoints == 6){
                Speed[0]++;                          // Increase Acrobatics
            }
            else if (tempPoints == 7){
                Speed[1]++;                          // Increase Driving
            }
            else if (tempPoints == 8){
                Speed[2]++;                          // Increase Finesse
            }
            else if (tempPoints == 9){
                Speed[3]++;                          // Increase Infiltration
            }
            else if (tempPoints == 10){
                Speed[4]++;                          // Increase Initiative
            }
            else if (tempPoints == 11){
                Speed[5]++;                          // Increase Targeting
            }
            else if (tempPoints == 12){
                Smarts[0]++;                         // Increase Alertness
            }
            else if (tempPoints == 13){
                Smarts[1]++;                         // Increase Culture
            }
            else if (tempPoints == 14){
                Smarts[2]++;                         // Increase Science
            }
            else if (tempPoints == 15){
                Smarts[3]++;                         // Increase Survival
            }
            else if (tempPoints == 16){
                Smarts[4]++;                         // Increase Technology
            }
            else if (tempPoints == 17){
                Social[0]++;                         // Increase Animal Handling
            }
            else if (tempPoints == 18){
                Social[1]++;                         // Increase Deception
            }
            else if (tempPoints == 19){
                Social[2]++;                         // Increase Performance
            }
            else if (tempPoints == 20){
                Social[3]++;                         // Increase Persuasion
            }
            else {
                Social[4]++;                         // Increase Streetwise
            }
        }
        else if (temp == 8) {                        // Set HP and stat point for Flora origin
            HP = 4;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Smarts[2]++;                         // Increase Science
            }
            else {
                Social[3]++;                         // Increase Persuasion
            }
        }
        else if (temp == 9) {                        // Set HP and stat point for Flyer origin
            HP = 3;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[1]++;                          // Increase Driving
            }
            else {
                Smarts[0]++;                         // Increase Alertness
            }
        }
        else if (temp == 11) {                        // Set HP and stat point for Insecticon origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;                        // Increase Athletics
            }
            else {
                Strength[1]++;                        // Increase Brawn
            }
        }
        else if (temp == 12) {                        // Set HP and stat point for Lookout origin
            HP = 2;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[2]++;                           // Increase Finesse
            }
            else if (tempPoints == 2){
                Speed[3]++;                           // Increase Infiltration
            }
            else if (tempPoints == 3){
                Social[1]++;                          // Increase Deception
            }
            else {
                Social[4]++;                          // Increase Streetwise
            }
        }
        else if (temp == 13) {                        // Set HP and stat point for Many-Armed origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;                           // Increase Acrobatics
            }
            else {
                Smarts[0]++;                          // Increase Alertness
            }
        }
        else if (temp == 14) {                        // Set HP and stat point for Mini-Con origin
            HP = 2;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;                           // Increase Acrobatics
            }
            else {
                Speed[4]++;                           // Increase Initiative
            }
        }
        else if (temp == 15 || temp == 16) {          // Set HP and stat point for Monolith or Monstrosity origin
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;                        // Increase Brawn
            }
            else {
                Strength[4]++;                        // Increase Might
            }
        }
        else if (temp == 17) {                        // Set HP and stat point for Outrider origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[0]++;                          // Increase Alertness
            }
            else {
                Smarts[3]++;                          // Increase Survival
            }
        }
        else if (temp == 18) {                        // Set HP and stat point for Pillar origin
            HP = 4;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Strength[1]++;                        // Increase Brawn
            }
            else if (tempPoints == 2) {
                Strength[2]++;                        // Increase Conditioning
            }
            else {
                Strength[3]++;                        // Increase Intimidation
            }
        }
        else if (temp == 19) {                        // Set HP and stat point for Pretender origin
            HP = 2;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Social[1]++;                          // Increase Deception
            }
            else if (tempPoints == 2) {
                Social[3]++;                          // Increase Persuasion
            }
            else {
                Social[4]++;                          // Increase Streetwise
            }
        }
        else if (temp == 20) {                        // Set HP and stat point for Primate origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;                          // Increase Survival
            }
            else {
                Social[3]++;                          // Increase Persuasion
            }
        }
        else if (temp == 21) {                        // Set HP and stat point for Quadruped origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;                        // Increase Brawn
            }
            else {
                Speed[3]++;                           // Increase Infiltration
            }
        }
        else if (temp == 22) {                        // Set HP and stat point for Rainmaker origin
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[4]++;                           // Increase Initiative
            }
            else {
                Speed[5]++;                           // Increase Targeting
            }
        }
        else if (temp == 23) {                        // Set HP and stat point for Salvaged origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;                          // Increase Survival
            }
            else {
                Smarts[4]++;                          // Increase Technology
            }
        }
        else if (temp == 24) {                        // Set HP and stat point for Saurian origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;                        // Increase Athletics
            }
            else {
                Speed[0]++;                           // Increase Acrobatics
            }
        }
        else if (temp == 25) {                        // Set HP and stat point for Seeker origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;                           // Increase Acrobatics
            }
            else {
                Speed[1]++;                           // Increase Driving
            }
        }
        else if (temp == 26) {                        // Set HP and stat point for Slitherer origin
            HP = 3;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Speed[3]++;                           // Increase Infiltration
            }
            else if (tempPoints == 2) {
                Social[1]++;                          // Increase Deception
            }
            else {
                Social[3]++;                          // Increase Persuasion
            }
        }
        else if (temp == 27) {                        // Set HP and stat point for Speaker origin
            HP = 3;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Smarts[1]++;                          // Increase Culture
            }
            else if (tempPoints == 2) {
                Social[3]++;                          // Increase Persuasion
            }
            else {
                Social[4]++;                          // Increase Streetwise
            }
        }
        else if (temp == 28) {                        // Set HP and stat point for Support origin
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[2]++;                          // Increase Science
            }
            else {
                Smarts[4]++;                          // Increase Technology
            }
        }
        else if (temp == 29) {                        // Set HP and stat point for Swimmer origin
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;                        // Increase Athletics
            }
            else {
                Smarts[3]++;                          // Increase Survival
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Method to select the role
    public void roleDecide() {

        // Initialize a randomizer
        Random randNum = new Random();                 // Assign random number generator to decide role

        temp = randNum.nextInt(Role.length);           // Set the temp variable to a random number within the amount or elements in the Role array
        newRole = Role[temp];                          // Set the Role to the corresponding element in the Role array
        
        Random randVal = new Random();                 // Assign random number generator to choose stat increase
        if (temp == 0) {                               // Set stats for Analyst
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Speed[2]++;                            // Increase Finesse
            }
            else if (tempPoints == 1) {
                Speed[3]++;                            // Increase Infiltration
            }
            else {
                Speed[4]++;                            // Increase Initiative
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;                           // Increase Alertness
            }
            else if (tempPoints == 1) {
                Smarts[2]++;                           // Increase Science
            }
            else {
                Smarts[4]++;                           // Increase Technology
            }
        }
        else if (temp == 1) {                          // Set stats for Field Commander
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Strength[1]++;                         // Increase Brawn
            }
            else if (tempPoints == 1) {
                Strength[3]++;                         // Increase Intimidation
            }
            else {
                Strength[4]++;                         // Increase Might
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Social[1]++;                           // Increase Deception
            }
            else if (tempPoints == 1){
                Social[2]++;                           // Increase Performance
            }
            else {
                Social[3]++;                           // Increase Persuasion
            }
        }
        else if (temp == 2) {                          // Set stats for Gunner
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Speed[4]++;                            // Increase Initiative
            }
            else {
                Speed[5]++;                            // Increase Targeting
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;                           // Increase Alertness
            }
            else {
                Smarts[3]++;                           // Increase Survival
            }
        }
        else if (temp == 3) {                          // Set stats for Modemaster
            tempPoints = randVal.nextInt(4);
            if (tempPoints == 0) {
                tempSkill = randVal.nextInt(5);
                Strength[tempSkill]++;                 // Increase a random Strength stat 
            }
            else if (tempPoints == 1) {
                tempSkill = randVal.nextInt(6);
                Speed[tempSkill]++;                    // Increase a random Speed stat
            }
            else if (tempPoints == 2) {
                tempSkill = randVal.nextInt(5);
                Smarts[tempSkill]++;                   // Increase a random Smarts stat
            }
            else {
                tempSkill = randVal.nextInt(5);
                Social[tempSkill]++;                   // Increase a random Social stat
            }
            tempPointscompare = tempPoints;
            while (tempPoints == tempPointscompare) {  // Verify the next stat to be increased is different
                tempPoints = randVal.nextInt(4);
            }
            if (tempPoints == 0) {
                tempSkill = randVal.nextInt(5);
                Strength[tempSkill]++;                 // Increase a random Strength stat
            }
            else if (tempPoints == 1) {
                tempSkill = randVal.nextInt(6);
                Speed[tempSkill]++;                    // Increase a random Speed stat
            }
            else if (tempPoints == 2) {
                tempSkill = randVal.nextInt(5);
                Smarts[tempSkill]++;                   // Increase a random Smarts stat
            }
            else {
                tempSkill = randVal.nextInt(5);
                Social[tempSkill]++;                   // Increase a random Social stat
            }
        }
        else if (temp == 4) {                          // Set stats for Raider
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Strength[0]++;                         // Increase Athletics
            }
            else {
                Strength[3]++;                         // Increase Intimidation
            }
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Smarts[0]++;                           // Increase Alertness
            }
            else {
                Smarts[1]++;                           // Increase Culture
            }
        }
        else if (temp == 5) {                          // Set stats for Scientist
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Strength[1]++;                         // Increase Brawn
            }
            else {
                Strength[2]++;                         // Increase Conditioning
            }
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Smarts[2]++;                           // Increase Science
            }
            else {
                Smarts[4]++;                           // Increase Technology
            }
        }
        else if (temp == 6) {                          // Set stats for Scout
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;                           // Increase Alertness
            }
            else if (tempPoints == 1) {
                Speed[3]++;                            // Increase Infiltration
            }
            else {
                Speed[4]++;                            // Increase Initiative
            }
            if (tempPoints == 0) {
                while (tempPoints == 0) {              // Verify that Alertness won't get increased a second time if it was increased on the first pass
                    tempPoints = randVal.nextInt(3);
                }
            }
            else {
                tempPoints = randVal.nextInt(3);
            }
            if (tempPoints == 0) {
                Smarts[0]++;                            // Increase Alertness
            }
            else if (tempPoints == 1) {
                Social[1]++;                            // Increase Deception
            }
            else {
                Social[4]++;                            // Increase Streetwise
            }
        }
        else if (temp == 7) {                           // Set stats for Warrior
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Strength[1]++;                          // Increase Brawn
            }
            if (tempPoints == 1) {
                Strength[2]++;                          // Increase Conditioning
            }
            else {
                Strength[4]++;                          // Increase Might
            }
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;                            // Increase Alertness
            }
            else if (tempPoints == 1) {
                Smarts[1]++;                            // Increase Culture
            }
            else {
                Smarts[3]++;                            // Increase Survival
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Method to select the sub-role
    public void subRoleDecide(){

        // Initialize a randomizer
        Random randNum = new Random();                                                      // Set a randomizer to select Sub-Role
                                                                                            // Check which role was selected
        if (temp == 0) {
            temp = randNum.nextInt(analystSubRole.length);
            newSubRole = analystSubRole[temp];                                              // Set the Analyst sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {                                     // Loop through each level to set stat points
                if (l == 1 || l == 10) {
                    AnalystSubRolePoints();                                                 // Assign Analyst Sub-Role point at levels 1 & 10
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 2, 5, 9, 14, 18, and 20 
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 3, 7, 11, 15, and 19
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 4, 8, 13, and 16
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 1) {
            temp = randNum.nextInt(fieldCommanderSubRole.length);
            newSubRole = fieldCommanderSubRole[temp];                                       // Set the Field Commander sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    FieldCommanderSubRolePoints();                                          // Assign Field Commander Sub-Role point at levels 1 & 10
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 2, 5, 9, 14, 18, and 20
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 3, 7, 11, 15, and 19
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 4, 8, 13, and 16
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 2) {
            temp = randNum.nextInt(gunnerSubRole.length);
            newSubRole = gunnerSubRole[temp];                                               // Set the Gunner sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    GunnerSubRolePoints();                                                  // Assign Gunner Sub-Role point at levels 1 & 10
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 2, 5, 9, 14, 18, and 20
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 3, 7, 11, 15, and 19
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 4, 8, 13, and 16
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 3) {
            temp = randNum.nextInt(modemasterSubRole.length);
            newSubRole = modemasterSubRole[temp];                                           // Set the Modemaster sub-role and stat points
            ModemasterTrack();                                                              // Execute the method to assign a Modemaster track
            MMFocus = randNum.nextInt(21);
            if (MMTrack == 0) {                                                             // Check which Modemaster track will be followed
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();                                          // Assign Modemaster Sub-Role point at levels 1 & 10
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomStrengthPoint();                                              // Assign a Strength point at levels 2, 5, 9, 14, 18, and 20
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSmartsPoint();                                                // Assign a Smarts point at levels 3, 7, 11, 15, and 19
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSpeedPoint();                                                 // Assign a Speed point at levels 4, 8, 13, and 16
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSocialPoint();                                                // Assign a Social point at levels 6, 12, and 17
                    }
                }
            }
            else if (MMTrack == 1) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();                                          // Assign Modemaster Sub-Role point at levels 1 & 10
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSmartsPoint();                                                // Assign a Smarts point at levels 2, 5, 9, 14, 18, and 20
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomStrengthPoint();                                              // Assign a Strength point at levels 3, 7, 11, 15, and 19
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSocialPoint();                                                // Assign a Social point at levels 4, 8, 13, and 16
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSpeedPoint();                                                 // Assign a Social point at levels 6, 12, and 17
                    }
                }
            }
            else if (MMTrack == 2) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();                                          // Assign Modemaster Sub-Role point at levels 1 & 10
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSpeedPoint();                                                 // Assign a Speed point at levels 2, 5, 9, 14, 18, and 20
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSocialPoint();                                                // Assign a Social point at levels 3, 7, 11, 15, and 19
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSmartsPoint();                                                // Assign a Smarts point at levels 4, 8, 13, and 16
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomStrengthPoint();                                              // Assign a Strength point at levels 6, 12, and 17
                    }
                }
            }
            else if (MMTrack == 3) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();                                          // Assign Modemaster Sub-Role point at levels 1 & 10
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSocialPoint();                                                // Assign a Social point at levels 2, 5, 9, 14, 18, and 20
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSpeedPoint();                                                 // Assign a Speed point at levels 3, 7, 11, 15, and 19
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomStrengthPoint();                                              // Assign a Strength point at levels 4, 8, 13, and 16
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSmartsPoint();                                                // Assign a Smarts point at levels 6, 12, and 17
                    }
                }
            }
        }
        else if (temp == 4) {
            temp = randNum.nextInt(raiderSubRole.length);
            newSubRole = raiderSubRole[temp];                                               // Set the Raider sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    RaiderSubRolePoints();                                                  // Assign Raider Sub-Role point at levels 1 & 10
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 2, 5, 9, 14, 18, and 20
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 3, 7, 11, 15, and 19
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 4, 8, 13, and 16
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 5) {
            temp = randNum.nextInt(scientistSubRole.length);
            newSubRole = scientistSubRole[temp];                                            // Set the Scientist sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    ScientistSubRolePoints();                                               // Assign Scientist Sub-Role point at levels 1 & 10
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 2, 5, 9, 14, 18, and 20
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 3, 7, 11, 15, and 19
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 4, 8, 13, and 16
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 6) {
            temp = randNum.nextInt(scoutSubRole.length);
            newSubRole = scoutSubRole[temp];                                                // Set the Scout sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    ScoutSubRolePoints();                                                   // Assign Scout Sub-Role point at levels 1 & 10
                } 
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSpeedPoint();                                                     // Assign a Speed point at levels 2, 5, 9, 14, 18, and 20
                } 
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19) {
                    RandomSmartsPoint();                                                    // Assign a Smarts point at levels 3, 7, 11, 15, and 19                                 
                } 
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSocialPoint();                                                    // Assign a Social point at levels 4, 8, 13, and 16
                } 
                else if (l == 6 || l == 12 || l == 17) {
                    RandomStrengthPoint();                                                  // Assign a Strength point at levels 6, 12, and 17
                }
            }
        }
        else if (temp == 7) {
            temp = randNum.nextInt(warriorSubRole.length);
            newSubRole = warriorSubRole[temp];                                               // Set the Warrior sub-role
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    WarriorSubRolePoints();                                                  // Assign Warrior Sub-Role point at levels 1 & 10
                } 
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomStrengthPoint();                                                   // Assign a Strength point at levels 2, 5, 9, 14, 18, and 20
                } 
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19) {
                    RandomSpeedPoint();                                                      // Assign a Speed point at levels 3, 7, 11, 15, and 19
                } 
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSmartsPoint();                                                     // Assign a Smarts point at levels 4, 8, 13, and 16
                } 
                else if (l == 6 || l == 12 || l == 17) {
                    RandomSocialPoint();                                                     // Assign a Social point at levels 6, 12, and 17
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Set beginning skill points
    public void statSetting(){
        // Declare variables
        int tempCategory, tempSkill;
        // Set a stat point in each category to ensure there's at least one stat per category
        RandomStrengthPoint();
        RandomSpeedPoint();
        RandomSmartsPoint();
        RandomSocialPoint();
        
        for (int i = 0; i < 8; i++) {                // Loop 8 times to get the remaining stats
            Random randNum = new Random();           // Assign a random number generator to randomize the selected category
            tempCategory = randNum.nextInt(4) + 1;   // Set category to increase
            if (tempCategory == 1) {
                RandomStrengthPoint();               // Execute method to increase a strength skill
            }
            else if (tempCategory == 2) {
                RandomSpeedPoint();                  // Execute method to increase a speed skill
            }
            else if (tempCategory == 3) {
                RandomSmartsPoint();                 // Execute method to increase a smarts skill
            }
            else {
                RandomSocialPoint();                 // Execute method to increase a social skill
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    // Setters and Getters
    public void setNewOrigin(String inNewOrigin) {
        newOrigin = inNewOrigin;
    }
    public String getNewOrigin() {
        return newOrigin;
    }

    public void setNewRole(String inNewRole) {
        newRole = inNewRole;
    }
    public String getNewRole() {
        return newRole;
    }

    public void setNewSubRole(String inNewSubRole) {
        newSubRole = inNewSubRole;
    }
    public String getNewSubRole() {
        return newSubRole;
    }

    public int[] getStrength() {
        return Strength;
    }

    public int[] getSpeed() {
        return Speed;
    }

    public int[] getSmarts() {
        return Smarts;
    }

    public int[] getSocial() {
        return Social;
    }

    public int getHP() {
        return HP;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void RandomStrengthPoint() {
        Random randNum = new Random();        // Assign random number generator to choose a skill to increase
        do {
            tempPoints = randNum.nextInt(5);  // Generate the number
        }while (Strength[tempPoints] == 6);   // Loop if the skill assigned to that number already has 6 points assigned to it
        Strength[tempPoints]++;               // Increase the skill
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void RandomSpeedPoint() {
        Random randNum = new Random();        // Assign random number generator to choose a skill to increase
        do {
            tempPoints = randNum.nextInt(6);  // Generate the number
        }while (Speed[tempPoints] == 6);      // Loop if the skill assigned to that number already has 6 points assigned to it
        Speed[tempPoints]++;                  // Increase the skill
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void RandomSmartsPoint() {
        Random randNum = new Random();        // Assign random number generator to choose a skill to increase
        do {
            tempPoints = randNum.nextInt(5);  // Generate the number
        }while (Smarts[tempPoints] == 6);     // Loop if the skill assigned to that number already has 6 points assigned to it
        Smarts[tempPoints]++;                 // Increase the skill
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void RandomSocialPoint() {
        Random randNum = new Random();        // Assign random number generator to choose a skill to increase
        do {
            tempPoints = randNum.nextInt(5);  // Generate the number
        }while (Social[tempPoints] == 6);     // Loop if the skill assigned to that number already has 6 points assigned to it
        Social[tempPoints]++;                 // Increase the skill
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void ModemasterTrack() {
        Random randNum = new Random();        // Assign random number generator to choose a skill to increase
        MMTrack = randNum.nextInt(4);         // Set Modemaster track
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void AnalystSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Smarts[1] < 6) {
                    Smarts[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Smarts[2] < 6) {
                    Smarts[2]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Smarts[4] < 6) {
                    Smarts[4]++;
                }
                else {
                    if (Smarts[1] < 6) {
                        Smarts[1]++;
                    }
                    else if (Smarts[2] < 6) {
                        Smarts[2]++;
                    }
                }
            }
        }
        else if (temp == 1) {
            do {
                tempPoints = randNum.nextInt(3);
            }while (Smarts[tempPoints] == 6);
            Smarts[tempPoints]++;
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[0] < 6) {
                    Social[0]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    if (Social[0] < 6) {
                        Social[0]++;
                    }
                    else if (Social[1] < 6) {
                        Social[1]++;
                    }
                }
            }
        }
        else if (temp == 3) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[4] < 6) {
                    Social[4]++;
                }
                else {
                    if (Social[1] < 6) {
                        Social[1]++;
                    }
                    else if (Social[3] < 6) {
                        Social[3]++;
                    }
                }
            }
        }
        else if (temp == 4) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[4] < 6) {
                    Social[4]++;
                }
                else {
                    if (Social[1] < 6) {
                        Social[1]++;
                    }
                    else if (Social[3] < 6) {
                        Social[3]++;
                    }
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void FieldCommanderSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    if (Social[1] < 6) {
                        Social[1]++;
                    }
                    else if (Social[2] < 6) {
                        Social[2]++;
                    }
                }
            }
        }
        else if (temp == 1) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[1] < 6) {
                    Social[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[4] < 6) {
                    Social[4]++;
                }
                else {
                    if (Social[1] < 6) {
                        Social[1]++;
                    }
                    else if (Social[3] < 6) {
                        Social[3]++;
                    }
                }
            }
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Smarts[0] < 6) {
                    Smarts[0]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Smarts[1] < 6) {
                    Smarts[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Smarts[4] < 6) {
                    Smarts[4]++;
                }
                else {
                    if (Smarts[0] < 6) {
                        Smarts[0]++;
                    }
                    else if (Smarts[1] < 6) {
                        Smarts[1]++;
                    }
                }
            }
        }
        else if (temp == 3) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Social[0] < 6) {
                    Social[0]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Social[2] < 6) {
                    Social[2]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Social[3] < 6) {
                    Social[3]++;
                }
                else {
                    if (Social[0] < 6) {
                        Social[0]++;
                    }
                    else if (Social[2] < 6) {
                        Social[2]++;
                    }
                }
            }
        }
        else if (temp == 4) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Strength[1] < 6) {
                    Strength[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Strength[2] < 6) {
                    Strength[2]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Strength[3] < 6) {
                    Strength[3]++;
                }
                else {
                    if (Strength[1] < 6) {
                        Strength[1]++;
                    }
                    else if (Strength[2] < 6) {
                        Strength[2]++;
                    }
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void GunnerSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0 || temp == 1) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Strength[0] < 6) {
                    Strength[0]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Strength[1] < 6) {
                    Strength[1]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Strength[3] < 6) {
                    Strength[3]++;
                }
                else {
                    if (Strength[0] < 6) {
                        Strength[0]++;
                    }
                    else if (Strength[1] < 6) {
                        Strength[1]++;
                    }
                }
            }
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Speed[0] < 6) {
                    Speed[0]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Speed[4] < 6) {
                    Speed[4]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Speed[5] < 6) {
                    Speed[5]++;
                }
                else {
                    if (Speed[0] < 6) {
                        Speed[0]++;
                    }
                    else if (Speed[4] < 6) {
                        Speed[4]++;
                    }
                }
            }
        }
        else if (temp == 3) {
            tempPoints = randNum.nextInt(2);
            if (tempPoints == 0) {
                if (Speed[3] < 6) {
                    Speed[3]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Speed[4] < 6) {
                    Speed[4]++;
                }
                else {
                    if (Speed[3] < 6) {
                        Speed[3]++;
                    }
                }
            }
        }
        else if (temp == 4) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                if (Speed[2] < 6) {
                    Speed[2]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 1) {
                if (Speed[4] < 6) {
                    Speed[4]++;
                }
                else {
                    tempPoints++;
                }
            }
            if (tempPoints == 2) {
                if (Speed[5] < 6) {
                    Speed[5]++;
                }
                else {
                    if (Speed[2] < 6) {
                        Speed[2]++;
                    }
                    else if (Speed[4] < 6) {
                        Speed[4]++;
                    }
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void ModemasterSubRolePoints() {
        if (MMFocus == 0) {
            Strength[0]++;
        }
        else if (MMFocus == 1) {
            Strength[1]++;
        }
        else if (MMFocus == 2) {
            Strength[2]++;
        }
        else if (MMFocus == 3) {
            Strength[3]++;
        }
        else if (MMFocus == 4) {
            Strength[4]++;
        }
        else if (MMFocus == 5) {
            Speed[0]++;
        }
        else if (MMFocus == 6) {
            Speed[1]++;
        }
        else if (MMFocus == 7) {
            Speed[2]++;
        }
        else if (MMFocus == 8) {
            Speed[3]++;
        }
        else if (MMFocus == 9) {
            Speed[4]++;
        }
        else if (MMFocus == 10) {
            Speed[5]++;
        }
        else if (MMFocus == 11) {
            Smarts[0]++;
        }
        else if (MMFocus == 12) {
            Smarts[1]++;
        }
        else if (MMFocus == 13) {
            Smarts[2]++;
        }
        else if (MMFocus == 14) {
            Smarts[3]++;
        }
        else if (MMFocus == 15) {
            Smarts[4]++;
        }
        else if (MMFocus == 16) {
            Social[0]++;
        }
        else if (MMFocus == 17) {
            Social[1]++;
        }
        else if (MMFocus == 18) {
            Social[2]++;
        }
        else if (MMFocus == 19) {
            Social[3]++;
        }
        else if (MMFocus == 20) {
            Social[4]++;
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void RaiderSubRolePoints() {
        Random randNum = new Random();
        tempPoints = randNum.nextInt(3);
        if (temp == 0) {
            if (tempPoints == 0) {
                Speed[0]++;
            }
            else if (tempPoints == 1) {
                Speed[3]++;
            }
            else {
                Speed[4]++;
            }
        }
        else {
            if (tempPoints == 0) {
                Strength[0]++;
            }
            else if (tempPoints == 1) {
                Strength[3]++;
            }
            else {
                Strength[4]++;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void ScientistSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Social[0]++;
            }
            else if (tempPoints == 1) {
                Social[2]++;
            }
            else {
                Social[3]++;
            }
        }
        else if (temp == 1) {
            tempPoints = randNum.nextInt(21);
            if (tempPoints == 0) {
                Strength[0]++;
            }
            else if (tempPoints == 1) {
                Strength[1]++;
            }
            else if (tempPoints == 2) {
                Strength[2]++;
            }
            else if (tempPoints == 3) {
                Strength[3]++;
            }
            else if (tempPoints == 4) {
                Strength[4]++;
            }
            else if (tempPoints == 5) {
                Speed[0]++;
            }
            else if (tempPoints == 6) {
                Speed[1]++;
            }
            else if (tempPoints == 7) {
                Speed[2]++;
            }
            else if (tempPoints == 8) {
                Speed[3]++;
            }
            else if (tempPoints == 9) {
                Speed[4]++;
            }
            else if (tempPoints == 10) {
                Speed[5]++;
            }
            else if (tempPoints == 11) {
                Smarts[0]++;
            }
            else if (tempPoints == 12) {
                Smarts[1]++;
            }
            else if (tempPoints == 13) {
                Smarts[2]++;
            }
            else if (tempPoints == 14) {
                Smarts[3]++;
            }
            else if (tempPoints == 15) {
                Smarts[4]++;
            }
            else if (tempPoints == 16) {
                Social[0]++;
            }
            else if (tempPoints == 17) {
                Social[1]++;
            }
            else if (tempPoints == 18) {
                Social[2]++;
            }
            else if (tempPoints == 19) {
                Social[3]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else if (tempPoints == 1) {
                Smarts[2]++;
            }
            else {
                Smarts[3]++;
            }
        }
        else if (temp == 3) {
            Smarts[4]++;
        }
        else if (temp == 4) {
            tempPoints = randNum.nextInt(2);
            if (tempPoints == 0) {
                Smarts[2]++;
            }
            else {
                Smarts[4]++;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void ScoutSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Speed[0]++;
            }
            else if (tempPoints == 1) {
                Speed[2]++;
            }
            else {
                Speed[3]++;
            }
        }
        else if (temp == 1) {
            tempPoints = randNum.nextInt(2);
            if (tempPoints == 0) {
                Speed[1]++;
            }
            else {
                Speed[4]++;
            }
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Speed[2]++;
            }
            else if (tempPoints == 1) {
                Speed[3]++;
            }
            else {
                Speed[5]++;
            }
        }
        else if (temp == 3) {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Speed[1]++;
            }
            else if (tempPoints == 1) {
                Speed[3]++;
            }
            else {
                Speed[5]++;
            }
        }
        else {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else if (tempPoints == 1) {
                Smarts[1]++;
            }
            else {
                Smarts[3]++;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void WarriorSubRolePoints() {
        Random randNum = new Random();
        if (temp == 0) { // Brute
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Strength[0]++;
            }
            else if (tempPoints == 1) {
                Strength[3]++;
            }
            else {
                Strength[4]++;
            }
        }
        else if (temp == 1) { // Pugilist
            tempPoints = randNum.nextInt();
            if (tempPoints == 0) {
                Strength[0]++;
            }
            else if (tempPoints == 1) {
                Strength[1]++;
            }
            else {
                Strength[4]++;
            }
        }
        else if (temp == 2) {
            tempPoints = randNum.nextInt(2);
            if (tempPoints == 0) {
                Speed[2]++;
            }
            else {
                Speed[4]++;
            }
        }
        else if (temp == 3) { // Shredder
            tempPoints = randNum.nextInt();
            if (tempPoints == 0) {
                Speed[0]++;
            }
            else if (tempPoints == 1) {
                Speed[2]++;
            }
            else {
                Speed[4]++;
            }
        }
        else {
            tempPoints = randNum.nextInt(3);
            if (tempPoints == 0) {
                Strength[1]++;
            }
            else if (tempPoints == 1) {
                Strength[2]++;
            }
            else {
                Strength[4]++;
            }
        }
    }

}
