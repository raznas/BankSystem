
public class Log {
	//Data members
	private long timeStamp;
	private int clientId;
	private String description;
	private float amount;

	//Empty constructor
	public Log() {

	}

	//Full constructor
	public Log(long timeStamp, int clientId, String description, float amount) {

		setTimeStamp(timeStamp);
		setClientId(clientId);
		setDescription(description);
		setAmount(amount);
	}
	
	//Methods
	public String getData() {
		return "Client ID "+ clientId +" has " +  description + " " +amount +" amount at " + timeStamp;
	
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Log [timeStamp=" + timeStamp + ", clientId=" + clientId + ", description=" + description + ", amount="
				+ amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + clientId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
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
		Log other = (Log) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (clientId != other.clientId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		return true;
	}

	
}
