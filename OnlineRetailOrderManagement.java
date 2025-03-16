// Base class Order
class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getOrderStatus() {
        System.out.println("Order ID: " + orderId + " placed on " + orderDate + " is being processed.");
    }
}

// Subclass ShippedOrder extending Order
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Order has been shipped. Tracking Number: " + trackingNumber);
    }
}

// Subclass DeliveredOrder extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Order delivered on: " + deliveryDate);
    }
}

// Main class to demonstrate multilevel inheritance
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(1001, "2025-03-11", "TRK12345", "2025-03-15");
        order.getOrderStatus();
    }
}
