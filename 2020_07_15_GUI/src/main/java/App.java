import javax.swing.*;
import java.awt.*;

public class App  {

   public static void main(String[] args) {
      Window frame = new Window();
      BeerDAO beerDao = new BeerDAO();

      beerDao.setUrl(STATICS.URL);
      beerDao.setUser(STATICS.USER);
      beerDao.setPass(STATICS.PASS);

      frame.setSize(1024,768);
      frame.createGUI();
      frame.setTitle("First test of GUI - Title");



      int count = 0;
      for(int i = 0; i < 20; i++){
         Beer biertje = beerDao.getBeerById(i);
         if(biertje != null){
            JLabel newLabel = new JLabel(biertje.name);
            frame.m_Labels.add(newLabel);
            frame.add(newLabel);
            count++;
         }
      }

      JButton button = new JButton("text");

      frame.add(button);
      frame.setVisible(true);
   }
}
