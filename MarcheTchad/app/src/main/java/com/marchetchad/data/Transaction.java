package com.marchetchad.data;

public class Transaction {
    private String buyerName;
    private String description;
    private double amount;
    private String date;
    private boolean isCompleted;

    public Transaction(String buyerName, String description, double amount, String date) {
        this.buyerName = buyerName;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.isCompleted = true; // Par défaut pour la démo
    }

    public String getBuyerName() { return buyerName; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}