package com.cos.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameInfos {
	private int id;
	private String gamename;
	private String price;
	private String image;
	private String movie;
	private String developer;
	private String publisher;
	private String explanation;
	private String tags;
	private String rating;
	private String releasedate;
	private String platform;
	private String minOS;
	private String minProcessor;
	private String minMemory;
	private String minGraphics;
	private String minDirectX;
	private String minStorage;
	private String recomOS;
	private String recomProcessor;
	private String recomMemory;
	private String recomGraphics;
	private String recomDirectX;
	private String recomStorage;
	private String languagesSupported;
	private String freeDown;
	private String gamePlayImage1;
	private String gamePlayImage2;
	private String gamePlayImage3;

}
