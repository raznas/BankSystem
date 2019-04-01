import java.util.Arrays;

public class Client {
	private int id;
	private String name;
	private float balance;
	private Account[] accounts = new Account[5];
	private float commissionRate = 0;
	private float interestRate = 0;
	private Logger logger;

	public Client() {

	}

	public Client(int id, String name, float balance) {
		setId(id);
		setName(name);
		setBalance(balance);
		

	}

	public void addAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			// if ((accounts[i]==null) && (accounts[i].getId() == account.getId())){
			if ((accounts[i] == null)) {
				accounts[i] = account;
				return;

			}
			// System.out.println("Duplicate ID");

		}
		System.out.println("Account list is full, cannot add " + account);
		Log log = new Log(System.currentTimeMillis(), getId(), " new balance ", balance);
		System.out.println("The following is the log from addAccount method: ");
		System.out.println(log);
		Logger logger = new Logger("c://");
		logger.Log(log);
	}

	public void getAccount() {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				System.out.println(accounts[i]);

			}

		}
		return;
	}

	public void removeAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].equals(account)) {
				accounts[i] = null;
				setBalance(getBalance() + account.getBalance());
				Log log = new Log(System.currentTimeMillis(), account.getId(), " Has been removed ",
						account.getBalance());
				System.out.println(log);
				Logger logger = new Logger("c:");
				logger.Log(log);
				return;

			}
		}
		System.out.println("Account does not exist, nothing to remove! ");
	}

	public void deposit(float amount) {
		balance += (amount - (amount * commissionRate));

	}

	public void withdraw(float amount) {
		balance -= (amount - (amount * commissionRate));
	}
	
	public void autoUpdateAccounts() {
		
		for (int i=0;i<accounts.length; i++) {
			if (accounts[i] != null) {
				accounts[i].setBalance(accounts[i].getBalance() +(accounts[i].getBalance()* interestRate));
				Log log = new Log(System.currentTimeMillis(), getId(), "Account daily interest updated ", accounts[i].getBalance());
				Logger logger = new Logger("c:");
				logger.Log(log);
			}
		}
	}

	public float getFortune() {
		float sum = getBalance();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				sum += accounts[i].getBalance();
			}

		}

		return sum;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", balance=" + balance+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(accounts);
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + Float.floatToIntBits(commissionRate);
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(interestRate);
		result = prime * result + ((logger == null) ? 0 : logger.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (!Arrays.equals(accounts, other.accounts))
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (Float.floatToIntBits(commissionRate) != Float.floatToIntBits(other.commissionRate))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(interestRate) != Float.floatToIntBits(other.interestRate))
			return false;
		if (logger == null) {
			if (other.logger != null)
				return false;
		} else if (!logger.equals(other.logger))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
