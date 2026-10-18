public class ProductInventoryParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3
                || data[0].trim().isEmpty()
                || data[1].trim().isEmpty()
                || data[2].trim().isEmpty()) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + data[0].trim()
                    + " | SKU: " + data[1].trim()
                    + " | Qty: " + data[2].trim());
        }
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}
