package com.example.StockTrading3.model;

public class Stock {

    public static int lastAssigned = 0;
    private String name;
    private int price;
    private int quantity;
    private int id;


    public Stock(String n, int p, int q) {
        this.name = n;
        this.price = p;
        this.quantity = q;
        this.id = ++lastAssigned;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //subtracts from quantity if buying and adds if selling
    public void modifyStockQuantity(boolean isBuying, int quant){
        if(isBuying){
            this.quantity = this.quantity - quant;
        }
        else {
            this.quantity = this.quantity + quant;
        }

    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

