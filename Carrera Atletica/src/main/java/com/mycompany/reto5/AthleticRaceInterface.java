
package com.mycompany.reto5;


import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AthleticRaceInterface extends JFrame implements ActionListener {
    JLabel etiregistrarcorredor,eticorredoresregistrados,etiresultados;
    JTextField txtregistrarcorredor,txtcorredoresregistrados,txtresultados;
    JButton registrar,iniciar,reiniciar,terminar;
    JTextArea areacorredoresregistrados,arearesultados;
    JPanel panel;
    Runner[] corredores;
    public int contador = 1;
      
    public AthleticRaceInterface() {
        
        
        corredores = new Runner[6]; 
        
        etiregistrarcorredor = new JLabel("Registar Corredor");
        etiregistrarcorredor.setBounds(10, 15, 130, 20);
        eticorredoresregistrados = new JLabel("Corredores Registrados");
        eticorredoresregistrados.setBounds(10, 80, 160, 20);
        etiresultados = new JLabel("Resultados");
        etiresultados.setBounds(10, 250, 80, 20);
        
        txtregistrarcorredor = new JTextField();
        txtregistrarcorredor.setBounds(10, 40, 300, 30);
        txtcorredoresregistrados = new JTextField();
        txtcorredoresregistrados.setBounds(100, 70, 80, 20);
        txtresultados = new JTextField();
        txtresultados.setBounds(100, 80, 80, 20);
        
        registrar = new JButton("Registar");
        registrar.setBounds(360, 40, 100, 30);
        registrar.addActionListener(this);
        iniciar = new JButton("Iniciar");
        iniciar.setBounds(360, 300, 100, 30);
        iniciar.addActionListener(this);
        reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(360, 350, 100, 30);
        reiniciar.addActionListener(this);
        terminar = new JButton("Terminar");
        terminar.setBounds(360, 400, 100, 30);
        terminar.addActionListener(this);
        
        areacorredoresregistrados = new JTextArea();
        areacorredoresregistrados.setBounds(10, 110, 330, 130);
        arearesultados = new JTextArea();
        arearesultados.setBounds(10, 290, 330, 140);
       
        panel = new JPanel();
        panel.setLayout(null);
        
        panel.add(etiregistrarcorredor);
        panel.add(eticorredoresregistrados);
        panel.add(etiresultados);
        panel.add(txtregistrarcorredor);
        panel.add(registrar);
        panel.add(iniciar);
        panel.add(reiniciar);
        panel.add(terminar);
        panel.add(areacorredoresregistrados);
        panel.add(arearesultados);
        
        add(panel);
        setBounds(400, 170, 500, 500);
        setTitle("Carrera Athletica");
        setVisible(true); 
    }

    public static void main(String[] args) {
        
        AthleticRaceInterface p= new AthleticRaceInterface();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == registrar){
        Capturar();
        }
        if(e.getSource() == iniciar){
         iniciar();
        }
        if(e.getSource() == reiniciar){
        reiniciar();
        }
        if(e.getSource() == terminar){
        terminar();
        }
        
    }
    
    void Capturar() { 
        
        areacorredoresregistrados.setText(" ");
        if (txtregistrarcorredor.getText().isEmpty()) return;
        for (int i = 0; i < corredores.length; i++) {
            if(corredores[i] == null){
                Runner corredor = new Runner();
                corredor.setName(txtregistrarcorredor.getText());
                corredores[i] = corredor;
                break;           
            }  
            }
            String corredorestxt = "";
            
            for (int j = 0; j < corredores.length; j++) {
                if(corredores[j] != null){
                    corredorestxt += (j + 1) + ".-" + corredores[j].getName() + "\n";               
                }
                areacorredoresregistrados.setText(corredorestxt);
        } 
            txtregistrarcorredor.setText("");
    }
    
    public void iniciar(){
        for (int i = 0; i < corredores.length; i++) {
            Hilo hilo = new Hilo(corredores[i], arearesultados, this);
            hilo.start();
        }
        
    }
    public void reiniciar(){
        areacorredoresregistrados.setText("");
        arearesultados.setText("");
        corredores = new Runner[5];    
    }    
    public void terminar(){
        System.exit(0);  
    }
}
