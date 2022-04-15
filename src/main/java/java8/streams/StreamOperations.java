package java8.streams;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.common.Employee;

public class StreamOperations {
    public static void main(String[] args) {
        List<Employee> employeeList = generateEmployeeData();
        System.out.println(employeeList);
        Map<String, Long> noOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("noOfMaleAndFemaleEmployees:"+noOfMaleAndFemaleEmployees);

        Map<String, List<Employee>> genderVsListOfEmployees=
                employeeList.stream().collect(Collectors.groupingBy(p->p.getGender()));
        //System.out.println("genderVsListOfEmployees:"+genderVsListOfEmployees);

        Map<String, Map<String, List<Employee>>> genderVsDeptVsListOfEmployees=
                employeeList.stream().collect(Collectors.groupingBy(p->p.getGender(),Collectors.groupingBy(p->p.getDepartment())));
        //System.out.println("genderVsDeptVsListOfEmployees:"+genderVsDeptVsListOfEmployees);

        Map<String, DoubleSummaryStatistics> genderVsSumOfSalary =
        employeeList.stream().collect(Collectors.groupingBy(p->p.getGender(),Collectors.summarizingDouble(p->p.getSalary())));
        System.out.println("genderVsSumOfSalary:"+genderVsSumOfSalary);
        /*
        Map<String, Employee> groupingByGenderAndEmployeeList=
                employeeList.stream().collect(Collectors.toMap(Employee::getGender, Function.identity()));
        System.out.println("groupingByGenderAndEmployeeList:"+groupingByGenderAndEmployeeList);
        */

        /*
        employeeList.stream()
                .collect(Collectors
                        .groupingBy(
                                e -> e,
                                Collectors.summarizingInt(e -> e.getSalary())
                        )
                )
                .forEach((k,v) -> {
                    k.scope = v.getSum();
                    System.out.println(k);
                });
    */
    }

    public static List<Employee> generateEmployeeData()
    {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Emp1", 20, "Female", "HR", 2011, 100));
        employeeList.add(new Employee(2, "Emp2", 30, "Male", "HR", 2015, 200));
        employeeList.add(new Employee(3, "Emp3", 40, "Male", "SALES", 2012, 100));
        employeeList.add(new Employee(4, "Emp4", 35, "Male", "SALES", 2014, 500));
        employeeList.add(new Employee(5, "Emp6", 25, "Female", "HR", 2013, 300));
        return employeeList;
    }
}
