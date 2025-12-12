 public static void applyDiscountTax() {
       System.out.println("\n----- Applying Discount & Tax -----");
        if (productCount == 0) {
        System.out.println("No items in cart to apply discount/tax.");
        System.out.println("\nReturning to cashier menu.......\n");
        return;
    }

    total = 0;
    
    for (int i = 0; i < productCount; i++) {
        int catIndex = productCategory[i];
        double pricePerItem = productPrice[i];
        double amount = pricePerItem * productQty[i];
        
        double discountAmount = amount * discount[catIndex];
        double taxAmount = amount * tax[catIndex];
        double finalPrice = amount - discountAmount + taxAmount;

        total += finalPrice;

        System.out.println("\n" + productName[i] + " - Qty: " + productQty[i] + ", Original: " + amount +
                ", Discount: "+ discountAmount + ", Tax: " + taxAmount +", Final: " + finalPrice);
    }

    System.out.println("Total Bill after Discount & Tax: " + total);
    System.out.println("\nReturning to cashier menu.......\n");
}