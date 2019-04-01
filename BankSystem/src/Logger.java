
public class Logger {
	// Data member
	private String driverName;

	// Constructors
	public Logger(String driverName) {
		setDriverName(driverName);
	}

	public Logger() {

	}

	// Methods
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	//print Log.getData on screen
	public void Log(Log log) {
	//	Log log1 = new Log(System.currentTimeMillis(), log.getClientId(), log.getDescription(), log.getAmount());
		log.getData();
	//	System.out.println(log1.getData());
	}
	
	//logs array - not in use for now
	public Log [] getLogs() {
		return getLogs();
	}
	
	@Override
	public String toString() {
		return "Logger [driverName=" + driverName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
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
		Logger other = (Logger) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		return true;
	}

	
}
