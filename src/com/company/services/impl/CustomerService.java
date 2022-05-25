package com.company.services.impl;

import com.company.models.Customer;
import com.company.services.ICustomerService;
import com.company.utils.MenuUtil;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    public static final List<Customer> customerList = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        customerList.add(new Customer("C001", "Nguyễn Văn A", LocalDate.parse("1996-01-01"), 1, "0123456879", "(+84)123456798", "nguyenvana@gmail.com", 1, "Đà Nẵng"));
        customerList.add(new Customer("C002", "Nguyễn Văn B", LocalDate.parse("1997-06-07"), 2, "0123456879", "(+84)123456798", "nguyenvanb@gmail.com", 1, "Quảng Bình"));
    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã khách hàng: ");
        String id = scanner.nextLine();

        boolean existCustomer = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (id.equals(customerList.get(i).getId())) {
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

                System.out.println("======= Loại khách =======");
                System.out.println("1 - Diamond  - Kim cương");
                System.out.println("2 - Platinum - Bạch kim");
                System.out.println("3 - Gold     - Vàng");
                System.out.println("4 - Silver   - Bạc");
                System.out.println("5 - Member   - Thành viên");
                int customerType = MenuUtil.choose(1, 5);

                System.out.print("Nhập vào địa chỉ: ");
                String address = scanner.nextLine();

                Customer customer = new Customer(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email, customerType, address);

                customerList.set(i, customer);

                System.out.println("Đã chỉnh sửa thành công!!!");
                existCustomer = true;
                break;
            }
        }

        if (!existCustomer) {
            System.out.println("Không tồn tại khách hàng cần chỉnh sửa, xin kiểm tra lại!");
        }
    }

    @Override
    public void displayCustomerUseService() {

    }

    @Override
    public void displayCustomerGetVoucher() {

    }

    @Override
    public void add() {
        System.out.println("Nhập vào mã khách hàng: ");
        String id = scanner.nextLine();

        boolean existCustomer = false;
        for (Customer customer : customerList) {
            if (id.equals(customer.getId())) {
                System.out.println("Mã khách hàng đã tồn tại, xin kiểm tra lại!!!");
                existCustomer = true;
                break;
            }
        }

        if (!existCustomer) {

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

            System.out.println("======= Loại khách =======");
            System.out.println("1 - Diamond  - Kim cương");
            System.out.println("2 - Platinum - Bạch kim");
            System.out.println("3 - Gold     - Vàng");
            System.out.println("4 - Silver   - Bạc");
            System.out.println("5 - Member   - Thành viên");
            int customerType = MenuUtil.choose(1, 5);

            System.out.print("Nhập vào địa chỉ: ");
            String address = scanner.nextLine();

            Customer customer = new Customer(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email, customerType, address);

            customerList.add(customer);
            System.out.println("Đã thêm thành công!!!");
        }
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
