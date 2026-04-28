package tech.getarrays.employeemanager.model;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee addedBy;

    public Item() {}

    public Item(String name, Employee addedBy) {
        this.name = name;
        this.addedBy = addedBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Employee getAddedBy() { return addedBy; }
    public void setAddedBy(Employee addedBy) { this.addedBy = addedBy; }
}

