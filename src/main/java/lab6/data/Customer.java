package lab6.data;

import java.util.Objects;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String secondName;
    private String address;
    private long cardNumber;
    private long cardBalance;

    public Customer(int id, String surname, String name, String secondName, String address, long cardNumber, long cardBalance) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.cardNumber = cardNumber;
        this.cardBalance = cardBalance;
    }

    public static Customer parse(String line) {
        String[] s = line.split(",");
        int id = Integer.parseInt(s[0]);
        String surname = s[1];
        String name = s[2];
        String secondName = s[3];
        String address = s[4];
        long cardNumber = Long.parseLong(s[5]);
        long cardBalance = Long.parseLong(s[6]);

        return new Customer(id, surname, name, secondName, address, cardNumber, cardBalance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(long cardBalance) {
        this.cardBalance = cardBalance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", cardNumber=" + cardNumber +
                ", cardBalance=" + cardBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && cardNumber == customer.cardNumber && cardBalance == customer.cardBalance && Objects.equals(surname, customer.surname) && Objects.equals(name, customer.name) && Objects.equals(secondName, customer.secondName) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, secondName, address, cardNumber, cardBalance);
    }

    public String toTxt() {
        return id + "," + surname + "," + name + "," + secondName + "," +address + "," + cardNumber + "," + cardBalance;
    }
}
