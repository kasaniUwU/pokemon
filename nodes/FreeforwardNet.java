package nodes;

import java.util.ArrayList;
import java.util.List;

public class FreeforwardNet{
    public List<List<node>> network =new ArrayList<>();
    activation func;
    public FreeforwardNet(int numInputs,int numLayers,activation func){
        this.func=func;
        for(int i=0; i<numLayers; i++){
            List<node> Layer=new ArrayList<>();
            for(int t=i; t<numLayers; t++){
                Layer.add(new node(numInputs));
            }
            network.add(Layer);
        }
    }
    public void change(double amount){
        for (List<node> nodes : network) {
            for (nodes.node node : nodes) {
                node.change(amount);
            }
        }
    }
    public double passThrough(double[] a){
        double[] aLast=a;
        for(int i=0; i<network.size(); i++){
            List<node> layer=network.get(i);
            double[] aNext=new double[network.get(i).size()];
            for(int t=0; t<layer.size(); t++){
                aNext[t]=layer.get(t).passThrough(func,aLast);
            }
            aLast=aNext;
        }
        return aLast[0];
    }
}
