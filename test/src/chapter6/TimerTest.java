package chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;



public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        //construct a timer that call the listener
        //once every second
        var timer = new Timer(1000,listener);
        timer.start();

        //keeping program running util the user select "OK"
        JOptionPane.showMessageDialog(null,"退出程序?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone,the time is"+ Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}