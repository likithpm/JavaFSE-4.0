import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Shoes", "Footwear"),
            new Product(4, "Phone", "Electronics"),
            new Product(5, "Watch", "Accessories")
        };
        Product result1 = linearSearch(products, "Phone");
        System.out.println("Linear Search Result: " + result1);
        Arrays.sort(products, Comparator.comparing(p -> p.productName));
        Product result2 = binarySearch(products, "Phone");
        System.out.println("Binary Search Result: " + result2);
    }
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
