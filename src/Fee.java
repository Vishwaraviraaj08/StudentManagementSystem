public class Fee {
    private double totalAmount;
    private double paidAmount;
    private boolean isPaid = false;

    public Fee() {
        this.totalAmount = 0.0;
        this.paidAmount = 0.0;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount += paidAmount;
        if (this.paidAmount >= totalAmount) {
            isPaid = true;
        }
    }

    public void resetPaidAmount() {
        this.paidAmount = 0.0;
        this.isPaid = false;
    }

    public double getBalanceAmount() {
        return totalAmount - paidAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

}
