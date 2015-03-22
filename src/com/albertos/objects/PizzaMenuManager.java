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

import com.albertos.controllers.EMFactory;
import com.albertos.controllers.PizzaJpaController;
import javax.persistence.EntityExistsException;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class PizzaMenuManager {

    private PizzaMenuManager() {
    } // Instantiation defeated

    private static PizzaMenuManager singleInstance = null;
    private static PizzaJpaController pjc = null;
    private Pizza pizzaDataForModification = null;

    public static PizzaMenuManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new PizzaMenuManager();
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

}
