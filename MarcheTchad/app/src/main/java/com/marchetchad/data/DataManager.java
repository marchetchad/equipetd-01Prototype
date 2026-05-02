package com.marchetchad.data;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private List<Transaction> transactions;
    private List<Dispute> disputes;
    private int score;
    private double totalSalesToday;

    private DataManager() {
        transactions = new ArrayList<>();
        disputes = new ArrayList<>();
        score = 0;
        totalSalesToday = 0;
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        totalSalesToday += transaction.getAmount();
        // Le score augmente de 50 points par transaction pour la démo
        score = Math.min(1000, score + 50);
    }

    public void addDispute(Dispute dispute) {
        disputes.add(dispute);
        // Un litige fait baisser le score de 100 points
        score = Math.max(0, score - 100);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Dispute> getDisputes() {
        return disputes;
    }

    public int getScore() {
        return score;
    }

    public double getTotalSalesToday() {
        return totalSalesToday;
    }
}