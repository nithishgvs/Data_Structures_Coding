package org.nithishgvs.Practice;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class OrgChart3 {


  public class EmployeeClass {

    private String name;
    private EmployeeClass manager;
    private Set<String> children;

    public EmployeeClass getManager() {
      return manager;
    }

    public void setManager(EmployeeClass manager) {
      this.manager = manager;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Set<String> getChildren() {
      return children;
    }

    public void setChildren(Set<String> children) {
      this.children = children;
    }
  }


  Map<String, EmployeeClass> employeeNodeMap = new LinkedHashMap<>();

  public void add(String id, String name, String managerId) {

    if (id != null && name != null && managerId != null && !employeeNodeMap.containsKey(id)) {
      EmployeeClass employeeNode = new EmployeeClass();
      employeeNode.setName(name);
      //employeeNodeMap.put(id, employeeNode);
      if (!managerId.equals("-1") && employeeNodeMap.containsKey(managerId)) {
        EmployeeClass managerNode = employeeNodeMap.get(managerId);
        if (managerNode.getChildren() == null) {
          managerNode.setChildren(new LinkedHashSet<>());
        }
        managerNode.getChildren().add(id);
        employeeNode.setManager(managerNode);
        employeeNode.setManager(managerNode);
      }
      employeeNodeMap.put(id, employeeNode);
      return;
    }

    throw new UnsupportedOperationException();
  }

  public int count(String employeeId) {
    if (employeeNodeMap.get(employeeId).getChildren() == null) {
      return 0;
    }
    int count = 0;
    for (String children : employeeNodeMap.get(employeeId).getChildren()) {
      count++;
      return count + count(children);
    }

    throw new UnsupportedOperationException();
  }

  public void move(String employeeId, String newManagerId) {
    if (!employeeNodeMap.containsKey(employeeId) || !employeeNodeMap.containsKey(newManagerId)) {
      return;
    } else {
      EmployeeClass employeeNode = employeeNodeMap.get(employeeId);
      EmployeeClass managerNode = employeeNodeMap.get(newManagerId);

      if (managerNode.getChildren() == null) {
        managerNode.setChildren(new LinkedHashSet<>());
      }

      managerNode.getChildren().add(employeeId);
      employeeNode.setManager(managerNode);


    }
  }


  public void remove(String employeeId) {
    if (!employeeNodeMap.containsKey(employeeId)) {
      return;
    }

    EmployeeClass employeeNode = employeeNodeMap.get(employeeId);

    if (employeeNode.getManager() != null) {
      EmployeeClass managerNode = employeeNode.getManager();
      managerNode.getChildren().remove(employeeId);
      managerNode.getChildren().addAll(employeeNode.getChildren());
      for (String children : employeeNode.getChildren()) {
        employeeNodeMap.get(children).setManager(managerNode);
      }
    }
    employeeNodeMap.remove(employeeId);


  }

  public void print() {
    Set<String> visited = new LinkedHashSet<>();

    for (Map.Entry<String, EmployeeClass> entry : employeeNodeMap.entrySet()) {
      if (!visited.contains(entry.getKey())) {
        System.out.println(entry.getValue().name + "  " + "[" + entry.getKey() + "]");
        visited.add(entry.getKey());
        if (entry.getValue().getChildren() != null) {
          for (String subs : entry.getValue().getChildren()) {
              System.out.println("  " + employeeNodeMap.get(subs).name + "  " + "[" + subs + "]");
              visited.add(subs);
          }
        }
      }
    }

  }

  @Test
  public void test() {
    add("10", "S G", "-1");
    add("7", "D M", "10");
    add("3", "L F", "-1");
    add("34", "L G", "7");
    add("5", "L P", "3");
    System.out.println(count("10"));
    move("34", "10");
    remove("7");
    print();
    //move("7", "10");
    //System.out.println(count("10"));
  }


}
