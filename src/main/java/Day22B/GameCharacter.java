package Day22B;

public class GameCharacter {
    protected String name;
    protected int hp;
    protected int baseAttack;

    public GameCharacter(String name, int hp, int baseAttack) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
                if( hp < 0 ) {
                    this.hp = 0;
                } else {
                    this.hp = hp;
                }

                if (baseAttack < 0) {
                    this.baseAttack = 0;
                } else {
                    this.baseAttack = baseAttack;
                }
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getBaseAttack() {
        return baseAttack;
    }

    public void takeDamage(int damage) {
        if (damage > 0){
            hp = hp - damage;
            if (hp < 0){
                hp = 0;
            }
        }

    }

    public int attack() {
        return baseAttack;
    }
}

// Subclass
class Mage extends GameCharacter {
    private int mana;
    private int spellPower;

    public Mage(String name, int hp, int baseAttack, int mana, int spellPower) {
        super(name, hp, baseAttack);
        if (mana < 0){
            this.mana = 0;
        }else{
            this.mana = mana;
        }
        if(spellPower < 0){
            this.spellPower = 0;
        }else{
            this.spellPower = spellPower;
        }
    }

    public int getMana() {
        return mana;
    }
    public int getSpellPower() {
        return spellPower;
    }

    public int castSpell() {
        // Tulis kode di sini
        if(mana >= 20){
            mana = mana - 20;
            return baseAttack + spellPower * 2;
        }else {
            return 0;
        }
    }

}

class StartGame {
    public static void main(String[] args) {
        GameCharacter warrior = new GameCharacter("Arthur", 100, 15);
        System.out.println(warrior.attack()); // Output: 15
        warrior.takeDamage(120);
        System.out.println(warrior.getHp());   // Output: 0 (HP tidak boleh negatif)

        Mage gandalf = new Mage("Gandalf", 80, 10, 30, 25);
        System.out.println(gandalf.castSpell()); // Output: 60 (10 + 25*2), Mana sisa 10
        System.out.println(gandalf.getMana());    // Output: 10
        System.out.println(gandalf.castSpell()); // Output: 0 (Mana kurang dari 20, gagal)

    }
}