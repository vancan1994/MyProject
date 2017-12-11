package business;
import java.util.Date;

public class Product {
    private String productID;
    private String categoryID;
    private String productName;
    private double price;
    private String description;
    private String image;
    private String image1;
    private String image2;
    private String image3;
    private String image4; 
    private Date date;
    public Product() {
    }

    public Product(String productID, String categoryID, String productName, double price, String description, String image, String image1, String image2, String image3, String image4) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }
    
    public Product(String categoryID, String productName, double price, String description, String image, String image1, String image2, String image3, String image4) {
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.date = date;
    }

    public Product(String productID, String categoryID, String productName, double price, String description, String image, String image1, String image2, String image3, String image4, Date date) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public Date getIndex() {
        return date;
    }

    public void setIndex(Date index) {
        this.date = index;
    }
    
   
    
}
