package com.company.services.impl;

import com.company.models.Booking;
import com.company.models.Contract;
import com.company.models.Customer;
import com.company.services.IContactService;

import java.util.*;
import java.util.stream.Collectors;

public class ContactService implements IContactService {
    private static final Scanner scanner = new Scanner(System.in);
    private static Queue<Booking> bookingQueue;
    private static TreeSet<Contract> contractTreeSet;

    static {
        bookingQueue = new LinkedList<>();
        bookingQueue.addAll(BookingService.bookingTreeSet);

        contractTreeSet = new TreeSet<>();
        contractTreeSet.add(new Contract("C001", "B001", 1000000, 10000000, "C001"));
        contractTreeSet.add(new Contract("C002", "B002", 2000000, 20000000, "C002"));
    }

    @Override
    public void edit() {

    }

    @Override
    public void add() {
        System.out.print("Nhập vào mã hợp đồng: ");
        String contractNo = scanner.nextLine();

        boolean existContract = false;
        for (Contract contract : contractTreeSet) {
            if (contractNo.equals(contract.getContractNo())) {
                System.out.println("Mã hợp đồng đã tồn tại, xin kiểm tra lại!!!");
                existContract = true;
                break;
            }
        }

        if (!existContract) {
            String bookingId = bookingQueue.poll().getId();
            System.out.println("Bạn đang tạo hợp đồng cho mã booking: " + bookingId);

            System.out.print("Nhập vào số tiền cọc trước: ");
            double advanceDepositAmount = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập vào tổng số tiền thanh toán: ");
            double totalPaymentAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("======== Mã khánh hàng ========");
            List<String> customerIdList = CustomerService.customerList.stream().map(Customer::getId).collect(Collectors.toList());

            for (String customerId : customerIdList) {
                System.out.println(customerId);
            }
            String customerId;
            boolean isExistCustomerId;
            do {
                System.out.print("Chọn mã khách hàng: ");
                customerId = scanner.nextLine();

                isExistCustomerId = customerIdList.contains(customerId);
                if (!isExistCustomerId) {
                    System.out.println("Mã khánh hàng không tồn tại, xin kiểm tra lại");
                }
            } while (!isExistCustomerId);


            Contract contract = new Contract(contractNo, bookingId, advanceDepositAmount, totalPaymentAmount, customerId);
            contractTreeSet.add(contract);

            System.out.println("Đã thêm thành công!!!");
        }
    }

    @Override
    public void display() {
        for (Contract contract : contractTreeSet) {
            System.out.println(contract);
        }
    }
}
