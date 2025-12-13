import java.io.*;
import java.util.*;
public class project{
    static Scanner sc = new Scanner(System.in);

    // Category data
    static String [] categories = {"Fruits","Vegetables","Bakery items","Beverages"};
    static double [] discount = {0.10,0.05,0.03,0.5};
    static double [] tax = {0.08,0.04,0.05,0.10};
    //Product data
    static String [] productName = new String[50];
    static double [] productPrice = new double[50];
    static int [] productQty = new int[50];
    static int [] productCategory = new int[50];
    static int productCount = 0;

    //cashier data
    static String[] cName = new String[50];
    static double[] cPrice = new double[50];
    static int[] cQty = new int[50];
    static int[] cCat = new int[50];
    static int cartCount = 0;
    static double total;

   public static void main(String[] args) {
    loadProductsFromFile();

        while (true) {
            
            System.out.println("\t.....Welcome to Grocery Billing System.....\t");
            System.out.println("\n\t============== MAIN MENU ======\t");
            System.out.println("\t------Please autenticate to Continue-------\t");
            try{
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
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
            sc.next();
        }
     }
    }
   // ======================== ADMIN LOGIN ============================
    public static void adminLogin() {
        System.out.println("\t.....Admin login panel.....\t\n");
        
        System.out.print("Enter Admin Username: ");
        String u = sc.next();

        System.out.print("Enter Admin Password: ");
        String p = sc.next();

        if (u.equals("admin") && p.equals("123")) {
            System.out.println("Admin Login Successful!");
            adminMenu();}
        else{
            System.out.println("Wrong login ");
        }
        } 
    
// ======================== ADMIN MENU =============================
    public static void adminMenu() {

        while (true) {
            try{
            System.out.println("\n====== ADMIN MENU ======");
            System.out.println("> Press 1 to View Categories");
            System.out.println("> Press 2 to Add Product");
            System.out.println("> Press 3 to View all products");
            System.out.println("> Press 4 to Search Product");
            System.out.println("> Press 5 to Update Product");
            System.out.println("> Press 0 Return to Main Menu");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                viewCategories();
            } 
            else if (choice == 2) {
                addProduct();
            } 
            else if (choice == 3) {
                viewAllProducts();
            }
            else if (choice == 4){
                searchProduct();
            } 
            else if (choice == 5) {
                updateProduct();
            } 
            else if (choice == 0) {
                break; 
            }
            else {
                System.out.println("Invalid Option! Try Again.");
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
            sc.next();
        }
        }
    }

       
    
  //  ========================= View categories=========================
      public static void viewCategories() {

        System.out.println("\n-----------CATEGORIES LIST-----------");
        
        for(int i=0; i<categories.length;i++){
            System.out.println((i+1) + ".----" +categories[i]+ "----"+ "\n\tDiscount: "+ (discount[i]*100) + "%" + "\n\tTax: " + (tax[i]*100) + "%");
         
        }
     }  
  // ======================== ADD PRODUCT ===============================
    public static void addProduct() { 

        System.out.println("\n-------Add Product-------");

        System.out.print("Enter Product Name: ");
        productName[productCount]= sc.next();
        //Price Validation
        while(true){
         try{
            System.out.print("Enter Product price: ");
            double price = sc.nextDouble();
            if(price>0){
                productPrice[productCount]=price;
                break;
            }else{
                System.out.println("Invalid price");
            }
         }catch(InputMismatchException e){
            System.out.println("Invalid input");
            sc.next();
         }
        }
        //Quantity validation
        while(true){
            try{
               System.out.print("Enter Product Quantity: ");
               int q=sc.nextInt();
               if(q>=0){
               productQty[productCount] = q;
               break;
               } else{
                System.out.println("Invalid Quantity");
               }
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                sc.next();
            }
        }
        //Category selection with validation
        while(true){
        System.out.println("\n-------Select Category-------");
         try{
            viewCategories();
            int c=sc.nextInt();
         if(c >= 1 && c<= categories.length){
           productCategory[productCount]=c - 1;
           break;
         }else{
            System.out.println("Invalid Category");
         }
        } catch (InputMismatchException e){
            System.out.println("Invalid input");
            sc.next();
        }
       }
        productCount++;
        saveProductsToFile();
        System.out.println("Product Added");
    }
    //--------------ViewAllProducts----------------
    public static void viewAllProducts() {
     System.out.println("-------All Products-------");
    if (productCount == 0) {
        System.out.println("No Products Added Yet!");
        return;
    }

    System.out.println("\n------ PRODUCT LIST ------");

    for (int i = 0; i < productCount; i++) {
        System.out.println("\nProduct #" + (i + 1));
        System.out.println("Name: " + productName[i]);
        System.out.println("Price: " + productPrice[i]);
        System.out.println("Quantity: " + productQty[i]);
        System.out.println("Category: " + categories[productCategory[i]]);
    }
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
         // Update price
        while (true) {
             try {
             System.out.print("Enter New Price: ");
             double price = sc.nextDouble();
             if (price > 0) {
              productPrice[i] = price;
              break;
             } else{
             System.out.println("Invalid price");}
            } catch (InputMismatchException e) {
             System.out.println("Invalid input");
             sc.next();
            }
        }
         // Update quantity
         while (true) {
            try {
             System.out.print("Enter New Quantity: ");
             int q = sc.nextInt();
             if (q >= 0) {
             productQty[i] = q;
             break;
             } else{
              System.out.println("Invalid quantity");}
            } catch (InputMismatchException e) {
              System.out.println("Invalid input");
              sc.next();
            }
        }

            saveProductsToFile();
            System.out.println("Product updated");
             return;
             }
         }
        System.out.println("Product not found");
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
          try{
            System.out.println("\n========== CASHIER MENU ==========");
            System.out.println("> Press 1 to Add Items to Cart");
            System.out.println("> Press 2 to Apply Discount & Tax");
            System.out.println("> Press 3 to Generate Bill");
            System.out.println("> Press 4 to Payment Process");
            System.out.println("> Press 0 to  Return to Main Menu");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) addToCart();
            else if (choice == 2) applyDiscountTax();
            else if (choice == 3) generateBill();
            else if (choice == 4) payment();
            else if (choice == 0) break;
            else System.out.println("Invalid option!");
          }catch(InputMismatchException e){
            System.out.println("Invalid option");
            sc.next();
          }
        }
      }
    //                           Add to cart
    //====================================================================

    public static void addToCart() {


        System.out.print("Product name: ");
        String name = sc.next();

        int index = -1;
        for (int i = 0; i < productCount; i++) {
            if (productName[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Product not found");
            return;
        }

        int qty;
        while (true) {
            try {
                System.out.print("Quantity: ");
                qty = sc.nextInt();
                if (qty > 0 && qty <= productQty[index])
                    break;
                else
                    System.out.println("Invalid quantity");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                sc.next();
            }
        }

        cName[cartCount] = productName[index];
        cPrice[cartCount] = productPrice[index];
        cQty[cartCount] = qty;
        cCat[cartCount] = productCategory[index];
        cartCount++;

        productQty[index] -= qty;
        saveProductsToFile();
        

        System.out.println("Added to cart");
    }
   
 //                          APPLY DISCOUNT & TAX
    // =====================================================================
    
    public static void applyDiscountTax() {

        total = 0;
        double amount=0, dis=0, tx=0;

        for (int i = 0; i < cartCount; i++) {
            amount = cPrice[i] * cQty[i];
            dis = amount * discount[cCat[i]];
            tx = amount * tax[cCat[i]];
            total += amount - dis + tx;
        }
        System.out.println("\nOriginal amount: "+ amount +" | Discount: "+ dis +" | Tax: "+ tx +"....");
        System.out.println("Total: " + total);
    }
   

//                              GENERATE BILL
    // =====================================================================

    public static void generateBill() {
       System.out.println("...\tBill\t...");
       applyDiscountTax();
       
       System.out.println("Payable: " + total);
    }
 //                              PAYMENT PROCESS
    // =====================================================================

    public static void payment() {
        System.out.println("\n Payment Process.......");
        if (cartCount == 0) {
            System.out.println("\nNo items in cart for payment.");
            System.out.println("\nReturning to cashier menu.......\n");
            return;
        }

        generateBill();
        while(true){
            try{
             System.out.print("Enter amount paid: ");
             double paid = sc.nextDouble();

             if (paid >= total) {
             System.out.println("\nPayment successful! Change: " + (paid - total));
             System.out.println("....................................................");
             cartCount = 0;
             total=0;
             break;
             } else {
            System.out.println("\nInsufficient payment. Transaction failed.");
             }
            System.out.println("\nReturning to cashier menu.......\n");
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                sc.next();
            }    
        }
     }
     //File save
     public static void saveProductsToFile(){
        try{
            FileWriter fw = new FileWriter("Products.txt");
            for(int i=0;i<productCount;i++){
                fw.write(productName[i] + "," + productPrice[i] + "," + productQty + "," + productCategory + "\n" );
                fw.close();
            } 
        } catch (Exception e){
            System.out.println("File error");
        }
     }
     //File load
     public static void loadProductsFromFile() {
        try {
            File f = new File("products.txt");
            if (!f.exists())
                return;

            Scanner fs = new Scanner(f);
            while (fs.hasNextLine()) {
                String[] d = fs.nextLine().split(",");
                productName[productCount] = d[0];
                productPrice[productCount] = Double.parseDouble(d[1]);
                productQty[productCount] = Integer.parseInt(d[2]);
                productCategory[productCount] = Integer.parseInt(d[3]);
                productCount++;
            }
            fs.close();
        } catch (Exception e) {
            System.out.println("File load error");
        }
    }
}