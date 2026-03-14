package cg.demo.association.test;
import java.util.List;

public interface OrderDao {
	public boolean addOrder(Order order,int custId);
	public Order getorder(int orderId);
	public List<Order> getOrders(String custName);

}
