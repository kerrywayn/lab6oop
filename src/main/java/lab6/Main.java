package lab6;

import lab6.data.Customer;
import lab6.io.CustomerReaderWriter;
import lab6.logic.CustomersArray;

import java.io.File;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        CustomerReaderWriter readerWriter = new CustomerReaderWriter();
        CustomersArray array = null;
        int m;
        while ((m = menu())!=0) {
            switch (m) {
                case 1 -> array = readerWriter.readFromFile(new File("customers.txt"));
                case 2 -> readerWriter.writeToFile(new File("customers.txt"), array);
                case 3 -> show(array.getCustomers());
                case 4 -> array.add(inputCustomer());
                case 5 -> {
                    System.out.println("Введите имя");
                    String s = scanner.nextLine();
                    Customer[] customers = array.findByName(s);
                    show(customers);
                }
                case 6 -> {
                    System.out.println("Введите интервал");
                    long min = scanner.nextLong();
                    long max = scanner.nextLong();
                    scanner.nextLine();
                    Customer[] customers = array.findByCard(min, max);
                    show(customers);
                }
                case 7 -> {
                    Customer[] customers = array.findByBalance();
                    show(customers);
                }
                case 8 -> {
                    Customer[] customers = array.sortByBalance();
                    show(customers);
                }
            }
        }

//                = readerWriter.readFromFile(new File("customers.txt"));
//        array.show();
//        Customer customer = inputCustomer();
//        array.add(customer);
//        array.show();
//        readerWriter.writeToFile(new File("file.txt"), array);

    }

    private void show(Customer[] customers) {
        System.out.println("------------------------");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
        System.out.println("------------------------");
    }

    public Customer inputCustomer(){
        System.out.print("id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("surname:");
        String surname = scanner.nextLine();
        System.out.print("name:");
        String name = scanner.nextLine();
        System.out.print("secondName:");
        String secondName = scanner.nextLine();
        System.out.print("adress:");
        String address = scanner.nextLine();
        System.out.print("cardNumber:");
        long cardNumber = Long.parseLong(scanner.nextLine());
        System.out.print("cardBalance:");
        long cardBalance = Long.parseLong(scanner.nextLine());

        return new Customer(id, surname, name, secondName, address, cardNumber, cardBalance);
    }

    public int menu() {
        System.out.println("""
                1. Read from file
                2. Write to file
                3. Show All
                4. Add customer
                5. Find customer by name
                6. Find customer by card number
                7. Customers with negative balance
                8. Sort customers by balance
                0. Exit
                """
        );
        return Integer.parseInt(scanner.nextLine());
    }

}
