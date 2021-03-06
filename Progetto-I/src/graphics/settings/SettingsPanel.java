package graphics.settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import utils.AppConfig;
import graphics.commons.MyFileChooser;

/**
 * pannello di grafica
 * @author Luca
 */
public class SettingsPanel extends JPanel{
    
    JComboBox tableBox, delayBox;
    JLabel tableNumber,menuPath,restaurantName,snapshotDelay,dialog;
    JPanel formatPane = new JPanel();
    JTextField field = new JTextField();
    JTextField file = new JTextField();
    final MyFileChooser fcs = new MyFileChooser();
    JButton browse,apply;
    AppConfig config;
    
    public SettingsPanel(AppConfig conf){
        this.config=conf;
        initGraphics();
        attachListeners();
        this.setLayout(new GridLayout(5,2,5,15));    //righe, colonne,hgap,vgap
        this.add(tableNumber);
        this.add(tableBox);
        this.add(restaurantName);
        this.add(field);
        this.add(menuPath);
        this.add(formatPane);
        this.add(snapshotDelay);
        this.add(delayBox);
        this.add(apply);
    }
    
    private void initGraphics(){
        file.setPreferredSize(new Dimension(250, 50));
        file.setText(config.getMenuPath());
        file.setEditable(false);
        field.setText(config.getRestaurantName());
        
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] delay = { 3, 5, 7, 10, 13, 15 };
        formatPane.setLayout(new FlowLayout());
        tableBox = new JComboBox(numbers);
        delayBox = new JComboBox(delay);
        delayBox.setSelectedIndex(2);
        browse = new JButton("Scegli...");
        apply = new JButton("Applica");
        tableNumber = new JLabel("Numero dei tavoli all'avvio: ");
        snapshotDelay = new JLabel("Delay snapshot (in secondi): ");
        menuPath = new JLabel("Percorso file menu: ");
        restaurantName = new JLabel("Nome del ristorante: ");
        dialog = new JLabel("Le modifiche saranno applicate dal prossimo avvio dell' applicazione!");
        dialog.setForeground(Color.red);
        dialog.setFont(new Font("Arial", Font.ITALIC,12));
        
        formatPane.add(file);
        formatPane.add(browse);
    }
    
    private void attachListeners() {
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fcs.show();
                               
                if (fcs.getSelected() == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fcs.getSelectedFile();
                    file.setText(selectedFile.getAbsolutePath());
                    file.repaint();
                }
            }
        });
        
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                config.setRestaurantName(field.getText());
                config.setSnapshotSeconds((int) delayBox.getSelectedItem()*1000);
                if(!file.getText().isEmpty()){
                    config.setMenuPath(file.getText());
                }
                config.setTableNumber((int) tableBox.getSelectedItem());
                config.commitChanges();
            }
        });
    }
        
}
