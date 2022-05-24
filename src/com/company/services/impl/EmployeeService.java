package com.company.services.impl;

import com.company.models.Employee;
import com.company.services.IEmployeeService;
import com.company.utils.MenuUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static List<Employee> employeeList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        employeeList = new ArrayList<>();

        employeeList.add(new Employee("E001", "Nguyễn Ngọc Quang", LocalDate.parse("1995-03-12"), 1, "123456789", "(+84)123456789", "ngocquang@gmailcom", 1, "Giám đốc", 15000000));
        employeeList.add(new Employee("E002", "Nguyễn Văn B", LocalDate.parse("1995-03-12"), 1, "123456789", "(+84)123456789", "nguyenvanb@gmailcom", 1, "Nhân viên", 7000000));
    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã nhân viên: ");
        String id = scanner.nextLine();

        boolean existEmployee = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id.equals(employeeList.get(i).getId())) {
                System.out.print("Nhập vào tên: ");
                String fullName = scanner.nextLine();

                System.out.print("Nhập vào ngày sinh (yyyy-MM-dd): ");
                LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

                System.out.println("======= Giới tính =======");
                System.out.println("1 - Nam");
                System.out.println("2 - Nữ");
                System.out.println("3 - Giới tính thứ 3");
                int gender = MenuUtil.choose(1, 3);

                System.out.print("Nhập vào số CMND: ");
                String idCard = scanner.nextLine();

                System.out.print("Nhập vào số điện thoại: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Nhập vào email: ");
                String email = scanner.nextLine();

                System.out.println("======= Trình độ =======");
                System.out.println("1 - Trung cấp");
                System.out.println("2 - Cao đẳng");
                System.out.println("3 - Đại học");
                System.out.println("4 - Sau đại học");
                int level = MenuUtil.choose(1, 4);

                System.out.print("Nhập vào Vị trí: ");
                String position = scanner.nextLine();

                System.out.print("Nhập vào lương: ");
                double salary = Double.parseDouble(scanner.nextLine());

                Employee employee = new Employee(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email, level, position, salary);

                employeeList.set(i, employee);

                System.out.println("Đã chỉnh sửa thành công!!!");
                existEmployee = true;
                break;
            }
        }

        if (!existEmployee) {
            System.out.println("Không tồn tại nhân viên cần chỉnh sửa, xin kiểm tra lại!");
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập vào mã nhân viên: ");
        String id = scanner.nextLine();

        boolean existEmployee = false;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                System.out.println("Mã nhân viên đã tồn tại, xin kiểm tra lại!!!");
                existEmployee = true;
                break;
            }
        }

        if (!existEmployee) {
            System.out.print("Nhập vào tên: ");
            String fullName = scanner.nextLine();

            System.out.print("Nhập vào ngày sinh (yyyy-MM-dd): ");
            LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

            System.out.println("======= Giới tính =======");
            System.out.println("1 - Nam");
            System.out.println("2 - Nữ");
            System.out.println("3 - Giới tính thứ 3");
            int gender = MenuUtil.choose(1, 3);

            System.out.print("Nhập vào số CMND: ");
            String idCard = scanner.nextLine();

            System.out.print("Nhập vào số điện thoại: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Nhập vào email: ");
            String email = scanner.nextLine();

            System.out.println("======= Trình độ =======");
            System.out.println("1 - Trung cấp");
            System.out.println("2 - Cao đẳng");
            System.out.println("3 - Đại học");
            System.out.println("4 - Sau đại học");
            int level = MenuUtil.choose(1, 4);

            System.out.print("Nhập vào Vị trí: ");
            String position = scanner.nextLine();

            System.out.print("Nhập vào lương: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee employee = new Employee(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email, level, position, salary);

            employeeList.add(employee);
            System.out.println("Đã thêm thành công!!!");
        }
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
