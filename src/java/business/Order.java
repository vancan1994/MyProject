package business;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Order implements Serializable{
    private int orderID;
    private Account account;
    private LocalDate dateOrder;
    private int status;
    private Cart cart;
    public Order() {
    }

    public Order(LocalDate dateOrder, int status, Cart cart) {
        this.dateOrder = dateOrder;
        this.status = status;
        this.cart = cart;
    }

    public Order(int orderID, Account account, LocalDate dateOrder, int status, Cart cart) {
        this.orderID = orderID;
        this.account = account;
        this.dateOrder = dateOrder;
        this.status = status;
        this.cart = cart;
    }
    
    public Order(int orderID, Account account, LocalDate dateOrder, Cart cart) {
        this.orderID = orderID;
        this.account = account;
        this.dateOrder = dateOrder;
        this.cart = cart;
    }
    
    public Order(Account account, LocalDate dateOrder, int status, Cart cart) {
        this.account = account;
        this.dateOrder = dateOrder;
        this.status = status;
        this.cart = cart;
    }

    public Order(Account account, LocalDate dateOrder, Cart cart) {
        this.account = account;
        this.dateOrder = dateOrder;
        this.cart = cart;
    }
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

   
    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    
    

    public double getInvoiceTotal() {
        double sum = 0;
        for(OrderDetail item : cart.getItems()){
            sum += item.getTotal();
        }
        return sum;
    }
    public String getInvoiceTotalFormat() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(getInvoiceTotal());
    }
}
