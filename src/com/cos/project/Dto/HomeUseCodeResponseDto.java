package com.cos.project.Dto;

import com.cos.project.model.GameCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeUseCodeResponseDto {
	private GameCode gameCode;
	private String gameImage;
}
