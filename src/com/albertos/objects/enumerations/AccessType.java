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
public enum AccessType {

    LOGIN, LOGOUT;

    public String toString() {
        switch (this) {
            case LOGIN:
                return "LOGIN";
            case LOGOUT:
                return "LOGOUT";
        }
        return "-Undefined-";
    }
}
