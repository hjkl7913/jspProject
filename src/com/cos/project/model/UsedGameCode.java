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
public class UsedGameCode {
	private int id;
	private int userId;
	private int gameId;
	private String gamename;
	private String gameCode;
	private Timestamp useDate;
}
