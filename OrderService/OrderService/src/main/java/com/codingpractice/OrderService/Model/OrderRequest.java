package com.codingpractice.OrderService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long productId;
    private long amount;
    private long quantity;
    private PaymentMode paymentmode;
}
