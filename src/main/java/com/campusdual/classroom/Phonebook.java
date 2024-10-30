package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private final Map<String, Contact> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }

    public Map<String, Contact> getData() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
        System.out.println("Contacto añadido: " + contact.getName() + " " + contact.getSurnames());
    }

    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos en el listín telefónico.");
        } else {
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                Contact contact = entry.getValue();
                System.out.println("Código: " + entry.getKey() + " | Nombre: " + contact.getName() + " " + contact.getSurnames());
            }
        }
    }
    public void selectContact(String code) {
        Contact contact = contacts.get(code);
        if (contact != null) {
            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                System.out.println("\n--- Menú de acciones para " + contact.getName() + " " + contact.getSurnames() + " ---");
                System.out.println("1. Llamar a mi número");
                System.out.println("2. Llamar a otro número");
                System.out.println("3. Mostrar detalles del contacto");
                System.out.println("4. Volver al menú principal");
                System.out.print("Selecciona una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        contact.callMyNumber();
                        break;
                    case 2:
                        System.out.print("Introduce el número al que deseas llamar: ");
                        String number = scanner.nextLine();
                        contact.callOtherNumber(number);
                        break;
                    case 3:
                        contact.showContactDetails();
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (option != 4);
        } else {
            System.out.println("No se encontró ningún contacto con el código proporcionado.");
        }
    }

    public void deleteContact(String code) {
        if (contacts.remove(code) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró ningún contacto con el código proporcionado.");
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n--- Menú de Phonebook ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Seleccionar un contacto");
            System.out.println("4. Eliminar un contacto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Introduce el nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String surname = scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, surname, phone);
                    addContact(contact);
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    System.out.print("Introduce el código del contacto que quieres seleccionar: ");
                    String code = scanner.nextLine();
                    selectContact(code);
                    break;
                case 4:
                    System.out.print("Introduce el código del contacto que quieres eliminar: ");
                    String codeToDelete = scanner.nextLine();
                    deleteContact(codeToDelete);
                    break;
                case 5:
                    System.out.println("Saliendo del listín telefónico.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (option != 5);
    }

}
