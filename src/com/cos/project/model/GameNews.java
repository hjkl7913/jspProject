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
public class GameNews {
	private int id;
	private int gameId;
	private String Image;
	private String content;
	private Timestamp createDate;
	private String timeAgo;
}
