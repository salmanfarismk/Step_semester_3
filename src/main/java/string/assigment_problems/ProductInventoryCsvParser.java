package string.assigment_problems;

/**
 * Problem 3: Product Inventory CSV Parser
 * Scenario: Warehouse Inventory Updates
 * 
 * Validates and extracts product inventory records from comma-separated strings.
 */
public class ProductInventoryCsvParser {

    /**
     * Splits a CSV line into fields, checks that exactly 3 fields exist,
     * and outputs formatted product details.
     *
     * @param csvLine The raw CSV string ("ProductName,SKU,Quantity")
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory CSV Parser ===");

        String record1 = "Wireless Mouse,WM-2201,150";
        System.out.println("Input: \"" + record1 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(record1);

        String record2 = "Wireless Mouse,150";
        System.out.println("\nInput: \"" + record2 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(record2);
    }
}
