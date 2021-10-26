package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Contents extends JPanel implements ActionListener {

    static int a = 50, b = 50, c = 400, d = 400, v = 375, w = 225, x = 350, y = 200 ;
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
            if(event.getKeyChar()== 'v'){
                xV = -1;
            }
            if(event.getKeyChar()== 'b'){
                xV = 1;
            }
            if(event.getKeyChar()== 'h'){
                yV = -1;
            }
            if(event.getKeyChar()== 'n'){
                yV = 1;
            }
            if(event.getKeyChar()== 'j'){
                cV = -1;
            }
            if(event.getKeyChar()== 'l'){
                cV = 1;
            }
            if(event.getKeyChar()== 'i'){
                dV = -1;
            }
            if(event.getKeyChar()== 'k'){
                dV = 1;
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
            if(event.getKeyChar()== 'v'){
//                xV = -1;
                xV = 0;
            }
            if(event.getKeyChar()== 'b'){
//                xV = 1;
                xV = 0;
            }
            if(event.getKeyChar()== 'h'){
//                yV = -1;
                yV = 0;
            }
            if(event.getKeyChar()== 'n'){
//                yV = 1;
                yV = 0;

            }
            if(event.getKeyChar()== 'j'){
                cV = 0;
            }
            if(event.getKeyChar()== 'l'){
                cV = 0;
            }
            if(event.getKeyChar()== 'i'){
                dV = 0;
            }
            if(event.getKeyChar()== 'k'){
                dV = 0;
            }
        }

        public void keyTyped(KeyEvent event) {
        }

    };

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.drawString("CONTROLS:", 775, 15);
        g2d.drawString("A: Decrease Size", 775, 30);
        g2d.drawString("S: Increase Size", 775, 45);
        g2d.drawString("Z: Move Left", 775, 60);
        g2d.drawString("X: Move Right", 775, 75);
        g2d.drawString("D: Move Up", 775, 90);
        g2d.drawString("C: Move Down", 775, 105);
        g2d.drawString("V: Move/Drag Left", 775, 120);
        g2d.drawString("B: Move/Drag Right", 775, 135);
        g2d.drawString("H: Move/Drag Up", 775, 150);
        g2d.drawString("N: Move/Drag Down", 775, 165);


        for(int i = 0; i < 5; i++) {
            g2d.drawLine(x + (a * i) , y, v+ (a * i), w);
            g2d.drawLine(x + (a * i), y + a, v+ (a * i), w + a);
            g2d.drawLine(x + a + (a * i), y, v + a+ (a * i), w);
            g2d.drawLine(x + a + (a * i), y + a, v + a+ (a * i), w + a);
            g2d.drawRect(x + (a * i), y, a, a);
            g2d.drawRect(v + (a * i), w, a, a);
        }

//        g2d.drawOval(c,d,15,15);


        g2d.drawString("test: " + isTrue, 10, 10);


    }

    public static int cV = 0;
    public static int dV = 0;
    public static int vV = 0;
    public static int wV = 0;
    public static int xV = 0;
    public static int yV = 0;

    public void move(){
        c = c + cV;
        d = d + dV;
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
        } else {
            isTrue = false;
        }

        if((w - y) >= a/2)
            w = (y + a/2);

        if((y - w) >= a/2)
            w = (y - a/2);


        if(c >= x - 15 && c <= x + a && d <= y + a && d >= y)
            c = x -15;

            repaint();
    }
}