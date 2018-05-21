import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Noah Tyler
 */
public class TopoSort {
    
       private int[] inDegreeArray;
       private int numOfNodes;
       private LinkedList<UWEdge> adjListArray[];
       private PrintWriter writer = new PrintWriter("topoOutput.txt");
    
       public static void main(String[] args) throws FileNotFoundException{
	        if(args.length != 1 || !new File(args[0]).exists()){
	            System.out.println("Error: Invalid Filename!");
	            System.exit(0);
	        }
	        
	        new TopoSort(new File(args[0]));
       }
       
       private TopoSort(File dataFile) throws FileNotFoundException{
            write(sort(dataFile));
       }
       
       private void createDiGraph(File dataFile) throws FileNotFoundException{
            Scanner sc = new Scanner(dataFile);
            while(sc.findInLine("c ") != null)
                sc.nextLine();
            numOfNodes = sc.nextInt();
            adjListArray = new LinkedList[numOfNodes+1];
            inDegreeArray = new int[numOfNodes+1];
            for(int i = 1; i < numOfNodes+1; i++)
                adjListArray[i] = new LinkedList<>();
            while(sc.hasNext()){
                UWEdge e = new UWEdge(sc.nextInt(),sc.nextInt());
                if(!adjListArray[e.getStartNode()].contains(e)){
                    adjListArray[e.getStartNode()].add(e);
                    inDegreeArray[e.getEndNode()]++;
                }
            }
       }            
       
       private String sort(File dataFile) throws FileNotFoundException{
           createDiGraph(dataFile);
           LinkedList<Integer> stack = new LinkedList<>();
           String output = "";
           for(int i = 1; i < numOfNodes+1; i++)
                if(inDegreeArray[i] == 0)
                   stack.push(i);
            int i = 1;
            while(!stack.isEmpty()){
                int u = stack.pop();
                output += u+" ";
                i++;
                for(UWEdge e : adjListArray[u]){
                    inDegreeArray[e.getEndNode()]--;
                    if(inDegreeArray[e.getEndNode()] == 0)
                        stack.push(e.getEndNode());
                }
            }
            if(i > numOfNodes)
                return output;
            else
                return "Input Graph Is Cyclic!";
       }
       
	    private void write(String s){
	        writer.println(s);
	        writer.flush();
	    }
}