import java.util.Scanner;
public class project{
    static Scanner sc = new Scanner(System.in);

    // Category data
    static String [] categories = {"Fruits","Vegetables", "Grocery","Bakery items","Beverages"};
    static double [] discount = {0.10,0.05,0.02,0.03,0.5};
    static double [] tax = {0.08,0.04,0.05,0.10,0.09};
    //Product data
    static String [] productName = new String[50];
    static double [] productPrice = new double[50];
    static int [] productQty = new int[50];
    static int [] productCategory = new int[50];
    static int productCount = 0;
    static double price, total;


   public static void main(String[] args) {

    

        while (true) {
            System.out.println("\t.....Welcome to Grocery Billing System.....\t");
            System.out.println("\n\t============== MAIN MENU ======\t");
            System.out.println("\t------Please autenticate to Continue-------\t");
   
            System.out.println("Press 1 to proceed as Admin.");
            System.out.println("Press 2 to proceed as Cashier.");
            System.out.println("Press 0 to exit System.");
           
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                adminLogin();
            } 
            else if (choice == 2) {
                cashierLogin();  
            } 
            else if (choice == 0) {
                System.out.println("\n\t...System executed Safely!...\t");
                break;
            } 
            else {
                System.out.println("Invalid Option! kindly Try Again.");
            }
        }
    }
   // ======================== ADMIN LOGIN ============================
    public static void adminLogin() {
        System.out.println("\t.....Admin login panel.....\t\n");
        
        System.out.print("\nEnter Admin Username: ");
        String u = sc.next();

        System.out.print("Enter Admin Password: ");
        String p = sc.next();

        if (u.equals("admin") && p.equals("123")) {
            System.out.println("Admin Login Successful!");
            adminMenu();
        } 
    }
// ======================== ADMIN MENU =============================
    public static void adminMenu() {

        while (true) {
            System.out.println("\n====== ADMIN MENU ======");
            System.out.println("1. View Categories");
            System.out.println("2. Add Product");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                viewCategories();
            } 
            else if (choice == 2) {
                addProduct();
            } 
            else if (choice == 3) {
                searchProduct();
            } 
            else if (choice == 4) {
                updateProduct();
            } 
            else if (choice == 0) {
                break; 
            }
            else {
                System.out.println("Invalid Option! Try Again.");
            }
        }
    }

       
    
  //  ========================= View categories=========================
      public static void viewCategories() {
        System.out.println("\n-----------CATEGORIES LIST-----------");
        for(int i=0; i<categories.length;i++){
            System.out.println((i+1) + "." +categories[i]+ "\nDiscount: "+ (discount[i]*100) + "%" + "\nTax: " + (tax[i]*100) + "%");
         
        }
     }  
  // ======================== ADD PRODUCT ===============================
    public static void addProduct() { 

        System.out.println("\n-------Add Product-------");

        System.out.print("Enter Product Name: ");
        productName[productCount]= sc.next();

        System.out.print("Enter Product price: ");
        productPrice[productCount]= sc.nextDouble();

        System.out.print("Enter Product Quantity: ");
        productQty[productCount] = sc.nextInt();

        System.out.println("\n-------Select Category-------");
         for(int i= 0; i<categories.length; i++){
            System.out.println((i+1) + "." + categories[i]);
        }
        productCategory[productCount]=sc.nextInt() - 1;
        System.out.println("Product Added Successfully!");
        productCount++;
    }
  // ======================== SEARCH PRODUCT ==============================
    public static void searchProduct() {
        System.out.println("\n--------Search Product--------");
        
        System.out.print("Enter product name to search: ");
        String name= sc.next();

        for(int i=0; i<productCount; i++){
            if(productName[i].equalsIgnoreCase(name)){
                System.out.println("Product Found: ");
                System.out.println("Name: " + productName[i]);
                System.out.println("Price: " + productPrice[i]);
                System.out.println("Quantity: " + productQty[i]);
                System.out.println("Category: " + categories[productCategory[i]]);
                return;
            }
        }
        System.out.println("Product not found");

     }
   
    // ======================== UPDATE PRODUCT ==============================
    public static void updateProduct() {
        System.out.println("\n---------Update Product---------");
        System.out.print("Enter Product Name to Update: ");
        String name = sc.next();

        for (int i = 0; i < productCount; i++) {

            if (productName[i].equalsIgnoreCase(name)) {

                System.out.print("Enter New Price: ");
                productPrice[i] = sc.nextDouble();

                System.out.print("Enter New Quantity: ");
                productQty[i] = sc.nextInt();

                System.out.println("Product Updated Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }
    //=============================================================
    //                  Cashier login
    //=============================================================
    public static void cashierLogin() {
        String user, pass;
        System.out.println("\t.....Cashier login panel.....\t\n");

        System.out.print("Enter Cashier Username: ");
        user = sc.next();
        System.out.print("Enter Cashier Password: ");
        pass = sc.next();

        if (user.equals("cashier") && pass.equals("456")) {
            cashierMenu();
        } else {
            System.out.println("Invalid cashier login!");
        }
    }
        
   
  //                              CASHIER MENU
    // =====================================================================
    public static void cashierMenu() {

        while (true) {
            System.out.println("\n========== CASHIER MENU ==========");
            System.out.println("1. Add Items to Cart");
            System.out.println("2. Apply Discount & Tax");
            System.out.println("3. Generate Bill");
            System.out.println("4. Payment Process");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) addToCart();
            else if (choice == 2) applyDiscountTax();
            else if (choice == 3) generateBill();
            else if (choice == 4) payment();
            else if (choice == 0) break;
            else System.out.println("Invalid option!");
        }
    }
    //                           Add to cart
    //====================================================================

    public static void addToCart() {
        
        while (true) {
            System.out.println("\n----- Add Item to Cart -----");
            System.out.print("Enter Product Name: ");
            productName[productCount] = sc.next(); 
            
            System.out.print("Enter Product Category (by name): ");
            String catName = sc.next();
            int catIndex = -1;
            for (int i = 0; i < categories.length; i++) {
                if (categories[i].equalsIgnoreCase(catName)) {
                    catIndex = i;
                    break;
                }
            }
            if (catIndex == -1) {
                System.out.println("Invalid category! Item not added.");
                continue;
            }
            productCategory[productCount] = catIndex;

            System.out.print("Enter Product Price: ");
            productPrice[productCount] = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            productQty[productCount] = sc.nextInt();

            productCount++;

            System.out.print("Do you want to add another item? (yes/no): ");
            String ans = sc.next();
            if (!ans.equalsIgnoreCase("yes")) break;
        }
        System.out.println("\nReturning to cashier menu.......\n");
    }

 //                          APPLY DISCOUNT & TAX
    // =====================================================================
    
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
   

//                              GENERATE BILL
    // =====================================================================

    public static void generateBill() {
        System.out.println("\n----- BILL -----");
        if (productCount == 0) {
        System.out.println("No items in cart to generate bill.");
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

        System.out.println("\n" + productName[i] + " | " + productQty[i] + " x " + pricePerItem +
                " = " + amount + " | Discount: " + discountAmount +
                " | Tax: " + taxAmount + " | Final: " + finalPrice);
    }

    System.out.println("TOTAL PAYABLE: " + total);
    System.out.println(".............................................................");
    System.out.println("\nReturning to cashier menu.......\n");
}
 //                              PAYMENT PROCESS
    // =====================================================================

    public static void payment() {
        System.out.println("\n Payment Process.......");
        if (productCount == 0) {
            System.out.println("\nNo items in cart for payment.");
            System.out.println("\nReturning to cashier menu.......\n");
            return;
        }

        generateBill();
        System.out.print("Enter amount paid: ");
        double paid = sc.nextDouble();

        if (paid >= total) {
            System.out.println("\nPayment successful! Change: " + (paid - total));
            System.out.println("....................................................");
            productCount = 0;
        } else {
            System.out.println("\nInsufficient payment. Transaction failed.");
        }
        System.out.println("\nReturning to cashier menu.......\n");
    }
}