import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGraph {

    public static void main(String[] args) throws IOException {
        System.out.println("Выберите Город от какого до какого города хотите направиться\n " +
                "Kaluga" +" "+
                "Moscow" +" "+
                "Orel" +" "+
                "Tula" +" "+
                "Ryazan'" +" "+
                "Kursk" +" "+
                "Lipezk" +" "+
                "Tambov" +" "+
                "Voronezh" +" "+
                "Saratov");
//        System.out.println();
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String otkuda = reader.readLine();
        String kuda = reader.readLine();


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
        graph.searchWay(otkuda,kuda);

    }
}
