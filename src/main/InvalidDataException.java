package main;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

public class InvalidDataException extends Exception {
    public InvalidDataException() {
    }

    @Override
    public String toString() {
        return "Dữ liệu nhập vào không hợp lệ";
    }

    @Override
    public String getMessage() {
        return "Dữ liệu nhập vào không hợp lệ";
    }
}
