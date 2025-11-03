package Test;

public class Test {
    public static void main(String[] args) {
       String refID= "8a9fee82861fbe9e01862055f15300c9_8a9f938897786fa0019778ceb18c2532";
        System.out.println(refID.lastIndexOf("_"));

        if (refID != null && refID.contains("_")) {
            System.out.println("ID= "+ refID.substring(refID.lastIndexOf("_") + 1));
        }
    }

    public static String extractPropertyId(String rawId) {
        if (rawId == null || rawId.trim().isEmpty()) {
            return rawId; // nothing to extract
        }
        // If underscore present → take the part after last underscore
        if (rawId.contains("_")) {
            return rawId.substring(rawId.lastIndexOf("_") + 1);
        }
        // Otherwise → treat the input as normal propertyId
        return rawId;
    }
}
