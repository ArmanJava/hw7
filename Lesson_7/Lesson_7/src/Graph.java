import java.util.*;

public class Graph {

    private List<Vertex> vertexes;
    private boolean[][] adjMatrix;
    private int[] path;

    private int size;
    private int last;

    public Graph(int maxSize) {

        vertexes = new ArrayList<>(maxSize);
        adjMatrix = new boolean[maxSize][maxSize];
        size = 0;
        last = 0;
        path = new int[maxSize];
    }

    public void addVertex(String label){
        Vertex vertex = new Vertex(label);
        vertexes.add(vertex);
        size++;
    }

    public boolean addEdge (String labelFrom, String labelTo){
        Vertex vertexFrom = findVertex(labelFrom);
        Vertex vertexTo = findVertex(labelTo);
        if(vertexFrom == null || vertexTo == null){
            return false;
        }
        addEdge(vertexFrom, vertexTo);
        return true;
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.println(vertexes.get(i));
        }
    }

    private void addEdge(Vertex vertexFrom, Vertex vertexTo) {
        int indexFrom = vertexes.indexOf(vertexFrom);
        int indexTo = vertexes.indexOf(vertexTo);
        adjMatrix[indexFrom][indexTo] = true;
        adjMatrix[indexTo][indexFrom] = true;
    }

    private Vertex findVertex(String label) {
        for (Vertex vertex : vertexes) {
            if (vertex.getLabel().equals(label)){
                return vertex;
            }
        }
        return null;
    }

/*    public void dfs (String label){
        Vertex vertex = findVertex(label);

        if (vertex == null){
            throw new IllegalArgumentException("Invalid label: " + label);
        }

        Stack<Vertex> stack = new Stack();

         visitVertex(vertex, stack);

        while (!stack.isEmpty()){
            vertex = getAdjVisitedVertex(stack.peek());
            if (vertex == null){
                stack.pop();
            } else {
                visitVertex(vertex, stack);
            }
        }

        clearVertexes();

    }*/

    public void bfs (String startLabel){
        Vertex vertex = findVertex(startLabel);
        if (vertex == null){
            throw new IllegalArgumentException("Invalid label: " + startLabel);
        }

        Queue<Vertex> queue = new ArrayDeque();

        visitVertex(vertex, queue);

        while (!queue.isEmpty()){
            vertex = getAdjVisitedVertex(queue.peek());
            if (vertex == null){
                queue.remove();
            } else {
                visitVertex(vertex, queue);
            }
        }
        clearVertexes();
    }

    public void searchWay(String startLabel, String finishLabel){
        Vertex vertex = findVertex(startLabel);

        if (vertex == null){
            throw new IllegalArgumentException("Invalid label: " + startLabel);
        }

        path[vertexes.indexOf(vertex)] = -1;

        Queue<Vertex> queue = new ArrayDeque();

        visitVertex(vertex, queue);

        while ( !queue.isEmpty() ){
            if (vertex != null && vertex.getLabel().equals(finishLabel)){
                break;
            }
            vertex = getAdjVisitedVertex(queue.peek());
            if (vertex == null){
                queue.remove();
            } else {
                visitVertex(vertex, queue);
            }
        }

        displayWay();

        clearVertexes();

    }

    private void displayWay() {
        int i = last;
        Stack<String> stack = new Stack();
        while(i != -1){
            stack.push(vertexes.get(i).getLabel());
            i = path[i];
        }
        System.out.println();
        System.out.println("Кратчайший маршрут из " + stack.peek() + " в " + vertexes.get(last).getLabel());

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + "-->");
        }
    }

    private void clearVertexes() {
        for (int i = 0; i < size; i++) {
            vertexes.get(i).setWasVisited(false);
        }
    }

/*    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        vertex.setWasVisited(true);
        System.out.println(vertex);
        stack.push(vertex);
    }*/

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        vertex.setWasVisited(true);
        System.out.println(vertex);
        queue.add(vertex);
    }


    private Vertex getAdjVisitedVertex(Vertex vertex){
        int startIndex = vertexes.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (adjMatrix[startIndex][i] && !vertexes.get(i).isWasVisited()){
                path[i] = startIndex;
                last = i;
                return vertexes.get(i);
            }
        }
        return null;
    }
}
