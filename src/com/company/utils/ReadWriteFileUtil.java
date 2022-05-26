package com.company.utils;

import com.company.models.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileUtil {
    private static List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            br.close();
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
            e.printStackTrace();
        }
        return stringList;
    }

    public static List<Employee> readEmployeeFile(String filePath) {
        List<Employee> employeeList = new ArrayList<>();

        List<String> stringList = readFile(filePath);
        for (String item : stringList) {
            Employee employee = new Employee();

            String[] info = item.split(",");
            employee.setId(info[0]);
            employee.setFullName(info[1]);
            employee.setDateOfBirth(LocalDate.parse(info[2]));
            employee.setGender(Integer.parseInt(info[3]));
            employee.setIdCard(info[4]);
            employee.setPhoneNumber(info[5]);
            employee.setEmail(info[6]);
            employee.setLevel(Integer.parseInt(info[7]));
            employee.setPosition(info[8]);
            employee.setSalary(Double.parseDouble(info[9]));

            employeeList.add(employee);
        }
        return employeeList;
    }

    private static void writeFile(String filePath, String data) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployeeFile(String filePath, List<Employee> employeeList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employeeList) {
            stringBuilder.append(employee.getInfo() + "\n");
        }

        writeFile(filePath, stringBuilder.toString());
    }
}