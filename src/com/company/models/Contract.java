package com.company.models;

public class Contract {
    /**
     * Số hợp đồng
     */
    private int contractNo;

    /**
     * Mã booking
     */
    private String bookingId;

    /**
     * Số tiền cọc trước
     */
    private double advanceDepositAmount;

    /**
     * Tổng số tiền thanh toán
     */
    private double totalPaymentAmount;

    /**
     * Mã khách hàng
     */
    private String customerId;

    public Contract() {
    }

    public Contract(int contractNo, String bookingId, double advanceDepositAmount, double totalPaymentAmount, String customerId) {
        this.contractNo = contractNo;
        this.bookingId = bookingId;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerId = customerId;
    }

    public int getContractNo() {
        return contractNo;
    }

    public void setContractNo(int contractNo) {
        this.contractNo = contractNo;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
