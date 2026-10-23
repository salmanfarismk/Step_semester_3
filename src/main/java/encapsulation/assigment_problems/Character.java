package encapsulation.assigment_problems;

/**
 * Problem 1: The Health Bar
 * Scenario: Game Character Battle Health
 * 
 * Demonstrates encapsulation with clamped boundary checks: health can never
 * drop below 0 or exceed the final maximum health. Modifiable only via
 * takeDamage and heal methods with no direct external setter.
 * 
 * Concepts: Encapsulation, final fields, clamped boundary validation, read-only getters.
 */
public class Character {

    private final int maxHealth;
    private int health;

    /**
     * Initializes the character with a fixed maximum health and sets current health to max.
     *
     * @param maxHealth Fixed maximum health capacity
     */
    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be greater than zero.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    /**
     * Inflicts damage on the character, reducing health.
     * Clamped at 0 (extra damage is wasted).
     *
     * @param amount Damage amount to inflict
     */
    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.max(0, health - amount);
        System.out.println("takeDamage(" + amount + ") -> health = " + health + (health == 0 ? " (floored)" : ""));
    }

    /**
     * Restores health to the character.
     * Clamped at maximum health (extra healing is wasted).
     *
     * @param amount Healing amount to restore
     */
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.min(maxHealth, health + amount);
        System.out.println("heal(" + amount + ") -> health = " + health + (health == maxHealth ? " (capped)" : ""));
    }

    /**
     * Read-only getter for current health.
     *
     * @return Current health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Read-only getter for maximum health.
     *
     * @return Maximum health capacity
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");

        Character c = new Character(100);
        System.out.println("Initial health: " + c.getHealth() + " / " + c.getMaxHealth());

        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);

        System.out.println("Final health: " + c.getHealth());
    }
}
