package com.company.controllers;

import com.company.services.*;
import com.company.services.impl.*;
import com.company.utils.MenuUtil;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService iEmployeeService;
    private static ICustomerService iCustomerService;
    private static IFacilityService iFacilityService;
    private static IBookingService iBookingService;
    private static IContactService iContactService;
    private static IPromotionService iPromotionService;

    static {
        iEmployeeService = new EmployeeService();
        iCustomerService = new CustomerService();
        iFacilityService = new FacilityService();
        iBookingService = new BookingService();
        iContactService = new ContactService();
        iPromotionService = new PromotionService();
    }

    public static void displayMainMenu() {
        while (true) {
            System.out.println("======== Main menu ========");
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");

            switch (MenuUtil.choose(1, 6)) {
                case 1:
                    manageEmployee();
                    break;
                case 2:
                    manageCustomer();
                    break;
                case 3:
                    manageFacility();
                    break;
                case 4:
                    manageBooking();
                    break;
                case 5:
                    managePromotion();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private static void manageEmployee() {
        while (true) {
            System.out.println("======== Employee Management ========");
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tEdit employee");
            System.out.println("4\tReturn main menu");

            switch (MenuUtil.choose(1, 4)) {
                case 1:
                    iEmployeeService.display();
                    break;
                case 2:
                    iEmployeeService.add();
                    break;
                case 3:
                    iEmployeeService.edit();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void manageCustomer() {
        while (true) {
            System.out.println("======== Customer Management ========");
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4.\tReturn main menu");

            switch (MenuUtil.choose(1, 4)) {
                case 1:
                    iCustomerService.display();
                    break;
                case 2:
                    iCustomerService.add();
                    break;
                case 3:
                    iCustomerService.edit();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void manageFacility() {
        while (true) {
            System.out.println("======== Facility Management ========");
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");

            switch (MenuUtil.choose(1, 4)) {
                case 1:
                    iFacilityService.display();
                    break;
                case 2:
                    iFacilityService.add();
                    break;
                case 3:
                    iFacilityService.displayMaintenances();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void manageBooking() {
        while (true) {
            System.out.println("======== Booking Management ========");
            System.out.println("1.\tAdd new booking");
            System.out.println("2.\tDisplay list booking");
            System.out.println("3.\tCreate new constracts");
            System.out.println("4.\tDisplay list contracts");
            System.out.println("5.\tEdit contracts");
            System.out.println("6.\tReturn main menu");

            switch (MenuUtil.choose(1, 6)) {
                case 1:
                    iBookingService.add();
                    break;
                case 2:
                    iBookingService.display();
                    break;
                case 3:
                    iContactService.add();
                    break;
                case 4:
                    iContactService.display();
                    break;
                case 5:
                    // TODO
                    break;
                case 6:
                    return;
            }
        }
    }

    private static void managePromotion() {
        while (true) {
            System.out.println("======== Promotion Management ========");
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3.\tReturn main menu");

            switch (MenuUtil.choose(1, 3)) {
                case 1:
                    iPromotionService.displayCustomersUseService();
                    break;
                case 2:
                    iPromotionService.displayCustomersGetVoucher();
                    break;
                case 3:
                    return;
            }
        }
    }
}
