package com.company.models;

public class Contract implements Comparable<Contract> {
    /**
     * Số hợp đồng
     */
    private String contractNo;

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

    public Contract(String contractNo, String bookingId, double advanceDepositAmount, double totalPaymentAmount, String customerId) {
        this.contractNo = contractNo;
        this.bookingId = bookingId;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerId = customerId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
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

    @Override
    public int compareTo(Contract o) {
        return this.contractNo.compareTo(o.contractNo);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNo='" + contractNo + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
