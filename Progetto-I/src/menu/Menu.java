package menu;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author federicovitro
 */
public class Menu {
    
    private ArrayList<MenuElement> menu;
    
    public Menu(String pathMenu) throws IOException{
        loadMenu(pathMenu);
    }
    
    /**
     * @autor JS
     * @param pathFile
     * @throws IOException
     * 
     */    
    private void loadMenu (String pathFile) throws IOException{
        menu = LoadFileText.menuFromDatabase(pathFile);
    }

    /**
     * @return menu
     * @author FabioTagliani
     */
    public ArrayList<MenuElement> getMenu() {
        return menu;
    }
        
    @Override
    public String toString(){
        String ret="";
        for (int i=0; i<menu.size(); i++){
            ret+=menu.get(i).toString()+"\n";
        }
        return ret;
    }
    
    /**
     * Ritorna tutti gli elementi di menu che abbiano lo stesso nome passato al metodo
     * In sostanza è un cerca.
     * @author Luca
     * @param elementName   il nome degli elementi da ottenere
     * @return  ArrayList degli elementi con stesso nome
     */
    public ArrayList<MenuElement> getElementByName(String elementName){
        elementName=elementName.toLowerCase();
        ArrayList<MenuElement> out = new ArrayList<>();
        
        for(int i=0;i<menu.size();i++){
            String temp = menu.get(i).getNameElement();
            if(elementName.contains(temp.toLowerCase())){
                out.add(menu.get(i));
            }
        }
        
        return out;
    }
    
    /**
     * Ritorna tutti gli elementi di menu che abbiano lo stesso tipo
     * In sostanza è un cerca.
     * @author Luca
     * @param type  il tipo degli elementi da ottenere
     * @return  ArrayList di elementi con lo stesso prezzo
     */
    public ArrayList<MenuElement> getElementByType(String type){
        type=type.toLowerCase();
        ArrayList<MenuElement> out = new ArrayList<>();
        
        for(int i=0;i<menu.size();i++){
            String temp = menu.get(i).getTypeElement();
            if(type.equals(temp.toLowerCase())){
                out.add(menu.get(i));
            }
        }
        
        return out;
    }
    
    /**
     * Ritorna tutti gli elementi di menu che abbiano lo stesso prezzo
     * In sostanza è un cerca.
     * @author Luca
     * @param cash  il prezzo dell' elemento che si vuole ottenere
     * @return  ArrayList degli elementi con relativo prezzo
     */
    public ArrayList<MenuElement> getElementByPrice(double cash){
        ArrayList<MenuElement> out = new ArrayList<>();
        for(int i=0;i<menu.size();i++){
            double temp = menu.get(i).getPrizeElement();
            if(cash == temp){
                out.add(menu.get(i));
            }
        }
        
        return out;
    }
}
