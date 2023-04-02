package lab6.io;

import lab6.data.Customer;
import lab6.logic.CustomersArray;

import java.io.*;

public class CustomerReaderWriter {
    public CustomersArray readFromFile(File file){
        CustomersArray customersArray = new CustomersArray();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer c = Customer.parse(line);
                customersArray.add(c);
            }
            return customersArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeToFile(File file, CustomersArray customersArray) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < customersArray.getSize(); i++) {
                writer.println(customersArray.getCustomers()[i].toTxt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
