package com.example.exerciciofixacaolist;

import com.example.exerciciofixacaolist.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExercicioFixacaoListApplication {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Locale.setDefault(Locale.US);

                //Criando lista de objetos.
                List<Employee> list = new ArrayList<>();

                // Part 1 - Reading Data:
                System.out.println("How many employees will be registered? ");
                int n = sc.nextInt();

                for(int i =0; i < n; i++){
                        System.out.println();
                        System.out.println("Employee #" + i + ":");

                        System.out.println("id: ");
                        int id = sc.nextInt();
                        while(hasId(list, id)){
                                System.out.println("Id already taken. Try again: ");
                        }

                        System.out.println("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Salary ");
                        double salary = sc.nextDouble();
                        //instanciando a classe usando o construtor
                        list.add(new Employee(id,name,salary));
                }

                // Part 2 - Updating salary of given employe:
                System.out.println();
                System.out.println("Enter the employee id that will have salary increase: ");
                int id = sc.nextInt();
                Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                if(emp == null){
                        System.out.println("This id does not exist!");
                }
                else{
                        System.out.println("Enter the percentage: ");
                        double percentage = sc.nextDouble();
                        emp.increaseSalary(percentage);
                }

                //PART 3 - LISTING EMPLOYEES;
                System.out.println();
                System.out.println("List of employees: ");
                for (Employee obj : list){
                        System.out.println(obj);
                }
                sc.close();
        }
        public static boolean hasId(List<Employee> list, int id){
                Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                return emp != null;
        }

}
