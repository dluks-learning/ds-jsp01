package dev.dluks.jsp01.services;

import dev.dluks.jsp01.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {

        double total = order.getBasic() - order.getDiscount();
        return total + shippingService.shipment(order);
    }

}
