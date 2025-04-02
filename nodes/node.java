package nodes;

public class node {
    private double w[];
    private double b;
    public node(int numInputs){
        w=new double[numInputs];
    }
    public node(int numInputs,double startingVal){
        w=new double[numInputs];
        for(int i=0; i<w.length; i++){
            w[i]=startingVal;
        }
        b=startingVal;
    }
    public void change(double amount){
        for(int i=0; i<w.length; i++){
            w[i]+=(Math.random()-0.5)*amount;
        }
        b+=(Math.random()-0.5)*amount;
    }
    public double passThrough(activation func,double[] a){
        double A=0;
        for(int i=0; i<a.length; i++){
            A+= a[i]*w[i];
        }
        A=func.activate(A+b);
        return A;
    }
}
