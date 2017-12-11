package business;

import java.time.LocalDate;

public class Posting {
    private int postingID;
    private String typePosting;
    private String category;
    private String postingTitle;
    private String description;
    private String phone;
    private String address;
    private String image;
    private LocalDate localDate;
    private int status;
    private Account account;
    
    public Posting() {
    }

    public Posting(String typePosting, String category, String postingTitle, String description, String phone, String address, String image, LocalDate localDate, int status, Account account) {
        this.typePosting = typePosting;
        this.category = category;
        this.postingTitle = postingTitle;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.localDate = localDate;
        this.status = status;
        this.account = account;
    }

    public Posting(int postingID, String typePosting, String category, String postingTitle, String description, String phone, String address, String image, LocalDate localDate, int status, Account account) {
        this.postingID = postingID;
        this.typePosting = typePosting;
        this.category = category;
        this.postingTitle = postingTitle;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.localDate = localDate;
        this.status = status;
        this.account = account;
    }
    
    public String getTypePosting() {
        return typePosting;
    }

    public void setTypePosting(String typePosting) {
        this.typePosting = typePosting;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPostingTitle() {
        return postingTitle;
    }

    public void setPostingTitle(String postingTitle) {
        this.postingTitle = postingTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountID) {
        this.account = accountID;
    }

    public int getPostingID() {
        return postingID;
    }

    public void setPostingID(int postingID) {
        this.postingID = postingID;
    }
    
}
