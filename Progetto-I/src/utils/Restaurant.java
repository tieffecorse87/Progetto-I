package utils;


import java.io.IOException;
import java.util.ArrayList;
import menu.Menu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author federicovitro
 */
public class Restaurant {
    
    private String name;
    private Room room;
    private Menu menu;
    
    public Restaurant(String name, int numberOfTables, String pathFile) throws IOException{
        this.name = name;
        initRoom(numberOfTables);
        initMenu(pathFile);
        initGUI();
    }
    
    private void initMenu(String pathFile) throws IOException{
        menu = new Menu(pathFile);
        
    }
    
    private void initRoom(int numberOfTables){
        room = new Room(numberOfTables);
        
    }
        
    public void addOrder(Order order){
        
        //TODO da sistemare quando sarà implementato menuElement
    }
    
    public void setReserved(int tableId){
    
        room.setReservedTable(tableId);
    }
    
    /**
     * Restituisce i tavoli della sala
     * @author fabiotagliani
     */
    public ArrayList<Table> getTables(){
    
        return room.getTables();
      
    }
        
    /**
    * Restituisce i tavoli non prenotati
    * @author fabiotagliani
    */
    public ArrayList<Table> getFreeTable(){
    
        return room.getFreeTable();
        
    }
    
    
    private void initGUI(){
        //TODO da fare quando penseremo all'interfaccia grafica.
    }
    
}
