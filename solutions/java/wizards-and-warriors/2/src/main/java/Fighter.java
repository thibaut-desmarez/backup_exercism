class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    boolean isVulnerable() {
        return false;
    }

    int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }
}

class Wizard extends Fighter {
    boolean spellPrepared = false;

    boolean isVulnerable() {
        return !spellPrepared;
    }

    void prepareSpell() {
        spellPrepared = true;
    }

    int getDamagePoints(Fighter fighter) {
        return this.spellPrepared ? 12 : 3;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}