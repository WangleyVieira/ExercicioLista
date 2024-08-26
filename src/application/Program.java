package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) +":");
            System.out.print("Id: ");
            Integer id = scanner.nextInt();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            Double salary = scanner.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee ID that will have salary increase: ");
        int idSalary = scanner.nextInt();

        //Employee emp = list.stream().filter(x->x.getId() == idSalary).findFirst().orElse(null);

        Integer pos = position(list, idSalary);
        if (pos == null) {
            System.out.println("This is id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = scanner.nextDouble();
            //emp.increaseSalary(percentage);
            list.get(pos).increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of Employee: ");
        for (Employee e : list) {
            System.out.println(e);
        }

        scanner.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            //pega o elemento na posição do ID na lista
            if (list.get(i).getId() == id) {
                return  i;
            }
        }
        //elemento não foi encontrado
        return null;
    }

}
