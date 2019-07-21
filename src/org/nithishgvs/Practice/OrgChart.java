package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class OrgChart {


  List<GraphNode> graphNodes = new ArrayList<>();

  public class GraphNode {

    private String vertexNumber;
    private String name;
    private String nextVertex;

    public GraphNode(String vertexNumber, String name, String nextVertex) {
      this.vertexNumber = vertexNumber;
      this.name = name;
      this.nextVertex = nextVertex;
    }
  }


  Map<String, String> employeeManagerMap = new LinkedHashMap<>();
  Map<String, List<String>> managerEmployeeMap = new LinkedHashMap<>();

  public void add(String id, String name, String managerId) {

    if (id != null && name != null && managerId != null) {
      if (!employeeManagerMap.containsKey(id)) {
        graphNodes.add(new GraphNode(id, name, managerId));
        employeeManagerMap.put(id, managerId);
        if (employeeManagerMap.containsKey(managerId)) {
          managerEmployeeMap.put(managerId, new ArrayList<>());
          managerEmployeeMap.get(managerId).add(id);
        }

      }
      return;
    }

    throw new UnsupportedOperationException();
  }


  public void print() {
    graphNodes.forEach((k) -> System.out.println(k.name + "  " + "[" + k.vertexNumber + "]"));

  }

  public void remove(String employeeId) {
    if (employeeId != null && employeeManagerMap.containsKey(employeeId)) {
      GraphNode currentNode = null;

      for (String subs : managerEmployeeMap.get(employeeId)) {
        for (int i = 0; i < graphNodes.size(); i++) {
          if (graphNodes.get(i).vertexNumber.equals(subs)) {
            GraphNode newNode = new GraphNode(graphNodes.get(i).vertexNumber,
                graphNodes.get(i).name,
                employeeManagerMap.get(employeeId));
            graphNodes.set(i, newNode);
            employeeManagerMap
                .put(graphNodes.get(i).vertexNumber, employeeManagerMap.get(employeeId));
          } else if (graphNodes.get(i).vertexNumber.equals(employeeId)) {
            currentNode = graphNodes.get(i);
          }
        }

      }
      graphNodes.remove(currentNode);
      managerEmployeeMap.remove(employeeId);
      managerEmployeeMap.get(employeeManagerMap.get(employeeId)).remove(employeeId);
      employeeManagerMap.remove(employeeId);
      return;
    }
    throw new UnsupportedOperationException();
  }


  public void move(String employeeId, String newManagerId) {
    if (employeeId == null || newManagerId == null) {
      throw new UnsupportedOperationException();
    }
    if (employeeManagerMap.containsKey(employeeId) && employeeManagerMap
        .containsKey(newManagerId)) {
      if (!managerEmployeeMap.containsKey(newManagerId)) {
        managerEmployeeMap.put(newManagerId, new ArrayList<>());
      }
      managerEmployeeMap.get(newManagerId).add(employeeId);
      for (int i = 0; i < graphNodes.size(); i++) {
        if (graphNodes.get(i).vertexNumber == employeeId) {
          GraphNode newNode = new GraphNode(graphNodes.get(i).vertexNumber, graphNodes.get(i).name,
              newManagerId);
          graphNodes.set(i, newNode);
          return;
        }
      }
    }
  }

  int count = 0;

  public int count(String employeeId) {
    if (managerEmployeeMap.containsKey(employeeId)) {
      for(GraphNode node:graphNodes){

      }
    }
    throw new UnsupportedOperationException();
  }

  @Test
  public void test() {
    add("10", "S G", "-1");
    add("7", "D M", "10");
    add("3", "L F", "-1");
    add("34", "L G", "7");
    add("5", "L P", "3");
    print();
    move("34", "5");
    remove("7");
    System.out.println(count("10"));
  }


}
