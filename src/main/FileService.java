package main;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    private File file;

    public void exportToCSV(String path, Manager manager) throws IOException {
        File fie = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Số điện thoại" + "," + "Nhóm" + "," + "Họ tên" + "," + "Giới tính" + "," + "Địa chỉ" + "," + "Ngày sinh" + "," + "Email");
        for (Contact contact : manager.getContactsList()) {
            bufferedWriter.write(contact.getPhoneNumber() + "," + contact.getGroup() + "," + contact.getName() + "," + (contact.isGender()? "Nam" : "Nữ") + "," + contact.getAddress() + "," + contact.getBirthDay().toString() + "," + contact.getEmail());
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }
}
