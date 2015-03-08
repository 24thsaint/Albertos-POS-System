/*
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 *  |      CENTRAL PHILIPPINE UNIVERSITY                   |
 *  |      Bachelor of Science in Software Engineering     |
 *  |      Jaro, Iloilo City, Philippines                  |
 *  |                                                      |
 *  |          This program is written by Rave, ©2015.     |
 *  |          You are free to use and distribute this.    |
 *  |          Reach me at: admin@blackout.biz.tm          |
 *  |                                                      |
 *  |               ~~~"CODE the FUTURE"~~~                |
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 */
package com.albertos.objects;

import com.albertos.controllers.DateandSaleJpaController;
import com.albertos.controllers.EMFactory;
import com.albertos.controllers.TransactionJpaController;
import com.albertos.displays.inventory.SalesTotalDisplay;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class SaleHandler {

    private DateandSaleJpaController dsc = new DateandSaleJpaController(EMFactory.getEmf());
    private TransactionJpaController tjc = new TransactionJpaController(EMFactory.getEmf());
    private SalesTotalDisplay std = new SalesTotalDisplay();

    public void sale(String cashier, double saleTotal, String details) {
        Transaction transaction = new Transaction();
        transaction.setEmployeeName(cashier);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionTotal(saleTotal);
        if (details.isEmpty()) {
            transaction.setDetails("None");
        } else {
            transaction.setDetails(details);
        }

        tjc.create(transaction);
    }

    public void closingTime() {
        List<Transaction> transactions = tjc.getAllTransactions(new Date());

        double total = 0;
        double transactionCount = 0;

        for (Transaction transaction : transactions) {
            total += transaction.getTransactionTotal();

            std.addEntry(transaction);
            transactionCount++;
        }

        DateandSale dateandSale = new DateandSale();
        dateandSale.setDateofSale(new Date());
        dateandSale.setDailySalesTotal(total);

        dsc.create(dateandSale);

        std.setSummaryDetails(String.valueOf(transactionCount), String.valueOf(total));

        std.setVisible(true);
    }

    public void displaySummary() {
        List<Transaction> transactions = tjc.getAllTransactions(new Date());

        double total = 0;
        double transactionCount = 0;

        for (Transaction transaction : transactions) {
            total += transaction.getTransactionTotal();

            std.addEntry(transaction);
            transactionCount++;
        }

        std.setSummaryDetails(String.valueOf(transactionCount), String.valueOf(total));

        std.setVisible(true);
    }
}
