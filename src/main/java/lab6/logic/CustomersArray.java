package lab6.logic;

import lab6.data.Customer;

import java.util.Arrays;
import java.util.Comparator;

public class CustomersArray {
    private int size;
    private Customer[] customers;

    public CustomersArray() {
        size = 0;
        customers = new Customer[100];
    }

    public int getSize() {
        return size;
    }

    public Customer[] getCustomers() {
        return Arrays.copyOf(customers,size);
    }

    public void add(Customer c) {
        customers[size] = c;
        size++;
    }

    public Customer[] findByName(String s) {
        Customer[] list = new Customer[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (s.equals(customers[i].getName())) {
                list[k++] = customers[i];
            }
        }
        return Arrays.copyOf(list, k);
    }

    public Customer[] findByCard(long min, long max) {
        Customer[] list = new Customer[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (customers[i].getCardNumber() >=min && customers[i].getCardNumber() <=max) {
                list[k++] = customers[i];
            }
        }
        return Arrays.copyOf(list, k);
    }

    public Customer[] findByBalance() {
        Customer[] list = new Customer[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (customers[i].getCardBalance() < 0) {
                list[k++] = customers[i];
            }
        }
        Customer[] res = Arrays.copyOf(list, k);
        Arrays.sort(res, new Comparator<Customer>() {

            @Override
            public int compare(Customer c1, Customer c2) {
                return Long.compare(c1.getCardBalance(), c2.getCardBalance());
            }
        });
        return res;
    }

    public Customer[] sortByBalance() {
        Customer[] list = new Customer[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            list[k++] = customers[i];
        }
        Customer[] res = Arrays.copyOf(list, k);
        Arrays.sort(res, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int r = Long.compare(c1.getCardBalance(), c2.getCardBalance());
                if (r!=0){
                    return r;
                }
                return Long.compare(c1.getCardNumber(), c2.getCardNumber());
            }
        });
        return res;
    }
}
