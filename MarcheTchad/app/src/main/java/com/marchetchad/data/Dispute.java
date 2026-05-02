package com.marchetchad.data;

public class Dispute {
    private String id;
    private String title;
    private String description;
    private String status; // "En cours", "Résolu"
    private String amount;
    private String blockchainHash;

    public Dispute(String id, String title, String description, String amount, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.blockchainHash = "0x" + Integer.toHexString(hashCode()) + "..." + System.currentTimeMillis() % 10000;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getAmount() { return amount; }
    public String getBlockchainHash() { return blockchainHash; }
}