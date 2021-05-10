package org.personal.company;

public class Company {
    private String companyName, companyAddress, companyContact, companyEmail;

    public String getName() {
        return companyName;
    }

    public String getAddress() {
        return companyAddress;
    }

    public String getContact() {
        return companyContact;
    }

    public String getEmail() {
        return companyEmail;
    }

    public void setName(String cName) {
        this.companyName = cName;
    }

    public void setAddress(String cAddress) {
        this.companyAddress = cAddress;
    }

    public void setContact(String cContact) {
        this.companyContact = cContact;
    }

    public void setEmail(String cEmail) {
        this.companyEmail = cEmail;
    }

    public Company(String name, String address, String contact, String email) {
        this.companyName = name;
        this.companyAddress = address;
        this.companyContact = contact;
        this.companyEmail = email;
    }
}
