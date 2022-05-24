package com.company.services.impl;

import com.company.models.Facility;
import com.company.models.House;
import com.company.models.Room;
import com.company.models.Villa;
import com.company.services.IFacilityService;
import com.company.utils.MenuUtil;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class FacilityService implements IFacilityService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LinkedHashMap<Facility, Integer> facilityLinkedHashMap;

    static {
        facilityLinkedHashMap = new LinkedHashMap<>();

        facilityLinkedHashMap.put(new Villa("Hội An", 60, 10000000, 10, 1, "Cao cấp", 10, 3), 1);
        facilityLinkedHashMap.put(new Villa("Hội An 2", 100, 15000000, 15, 2, "Cao cấp", 16, 4), 7);
        facilityLinkedHashMap.put(new House("Đà Nẵng 1", 100, 15000000, 15, 2, "Cao cấp", 4), 6);
        facilityLinkedHashMap.put(new House("Đà Nẵng 2", 100, 7000000, 6, 3, "Cao cấp", 4), 5);
        facilityLinkedHashMap.put(new Room("Quảng Trị 1", 100, 7000000, 6, 3, "Ăn cơm buổi sáng"), 5);
        facilityLinkedHashMap.put(new Room("Quảng Trị 2", 100, 7000000, 6, 3, "Nhậu đêm khuya"), 5);
    }

    @Override
    public void displayMaintenances() {
        System.out.println("================== Danh sách Villa ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facilityLinkedHashMap.get(facility) >= 5 && facility instanceof Villa) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }

        System.out.println("================== Danh sách House ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facilityLinkedHashMap.get(facility) >= 5 && facility instanceof House) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }

        System.out.println("================== Danh sách Room ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facilityLinkedHashMap.get(facility) >= 5 && facility instanceof Room) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }
    }

    @Override
    public void add() {
        while (true) {
            System.out.println("======= Chọn loại dịch vụ muốn thêm =======");
            System.out.println("1.\tAdd New Villa");
            System.out.println("2.\tAdd New House");
            System.out.println("3.\tAdd New Room");
            System.out.println("4.\tBack to menu");

            switch (MenuUtil.choose(1, 4)) {
                case 1:
                    Villa villa = new Villa();
                    inputFacility(villa);

                    System.out.print("Nhập vào tiêu chuẩn phòng: ");
                    String roomStandard = scanner.nextLine();

                    System.out.print("Nhập vào Diện tích hồ bơi: ");
                    double poolArea = Double.parseDouble(scanner.nextLine());

                    System.out.print("Nhập vào số tầng: ");
                    int numberFloors = Integer.parseInt(scanner.nextLine());

                    villa.setRoomStandard(roomStandard);
                    villa.setPoolArea(poolArea);
                    villa.setNumberFloors(numberFloors);

                    facilityLinkedHashMap.put(villa, 0);
                    System.out.println("Đã thêm thành công!!!");
                    break;
                case 2:
                    House house = new House();
                    inputFacility(house);

                    System.out.print("Nhập vào tiêu chuẩn phòng: ");
                    String roomStandardHouse = scanner.nextLine();

                    System.out.print("Nhập vào số tầng: ");
                    int numberFloorsHouse = Integer.parseInt(scanner.nextLine());

                    house.setRoomStandard(roomStandardHouse);
                    house.setNumberFloors(numberFloorsHouse);

                    facilityLinkedHashMap.put(house, 0);
                    System.out.println("Đã thêm thành công!!!");
                    break;
                case 3:
                    Room room = new Room();
                    inputFacility(room);

                    System.out.print("Nhập vào dịch vụ miễn phí đi kèm: ");
                    String freeService = scanner.nextLine();

                    room.setFreeService(freeService);

                    facilityLinkedHashMap.put(room, 0);
                    System.out.println("Đã thêm thành công!!!");
                    break;
                default:
                    return;
            }
        }
    }

    private void inputFacility(Facility facility) {
        System.out.print("Nhập vào tên dịch vụ: ");
        String name = scanner.nextLine();

        System.out.print("Nhập vào diện tích sử dụng: ");
        double area = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập vào chi phí thuê: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập vào số người tối đa: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("======= Kiểu thuê =======");
        System.out.println("1 - thuê theo năm");
        System.out.println("2 - thuê theo tháng");
        System.out.println("3 - thuê theo ngày");
        System.out.println("4 - thuê theo giờ");
        int rentalType = MenuUtil.choose(1, 4);

        facility.setName(name);
        facility.setArea(area);
        facility.setPrice(price);
        facility.setMaxPeople(maxPeople);
        facility.setRentalType(rentalType);
    }


    @Override
    public void display() {
        System.out.println("================== Danh sách Villa ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facility instanceof Villa) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }

        System.out.println("================== Danh sách House ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facility instanceof House) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }

        System.out.println("================== Danh sách Room ==================");
        for (Facility facility : facilityLinkedHashMap.keySet()) {
            if (facility instanceof Room) {
                System.out.println(facility + " - Số lần sử dụng: " + facilityLinkedHashMap.get(facility));
            }
        }
    }
}
