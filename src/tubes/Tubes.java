/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

import javax.swing.SwingUtilities;
import tubes.ui.MainPage;

/**
 *
 * @author Lenovo
 */
public class Tubes {

     public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
            }
        });
    }
    
}
