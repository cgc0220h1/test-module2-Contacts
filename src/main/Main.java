package main;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Manager manager = new Manager();
        String choice;
        boolean isExit = false;
        while (!isExit) {
            System.out.println();
            displayMenu();
            choice = scanner.next();
            switch (choice) {
                case "1":
                    if (manager.checkStatus()) {
                        System.out.println("Danh bạ trống, cần thêm danh bạ");
                    } else {
                        for (int index = 0; index < manager.getContactsList().size(); index++) {
                            for (int count = index; count < 5; count++) {

                            }
                        }

                    }
                    break;
                case "2":
                    Contact contact = new Contact();
                    try {
                        updateInfo(contact);
                        manager.add(contact);
                        System.out.println("Thêm danh bạ thành công!");
                    } catch (InvalidDataException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Thêm danh bạ không thành công");
                    } catch (InputMismatchException e) {
                        System.out.println("Dữ liệu nhập vào phải là số");
                        System.out.println("Thêm danh bạ không thành công");
                    } catch (DateTimeException e) {
                        System.out.println("Ngày tháng nhập vào không đúng!");
                        System.out.println("Thêm danh bạ không thành công");
                    } finally {
                        System.out.println("Kết thúc việc thêm danh bạ");
                    }
                    break;
                case "3":
                    scanner.nextLine();
                    String input;
                    do {
                        System.out.println("Nhập vào số điện thoại, ấn enter để thoát: ");
                        input = scanner.nextLine();
                        Contact contactSearch = manager.searchByNumber(input);
                        if (contactSearch == null) {
                            System.out.println("Không tìm thấy danh bạ");
                        } else {
                            System.out.println(contactSearch);
                            break;
                        }
                    } while (!input.equals(""));
                    break;
                case "4":
                    scanner.nextLine();
                    do {
                        System.out.println("Nhập vào số điện thoại, ấn enter để thoát: ");
                        input = scanner.nextLine();
                        Contact contactSearch = manager.searchByNumber(input);
                        if (contactSearch == null) {
                            System.out.println("Không tìm thấy danh bạ");
                        } else {
                            System.out.println("Bạn có muốn xoá ? (Y/N)");
                            char confirm = scanner.next().toLowerCase().charAt(0);
                            if (confirm == 'y') {
                                manager.remove(contactSearch);
                                System.out.println("Xoá danh bạ thành công!");
                                break;
                            } else {
                                break;
                            }
                        }
                    } while (!input.equals(""));
                    break;
                case "5":
                    scanner.nextLine();
                    System.out.println("1. Tìm kiếm theo số điện thoại");
                    System.out.println("2. Tìm kiếm theo tên");
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.println("Nhập số điện thoại: ");
                            input = scanner.nextLine();
                            Contact contactSearch = manager.searchNumberRelatively(input);
                            if (contactSearch == null) {
                                System.out.println("Không tìm thấy danh bạ");
                            } else {
                                System.out.println(contactSearch);
                            }
                            break;
                        case "2":
                            System.out.println("Nhập tên: ");
                            input = scanner.nextLine();
                            contactSearch = manager.searchNameRelatively(input);
                            if (contactSearch == null) {
                                System.out.println("Không tìm thấy danh bạ");
                            } else {
                                System.out.println(contactSearch);
                            }
                            break;
                        default:
                            System.out.println("Lựa chọn không phù hợp");
                    }
                    break;
                case "6":

                case "0":
                    System.out.println("Thoát chương trình");
                    isExit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không đúng. Vui lòng nhập lại");
            }
        }
    }

    private static void updateInfo(Contact contact) throws InvalidDataException, InputMismatchException, DateTimeException {
        System.out.println("Nhập vào số điện thoại");
        String number = scanner.next();
        if (!number.matches("\\d{9,10}")) {
            throw new InvalidDataException();
        }
        contact.setPhoneNumber(number);
        scanner.nextLine();
        System.out.println("Nhập vào nhóm của danh bạ");
        contact.setGroup(scanner.nextLine());
        System.out.println("Nhập vào tên của danh bạ");
        contact.setName(scanner.nextLine());
        System.out.println("Lựa chọn giới tính: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        int gender = scanner.nextInt();
        if (gender < 1 || gender > 2) {
            throw new InvalidDataException();
        } else if (gender == 1) {
            contact.setGender(true);
        } else contact.setGender(false);
        scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        contact.setAddress(scanner.nextLine());
        System.out.println("Nhập ngày sinh: ");
        int day = scanner.nextInt();
        System.out.println("Nhập tháng sinh: ");
        int month = scanner.nextInt();
        System.out.println("Nhập năm sinh: ");
        int year = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        contact.setBirthDay(localDate);
        scanner.nextLine();
        System.out.println("Nhập vào email: ");
        String email = scanner.nextLine();
        if (!email.matches("\\D\\w*@\\w+\\.(\\w{2,3}|\\.\\w{2,3})")) {
            throw new InvalidDataException();
        }
        contact.setEmail(email);
        System.out.println("Danh bạ đã được khởi tạo!");
    }

    private static void displayMenu() {
        System.out.println("-------Chương trình quản lý danh bạ-----");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ File");
        System.out.println("7. Ghi vào File");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
