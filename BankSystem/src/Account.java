
public class Account {
	private int id;
	private float balance;

	public Account() {

	}

	public Account(int id, float balance) {
		setId(id);
		setBalance(balance);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		Log log = new Log(System.currentTimeMillis(), getId(), " new balance ", balance);
		System.out.println("The following is the log from setBalance method: ");
		System.out.println(log);
		Logger logger = new Logger("c://");

	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
