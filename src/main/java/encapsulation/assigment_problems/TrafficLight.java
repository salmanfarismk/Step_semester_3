package encapsulation.assigment_problems;

/**
 * Problem 4: The Traffic Light
 * Scenario: Strict State-Machine Traffic Signal
 * 
 * Demonstrates state-machine encapsulation where internal state can only
 * transition through a strictly regulated sequence (RED -> GREEN -> YELLOW -> RED)
 * and can never be forced to jump directly to an arbitrary state.
 * 
 * Concepts: State machine encapsulation, restricted mutation, final identity, read-only inspection.
 */
public class TrafficLight {

    private final String id;
    private String color;

    /**
     * Initializes a traffic light with a fixed ID and default starting color RED.
     *
     * @param id Permanent identifier for the traffic light
     */
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    /**
     * Advances the traffic light to the next color in the cycle:
     * RED -> GREEN -> YELLOW -> RED.
     *
     * @return The new current color after transition
     */
    public String next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
            default:
                color = "RED";
                break;
        }
        return color;
    }

    /**
     * Read-only getter for the current color.
     *
     * @return Current active color
     */
    public String getColor() {
        return color;
    }

    /**
     * Read-only getter for the traffic light ID.
     *
     * @return Permanent traffic light ID
     */
    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Traffic Light ===");

        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light " + t.getId() + " initial color: " + t.getColor());

        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
    }
}
