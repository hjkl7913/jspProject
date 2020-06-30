package com.cos.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cart {
		private int id;
		private int gameId;
		private int userId;
		private String gamename;
		private String contentImage;
		private String price;
		

}
