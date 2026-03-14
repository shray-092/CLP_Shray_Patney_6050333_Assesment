package cg.demo.association.test;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="abes_order")
public class Order {

    @Id
    @GeneratedValue()
  
    private int orderId;

  
    private Date orderDate;

  
    private double orderAmt;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {}
    public Order(Date orderDate, double orderAmt) {
		this.orderDate = orderDate;
		this.orderAmt = orderAmt;
	}

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}