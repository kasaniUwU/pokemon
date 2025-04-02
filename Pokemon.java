import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * the parent class for enemy Pokémon and friendly Pokémon.
 * used for making Pokémon but can't display them
 */
public class Pokemon extends JComponent {
    public final String type;
    public int health;
    public final int maxHealth;
    public BufferedImage image;
    public final String name;
    public String friendliness;
    private static final String[] types={"grass","fire","water","electric"};
    public Pokemon(String _Type,int _Health,String name,Boolean isEnemy,Boolean isFriendly) {
        this.name=name;
        if(isEnemy){
            friendliness="enemy";
            //super.setBounds((int) 0, (int) 0,100,100);
        }else if(isFriendly){
            friendliness="friendly";
        }else {
            friendliness="wild";
            //gives the Pokémon a default image
            try {
                image = ImageIO.read(new File("assets//images//" + name + ".png"));
            } catch (IOException e) {
                try {
                    image = ImageIO.read(new File("assets//images//error.png"));
                } catch (IOException e2) {
                    System.out.println("error texture not found");
                }
                System.out.println("warning: no image exists for " + name);
            }
        }
        //checks to make sure that the given type is a valid type
        for(int i=0; i< types.length; i++){
            if(types[i].equals(_Type)){
                break;
            }
            if(i+1==types.length){
                throw(new java.lang.Error(_Type+" is not a valid pokemon type"));
            }
        }
        health=_Health;
        maxHealth=_Health;
        type =_Type;

    }

    /**
     * @param target the target the move
     * @param _move what move the Pokémon is using
     * @return returns text about whether or not the move was effected. used for diolge
     */
    public String doMove(Pokemon target,String _move){
        return Moves.damage(target,_move,this);
    }
    public Dimension getPreferredSize(){
        return new Dimension(200,200);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
