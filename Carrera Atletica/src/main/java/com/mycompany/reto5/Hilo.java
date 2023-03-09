
package com.mycompany.reto5;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class Hilo extends Thread {

    private Runner corredor;
    private final JTextArea textArea;
    private AthleticRaceInterface athletic;
    
    public Hilo(Runner corredor, JTextArea textArea, AthleticRaceInterface athletic) {
        this.corredor = corredor;
        this.textArea = textArea;
        this.athletic = athletic;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.corredor.getSpeed() * 1000);
            String txt = this.textArea.getText();
            txt += this.athletic.contador + ".-" + corredor.getName() + " - " + "Tiempo: "+ corredor.getSpeed() + " Segundos \n "; 
            this.athletic.contador++;
            this.textArea.setText(txt);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
