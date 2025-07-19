package claim.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class Claim {
    @CsvBindByName(column = "ID")
    private String id;
    @CsvBindByName(column = "Type")
    private ClaimType type;
    @CsvBindByName(column = "Amount")
    private double amount;
    @CsvBindByName(column = "Deadline")
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate deadline;
    @CsvBindByName(column = "Complexity")
    private ClaimComplexity complexity;

    public String getId() {
        return id;
    }

    public ClaimType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public ClaimComplexity getComplexity() {
        return complexity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(ClaimType type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setComplexity(ClaimComplexity complexity) {
        this.complexity = complexity;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f, %s, %s", id, type, amount, deadline, complexity);
    }
}
