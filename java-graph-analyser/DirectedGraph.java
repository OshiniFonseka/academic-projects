// student ID - 20210855
// Name - Oshini Fonseka

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DirectedGraph {
    public static void main(String[] args) {
        // reading input file
        List<List<Integer>> adjacencyList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File("input.txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] vertices = line.split(" ");
                List<Integer> edge = new ArrayList<>();
                for (String vertex : vertices) {
                    edge.add(Integer.parseInt(vertex));
                }
                adjacencyList.add(edge);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //  sink elimination algorithm
        while (!adjacencyList.isEmpty()) {
            // Find sink
            int sink = findSink(adjacencyList);
            if (sink == -1) {
                System.out.println("\nCyclic graph");
                break;
            } else {
                System.out.println("Found sink vertex " + sink);
            }

            // Remove sink
            boolean removed = removeSink(adjacencyList, sink);
            if (removed) {
                System.out.println("Removed sink vertex " + sink);

            } else {
                System.out.println("Could not remove sink vertex " + sink + " (contains outgoing edges)");
            }
        }

        // Check for cycles if no cycles print acyclic graph
        List<Integer> cycle = findCycle(adjacencyList);
        if (cycle != null) {
            System.out.print("cycle is : ");
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i));
                if (i < cycle.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("\nAcyclic graph");
        }
    }

    //identifying sink vertex
    private static int findSink(List<List<Integer>> adjacencyList) {
        Set<Integer> sources = new HashSet<>();
        Set<Integer> destinations = new HashSet<>();
        for (List<Integer> edge : adjacencyList) {
            sources.add(edge.get(0));
            destinations.add(edge.get(1));
        }
        for (int destination : destinations) {
            if (!sources.contains(destination)) {
                return destination;
            }
        }
        return -1;
    }

    //remove identified sink vertex
    private static boolean removeSink(List<List<Integer>> adjacencyList, int sink) {
        boolean hasOutgoingEdges = false;
        for (List<Integer> edge : adjacencyList) {
            if (edge.get(0) == sink) {
                hasOutgoingEdges = true;
                break;
            }
        }
        if (!hasOutgoingEdges) {
            for (int i = 0; i < adjacencyList.size(); i++) {
                List<Integer> edge = adjacencyList.get(i);
                if (edge.get(0) == sink || edge.get(1) == sink) {
                    adjacencyList.remove(i);
                    i--;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //finding cycles if cyclic
    private static List<Integer> findCycle(List<List<Integer>> adjacencyList) {
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
        for (List<Integer> edge : adjacencyList) {
            int source = edge.get(0);
            int destination = edge.get(1);
            adjacencyLists.putIfAbsent(source, new ArrayList<>());
            adjacencyLists.get(source).add(destination);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int vertex : adjacencyLists.keySet()){
            if (!visited.contains(vertex)) {
                List<Integer> cycle = findCycleUtil(vertex, adjacencyLists, visited, stack, parentMap);
                if (cycle != null) {
                    return cycle;
                }
            }
        }
        return null;
    }

    private static List<Integer> findCycleUtil(int vertex, Map<Integer, List<Integer>> adjacencyLists, Set<Integer> visited, Stack<Integer> stack, Map<Integer, Integer> parentMap) {
        visited.add(vertex);
        stack.push(vertex);

        for (int neighbor : adjacencyLists.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                parentMap.put(neighbor, vertex);
                List<Integer> cycle = findCycleUtil(neighbor, adjacencyLists, visited, stack, parentMap);
                if (cycle != null) {
                    return cycle;
                }
            } else if (stack.contains(neighbor)) { // found a back edge
                List<Integer> cycle = new ArrayList<>();
                cycle.add(neighbor);
                int currentVertex = vertex;
                while (currentVertex != neighbor) { // trace back the path from current vertex to neighbor using parent map
                    cycle.add(currentVertex);
                    currentVertex = parentMap.get(currentVertex);
                }
                cycle.add(neighbor); // add neighbor again to complete the cycle
                Collections.reverse(cycle); // reverse the list to get the correct order of vertices in the cycle
                return cycle;
            }
        }

        stack.pop();
        return null;
    }
}