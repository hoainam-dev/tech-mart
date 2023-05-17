package model;

public class Order extends Product{
	private int id;
	private String user;
	private int quantity;
	private double price;
	private String address;
	
	public Order() {
	}
	
	public Order(int id, String user, int quantity, double price, String address) {
		this.id = id;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
