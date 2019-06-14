package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.dao.OrderRepository;
import fr.smeal.subscription.model.Order;
import fr.smeal.subscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder() {
        Order order = new Order();
        order.setConversionRate(new BigDecimal(1));
        order.setCurrentState(2);
        order.setGift(false);
        order.setIdAddressDelivery(4);
        order.setIdAddressInvoice(4);
        order.setIdCarrier(2);
        order.setIdCart(5);
        order.setIdCurrency(1);
        order.setIdCustomer(1);
        order.setIdLang(1);
        order.setPaiyment("Chèque");
        order.setReference("REF007");
        order.setRecyclable(true);
        order.setTotalPaid(new BigDecimal(99.99));
        order.setTotalPaidTaxIncluded(new BigDecimal(88.88));
        order.setInvoiceDate(new Date());
        order.setDeliveryDate(new Date());
        order.setDateAdd(new Date());
        order.setDateUpdate(new Date());
        order.setValid(true);

        order = orderRepository.save(order);

        return order;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
