package com.campusdual.classroom;

import java.text.Normalizer;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.toLowerCase;

public class Contact implements ICallActions {

    private String name;
    private String surname;
    private String phone;
    private String code;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.code = generateCode();//General el código
    }

    private String generateCode() {
        String normalizedSurname = Normalizer.normalize(surname, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();
        String [] parts = normalizedSurname.split(" ");

        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(Character.toLowerCase(name.charAt(0)));

        if (parts.length == 1) {
            codeBuilder.append(parts[0]);
        }else{
            codeBuilder.append(parts[0].charAt(0));
            for (int i = 1; i< parts.length; ++i) {
                codeBuilder.append(parts[i]);
            }
        }
        return codeBuilder.toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public void callMyNumber() {
        System.out.println("Llamando a " + this.name + " " + this.surname + " a su número: " + this.phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando a " + this.name + " " + this.surname + " al número: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + this.name);
        System.out.println("Apellidos: " + this.surname);
        System.out.println("Teléfono: " + this.phone);
        System.out.println("Código: " + this.code);
    }
}
