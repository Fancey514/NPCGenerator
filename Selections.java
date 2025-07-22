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

    public Selections(int lvlIn) {
        characterLevel = lvlIn;
        originDecide();
        roleDecide();
        subRoleDecide();
        statSetting();
    }

    // Method to select the origin
    public void originDecide() {

        // Initialize a randomizer
        Random randNum = new Random();

        temp = randNum.nextInt(Origin.length);  // Set the temp variable to a random number within the amount or elements in the Origin array
        newOrigin = Origin[temp];               // Set the Origin to the corresponding element in the Origin array
        Random randVal = new Random();
        if (temp == 0) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;
            }
            else {
                Smarts[4]++;
            }
        }
        else if (temp == 1) {
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;
            }
            else {
                Strength[4]++;
            }
        }
        else if (temp == 2) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;
            }
            else {
                Strength[2]++;
            }
        }
        else if (temp == 3) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Social[3]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 4) {
            HP = 3;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else if (tempPoints == 2){
                Strength[1]++;
            }
            else if (tempPoints == 3){
                Speed[1]++;
            }
            else {
                Speed[4]++;
            }
        }
        else if (temp == 5) {
            HP = 2;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[2]++;
            }
            else if (tempPoints == 2){
                Speed[3]++;
            }
            else if (tempPoints == 3){
                Smarts[0]++;
            }
            else {
                Smarts[1]++;
            }
        }
        else if (temp == 6) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else {
                Strength[4]++;
            }
        }
        else if (temp == 7 || temp == 10) {
            HP = 3;
            tempPoints = randVal.nextInt(21) + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else if (tempPoints == 2){
                Strength[1]++;
            }
            else if (tempPoints == 3){
                Strength[2]++;
            }
            else if (tempPoints == 4){
                Strength[3]++;
            }
            else if (tempPoints == 5){
                Strength[4]++;
            }
            else if (tempPoints == 6){
                Speed[0]++;
            }
            else if (tempPoints == 7){
                Speed[1]++;
            }
            else if (tempPoints == 8){
                Speed[2]++;
            }
            else if (tempPoints == 9){
                Speed[3]++;
            }
            else if (tempPoints == 10){
                Speed[4]++;
            }
            else if (tempPoints == 11){
                Speed[5]++;
            }
            else if (tempPoints == 12){
                Smarts[0]++;
            }
            else if (tempPoints == 13){
                Smarts[1]++;
            }
            else if (tempPoints == 14){
                Smarts[2]++;
            }
            else if (tempPoints == 15){
                Smarts[3]++;
            }
            else if (tempPoints == 16){
                Smarts[4]++;
            }
            else if (tempPoints == 17){
                Social[0]++;
            }
            else if (tempPoints == 18){
                Social[1]++;
            }
            else if (tempPoints == 19){
                Social[2]++;
            }
            else if (tempPoints == 20){
                Social[3]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 8) {
            HP = 4;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Smarts[2]++;
            }
            else {
                Social[3]++;
            }
        }
        else if (temp == 9) {
            HP = 3;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[1]++;
            }
            else {
                Smarts[0]++;
            }
        }
        else if (temp == 11) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else {
                Strength[1]++;
            }
        }
        else if (temp == 12) {
            HP = 2;
            tempPoints = randVal.nextInt(4) + 1;
            if (tempPoints == 1) {
                Speed[2]++;
            }
            else if (tempPoints == 2){
                Speed[3]++;
            }
            else if (tempPoints == 3){
                Social[1]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 13) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;
            }
            else {
                Smarts[0]++;
            }
        }
        else if (temp == 14) {
            HP = 2;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;
            }
            else {
                Speed[4]++;
            }
        }
        else if (temp == 15 || temp == 16) {
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;
            }
            else {
                Strength[4]++;
            }
        }
        else if (temp == 17) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[0]++;
            }
            else {
                Smarts[3]++;
            }
        }
        else if (temp == 18) {
            HP = 4;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Strength[1]++;
            }
            else if (tempPoints == 2) {
                Strength[2]++;
            }
            else {
                Strength[3]++;
            }
        }
        else if (temp == 19) {
            HP = 2;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Social[1]++;
            }
            else if (tempPoints == 2) {
                Social[3]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 20) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;
            }
            else {
                Social[3]++;
            }
        }
        else if (temp == 21) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[1]++;
            }
            else {
                Speed[3]++;
            }
        }
        else if (temp == 22) {
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[4]++;
            }
            else {
                Speed[5]++;
            }
        }
        else if (temp == 23) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[3]++;
            }
            else {
                Smarts[4]++;
            }
        }
        else if (temp == 24) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else {
                Speed[0]++;
            }
        }
        else if (temp == 25) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Speed[0]++;
            }
            else {
                Speed[1]++;
            }
        }
        else if (temp == 26) {
            HP = 3;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Speed[3]++;
            }
            else if (tempPoints == 2) {
                Social[1]++;
            }
            else {
                Social[3]++;
            }
        }
        else if (temp == 27) {
            HP = 3;
            tempPoints = randVal.nextInt(3) + 1;
            if (tempPoints == 1) {
                Smarts[1]++;
            }
            else if (tempPoints == 2) {
                Social[3]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 28) {
            HP = 4;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Smarts[2]++;
            }
            else {
                Smarts[4]++;
            }
        }
        else if (temp == 29) {
            HP = 3;
            tempPoints = randVal.nextInt() + 1;
            if (tempPoints == 1) {
                Strength[0]++;
            }
            else {
                Smarts[3]++;
            }
        }
    }

    // Method to select the role
    public void roleDecide() {

        // Initialize a randomizer
        Random randNum = new Random();

        temp = randNum.nextInt(Role.length);    // Set the temp variable to a random number within the amount or elements in the Role array
        newRole = Role[temp];                   // Set the Role to the corresponding element in the Role array
        Random randVal = new Random();
        if (temp == 0) {
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Speed[2]++;
            }
            else if (tempPoints == 1) {
                Speed[3]++;
            }
            else {
                Speed[4]++;
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else if (tempPoints == 1) {
                Smarts[2]++;
            }
            else {
                Smarts[4]++;
            }
        }
        else if (temp == 1) {
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Strength[1]++;
            }
            else if (tempPoints == 1) {
                Strength[3]++;
            }
            else {
                Strength[4]++;
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Social[1]++;
            }
            else if (tempPoints == 1){
                Social[2]++;
            }
            else {
                Social[3]++;
            }
        }
        else if (temp == 2) {
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Speed[4]++;
            }
            else {
                Speed[5]++;
            }
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else {
                Smarts[3]++;
            }
        }
        else if (temp == 3) {
            tempPoints = randVal.nextInt(4);
            if (tempPoints == 0) {
                tempSkill = randVal.nextInt(5);
                Strength[tempSkill]++;
            }
            else if (tempPoints == 1) {
                tempSkill = randVal.nextInt(6);
                Speed[tempSkill]++;
            }
            else if (tempPoints == 2) {
                tempSkill = randVal.nextInt(5);
                Smarts[tempSkill]++;
            }
            else {
                tempSkill = randVal.nextInt(5);
                Speed[tempSkill]++;
            }
            tempPointscompare = tempPoints;
            while (tempPoints == tempPointscompare) {
                tempPoints = randVal.nextInt(4);
            }
            if (tempPoints == 0) {
                tempSkill = randVal.nextInt(5);
                Strength[tempSkill]++;
            }
            else if (tempPoints == 1) {
                tempSkill = randVal.nextInt(6);
                Speed[tempSkill]++;
            }
            else if (tempPoints == 2) {
                tempSkill = randVal.nextInt(5);
                Smarts[tempSkill]++;
            }
            else {
                tempSkill = randVal.nextInt(5);
                Speed[tempSkill]++;
            }
        }
        else if (temp == 4) {
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Strength[0]++;
            }
            else {
                Strength[3]++;
            }
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else {
                Smarts[1]++;
            }
        }
        else if (temp == 5) {
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Strength[1]++;
            }
            else {
                Strength[2]++;
            }
            tempPoints = randVal.nextInt();
            if (tempPoints == 0) {
                Smarts[2]++;
            }
            else {
                Smarts[4]++;
            }
        }
        else if (temp == 6) {
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else if (tempPoints == 1) {
                Speed[3]++;
            }
            else {
                Speed[4]++;
            }
            if (tempPoints == 0) {
                while (tempPoints == 0) {
                    tempPoints = randVal.nextInt(3);
                }
            }
            else {
                tempPoints = randVal.nextInt(3);
            }
            if (tempPoints == 0) {
                Smarts[0]++;
            }
            else if (tempPoints == 1) {
                Social[1]++;
            }
            else {
                Social[4]++;
            }
        }
        else if (temp == 7) {
            tempPoints = randVal.nextInt(3);
            if (tempPoints == 0) {
                Strength[1]++;
            }
            if (tempPoints == 1) {
                Strength[2]++;
            }
            else {
                Strength[4]++;
            }
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

    // Method to select the sub-role
    public void subRoleDecide(){

        // Initialize a randomizer
        Random randNum = new Random();
                                                                        // Check which role was selected
        if (temp == 0) {
            temp = randNum.nextInt(analystSubRole.length);
            newSubRole = analystSubRole[temp];                          // Set the analyst sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    AnalystSubRolePoints();
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSocialPoint();
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSpeedPoint();
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomStrengthPoint();
                }
            }
        }
        else if (temp == 1) {
            temp = randNum.nextInt(fieldCommanderSubRole.length);
            newSubRole = fieldCommanderSubRole[temp];                   // Set the field commander sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    FieldCommanderSubRolePoints();
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSocialPoint();
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSmartsPoint();
                }
            }
        }
        else if (temp == 2) {
            temp = randNum.nextInt(gunnerSubRole.length);
            newSubRole = gunnerSubRole[temp];                           // Set the gunner sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    GunnerSubRolePoints();
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSpeedPoint();
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSmartsPoint();
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSocialPoint();
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomStrengthPoint();
                }
            }
        }
        else if (temp == 3) {
            temp = randNum.nextInt(modemasterSubRole.length);
            newSubRole = modemasterSubRole[temp];                       // Set the modemaster sub-role and stat points
            ModemasterTrack();
            MMFocus = randNum.nextInt(21);
            if (MMTrack == 0) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomStrengthPoint();
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSmartsPoint();
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSpeedPoint();
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSocialPoint();
                    }
                }
            }
            else if (MMTrack == 1) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSmartsPoint();
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomStrengthPoint();
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSocialPoint();
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSpeedPoint();
                    }
                }
            }
            else if (MMTrack == 2) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSpeedPoint();
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSocialPoint();
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomSmartsPoint();
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomStrengthPoint();
                    }
                }
            }
            else if (MMTrack == 3) {
                for (int l = 1; l <= characterLevel; l++) {
                    if (l == 1 || l == 10) {
                        ModemasterSubRolePoints();
                    }
                    else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                        RandomSocialPoint();
                    }
                    else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                        RandomSpeedPoint();
                    }
                    else if (l == 4 || l == 8 || l == 13 || l == 16) {
                        RandomStrengthPoint();
                    }
                    else if (l == 6 ||l == 12 ||l == 17) {
                        RandomSmartsPoint();
                    }
                }
            }
        }
        else if (temp == 4) {
            temp = randNum.nextInt(raiderSubRole.length);
            newSubRole = raiderSubRole[temp];                           // Set the raider sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    RaiderSubRolePoints();
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSocialPoint();
                }
            }
        }
        else if (temp == 5) {
            temp = randNum.nextInt(scientistSubRole.length);
            newSubRole = scientistSubRole[temp];                        // Set the scientist sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    ScientistSubRolePoints();
                }
                else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSmartsPoint();
                }
                else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19 ) {
                    RandomSpeedPoint();
                }
                else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomStrengthPoint();
                }
                else if (l == 6 ||l == 12 ||l == 17) {
                    RandomSocialPoint();
                }
            }
        }
        else if (temp == 6) {
            temp = randNum.nextInt(scoutSubRole.length);
            newSubRole = scoutSubRole[temp];                            // Set the scout sub-role and stat points
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    ScoutSubRolePoints();
                } else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomSpeedPoint();
                } else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19) {
                    RandomSmartsPoint();
                } else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSocialPoint();
                } else if (l == 6 || l == 12 || l == 17) {
                    RandomStrengthPoint();
                }
            }
        }
        else if (temp == 7) {
            temp = randNum.nextInt(warriorSubRole.length);
            newSubRole = warriorSubRole[temp];                          // Set the warrior sub-role
            for (int l = 1; l <= characterLevel; l++) {
                if (l == 1 || l == 10) {
                    WarriorSubRolePoints();
                } else if (l == 2 || l == 5 || l == 9 || l == 14 || l == 18 || l == 20) {
                    RandomStrengthPoint();
                } else if (l == 3 || l == 7 || l == 11 || l == 15 || l == 19) {
                    RandomSpeedPoint();
                } else if (l == 4 || l == 8 || l == 13 || l == 16) {
                    RandomSmartsPoint();
                } else if (l == 6 || l == 12 || l == 17) {
                    RandomSocialPoint();
                }
            }
        }
    }

    // Set beginning skill points
    public void statSetting(){
        int tempCategory, tempSkill;
        RandomStrengthPoint();
        RandomSpeedPoint();
        RandomSmartsPoint();
        RandomSocialPoint();
        for (int i = 0; i < 8; i++) {
            Random randNum = new Random();
            tempCategory = randNum.nextInt(4) + 1;
            if (tempCategory == 1) {
                RandomStrengthPoint();
            }
            else if (tempCategory == 2) {
                RandomSpeedPoint();
            }
            else if (tempCategory == 3) {
                RandomSmartsPoint();
            }
            else {
                RandomSocialPoint();
            }
        }
    }

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

    public void RandomStrengthPoint() {
        Random randNum = new Random();
        do {
            tempPoints = randNum.nextInt(5);

        }while (Strength[tempPoints] == 6);
        Strength[tempPoints]++;
    }

    public void RandomSpeedPoint() {
        Random randNum = new Random();
        do {
            tempPoints = randNum.nextInt(6);
        }while (Speed[tempPoints] == 6);
        Speed[tempPoints]++;

    }

    public void RandomSmartsPoint() {
        Random randNum = new Random();
        do {
            tempPoints = randNum.nextInt(5);
        }while (Smarts[tempPoints] == 6);
        Smarts[tempPoints]++;
    }

    public void RandomSocialPoint() {
        Random randNum = new Random();
        do {
            tempPoints = randNum.nextInt(5);
        }while (Social[tempPoints] == 6);
        Social[tempPoints]++;
    }

    public void ModemasterTrack() {
        Random randNum = new Random();
        MMTrack = randNum.nextInt(4);
    }

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