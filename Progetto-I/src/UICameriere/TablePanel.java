/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UICameriere;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JPanel;
import restaurant.Restaurant;

/**
 *
 * @author Fabio
 */
public class TablePanel /*extends Observable*/{
    
    private ArrayList<JButton> tableButtons;
    private restaurant.Restaurant restaurant;
    private int selectedTable;
    private JPanel panel;
    
    public TablePanel(Restaurant restaurant) {
        this.restaurant = restaurant;
        tableButtons = new ArrayList<>();
        panel= new JPanel();
        initComponent();
    }
    
    private void initComponent(){
    
        for (int i = 0; i < restaurant.getTables().size(); i++) {

            JButton button = new JButton(String.valueOf(i + 1));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if(selectedTable != 0){
                        tableButtons.get(selectedTable - 1).setBackground(null);
                    }
                    
                    JButton button = (JButton)e.getSource();
                    selectedTable = Integer.parseInt(button.getText());
                    button.setBackground(Color.red);
                    
                    
                    System.err.println(restaurant.getOrderTable(selectedTable).toString());
                    System.err.println("-------> " + selectedTable);
                    
                }
            });

            tableButtons.add(button);
            panel.add(button);
        }
    }

    public int getSelectedTable() {
        return selectedTable;
    }  

    public JPanel getPanel() {
        return panel;
    }
}
