package com.company.services.impl;

import com.company.models.Booking;
import com.company.models.Customer;
import com.company.models.Facility;
import com.company.services.IPromotionService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class PromotionService implements IPromotionService {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomersUseService() {
        System.out.print("Nhập vào năm sử dụng dịch vụ: ");
        int year = scanner.nextInt();

        // Lấy facilityId của những facility có rentalType = 1 (1 - thuê theo năm)
        Set<String> facilityIdSet = FacilityService.facilityLinkedHashMap.keySet()
                .stream().filter(item -> item.getRentalType() == 1)
                .map(Facility::getFacilityId).collect(Collectors.toSet());
        /*
         *  Lấy ra mã khách hàng đã Booking thỏa mãn điều kiện
         *  - Thuộc facilityId của những facility có rentalType = 1 (1 - thuê theo năm)
         *  - Năm booking người dùng nhập vào
         */
        Set<String> customerIdSet = BookingService.bookingTreeSet.stream()
                .filter(item -> facilityIdSet.contains(item.getFacilityId()) && item.getStartDay().getYear() == year)
                .map(Booking::getCustomerId)
                .collect(Collectors.toSet());

        //Xuất thông tin của khách hàng thông qua mã khách hàng
        if (customerIdSet.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng tương ứng");
        } else {
            CustomerService.customerList.stream()
                    .filter(item -> customerIdSet.contains(item.getId()))
                    .forEach(System.out::println);
        }
    }

    @Override
    public void displayCustomersGetVoucher() {
        System.out.print("Nhập vào số lượng voucher khuyến mại 10%: ");
        int voucher10Percent = scanner.nextInt();

        System.out.print("Nhập vào số lượng voucher khuyến mại 20%: ");
        int voucher20Percent = scanner.nextInt();

        System.out.print("Nhập vào số lượng voucher khuyến mại 50%: ");
        int voucher50Percent = scanner.nextInt();

        int yearCurrent = LocalDate.now().getYear();
        Set<String> customerIdSet = BookingService.bookingTreeSet.stream()
                .filter(item -> item.getStartDay().getYear() == yearCurrent)
                .map(Booking::getCustomerId)
                .collect(Collectors.toSet());

        //Xuất thông tin của khách hàng thông qua mã khách hàng
        if (customerIdSet.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng tương ứng");
        } else {
            Set<Customer> customerSet = CustomerService.customerList.stream()
                    .filter(item -> customerIdSet.contains(item.getId()))
                    .collect(Collectors.toSet());

            Stack<Customer> customerStack = new Stack<>();
            customerSet.forEach(customerStack::push);

            int total = voucher10Percent + voucher20Percent + voucher50Percent;
            for (int i = 0; i < total && !customerStack.isEmpty(); i++) {
                if (voucher10Percent > 0) {
                    System.out.println(customerStack.pop() + " - Khuyến mã 10%");
                    voucher10Percent--;
                } else if (voucher20Percent > 0) {
                    System.out.println(customerStack.pop() + " - Khuyến mã 20%");
                    voucher20Percent--;
                } else if (voucher50Percent > 0) {
                    System.out.println(customerStack.pop() + " - Khuyến mã 50%");
                    voucher50Percent--;
                }
            }
        }
    }
}
