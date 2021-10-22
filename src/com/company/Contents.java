package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Contents extends JPanel implements ActionListener {

    static int a = 50, b = 50, v = 375, w = 225, x = 350, y = 200 ;
    static boolean isTrue = false;

    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();

    }

    static KeyListener listener = new KeyListener() {
        public void keyPressed(KeyEvent event) {
            if(event.getKeyChar()== 'w'){
                event.consume();
            }
            if(event.getKeyChar()== 's'){
                a++;
                b+=2;
                event.consume();
            }
            if(event.getKeyChar()== 'a'){
                a--;
                b-=2;
                event.consume();
            }
            if(event.getKeyChar()== 'z'){
//                if((v - x) < a)
                vV = -1;
            }
            if(event.getKeyChar()== 'x'){
                    vV = 1;
            }
            if(event.getKeyChar()== 'd'){
                wV = -1;
            }
            if(event.getKeyChar()== 'c'){
                wV = 1;
            }
        }

        public void keyReleased(KeyEvent event) {
            if(event.getKeyChar()==KeyEvent.VK_M){
                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_N){

                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_H){
                event.consume();
            }
            if(event.getKeyChar()== 'z'){
                vV = 0;
            }
            if(event.getKeyChar()== 'x'){
                vV = 0;
            }
            if(event.getKeyChar()== 'd'){
                wV = 0;
            }
            if(event.getKeyChar()== 'c'){
                wV = 0;
            }
        }

        public void keyTyped(KeyEvent event) {
        }

    };

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.drawLine(x, y, v, w);
        g2d.drawLine(x, y + a, v, w + a);
        g2d.drawLine(x + a, y, v + a, w);
        g2d.drawLine(x + a, y + a, v + a, w + a);
        g2d.drawRect(x, y, a, a);
        g2d.drawRect(v, w, a, a);


        g2d.drawString("test: " + isTrue, 10, 10);


    }

    public static int vV = 0;
    public static int wV = 0;
    public static int xV = 0;
    public static int yV = 0;

    public void move(){
        v = v + vV;
        w = w + wV;
        x = x + xV;
        y = y + yV;
    }

    public void actionPerformed(ActionEvent e) {
        move();

        if((v - x) >= a/2){
            v = (x + a/2);
        }

        if((x - v) >= a/2){
            v = (x - a/2);
            isTrue = true;
        }

        if((w - y) >= a/2)
            w = (y + a/2);

        if((y - w) >= a/2)
            w = (y - a/2);


            repaint();
    }
}