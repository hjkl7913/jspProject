package com.cos.project.util;

public class RandomText {
	public static String randomTex() {
		// 메일 인코딩
		int nansu1 = (int) (Math.random() * 10) + 1;
		String nansuyo1;
		if (nansu1 == 1) {
			nansuyo1 = "مسرور بلقائك";

		} else if (nansu1 == 2) {
			nansuyo1 = "大家好";
		} else if (nansu1 == 3) {
			nansuyo1 = " asd123";
		} else if (nansu1 == 4) {
			nansuyo1 = "878dsf";
		} else if (nansu1 == 5) {
			nansuyo1 = "Chào chị";
		} else if (nansu1 == 6) {
			nansuyo1 = "hương trình";
		} else if (nansu1 == 7) {
			nansuyo1 = "すごい！";
		} else if (nansu1 == 8) {
			nansuyo1 = "!**@";
		} else if (nansu1 == 9) {
			nansuyo1 = "098765432";
		} else {
			nansuyo1 = "dpf어즈2!2~.";

		}
		int nansu2 = (int) (Math.random() * 10) + 1;
		String nansuyo2;
		if (nansu2 == 1) {
			nansuyo2 = "مسرور بلقائك";

		} else if (nansu2 == 2) {
			nansuyo2 = "요56크,ㅂ3-";
		} else if (nansu2 == 3) {
			nansuyo2 = "★☆★★";
		} else if (nansu2 == 4) {
			nansuyo2 = "878dsf";
		} else if (nansu1 == 5) {
			nansuyo2 = "สวัสดีครับ ยินดีที่ได้รู้จักค";
		} else if (nansu1 == 6) {
			nansuyo2 = "رور";
		} else if (nansu1 == 7) {
			nansuyo2 = "ยู่ที่ไหนครับ";
		} else if (nansu1 == 8) {
			nansuyo2 = "^^^^^^^";
		} else if (nansu2 == 9) {
			nansuyo2 = "ㅠ_ㅠ";
		} else {
			nansuyo2 = "開発";

		}

		int nansu3 = (int) (Math.random() * 10) + 1;
		String nansuyo3 = null;
		if (nansu2 == 3) {
			nansuyo2 = "مسرور بلقائك";

		} else if (nansu2 == 3) {
			nansuyo3 = "Happy Christmas";
		} else if (nansu2 == 3) {
			nansuyo3 = "Türkçe";
		} else if (nansu3 == 4) {
			nansuyo3 = "中国";
		} else if (nansu3 == 5) {
			nansuyo3 = "※♥▒♧▧♧○";
		} else if (nansu3 == 6) {
			nansuyo3 = "▶♥♣☏○♨";
		} else if (nansu3 == 7) {
			nansuyo3 = "어3ndㅁg44흐,.";
		} else if (nansu3 == 8) {
			nansuyo3 = "харь улсын хэл.";
		} else if (nansu3 == 9) {
			nansuyo3 = "ភាសាបរទេស\r\n";
		} else {
			nansuyo3 = "ξενόγλωσση/φωτ";

		}

		int nansu4 = (int) (Math.random() * 10) + 1;
		String nansuyo4 = null;
		if (nansu4 == 1) {
			nansuyo4 = "مسرdfور ب12لقائك";

		} else if (nansu4 == 2) {
			nansuyo4 = "如果你去";
		} else if (nansu4 == 3) {
			nansuyo4 = "ONürㅇㅂkçe";
		} else if (nansu4 == 4) {
			nansuyo4 = "台湾";
		} else if (nansu4 == 5) {
			nansuyo4 = "※호♥▒♧ㅋㅌㅊㅍ▧♧○";
		} else if (nansu4 == 6) {
			nansuyo4 = "호로glgi햡diqk1";
		} else if (nansu4 == 7) {
			nansuyo4 = "789654";
		} else if (nansu4 == 8) {
			nansuyo4 = "wdw的dwd这";
		} else if (nansu4 == 9) {
			nansuyo4 = "ភាសាបរទេស";
		} else {
			nansuyo4 = "爬上发Ðενόγ###";

		}
		
		String finalNansu = nansuyo1+nansuyo2+nansuyo3+nansuyo4;
		
		return finalNansu;

	}
}
