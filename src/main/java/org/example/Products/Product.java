package org.example.Products;

public class Product {
    int id;
    String name;
    int cost;
    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    public String printInfo() {
        return "Product: ID: " + id + " Name: " + name + " Cost: " + cost + ".";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
