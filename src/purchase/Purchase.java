package purchase;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Purchase {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Order order = null;
        
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String c_Name = sc.nextLine();
        System.out.print("Email: ");
        String c_Email = sc.next();
        System.out.print("Birth date: (DD/MM/YYYY): ");
        String c_bd = sc.next();
        Date c_Date = sdf.parse(c_bd);
        Client client = new Client(c_Name, c_Email, c_Date);
        
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String os = sc.next();
        OrderStatus w1 = OrderStatus.valueOf(os);
        System.out.print("How many itens to this order? ");
        int quant = sc.nextInt();
        
        
        for (int i = 1 ; i <= quant ; i++){
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            sc.next();
            System.out.print("Product Price: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            Product product = new Product(nameProduct, priceProduct);
            OrderItem orderItem = new OrderItem(quantity, priceProduct, product);
            order = new Order(new Date(), w1, client);
            order.addItem(orderItem);
        }   
        
        System.out.println("ORDER SUMARY: ");
        System.out.println(order);
        
        sc.close();
        
    }
    
}
