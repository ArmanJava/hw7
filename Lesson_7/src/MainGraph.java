public class MainGraph {

    public static void main(String[] args) {

        Graph graph = new Graph (10);
        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Ryazan'");
        graph.addVertex("Kaluga");
        graph.addVertex("Lipezk");
        graph.addVertex("Tambov");
        graph.addVertex("Orel");
        graph.addVertex("Saratov");
        graph.addVertex("Kursk");
        graph.addVertex("Voronezh");

        graph.addEdge("Moscow", "Tula");
        graph.addEdge("Moscow", "Ryazan'");
        graph.addEdge("Moscow", "Kaluga");
        graph.addEdge("Tula", "Lipezk");
        graph.addEdge("Lipezk", "Voronezh");
        graph.addEdge("Ryazan'", "Tambov");
        graph.addEdge("Tambov", "Saratov");
        graph.addEdge("Saratov", "Voronezh");
        graph.addEdge("Kaluga", "Orel");
        graph.addEdge("Orel", "Kursk");
        graph.addEdge("Kursk", "Voronezh");

        //graph.bfs("Moscow");
        graph.searchWay("Kaluga","Saratov");

    }
}
