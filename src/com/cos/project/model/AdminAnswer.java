package com.cos.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminAnswer {
	private int answerId;
	private int userId;
	private String displayName;
	private String email;
	private String platform;
	private String language;
	private String question;
	private String answer;
	private String writeDate;
	private String answerDate;
}
