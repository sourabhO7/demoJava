package filehandling;

import java.io.*;
import java.util.Scanner;

public class GloLogisticsFileHandling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String id = sc.nextLine();

        System.out.println("Enter employee name: ");
        String name = sc.nextLine();

        System.out.println("Enter employee department: ");
        String department = sc.nextLine();

        String employeeData = "Id: "+id+" ,Name: "+name+" ,Department: "+department;

        String filePath = "/home/sourabh/Documents/supplier_data.txt";

        addSupplier(employeeData,filePath);
        getSupplier(filePath);

    }

    //get the supplier record from the file
    private static void getSupplier(String filePath){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String empData;
            while ((empData = reader.readLine())!=null){
                System.out.println(empData);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    //create a new supplier
    private static void addSupplier(String filePath, String employeeData){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(employeeData);
            writer.newLine();
            writer.close();
            System.out.println("Employee data stored successfully in the file.");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
