package com.company.services.impl;

import com.company.models.Booking;
import com.company.models.Customer;
import com.company.models.Facility;
import com.company.services.IBookingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BookingService implements IBookingService {
    public static TreeSet<Booking> bookingTreeSet;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        bookingTreeSet = new TreeSet<>();

        bookingTreeSet.add(new Booking("B001", LocalDate.parse("2021-01-03"), LocalDate.parse("2021-03-03"), "C001", "V001"));
        bookingTreeSet.add(new Booking("B002", LocalDate.parse("2021-01-02"), LocalDate.parse("2021-03-04"), "C002", "V002"));
        bookingTreeSet.add(new Booking("B003", LocalDate.parse("2021-01-02"), LocalDate.parse("2021-03-01"), "C002", "V002"));
        bookingTreeSet.add(new Booking("B004", LocalDate.parse("2021-01-02"), LocalDate.parse("2021-03-02"), "C002", "V002"));
        bookingTreeSet.add(new Booking("B005", LocalDate.now(), LocalDate.now().plusMonths(1), "C002", "V002"));
        bookingTreeSet.add(new Booking("B006", LocalDate.now().plusDays(1), LocalDate.now().plusMonths(1), "C001", "V002"));
        bookingTreeSet.add(new Booking("B007", LocalDate.now().plusDays(2), LocalDate.now().plusMonths(1), "C003", "V002"));
    }

    @Override
    public void add() {
        System.out.print("Nhập vào mã booking: ");
        String id = scanner.nextLine();

        boolean existBooking = false;
        for (Booking booking : bookingTreeSet) {
            if (id.equals(booking.getId())) {
                System.out.println("Mã booking đã tồn tại, xin kiểm tra lại!!!");
                existBooking = true;
                break;
            }
        }

        if (!existBooking) {
            System.out.print("Nhập vào ngày bắt đầu: ");
            LocalDate startDay = LocalDate.parse(scanner.nextLine());

            System.out.print("Nhập vào ngày kết thúc: ");
            LocalDate endDay = LocalDate.parse(scanner.nextLine());

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

            System.out.println("======== Mã dịch vụ ========");
            List<String> facilityIdList = FacilityService.facilityLinkedHashMap.keySet().stream().map(Facility::getFacilityId).collect(Collectors.toList());

            for (String facilityId : facilityIdList) {
                System.out.println(facilityId);
            }
            String facilityId;
            boolean isExistFacilityId;
            do {
                System.out.print("Chọn mã dịch vụ: ");
                facilityId = scanner.nextLine();

                isExistFacilityId = facilityIdList.contains(facilityId);
                if (!isExistFacilityId) {
                    System.out.println("Mã dịch vụ không tồn tại, xin kiểm tra lại");
                }
            } while (!isExistFacilityId);


            Booking booking = new Booking(id, startDay, endDay, customerId, facilityId);

            bookingTreeSet.add(booking);

            for (Facility facility : FacilityService.facilityLinkedHashMap.keySet()) {
                if (facility.getFacilityId().equals(facilityId)) {
                    int numberUsed = FacilityService.facilityLinkedHashMap.get(facility);
                    FacilityService.facilityLinkedHashMap.put(facility, numberUsed + 1);
                    break;
                }
            }
            System.out.println("Đã thêm thành công!!!");
        }
    }


    @Override
    public void display() {
        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
    }
}
