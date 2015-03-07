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
package com.albertos.objects.enumerations;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public enum AccountType {
    MANAGER, CASHIER;

    public String toString() {
        switch (this) {
            case MANAGER:
                return "MANAGER";
            case CASHIER:
                return "CASHIER";
        }
        return "-Undefined-";
    }
}
