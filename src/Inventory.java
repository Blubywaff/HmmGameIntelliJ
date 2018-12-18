import java.util.*;

public class Inventory
{
    private ArrayList<Object> items =  new ArrayList<Object>();
    private ZombieParts zParts = new ZombieParts(0);
    private Wood wood = new Wood(0);
    private Stone stone = new Stone(0);
    private Gun gunPrimary;
    private Gun gunSecondary;
    private Gun gunBody;
    private Armor armorHead;
    private Armor armorChest;
    private Armor armorLegs;
    private Armor armorFeet;
    private Armor armorHands;
    private Tool toolPrimary;
    private Tool toolSecondary;
    private int numAM = 0;
    private ArmorModule[] armorModules = new ArmorModule[getNumAM()];

    public Inventory() {
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
        setNumAM(getArmorHands().numAM + getArmorHead().numAM + getArmorChest().numAM + getArmorLegs().numAM + getArmorFeet().numAM);
        setArmorModules(new ArmorModule[getNumAM()]);
        int nums = 0;
        for(ArmorModule a : temp) {
            getArmorModules()[nums] = a;
            nums++;
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