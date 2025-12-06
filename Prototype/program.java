package Prototype;

import java.util.Scanner;
public class program{
    static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {

    

        while (true) {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1. Admin Login");
            System.out.println("2. Cashier Login");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                adminLogin();
            } 
            else if (choice == 2) {
                cashierLogin();  
            } 
            else if (choice == 0) {
                System.out.println("Exiting Program...");
                break;
            } 
            else {
                System.out.println("Invalid Option! Try Again.");
            }
        }
    }
   // ======================== ADMIN LOGIN ============================
    public static void adminLogin() {

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
        System.out.println("categories...");
     }  
  // ======================== ADD PRODUCT ===============================
    public static void addProduct() { 
        System.out.println("Add product.....");
     }
  // ======================== SEARCH PRODUCT ==============================
      public static void searchProduct() {
     //   System.out.println("Search product.....");
     }
   
    // ======================== UPDATE PRODUCT ==============================
    public static void updateProduct() {
        System.out.println("Update product.......");
    }
    //=============================================================
    //                  Cashier login
    //=============================================================
    public static void cashierLogin() {
        String user, pass;

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
          System.out.println("Add to cart......");
}
  //                          APPLY DISCOUNT & TAX
    // =====================================================================
    
    public static void applyDiscountTax() {
        System.out.println("apply Discount and tax........");
}
   //                              GENERATE BILL
    // =====================================================================

    public static void generateBill() {
        System.out.println("gerarate bill......");
}
 //                              PAYMENT PROCESS
    // =====================================================================

    public static void payment() {
        System.out.println(" payment process.......");
}
}
 
    


