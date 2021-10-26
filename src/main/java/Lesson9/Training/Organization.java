package Lesson9.Training;

import java.util.List;
import java.util.Objects;

public class Organization {
    private int teamId;
    private String teamName;
    private List<Employee> employeeList;

    public Organization(int teamId, String teamName, List<Employee> employeeList) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.employeeList = employeeList;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return teamId == that.teamId && Objects.equals(teamName, that.teamName) && Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, employeeList);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
