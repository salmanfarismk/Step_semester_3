package string.assigment_problems;

/**
 * Problem 4: The Warehouse Inventory Balancer
 * Scenario: Retail Warehouse Stock Auditing
 * 
 * Balances total stock across two warehouse storage sections and locates
 * the peak-quantity inventory item.
 */
public class WarehouseInventoryBalancer {

    /**
     * Computes totals for each warehouse section, checks balance status,
     * and reports the overall highest-quantity item.
     *
     * @param sectionA Array of quantities for Section A
     * @param sectionB Array of quantities for Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid inventory records.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxItemIndex = -1; // 1-based index

        // Process Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        // Process Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQty, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer ===");

        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(sectionA1, sectionB1);

        int[] sectionA2 = {50, 20, 30};
        int[] sectionB2 = {40, 25, 30};
        System.out.println("\nInput: sectionA={50,20,30}, sectionB={40,25,30}");
        analyzeInventory(sectionA2, sectionB2);
    }
}
