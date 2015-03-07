
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
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Sure na sure?", JOptionPane.YES_NO_OPTION);
        
        if (confirm==JOptionPane.YES_OPTION) {
            System.out.println("You are sure");
        } else {
            System.out.println("You are not sure");
        }
    }
}
