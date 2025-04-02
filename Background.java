import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Background extends JComponent {
    List<Pokemon> onScreenPokemon=new ArrayList<>();
    BufferedImage backgroundImage;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    public Background() {
        try {
            backgroundImage = ImageIO.read(new File("assets//images//background.jpg"));
        } catch (IOException e) {
            throw (new java.lang.Error("couldn't find background image at \"assets//images//background.jpg\""));
        }
        super.setBounds(0,0, (int) width, (int) height);
    }
    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage, 0, 0, (int) width, (int) height, null);
        g.setColor(Color.RED);
        double w=255*(1-((double) Main.squirtle.health /(double)Main.squirtle.maxHealth));
        if(w>255){w=255;}
        g.fillRect((int) (width*0.218+255-w), (int) (height*0.2111),(int)w,11);
        double w2=255*(1-((double) Main.bulbasaur.health /(double)Main.bulbasaur.maxHealth));
        if(w2>255){w2=255;}
        g.fillRect((int) (width*0.727+255-w2), (int) (height*0.565),(int)w2,11);
    }
}
