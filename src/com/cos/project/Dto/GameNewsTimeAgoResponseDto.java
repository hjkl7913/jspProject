package com.cos.project.Dto;

import com.cos.project.model.GameNews;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameNewsTimeAgoResponseDto {
	private GameNews gameNews ;
	private String timeAgo;
}
