/**
 *@author Noah Tyler
 * CSC 406.02 - Assignment 4
 */

public class UWEdge{
    
    private final int node1, node2;
    
    public UWEdge(int node1 , int node2){
        this.node1 = node1;
        this.node2 = node2;
    }
    
    public int getStartNode(){
        return node1;
    }
    
    public int getEndNode(){
        return node2;
    }
    
    @Override
    public String toString(){
        return node1+" ---> "+node2+"";
    }

    @Override
    public boolean equals(Object obj) { 
        final UWEdge e = (UWEdge) obj;
        return e.getStartNode() == this.node1 && e.getEndNode() == this.node2;
    }
}