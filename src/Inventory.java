import java.util.*;

public class Inventory
{
    private ArrayList<Object> items =  new ArrayList<>();
    private ZombieParts zParts = new ZombieParts(0);
    private Wood wood = new Wood(0);
    private Stone stone = new Stone(0);
    private Gun gunPrimary = new NullGun();
    private Gun gunSecondary = new NullGun();
    private Gun gunBody = new NullGun();
    private Armor armorHead = new NullArmor();
    private Armor armorChest = new NullArmor();
    private Armor armorLegs = new NullArmor();
    private Armor armorFeet = new NullArmor();
    private Armor armorHands = new NullArmor();
    private Tool toolPrimary = new NullTool();
    private Tool toolSecondary = new NullTool();
    private int numAM = 0;
    private ArmorModule[] armorModules = new ArmorModule[getNumAM()];
    public ArrayList<Turret> turrets = new ArrayList<>();

    public Inventory() {
        init();
    }

    public void init() {
        fixAMs();
    }

    public void backfillAMs() {
        for(int i = 0; i < getNumAM(); i++) {
            if(getArmorModules()[i] == null) {
                getArmorModules()[i] = new NullArmorModule();
            }
        }
    }

    public void checkAMNum() {
        setNumAM(getArmorHands().numAM + getArmorHead().numAM + getArmorChest().numAM + getArmorLegs().numAM + getArmorFeet().numAM);
    }

    public void addResource(String t, double a) {
        if(t == "Wood") {
            getWood().amount += a;
        } else if(t == "Stone") {
            getStone().amount += a;
        } else if(t == "ZombieParts") {
            getzParts().amount += a;
        }
    }
    public void fixAMs() {
        ArmorModule[] temp = getArmorModules();
        checkAMNum();
        setArmorModules(new ArmorModule[getNumAM()]);
        backfillAMs();
        int nums = 0;
        for(ArmorModule a : temp) {
            getArmorModules()[nums] = a;
            nums++;
        }
    }

    public void addAM(ArmorModule am) {
        fixAMs();
        if(armorModules.length != 0) {
            int num = 0;
            for (int i = 0; i < armorModules.length; i++) {
                if (armorModules[i] instanceof NullArmorModule) {
                    num = i;
                }
            }
            armorModules[num] = am;
        } else {
            System.out.println("Invalid");
        }
    }

    public Gun getPrimary() {
        return getGunPrimary();
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public ZombieParts getzParts() {
        return zParts;
    }

    public Wood getWood() {
        return wood;
    }

    public Stone getStone() {
        return stone;
    }

    public Gun getGunPrimary() {
        return gunPrimary;
    }

    public Gun getGunSecondary() {
        return gunSecondary;
    }

    public Gun getGunBody() {
        return gunBody;
    }

    public Armor getArmorHead() {
        return armorHead;
    }

    public Armor getArmorChest() {
        return armorChest;
    }

    public Armor getArmorLegs() {
        return armorLegs;
    }

    public Armor getArmorFeet() {
        return armorFeet;
    }

    public Armor getArmorHands() {
        return armorHands;
    }

    public Tool getToolPrimary() {
        return toolPrimary;
    }

    public Tool getToolSecondary() {
        return toolSecondary;
    }

    public int getNumAM() {
        return numAM;
    }

    public ArmorModule[] getArmorModules() {
        return armorModules;
    }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
    }

    public void setzParts(ZombieParts zParts) {
        this.zParts = zParts;
    }

    public void setWood(Wood wood) {
        this.wood = wood;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public void setGunPrimary(Gun gunPrimary) {
        this.gunPrimary = gunPrimary;
    }

    public void setGunSecondary(Gun gunSecondary) {
        this.gunSecondary = gunSecondary;
    }

    public void setGunBody(Gun gunBody) {
        this.gunBody = gunBody;
    }

    public void setArmorHead(Armor armorHead) {
        this.armorHead = armorHead;
    }

    public void setArmorChest(Armor armorChest) {
        this.armorChest = armorChest;
    }

    public void setArmorLegs(Armor armorLegs) {
        this.armorLegs = armorLegs;
    }

    public void setArmorFeet(Armor armorFeet) {
        this.armorFeet = armorFeet;
    }

    public void setArmorHands(Armor armorHands) {
        this.armorHands = armorHands;
    }

    public void setToolPrimary(Tool toolPrimary) {
        this.toolPrimary = toolPrimary;
    }

    public void setToolSecondary(Tool toolSecondary) {
        this.toolSecondary = toolSecondary;
    }

    public void setNumAM(int numAM) {
        this.numAM = numAM;
    }

    public void setArmorModules(ArmorModule[] armorModules) {
        this.armorModules = armorModules;
    }

}