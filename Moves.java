import java.util.HashMap;
import java.util.Map;

/**
 * the class used for all moves. should only ever be created once and should never be referenced as an object
 */
public class Moves {
    public static Map<String,move> MoveList = new HashMap<>();
    public static Map<String,String[]> strongTo = new HashMap<>();
    public static Map<String,String[]> weakTo = new HashMap<>();

    /**
     * should be called when the program is first run to create the move list
     */
    public Moves(){
        MoveList.put("nuke",(a,b,c)->{a.health-=1000000; return "Its so effective, everyone is dead!";});
        MoveList.put("thunderbolt",(a,b,c)->{a.health-=1000000; return "Its so effective, everyone is dead!";});
        MoveList.put("leaf_blade",(a,b,c)->{a.health-= (int) (90+c*0.1*90+90*(Math.random()-0.5)*0.1); return "";});
        MoveList.put("water_gun",(a,b,c)->{a.health-= (int) (40+c*1*40+40*(Math.random()-0.5)*2); return "";});
        MoveList.put("heal",(a,b,c)->{b.health+= 50; return "healed";});
        strongTo.put("grass",new String[] {"water"});
        strongTo.put("water",new String[] {"fire"});
        strongTo.put("fire",new String[] {"electric","grass"});
        weakTo.put("fire",new String[] {"water"});
        weakTo.put("water",new String[] {"grass","electric"});
        weakTo.put("grass",new String[] {"fire","electric"});
    }
    public static String damage(Pokemon target, String _move,  Pokemon attacker){
        String type=attacker.type;
        String[] sTo=strongTo.get(target.type);
        String[] wTo=weakTo.get(target.type);
        for(String t:sTo){
            if(t.equals(type)){
                MoveList.get(_move).useMove(target,attacker,1);
                return "the attack was super effective";
            }
        }
        for(String t:wTo){
            if(t.equals(type)){
                MoveList.get(_move).useMove(target,attacker,-1);
                return "the attack wasn't very effective";
            }
        }
        return MoveList.get(_move).useMove(target,attacker,0);
    }

}
