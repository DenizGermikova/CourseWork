package ua.opnu.labwork4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    private Double price;

    private Integer stock;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    private List<ua.opnu.labwork4.model.Category> categories = new ArrayList<>();

    @ManyToOne
    @JsonIgnoreProperties("products")
    private ua.opnu.labwork4.model.Brand brand;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public List<ua.opnu.labwork4.model.Category> getCategories() {
        return categories;
    }

    public ua.opnu.labwork4.model.Brand getBrand() {
        return brand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCategories(List<ua.opnu.labwork4.model.Category> categories) {
        this.categories = categories;
    }

    public void setBrand(ua.opnu.labwork4.model.Brand brand) {
        this.brand = brand;
    }
}