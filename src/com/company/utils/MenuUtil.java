package com.company.utils;

import java.util.Scanner;

public class MenuUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int choose(int start, int end) {
        int choose;

        do {
            choose = getInt();

            if (choose < start || choose > end) {
                System.out.printf("Lựa chọn không hợp lệ, lựa chọn chỉ được phép từ [%d-%d], xin hãy chọn lại!!!\n", start, end);
            }
        } while (choose < start || choose > end);

        return choose;
    }

    private static int getInt() {
        int choose = -1;

        boolean isValid;
        do {
            isValid = true;
            System.out.print("\nNhập vào sự lựa chọn của bạn: ");

            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Bạn phải nhập vào số, xin hãy nhập lại!");
            }
        } while (!isValid);

        return choose;
    }

    public static String parseGender(int target) {
        switch (target) {
            case 1:
                return "Nam";
            case 2:
                return "Nữ";
            case 3:
                return "Giới tính thứ 3";
            default:
                return "Không xác định";
        }
    }

    public static String parseLevel(int target) {
        switch (target) {
            case 1:
                return "Trung cấp";
            case 2:
                return "Cao đẳng";
            case 3:
                return "Đại học";
            case 4:
                return "Sau đại học";
            default:
                return "Không xác định";
        }
    }

    public static String parseCustomerType(int target) {
        switch (target) {
            case 1:
                return "Diamond";
            case 2:
                return "Platinum";
            case 3:
                return "Gold";
            case 4:
                return "Silver";
            case 5:
                return "Member";
            default:
                return "Không xác định";
        }
    }

    public static String parseRentalType(int target) {
        switch (target) {
            case 1:
                return "thuê theo năm";
            case 2:
                return "thuê theo tháng";
            case 3:
                return "thuê theo ngày";
            case 4:
                return "thuê theo giờ";
            default:
                return "Không xác định";
        }
    }
}
