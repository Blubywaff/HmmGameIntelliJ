public class ManualArmorTurret extends ArmorTurret{
    public Gun gun;
    public ManualArmorTurret() {
        gun = new TripleSlingshot();
    }

    @Override
    public void doStuff() {
        //fire();
    }
    
    public void fire() {
        fire(calcVector());
    }
    
    public void fire(Vector v) {
        gun.fire(v);
    }
    
    public Vector calcVector() {
        return MainProgram.player.genVector();
    }
}