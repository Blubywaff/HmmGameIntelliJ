public class CampFireBuff extends Buff {
    public CampFireBuff() {
        super();
        time = 30000;
    }

    @Override
    public void apply(Entity e) {
        e.regenFactor += e.defaultRegenFactor;
        applyTick = MainProgram.tick;
    }

    @Override
    public void unapply(Entity e) {
        e.regenFactor -= e.defaultRegenFactor;
    }
}
