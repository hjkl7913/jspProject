package com.cos.project.Dto;

import com.cos.project.model.OrderList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderListResponseDto {
	private OrderList orderList;
	private String contentImage;
	private String price;
}
