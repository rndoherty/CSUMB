/**
 * CST 338 - Fall 2015 Session A
 * Assignment 5, GUI Cards - High Card
 * Phase I
 * @author Robert Contreras
 * @author Ryan Doherty
 * @author Hyo Lee
 */

import javax.swing.*;
import java.awt.*;

public class Assignment5
{

 // static for the 57 icons and their corresponding labels
    // normally we would not have a separate label for each card, but
    // if we want to display all at once using labels, we need to.
    
    static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
    static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
       
    static void loadCardIcons()
    {
       // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
       // in a SHORT loop.  For each file name, read it in and use it to
       // instantiate each of the 57 Icons in the icon[] array.
        String[] cardSuites = new String[] {"C","D","H","S"};
        String[] cardValues = new String[] {"A","K","Q","J","X","T","9","8","7","6","5","4","3","2"};
        int x = 0;
        for (String s : cardSuites){
            for (String v : cardValues){
                icon[x]=new ImageIcon("images/" + v+s + ".gif");
                x++;
            }
        }
        icon[NUM_CARD_IMAGES-1]=new ImageIcon("images/BK.gif");
        
        
    }
    
    // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
    static String turnIntIntoCardValue(int k)
    {
       // an idea for a helper method (do it differently if you wish)
        return "";
    }
    
    // turns 0 - 3 into "C", "D", "H", "S"
    static String turnIntIntoCardSuit(int j)
    {
       // an idea for another helper method (do it differently if you wish)
        return "";
    }
    
    // a simple main to throw all the JLabels out there for the world to see
    public static void main(String[] args)
    {
       int k;
       
       // prepare the image icon array
       loadCardIcons();
       
       // establish main frame in which program will run
       JFrame frmMyWindow = new JFrame("Card Room");
       frmMyWindow.setSize(1150, 650);
       frmMyWindow.setLocationRelativeTo(null);
       frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // set up layout which will control placement of buttons, etc.
       FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
       frmMyWindow.setLayout(layout);
       
       // prepare the image label array
       JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
       for (k = 0; k < NUM_CARD_IMAGES; k++)
          labels[k] = new JLabel(icon[k]);
       
       // place your 3 controls into frame
       for (k = 0; k < NUM_CARD_IMAGES; k++)
          frmMyWindow.add(labels[k]);

       // show everything to the user
       frmMyWindow.setVisible(true);
    }

}
