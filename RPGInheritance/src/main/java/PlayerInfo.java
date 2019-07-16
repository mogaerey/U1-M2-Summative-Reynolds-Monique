public abstract class PlayerInfo {
    String name;
    int strength;
    int health;
    int stamina;
    int speed;
    int attackPower;
    int shieldStrength;


    public PlayerInfo(String name, int strength, int health, int stamina, int speed,
                      int attackPower, int shieldStrength) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
        this.shieldStrength = shieldStrength;
    }

    public String toString() {
        return name + "  " + strength + "  " + health + "  " + stamina + "  " + speed + "  " + attackPower + "  " +
                shieldStrength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    // abilities methods
    public void run() {

    }

    public void attack() {
    }

    public void heal() {
    }

    public void decreaseHealth() {
    }

    public void increaseStamina() {
    }

    public void decreaseStamina() {

    }

}