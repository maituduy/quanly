public class Client {
	private String ClientId;
	private Type type;

	public Client(String s, Type type) {
		this.ClientId = s;
		this.type = type;
	}

	void print() {
		System.out.println("ClientId = " + this.ClientId + ", type = " + this.type);  
	}
	Type getType() {
		return this.type;
	}
	@Override
	public String toString() {
		return "Client [ClientId=" + ClientId + ", type=" + type + "]";
	}
	public void setClientId(String clientId) {
		ClientId = clientId;
	}
	public void setType(Type type) {
		this.type = type;
	}
	String getClientId() {
		return this.ClientId;
	}
}
