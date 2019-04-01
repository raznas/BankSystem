

public class Test {

	public static void main(String[] args) {
		Log l1 = new Log(System.currentTimeMillis(), 123, "bla bla", 10);
		System.out.println(l1);
		System.out.println(l1.getData());

		Logger driver = new Logger("c:");
		System.out.println(driver);
		System.out.println("Start");
		
		Account a1 = new Account(301, 100);
		System.out.println(a1);
		a1.setBalance(150);
		System.out.println(a1);
		
						
		Client c1 = new Client(12, "test", 122);
		System.out.println(c1);
		
		System.out.println("##########");
		System.out.println("Testing accounts");
		Account a2 = new Account(302, 200);
		Account a3 = new Account(0, 300);
		Account a4 = new Account(304, 400);
		Account a5 = new Account(305, 500);
		Account a6 = new Account(305, 600);
		c1.addAccount(a1);
		System.out.println(c1);
		System.out.println("Account a1");
		System.out.println(a1);
		c1.addAccount(a2);
		c1.addAccount(a3);
		c1.addAccount(a4);
		//c1.addAccount(a5);
		System.out.println(c1);
		c1.addAccount(a6);
		System.out.println(c1);
		
		System.out.println("#### Testing getAccount #####");
		c1.getAccount();
		System.out.println(c1.getBalance());
		System.out.println("#### Testing removeAccount #####");
		c1.removeAccount(a2);
		c1.getAccount();
		c1.getBalance();
		System.out.println(c1.getBalance());
		System.out.println("#### Testing removeAccount #####");
		c1.removeAccount(a2);
		c1.getAccount();
		c1.getBalance();
		System.out.println(c1.getBalance());
		System.out.println("");
		System.out.println("#### Testing deposit #####");
		System.out.println(c1.getBalance());
		c1.deposit(100);
		System.out.println(c1.getBalance());
		System.out.println("#### Testing withdraw #####");
		c1.withdraw(100);
		System.out.println(c1.getBalance());
		System.out.println("#### Testing getFortune #####");
		System.out.println(c1.getFortune());
		
		System.out.println("#### Testing new client #####");
		Client c2 = new Client(234, "avi", 70);
		Account b1 = new Account(1, 100);
		Account b2 = new Account(2, 50);
		c2.addAccount(b1);
		c2.addAccount(b2);
		c2.getAccount();
		c2.getBalance();
		c2.getFortune();
		System.out.println(c2.getFortune());
		System.out.println("#### Interst update #####");
		c2.autoUpdateAccounts();
		c2.getBalance();
		System.out.println(c2.getFortune());
		System.out.println("#### Testing Bank #####");
		Bank bank1 = new Bank();
		bank1.addClient(c2);
		bank1.addClient(c1);
		System.out.println(bank1.getClients());
		System.out.println(bank1.getBalance());
		System.out.println("#### Remove client #####");
		Client c3 = new Client(222, "gog", 10000);
		System.out.println(c3);
		bank1.addClient(c3);
		bank1.removeClient(222);
		System.out.println(c3);
		
	}

}
