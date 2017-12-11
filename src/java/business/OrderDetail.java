package business;

import java.text.NumberFormat;

public class OrderDetail {
    private int orderID;
    private Product product;
    private int quantity;
    private double price;
 
    public OrderDetail() {
    }

    public OrderDetail(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int orderID, Product product, int quantity, double price) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }



    
 
    
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal()
    {
        double total = quantity * price;
        return total;
    }
    public String getTotalFormatted()
    {
        double total = this.getTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String totalFormatted = currency.format(total);
        return totalFormatted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "ProductID: "+product.getProductID()+
                "\nProductName: "+product.getProductName()+
                "\nDescription: "+product.getDescription()+
                "\nPrice: "+product.getPrice();
    }
}
