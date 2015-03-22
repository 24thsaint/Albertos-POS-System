
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

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
/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class PizzaTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Preferences preferences = Preferences.userRoot();
        System.out.println(preferences.getBoolean("isOpen", true));

        while (true) {
            System.out.println("Press [1] to open, press [2] to close");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    preferences.remove("isOpen");
                    preferences.putBoolean("isOpen", true);
                    break;
                case 2:
                    preferences.remove("isOpen");
                    preferences.putBoolean("isOpen", false);
                    break;
                case 3:
                    preferences.remove("isOpen");
                default: //do nothing
            }

            System.out.println("Store is " + (preferences.getBoolean("isOpen", true) ? "OPEN" : "CLOSED"));
        }
    }
}
