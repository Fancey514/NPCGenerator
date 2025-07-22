public class NPC {
    private String origin;
    private String role;
    private String subRole;
    private int[] Strength = {0, 0, 0, 0, 0};
    private int [] Speed = {0, 0, 0, 0, 0, 0};
    private int[] Smarts = {0, 0, 0, 0, 0};
    private int[] Social = {0, 0, 0, 0, 0};
    int HP, level;

    public NPC(String inOrigin, String inRole, String inSubRole, int[] inStrength, int[] inSpeed, int[] inSmarts, int[] inSocial, int inHP, int inLevel) {
        origin = inOrigin;
        role = inRole;
        subRole = inSubRole;
        Strength = inStrength;
        Speed = inSpeed;
        Smarts = inSmarts;
        Social = inSocial;
        HP = inHP;
        level = inLevel;
    }

    public NPC() {
        origin = "";
        role = "";
        subRole = "";
    }

    public void setOrigin(String origIn) {
        origin = origIn;
    }

    public void setRole(String roleIn) {
        role = roleIn;
    }

    public void setSubRole(String subRoleIn) {
        subRole = subRoleIn;
    }

    public void setStrength(int[] StrengthIn) {
        Strength = StrengthIn;
    }

    public void setSpeed(int[] SpeedIn) {
        Speed = SpeedIn;
    }

    public void setSmarts(int[] SmartsIn) {
        Smarts = SmartsIn;
    }

    public void setSocial(int[] SocialIn) {
        Social = SocialIn;
    }

    public void setHP(int HPin) {
        HP = HPin;
    }

    public void setLevel(int levelIn) {
        level = levelIn;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRole() {
        return role;
    }

    public String getSubRole() {
        return subRole;
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

    public int getLevel() {
        return level;
    }
}
