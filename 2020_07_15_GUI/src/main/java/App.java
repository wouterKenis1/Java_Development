import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

   private JokeWindow jWindow;

   public static void main(String[] args) {
      // make dao for beers
      BeerDAO beerDao = new BeerDAO();
      // set the connection variables for the dao
      beerDao.setUrl(STATICS.URL);
      beerDao.setUser(STATICS.USER);
      beerDao.setPass(STATICS.PASS);

      // make a window
      Window frame = new Window();
      // set the sta
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

      jWindow = new JokeWindow(this);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(jWindow.JOKECOUNT < 5){
         jWindow = null;
         jWindow = new JokeWindow(this);
      }

   }
}
