public class Payment {
	private double amount;
	double getAmount() {
		return amount;
	}

	public Payment(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"amount=" + amount +
				'}';
	}
}
