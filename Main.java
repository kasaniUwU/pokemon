import nodes.FreeforwardNet;
import nodes.activation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Main {
    public static boolean wait=false;
    public static Scanner IN=new Scanner(System.in);
    public static double x=21;
    public static double x2=30;
    public static JFrame main=new JFrame();
    public static JLabel out=new JLabel("waiting");
    public static Enemy squirtle=new Enemy("water",314,"007");
    public static Friendly bulbasaur=new Friendly("grass",314,"001");
    public static void main(String args[]){
        new Moves();
        thread2 e=new thread2();
        e.start();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (IsKeyPressed.class) {
                    if (ke.getID() == KeyEvent.KEY_PRESSED&&x==21&&!(bulbasaur.health<=0||squirtle.health<=0)) {
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            x = 0;
                            x2 = 0;
                        }else if(ke.getKeyCode() == KeyEvent.VK_1){
                            out.setText(bulbasaur.doMove(squirtle,bulbasaur.movesList.get(0)));
                            x=0;
                            x2=0;
                        }else if(ke.getKeyCode() == KeyEvent.VK_2){
                            out.setText(bulbasaur.doMove(squirtle,"heal"));
                            x=20;
                            x2=0;
                        }
                    }
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    double width = screenSize.getWidth()/100.0;
                    double height = screenSize.getHeight()/100.0;
                    out.setBounds((int) (width*15), (int) (height*55),300,300);
                    return false;
                }
            }
        });

        //Friendly e=new Friendly("grass",100,"e");
        main.setLayout(null);
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setUndecorated(true);
        bulbasaur.movesList.add("leaf_blade");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth()/100.0;
        double height = screenSize.getHeight()/100.0;
        JLabel l = new JLabel("press 1 to perform leaf blade and 2 to heal");
        main.add(bulbasaur);
        main.add(squirtle);
        main.add(l);
        main.add(out);
        main.add(new Background());
        //main.add(e);
        l.setFont(new Font("Serif", Font.PLAIN, 30));
        l.setBounds((int) (width*10), (int) (height*65),300,600);
        out.setFont(new Font("Serif", Font.PLAIN, 30));
        out.setBounds((int) (width*15), (int) (height*55),300,600);
        main.setVisible(true);

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!wait) {
                    squirtle.setBounds((int) (Math.sin(Main.x) * 20 * (1 - 0.05 * x)) + (int) (60 * width) - 50, (int) (30 * height) - 200, 400, 400);
                    bulbasaur.setBounds((int) (Math.sin(Main.x2) * 20 * (1 - 0.05 * x2)) + (int) (10 * width) - 50, (int) (69.5 * height) - 225, 400, 225);
                    if (x < 20) {
                        Main.x += 2;
                    }
                    if (x == 20) {
                        out.setText(squirtle.doMove(bulbasaur, "water_gun"));
                        x++;
                    }
                    if (x2 < 20 && x == 21) {
                        Main.x2 += 2;
                    }
                    if (bulbasaur.health <= 0) {
                        main.remove(bulbasaur);
                        out.setText("bulbasaur fainted!");
                    }
                    if (squirtle.health <= 0) {
                        main.remove(squirtle);
                        out.setText("squirtle fainted!");
                    }
                    main.repaint();
                }
            }
        }, 25, 25);
        /*
        activation func=(z)->{return (Math.pow(Math.E,z)-Math.pow(Math.E,-z))/Math.pow(Math.E,z)+Math.pow(Math.E,-z);};
        activation func2=(z)->{
        if(z>0){
            return 1.0;
        }else{
            return 0.0;
        }};
        FreeforwardNet ai1=new FreeforwardNet(2,1,func2);
        FreeforwardNet ai2=new FreeforwardNet(2,1,func2);
        double[][] a={
                {0,0},
                {0,1},
                {1,0},
                {1,1}
        };
        double[] c={0,1,1,1};
        for(int i=0; i<1000; i++){
            ai1.change(0.1);
            ai2.change(0.1);
            double dif1=0;
            double dif2=0;
            for(int t=0; t<a.length; t++){
                dif1+=Math.abs(ai1.passThrough(a[t])-c[t]);
                dif2+=Math.abs(ai2.passThrough(a[t])-c[t]);
                System.out.print(ai1.passThrough(a[t])+",");
            }
            System.out.println(dif1);
            if(dif1>dif2){
                ai2=ai1;
            }else{
                ai1=ai2;
            }
            if(dif1==0.0){
                for(int t=0; t<a.length; t++){
                    System.out.print(ai1.passThrough(a[t])+",");
                }
                System.out.println(i+"sucess");
                i=1000000;
                break;
            }
        }

         */
    }
}
