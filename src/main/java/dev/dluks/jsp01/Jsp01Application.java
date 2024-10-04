package dev.dluks.jsp01;

import dev.dluks.jsp01.entities.Order;
import dev.dluks.jsp01.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class Jsp01Application implements CommandLineRunner {

    private final OrderService orderService;

    public Jsp01Application(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Jsp01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);

        Order order = new Order(1034, 150.0, 20.0);

        System.out.printf("Pedido código %d%n", order.getCode());
        System.out.printf("Valor total: R$ %.2f", orderService.total(order));

    }
}
