package EduSwapApplication.Purchase;

import javax.persistence.*;
import EduSwapApplication.Users.User;
import EduSwapApplication.Listings.Listing;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;
    
    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Listing listing;
    
    private String purchaseDate;
    private String paymentStatus;
    private String transactionId;
    private boolean accessGranted;
    
    public Purchase() {}
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public User getBuyer() { return buyer; }
    public void setBuyer(User buyer) { this.buyer = buyer; }
    public Listing getListing() { return listing; }
    public void setListing(Listing listing) { this.listing = listing; }
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public boolean isAccessGranted() { return accessGranted; }
    public void setAccessGranted(boolean accessGranted) { this.accessGranted = accessGranted; }
}
