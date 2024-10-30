package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {

        Contact c1 = new Contact("Javier", "López", "654321321");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "654321321");
        Contact c3 = new Contact("Jose Manuel", "Soria", "654321321");
        Contact c4 = new Contact("Santiago","Fernández Rocha", "654321321");
        Contact c5 = new Contact("Esteban","Serrano del Río", "654321321");
        Contact c6 = new Contact("Fernando Miguel","Juan de los Santos Requejo León", "654321321");

        c1.callMyNumber();
        c1.callOtherNumber("649735411");
        c1.showContactDetails();

        c2.callMyNumber();
        c2.callOtherNumber("649735411");
        c2.showContactDetails();

        c3.callMyNumber();
        c3.callOtherNumber("649735411");
        c3.showContactDetails();

        c4.callMyNumber();
        c4.callOtherNumber("649735411");
        c4.showContactDetails();

        c5.callMyNumber();
        c5.callOtherNumber("649735411");
        c5.showContactDetails();

        c6.callMyNumber();
        c6.callOtherNumber("649735411");
        c6.showContactDetails();
    }
}