package com.example.BackFinal.model;

import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String brand;
    private String imageUrl;

    public Producto () {
    }

    public Producto(Integer id, String name, double price, String category, String description, String brand, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.imageUrl = imageUrl;
    }
    public Producto(String name, double price, String category, String description, String brand, String imageUrl) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", imagen='" + imageUrl + '\'' +
                '}';
    }
}
