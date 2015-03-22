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
import com.albertos.controllers.PizzaJpaController;
import com.albertos.controllers.TransactionJpaController;
import com.albertos.displays.inventory.SalesTotalDisplay;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.persistence.EntityExistsException;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class PizzaStoreManager {

    private PizzaStoreManager() {        
    } // Instantiation defeated    
    
    private static PizzaStoreManager singleInstance = null;
    private static PizzaJpaController pjc = null;
    private Pizza pizzaDataForModification = null;
    private DateandSaleJpaController dsc = new DateandSaleJpaController(EMFactory.getEmf());
    private TransactionJpaController tjc = new TransactionJpaController(EMFactory.getEmf());
    private SalesTotalDisplay std = new SalesTotalDisplay();
    private final Preferences preferences = Preferences.userRoot();
    
    public void setOpen(boolean status) {
        preferences.putBoolean("isOpen", status);
    }
    
    public boolean isOpen() {
        return preferences.getBoolean("isOpen", true);
    }

    public static PizzaStoreManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new PizzaStoreManager();
        }
        return singleInstance;
    }

    public static PizzaJpaController getController() {
        if (pjc == null) {
            pjc = new PizzaJpaController(EMFactory.getEmf());
        }
        return pjc;
    }

    public void addPizza(String name,
            String description,
            double nineInchPizzaPrice,
            double elevenInchPizzaPrice) throws EntityExistsException {
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setDescription(description);
        pizza.setNineInchPizzaPrice(nineInchPizzaPrice);
        pizza.setElevenInchPizzaPrice(elevenInchPizzaPrice);

        if (getController().exists(name)) {
            throw new EntityExistsException("Menu with same pizza name already exists!");
        } else {
            getController().create(pizza);
        }
    }

    public Pizza getPizzaDataForModification() {
        return pizzaDataForModification;
    }

    public void setPizzaDataForModification(Pizza pizzaDataForModification) {
        this.pizzaDataForModification = pizzaDataForModification;
    }
    
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

        double total = displaySummary();
        
        DateandSale dateandSale = new DateandSale();
        dateandSale.setDateofSale(new Date());
        dateandSale.setDailySalesTotal(total);

        dsc.create(dateandSale);
    }

    public double displaySummary() {
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
        return total;
    }        

}
