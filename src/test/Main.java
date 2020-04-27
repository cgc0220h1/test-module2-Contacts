package test;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choie = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            throw new NullPointerException();
        }
    }
}
