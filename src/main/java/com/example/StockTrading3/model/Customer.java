package com.example.StockTrading3.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private static int lastAssignedC = 0;
    private String name;
    private int holdings;
    private int balance;
    private Map<Stock, Integer> list;
    private int id;



    //constructor
    public Customer (String n){
        name = n;
        holdings = 0;
        balance = 0;
        list = new HashMap<Stock, Integer>();
        id = ++lastAssignedC;

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


    public int getHoldings() {
        return holdings;
    }


    public int getBalance() {
        return balance;
    }


    public Map<Stock, Integer> getList() {
        return list;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setHoldings(int holdings) {
        this.holdings = holdings;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void setList(Map<Stock, Integer> list) {
        this.list = list;
    }


    public String generateStatement() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", holdings=" + holdings +
                ", balance=" + balance +
                ", list=" + list +
                '}';
    }

    public void buy(Stock st, int quant){
        int totalCost = quant * st.getPrice();
        if(totalCost > this.balance){
            System.out.println("You are buying stocks over your balance");
        }
        else {
            this.balance = this.balance - totalCost;
            this.holdings = this.holdings + totalCost;
            st.setQuantity(st.getQuantity() - quant);
            if(list.containsKey(st)){
                list.replace(st, quant);
            }
            else {
                list.put(st, quant);
            }
        }

    }

    public void addFunds(int bal){
        this.balance = this.balance + bal;
    }



    public void sell(Stock st, int quant){
        int totalCost = quant * st.getPrice();
        this.balance = this.balance + totalCost;
        this.holdings = this.holdings - totalCost;
        if (list.containsKey(st)){
            if(quant > list.get(st)){
                System.out.println("You are trying to sell " + quant + " stocks but only have " + list.get(st)+ ".");

            }
            else if (quant == list.get(st)){
                list.remove(st);
                st.setQuantity(st.getQuantity() + quant);
            }
            else {
                int currValue = list.get(st);
                list.replace(st, currValue - quant);
                st.setQuantity(st.getQuantity() + quant);
            }
        }
    }
}

