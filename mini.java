import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
    int destinationId;
    int weight;

    public Edge(int destinationId, int weight) {
        this.destinationId = destinationId;
        this.weight = weight;
    }
}

class PqPair implements Comparable<PqPair> {
    int distance;
    int nodeId;

    public PqPair(int distance, int nodeId) {
        this.distance = distance;
        this.nodeId = nodeId;
    }

    @Override
    public int compareTo(PqPair other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Graph {
    private final List<List<Edge>> adjList;
    private final Map<String, Integer> locationToId;
    private final List<String> idToLocation;
    private int nextId;
    private boolean hasNegativeWeight = false;

    public Graph() {
        this.adjList = new ArrayList<>();
        this.locationToId = new HashMap<>();
        this.idToLocation = new ArrayList<>();
        this.nextId = 0;
    }

    private String normalize(String locationName) {
        return locationName.trim().toLowerCase();
    }

    private int getId(String locationName) {
        String key = normalize(locationName);
        if (!locationToId.containsKey(key)) {
            locationToId.put(key, nextId);
            idToLocation.add(locationName.trim());
            adjList.add(new ArrayList<>());
            nextId++;
        }
        return locationToId.get(key);
    }

    public void addRoute(String loc1, String loc2, int weight) {
        if (weight < 0) {
            hasNegativeWeight = true;
        }
        int id1 = getId(loc1);
        int id2 = getId(loc2);

        adjList.get(id1).add(new Edge(id2, weight));
        adjList.get(id2).add(new Edge(id1, weight));
    }

    public void printLocations() {
        System.out.println("Available locations:");
        for (String name : idToLocation) {
            System.out.println("- " + name);
        }
        System.out.println();
    }

    public void findShortestPath(String startLocation, String endLocation) {
        String startKey = normalize(startLocation);
        String endKey = normalize(endLocation);

        if (!locationToId.containsKey(startKey)) {
            System.out.println("Error: Start location '" + startLocation + "' not found.");
            return;
        }
        if (!locationToId.containsKey(endKey)) {
            System.out.println("Error: End location '" + endLocation + "' not found.");
            return;
        }

        if (hasNegativeWeight) {
            System.out.println("Warning: Graph contains negative edge weights. Dijkstra's algorithm may produce incorrect results.");
        }

        int startId = locationToId.get(startKey);
        int endId = locationToId.get(endKey);
        int numNodes = nextId;

        PriorityQueue<PqPair> pq = new PriorityQueue<>();

        int[] distances = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        int[] parent = new int[numNodes];
        for (int i = 0; i < numNodes; i++) parent[i] = -1;

        distances[startId] = 0;
        pq.add(new PqPair(0, startId));

        while (!pq.isEmpty()) {
            PqPair top = pq.poll();
            int u = top.nodeId;
            int d = top.distance;

            if (d > distances[u]) continue;
            if (u == endId) break;

            for (Edge edge : adjList.get(u)) {
                int v = edge.destinationId;
                int weight = edge.weight;

                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    parent[v] = u;
                    pq.add(new PqPair(distances[v], v));
                }
            }
        }

        System.out.println("\n--- Result ---");
        if (distances[endId] == Integer.MAX_VALUE) {
            System.out.println("No path found from '" + startLocation.trim() + "' to '" + endLocation.trim() + "'.");
            return;
        }

        System.out.println("Shortest distance: " + distances[endId] + " km");

        List<String> path = new ArrayList<>();
        int currentId = endId;
        if (startId == endId) {
            path.add(idToLocation.get(startId));
        } else {
            while (currentId != startId) {
                path.add(idToLocation.get(currentId));
                if (parent[currentId] == -1) {
                    System.out.println("Error: Path reconstruction failed.");
                    return;
                }
                currentId = parent[currentId];
            }
            path.add(idToLocation.get(startId));
        }

        Collections.reverse(path);
        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\n");
    }
}

public class mini {
    public static void main(String[] args) {
        Graph map = new Graph();

        map.addRoute("Anand", "Vallabh Vidyanagar", 4);
        map.addRoute("Anand", "Karamsad", 6);
        map.addRoute("Anand", "Nadiad", 19);
        map.addRoute("Anand", "Borsad", 18);
        map.addRoute("Vallabh Vidyanagar", "Karamsad", 3);
        map.addRoute("Vallabh Vidyanagar", "Vasna", 9);
        map.addRoute("Karamsad", "Borsad", 15);
        map.addRoute("Borsad", "Vasna", 12);
        map.addRoute("Borsad", "Tarapur", 30);
        map.addRoute("Nadiad", "Uttarsanda", 8);
        map.addRoute("Nadiad", "Ahmedabad", 55);
        map.addRoute("Uttarsanda", "Vasna", 18);

        System.out.println("================================");
        System.out.println("  Mini GPS Route Planner (Java)");
        System.out.println("================================");

        try (Scanner scanner = new Scanner(System.in)) {
            String choice;
            OUTER:
            while (true) {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. List All Locations");
                System.out.println("2. Find Shortest Path");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1-3): ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        String start, end;
                        System.out.print("\n  Enter Start Location: ");
                        start = scanner.nextLine();
                        System.out.print("  Enter End Location: ");
                        end = scanner.nextLine();
                        map.findShortestPath(start, end);
                    }
                    case "2" -> {
                        System.out.println();
                        map.printLocations();
                    }
                    case "3" -> {
                        System.out.println("\nExiting... Goodbye!");
                        System.out.println("================================");
                        break OUTER;
                    }
                    default ->
                        System.out.println("\nError: Invalid choice. Please enter 1, 2, or 3.");
                }
            }
        }
    }
}