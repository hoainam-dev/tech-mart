package model;

public class OrderDetail {
	private int id;
	private int order_id;
	private int user_id;
	private double total;
	
	public OrderDetail() {
		
	}

	public OrderDetail(int id, int order_id, int user_id, double total) {
		this.id = id;
		this.order_id = order_id;
		this.user_id = user_id;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
}
