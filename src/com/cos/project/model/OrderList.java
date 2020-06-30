package com.cos.project.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderList {
	private int orderId;
	private int gameId;
	private int userId;
	private String gamename;
	private Timestamp buyDate;
}
