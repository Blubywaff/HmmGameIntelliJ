import java.util.*;

public class Inventory
{
    public ArrayList<Object> items =  new ArrayList<Object>();
    public Wood wood = new Wood(0);
    public Stone stone = new Stone(0);
    public Gun gunPrimary;
    public Gun gunSecondary;
    public Gun gunBody;
    public Armor armorHead;
    public Armor armorChest;
    public Armor armorLegs;
    public Armor armorFeet;
    public Armor armorHands;
    public Tool toolPrimary;
    public Tool toolSecondary;
    public Inventory()
    {
    }
    public Gun getPrimary() {
        return gunPrimary;
    }
    public void addResource(String t, double a) {
        if(t == "Wood") {
            wood.amount += a;
        } else if(t == "Stone") {
            stone.amount += a;
        }
    }
} 