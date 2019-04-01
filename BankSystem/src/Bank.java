import java.util.Arrays;

import org.omg.PortableInterceptor.ClientRequestInterceptor;

public class Bank {
	private Client[] clients = new Client[101];
	private Logger logService;
	// private accountUpdater;

	public Bank() {

	}

	public Bank(Client[] clients, Logger logService) {
		super();
		this.clients = clients;
		this.logService = logService;
	}

	// An empty constructor that instantiates the clinets array
	public Bank(Client[] clients) {

	}

	public float getBalance() {
		float sum = 0;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null) {
				sum += clients[i].getFortune();
			}

		}
		return sum;
	}

	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				clients[i] = client;

				Log log = new Log(System.currentTimeMillis(), client.getId(), "New Client has beed added",
						client.getBalance());
				Logger logger = new Logger("c:");
				logger.Log(log);
				return;
			}
		}
	}

	public void removeClient(int id) {
		for (int i = 0; i < clients.length; i++) {
			if ((clients[i] != null) && (clients[i].getId() == id)) {
				Log log = new Log(System.currentTimeMillis(), clients[i].getId(), "Client has been removed",
						clients[i].getBalance());
				Logger logger = new Logger("C:");
				logger.Log(log);
				clients[i] = null;
				return;

			}
		}
		System.out.println("No such client ID");
	}

	public Client[] getClients() {
		return clients;
	}

	public void setClients(Client[] clients) {
		this.clients = clients;
	}

	public Logger getLogService() {
		return logService;
	}

	public void setLogService(Logger logService) {
		this.logService = logService;
	}

	@Override
	public String toString() {
		return "Bank [clients=" + Arrays.toString(clients) + ", logService=" + logService + ", getClients()="
				+ Arrays.toString(getClients()) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(clients);
		result = prime * result + ((logService == null) ? 0 : logService.hashCode());
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
		Bank other = (Bank) obj;
		if (!Arrays.equals(clients, other.clients))
			return false;
		if (logService == null) {
			if (other.logService != null)
				return false;
		} else if (!logService.equals(other.logService))
			return false;
		return true;
	}

}
