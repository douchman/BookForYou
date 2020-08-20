package com.proj.bookforyou.Recommend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 유저 성향 분석 객체


public class TendsAnalysis implements ITendsAnalysis {

	private final String [] readerTxtLst= {"교양","실용","청소년","중고등참고서","초등참고서","아동","전문"};
	private final String [] publishTxtLst= {"문고본","사전","신서판","단행본","전집","전자출판물","도감","만화","혼합자료"};
	private final String [][] contentsClassLst = {
			{"컴퓨터과학","도서학","문헌","백과사전","강연집","간행물","박물관","신문","총서","향토자료"},
			{"철학","형이상학","인간학","철학체계","사서","동양철학","서양철학","논리학","심리학","윤리학"},
			{"종교","비교종교학","불교","천주교","도교","천도교","","힌두교","이슬람교","기타종교"},
			{"사회과학","통계학","경영학","사회학","정치학","행정학","법학","교육학","풍속","군사학"},
			{"자연과학","수학","물리학","화학","천문학","지구과학","광물학","생명과학","식물학","동물학"},
			{"기술과학","의학","농학","공학","건축공학","기계공학","전기공학","화학공학","제조업","생활과학"},
			{"","조형예술","장식미술","서예","회화","사진예술","음악","공연예술","스포츠"},
			{"한국어","중국어","아시아어","영어","독일어","프랑스어","스페인어","이탈리아어","기타언어"},
			{"한국문학","중국문학","아시아문학","영미문학","독일문학","프랑스문학","스페인문학","이탈리아문학","기타문학"},
			{"아시아역사","유럽역사","아프리카역사","북아메리카역사","남아메리카역사","오세아니아역사","","지리","전기"}
	};
	// 독자대상 기호값 저장
	List<Map<String, Integer>> ReaderSignLst;
	// 발행형태 기호값 저장
	List<Map<String, Integer>> PublishSignLst;
	// 내용분류1 기호값
	List<Map<String, Integer>> contentsSignLstA;
	// 내용분류2 기호값
	List<Map<String, Integer>> contentsSignLstB;
	//String [][] contentsClassArr;
	
	List<String> usrBookLst;
	
	public TendsAnalysis() {
		ReaderSignLst = new ArrayList<Map<String, Integer>>();
		PublishSignLst = new ArrayList<Map<String, Integer>>();
		contentsSignLstA = new ArrayList<Map<String, Integer>>();
		contentsSignLstB = new ArrayList<Map<String, Integer>>();
		}
	
	
	@Override
	public void setUsrBookLst(List<String> usrBookLst) {
		this.usrBookLst = usrBookLst;
	}
	
	
	// 데이터를 가공하여 분석한 성향 결과를 어떻게 전달할까?
	

}
