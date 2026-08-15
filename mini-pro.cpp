#include <iostream>
#include <vector>
#include <string>
#include <map>          // To map location names (string) to IDs (int)
#include <queue>        // For the priority queue
#include <limits>     // To get 'infinity' (INT_MAX)
#include <algorithm>  // For std::reverse

// Define 'infinity' for our distance calculations
#define INF std::numeric_limits<int>::max()

// --- Data Structures ---

// A pair to represent (destination_node_id, weight)
using Edge = std::pair<int, int>;

// A pair to represent (current_distance, node_id)
// We use this in the priority queue
using PqPair = std::pair<int, int>;

/**
 * @class Graph
 * @brief Represents a network of locations and routes for pathfinding.
 *
 * This class encapsulates all the logic for a map, including:
 * - Mapping location names (e.g., "Anand") to integer IDs.
 * - Storing the graph using an adjacency list.
 * - Implementing Dijkstra's algorithm to find the shortest path.
 */
class Graph {
private:
    // Adjacency list:
    // Index 'i' of this vector holds a list of all edges (neighbors)
    // for the node with ID 'i'.
    // Each 'Edge' pair is (neighbor_id, weight)
    std::vector<std::vector<Edge>> adjList;

    // --- Mappers ---
    // These two maps allow us to use user-friendly strings in the
    // interface but fast integer IDs in the algorithm.
    
    // Maps a location name (e.g., "Anand") to a unique integer ID (e.g., 0)
    std::map<std::string, int> locationToId;

    // Maps a unique integer ID (e.g., 0) back to its name (e.g., "Anand")
    std::vector<std::string> idToLocation;

    // Counter to assign new unique IDs
    int nextId = 0;

    /**
     * @brief Gets the integer ID for a location, creating it if it doesn't exist.
     * @param locationName The name of the location (e.g., "Anand").
     * @return The unique integer ID for that location.
     */
    int getId(const std::string& locationName) {
        // Check if the location already has an ID
        if (locationToId.find(locationName) == locationToId.end()) {
            // If not, create a new ID
            locationToId[locationName] = nextId;
            idToLocation.push_back(locationName);
            
            // Resize the adjacency list to accommodate the new node
            adjList.resize(nextId + 1);
            
            nextId++;
        }
        return locationToId[locationName];
    }

public:
    /**
     * @brief Adds a two-way (undirected) edge between two locations.
     * @param loc1 The name of the first location.
     * @param loc2 The name of the second location.
     * @param weight The distance or cost (weight) of the route between them.
     */
    void addRoute(const std::string& loc1, const std::string& loc2, int weight) {
        // Get integer IDs for both locations
        int id1 = getId(loc1);
        int id2 = getId(loc2);

        // Add the edge in both directions for an undirected graph
        // (loc1) --> (loc2, weight)
        adjList[id1].push_back(std::make_pair(id2, weight));
        // (loc2) --> (loc1, weight)
        adjList[id2].push_back(std::make_pair(id1, weight));
    }

    /**
     * @brief Prints all available locations registered in the graph.
     */
    void printLocations() {
        std::cout << "Available locations:\n";
        for (const auto& name : idToLocation) {
            std::cout << "- " << name << "\n";
        }
        std::cout << std::endl;
    }

    /**
     * @brief Finds the shortest path using Dijkstra's algorithm.
     * @param startLocation The name of the starting location.
     * @param endLocation The name of the destination location.
     */
    void findShortestPath(const std::string& startLocation, const std::string& endLocation) {
        // --- 1. Validate Input ---
        if (locationToId.find(startLocation) == locationToId.end()) {
            std::cout << "Error: Start location '" << startLocation << "' not found.\n";
            return;
        }
        if (locationToId.find(endLocation) == locationToId.end()) {
            std::cout << "Error: End location '" << endLocation << "' not found.\n";
            return;
        }

        int startId = locationToId[startLocation];
        int endId = locationToId[endLocation];
        int numNodes = nextId;

        // --- 2. Initialize Dijkstra's Data Structures ---

        // A min-priority queue to store {distance, node_id}
        // It always keeps the node with the smallest distance at the top.
        std::priority_queue<PqPair, std::vector<PqPair>, std::greater<PqPair>> pq;

        // 'distances' vector: stores the shortest distance found *so far*
        // from 'startId' to all other nodes.
        std::vector<int> distances(numNodes, INF);

        // 'parent' map: stores the predecessor of a node in the
        // shortest path. This is how we rebuild the path.
        // parent[child] = parent_node
        std::map<int, int> parent;

        // --- 3. Run Dijkstra's Algorithm ---

        // The distance from the start node to itself is 0
        distances[startId] = 0;
        pq.push(std::make_pair(0, startId));

        while (!pq.empty()) {
            // Get the node with the smallest distance from the source
            int u = pq.top().second; // node_id
            int d = pq.top().first;  // distance
            pq.pop();

            // Optimization: If we've already found a shorter path to 'u',
            // this entry in the PQ is 'stale'. Skip it.
            if (d > distances[u]) {
                continue;
            }

            // If we reached our destination, we can stop early
            // (This is a valid optimization for Dijkstra's)
            if (u == endId) {
                break;
            }

            // 'Relaxation' step:
            // Check all neighbors 'v' of the current node 'u'
            for (const auto& edge : adjList[u]) {
                int v = edge.first;      // neighbor_id
                int weight = edge.second; // weight of edge (u, v)

                // If we found a shorter path to 'v' *through* 'u'
                if (distances[u] + weight < distances[v]) {
                    // Update the new shortest distance
                    distances[v] = distances[u] + weight;
                    // Record that we reached 'v' via 'u'
                    parent[v] = u;
                    // Push the new, shorter path to the priority queue
                    pq.push(std::make_pair(distances[v], v));
                }
            }
        }

        // --- 4. Process Results and Print Path ---

        std::cout << "\n--- Result ---\n";
        // Check if a path was found
        if (distances[endId] == INF) {
            std::cout << "No path found from '" << startLocation << "' to '" << endLocation << "'.\n";
            return;
        }

        // A path was found! Print the total distance.
        std::cout << "Shortest distance: " << distances[endId] << " km\n";

        // Reconstruct the path by backtracking from the end node
        // using the 'parent' map.
        std::vector<std::string> path;
        int currentId = endId;

        while (currentId != startId) {
            path.push_back(idToLocation[currentId]);
            currentId = parent[currentId];
        }
        // Add the start location
        path.push_back(startLocation);

        // The path was built backward, so reverse it
        std::reverse(path.begin(), path.end());

        // Print the final path
        std::cout << "Path: ";
        for (size_t i = 0; i < path.size(); ++i) {
            std::cout << path[i];
            if (i < path.size() - 1) {
                std::cout << " -> ";
            }
        }
        std::cout << "\n";
    }
};

// --- Main Function: The Application ---
int main() {
    // 1. Create our graph (our map)
    Graph map;

    // 2. Add routes. Distances are approximate "as the crow flies" or road distance.
    // This creates our sample map.
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

    // 3. Start the user interface
    std::cout << "================================\n";
    std::cout << "  Mini GPS Route Planner\n";
    std::cout << "================================\n\n";

    // Print all locations so the user knows what to type
    map.printLocations();

    std::string start, end;
    
    std::cout << "Enter Start Location: ";
    std::getline(std::cin, start); // Use getline to allow spaces in names

    std::cout << "Enter End Location: ";
    std::getline(std::cin, end);

    // 4. Find and print the shortest path
    map.findShortestPath(start, end);

    std::cout << "\n================================\n";

    return 0;
}
