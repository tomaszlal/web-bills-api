package ma.cu.lalewicz.WebBills.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    @OneToMany(mappedBy = "category")
//    private List<Bills> bills;

    @Column(nullable = false)
    private String name;

    @Column(length = 26, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String recipient; //odbiorca

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Bills> getBills() {
//
//        return bills;
//    }
//
//    public void setBills(List<Bills> bills) {
//        this.bills = bills;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
