package ma.cu.lalewicz.WebBills.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Category category;


    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;   //nr faktury i lub tytuł zapłaty

    @Column(name = "amount")
    private double amount;          //kwota

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;       // data wystawienia

    @Column(name = "due_date")
    private LocalDate dueDate;           // termin płatności

    @Column(name = "DATE_OF_PAYMENT")
    private LocalDate dateOfPayment;     // data zaplaty z afakture

    @Column(name = "WAS_PAID")
    private boolean wasPaid;        //czy został opłacony domyślnnie false


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }



    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean isWasPaid() {
        return wasPaid;
    }

    public void setWasPaid(boolean wasPaid) {
        this.wasPaid = wasPaid;
    }

}
