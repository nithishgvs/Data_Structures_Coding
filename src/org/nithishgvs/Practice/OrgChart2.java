package org.nithishgvs.Practice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class OrgChart2 {


  public class EmployeeNode {

    private String managerId;
    private String name;

    private Set<String> employeesReportingList;

    public Set<String> getEmployeesReportingList() {
      return employeesReportingList;
    }

    public EmployeeNode(String managerId, String name) {
      this.managerId = managerId;
      this.name = name;
      this.employeesReportingList = new LinkedHashSet<>();
    }
  }


  Map<String, EmployeeNode> employeeNodeMap = new LinkedHashMap<>();


  public void add(String id, String name, String managerId) {

    if (id != null && name != null && managerId != null && !employeeNodeMap.containsKey(id)) {
      EmployeeNode employeeNode = new EmployeeNode(managerId, name);
      employeeNodeMap.put(id, employeeNode);
      if (!managerId.equals("-1")) {
        updateManagerReportings(managerId, id);
      }
      return;
    }

    throw new UnsupportedOperationException();
  }


  public void move(String employeeId, String newManagerId) {
    //Moving employee to another manager means reporting to other and this person suborniats will also be reported to other
    if (!employeeNodeMap.containsKey(employeeId) || !employeeNodeMap.containsKey(newManagerId)) {
      return;
    } else {
      EmployeeNode employeeNode = employeeNodeMap.get(employeeId);
      String managerId = employeeNode.managerId;
      //Removing the current employee subordinates
      if (!managerId.equals("-1")) {
        Set<String> previousManagerList = employeeNodeMap.get(managerId)
            .getEmployeesReportingList();
        previousManagerList.removeAll(employeeNode.employeesReportingList);
        previousManagerList.remove(employeeId);
      }
      Set<String> newManagerList = employeeNodeMap.get(newManagerId).getEmployeesReportingList();
      newManagerList.add(employeeId);
      newManagerList.addAll(employeeNode.employeesReportingList);
      return;
    }
  }

  public void remove(String employeeId) {
    if (!employeeNodeMap.containsKey(employeeId)) {
      return;
    }

    EmployeeNode employeeNode = employeeNodeMap.get(employeeId);
    if (!employeeNode.managerId.equals("-1")) {
      employeeNodeMap.get(employeeNode.managerId).getEmployeesReportingList().remove(employeeId);
    }
    employeeNodeMap.remove(employeeId);


  }

  public int count(String employeeId) {
    if (employeeNodeMap.containsKey(employeeId)) {
      return employeeNodeMap.get(employeeId).getEmployeesReportingList().size();
    }

    throw new UnsupportedOperationException();
  }


  public void print() {
    Set<String> visited = new HashSet<>();

    for (Map.Entry<String, EmployeeNode> entry : employeeNodeMap.entrySet()) {
      if (!visited.contains(entry.getKey())) {
        System.out.println(entry.getValue().name + "  " + "[" + entry.getKey() + "]");
        visited.add(entry.getKey());
        for (String subs : entry.getValue().employeesReportingList) {
          System.out.println("  " + employeeNodeMap.get(subs).name + "  " + "[" + subs + "]");
          visited.add(subs);
        }
      }
    }

  }

  private void updateManagerReportings(String managerId, String id) {

    while (employeeNodeMap.containsKey(managerId)) {
      employeeNodeMap.get(managerId).getEmployeesReportingList().add(id);
      managerId = employeeNodeMap.get(managerId).managerId;
    }
  }


  @Test
  public void test() {
    add("10", "S G", "-1");
    add("7", "D M", "10");
    add("3", "L F", "-1");
    add("34", "L G", "7");
    add("5", "L P", "3");
    print();
    //move("34", "10");
    remove("7");
    move("7", "10");
    System.out.println(count("10"));
  }


}
