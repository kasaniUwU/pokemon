import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * the class used for all enemy Pokémon
 */
public class Enemy extends Pokemon {
    public Enemy(String _Type,int _Health,String name) {
        super(_Type, _Health, name, false, true);
        try {
            super.image = ImageIO.read(new File("assets//images//" + name + ".png"));
        } catch (IOException e) {
            try {
                super.image = ImageIO.read(new File("assets//images//error.png"));
            } catch (IOException e2) {
                System.out.println("error texture not found");
            }
            System.out.println("warning: no image exists for " + name);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth()/100.0;
        double height = screenSize.getHeight()/100.0;
        super.setBounds((int) (60*width)-50, (int) (30*height)-200, 400, 400);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(super.image, 0, 0,400, 400, null);
    }
}
