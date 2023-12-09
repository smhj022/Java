package Graphs;

public class main {
    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A","B");
        myGraph.addEdge("A","C");
        myGraph.addEdge("A","D");
        myGraph.addEdge("C","D");
        myGraph.addEdge("D","B");

        myGraph.printGraph();

        myGraph.removeVertex("D");
        myGraph.printGraph();


    }
}
