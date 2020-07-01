package be.vdab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testWindow {
    static GraphicsConfiguration gc;
public static void main(String[] args)
{

    JFrame frame = new JFrame(gc);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Window_Title");
    frame.setSize(600,400);
    frame.setLocation(300,300);
    frame.setResizable(true);

    var button1 = new JButton("Button");
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            do_Something();
        }
    });
    button1.setSize(2000,500);
    frame.setBounds(50,50,200,50);
    frame.add(button1);

    //frame.pack();
    frame.setVisible(true);
}
public static void do_Something()
{
    System.out.println("did something, boss");
}
}
