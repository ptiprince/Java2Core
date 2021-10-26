package Lesson4;

import java.util.*;


public class PhoneBook {
    private String phone;
    private String lastName;

    public PhoneBook() {
        this.phone = phone;
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   HashMap<String, String> book = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(phone, phoneBook.phone) && Objects.equals(lastName, phoneBook.lastName) && Objects.equals(book, phoneBook.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, lastName, book);
    }

    public void addContact(String phone, String lastName) {
       book.put(phone, lastName);
  }

    public List<String> getPhones(String lastname) {
        ArrayList<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : book.entrySet()) {
            if (entry.getValue().equals(lastname)) {
                phones.add(entry.getKey());
            }
        }
        return Collections.singletonList(lastname + phones);
    }


}
