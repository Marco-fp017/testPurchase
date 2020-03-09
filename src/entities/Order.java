package entities;

import entities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private Client client;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItem = new ArrayList<>();
    
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Order(Date moment, OrderStatus w1, Client client){
        this.moment = moment;
        this.orderStatus = w1;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }
    
    public void setMoment(Date moment){
        this.moment = moment;
    }
    
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public List<OrderItem> getItems(){
        return orderItem;
    }
    
    public void addItem(OrderItem item){
        orderItem.add(item);
    }
    
    public void removeItem(OrderItem item){
        orderItem.remove(item);
    }    
    
    public double total(){
        double sum = 0;
        for (OrderItem Oi : orderItem){
        sum += Oi.subtotal();
        }
        return sum;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Order Moment: " + sdf1.format(moment) + "\n");
        sb.append("OrderStatus: " + orderStatus);
        sb.append("Client: " + client + "\n");
        sb.append("Order itens: \n");
        for(OrderItem item : orderItem){
            sb.append(item + "\n");
        }
        sb.append("Total price: " + String.format("%.2f", total()));
        return sb.toString();
    }
}
