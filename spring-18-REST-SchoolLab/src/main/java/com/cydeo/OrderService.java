package com.cydeo;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.PaymentDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderList();
    void updateOrder(OrderDTO order);
    void createOrder(OrderDTO order);
    List<OrderDTO> listOrderByPaymentMethod(PaymentDTO paymentMethod);
    List<OrderDTO> listOrderByEmail(String email);
}
