package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
    private List<OrderDetail> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<OrderDetail> items) {
        this.items = items;
    }
    
    

    public void setItems(List<OrderDetail> orderDetails) {
        this.items = orderDetails;
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }
    

    public void addItems(OrderDetail item){
        String productID = item.getProduct().getProductID();
        int quantity = item.getQuantity();
        for(OrderDetail li:items){
            if(li.getProduct().getProductID().equals(productID)){
                li.setQuantity(quantity);
                return;// de thoat khoi vong nhanh hon
            }
        }
        items.add(item);
    }
    public void removeItem(OrderDetail item){
        String productID = item.getProduct().getProductID();
        for(OrderDetail o:items){
            if(o.getProduct().getProductID().equals(productID)){
                items.remove(o);
                return;// de thoat khoi vong nhanh hon
            }
        }
    }
    public void updateItem(OrderDetail item) {
        String productID = item.getProduct().getProductID();
        //int quantity = item.getQuantity();
        
        for(OrderDetail li:items){
            if(li.getProduct().getProductID().equals(productID)){
                li.setQuantity(li.getQuantity()+1);
                return;
            }
        }
        items.add(item);
    }
    
    public void updateItemDetail(OrderDetail item) {
        String productID = item.getProduct().getProductID();
        int quantity = item.getQuantity();

        for(OrderDetail li:items){
            if(li.getProduct().getProductID().equals(productID)){
                li.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
}
