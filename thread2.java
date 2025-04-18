import java.awt.*;

public class thread2 extends Thread{
    public void run(){
        String pok=Main.IN.nextLine();
        Main.main.remove(Main.bulbasaur);
        Main.wait=true;
        String pokName=pok.substring(0,pok.indexOf(" "));
        pok=pok.substring(pok.indexOf(" ")+1);
        String pokType=pok.substring(0,pok.indexOf(" "));
        pok=pok.substring(pok.indexOf(" ")+1);
        int pokHealth= Integer.parseInt(pok.substring(0,pok.indexOf(" ")));
        pok=pok.substring(pok.indexOf(" ")+1);
        Main.bulbasaur=new Friendly(pokType,pokHealth,pokName);
        while(pok.contains(" ")){
                Main.bulbasaur.movesList.add(pok.substring(0, pok.indexOf(" ")));
                pok = pok.substring(pok.indexOf(" ") + 1);
        }
        Main.bulbasaur.movesList.add(pok);

        Main.main.add(Main.bulbasaur);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth()/100.0;
        double height = screenSize.getHeight()/100.0;
        Main.bulbasaur.setBounds((int) (Math.sin(Main.x2) * 20 * (1 - 0.05 * 30)) + (int) (10 * width) - 50, (int) (69.5 * height) - 225, 400, 225);
        //007 water 314 water_gun
        Main.main.revalidate();
        Main.wait=false;
    }
}
