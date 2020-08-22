package com.proj.bookforyou.TendsAnalysis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;
import com.proj.bookforyou.MemberShip.UsrBookInfo;

import oracle.net.aso.b;

// 유저 성향 분석 객체

@Service
public class TendsAnalysisService implements ITendsAnalysisService {

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
	
	
	// 독자대상 기호 분석후에 도출된 성향 코드에 따른 출력문구 정리
	private final String A00 = "하나에 얽메이지 않고 <br/>다양한 문화를 좋아하시네요.";
	private final String A01 = "젊은 나이에도 <br/> 다양한 문학을 즐기시는군요.";
	private final String A10 = "실생활에 도움이되는 서적을 많이 읽는<br/> 현실적인 사람이군요.";
	private final String A40 = "본인에게 맞는책을 잘 읽으시네요";
	private final String A41 = "회원님은 연령에 비해 <br/>쉬운책을 자주 읽으시는것 같아요.<br/>" + 
	                		   "가끔은 조금 어려운 책을 읽어보는건 어떨까요 ?";
	private final String A50 = "참고서를 주로 보시는군요.<br/> 배움의 길은 끝이 없다고 하죠.";
	private final String A51 = "참고서를 자주보시네요!<br/> 혹시 자녀분을 두신걸까요 ?";
	private final String A52 = "참고서를 많이 읽으셨어요. <br/> 예전에 배운 것들이 그리워진 걸까요 ?";
	private final String A70 = "아동 도서를 많이 보시네요. <br/>  동화는 동심을 자극하죠.";
	private final String A90 = "전문도서를 많이 읽으시네요. <br/> 교수님이나 선생님 이실까요. 멋지시네요.";
	private final String A91 = "젊은 나이에 전문도서를 주로 읽으시는군요?<br/> 상당한 지식을 보유하셨나봐요.";
	
	// 내용분류 기호 분석후에 도출된 성향 코드에 따른 출력문구 정리
	
	
	private final String B00 ="다양한 지식을 추구하는 <br/> 박학다식한 사람이시네요.";
	private final String B10 ="삶에서 얻은것을 바탕으로 <br/>진리를 찾는.. <br/> 철학적인 삶을 사시는군요.";
	private final String B11 ="어린나이에도 불구하고 <br/>철학 서적을 정말 좋아하시네요.<br/> 세계 최연소 철학자가 아닐까요?";
	private final String B20 ="종교서적을 자주 보시는걸보면 <br/>신앙심이 매우 깊은 분일 것 같네요.";
	private final String B30 ="공학관련 서적을 많이 보시네요.<br/> 과학에 대한<br/>관심과 열정이 뚜렷하신분 같습니다.";
	private final String B60 ="예술에 대해 관심이 많으시군요.";
	private final String B70 ="각나라에 대한 <br/>문학과 언어에 관심이 많으시군요.";
	private final String B90 ="역사서적을 많이 읽으시네요.<br/>역사를 알면 미래가 보인다고하죠 <br/>회원님은 미래가 보이시나요?";
	
	
	// 로그인세션으로 받게될  회원데이터가 담긴 member 객체
	private BfuMember member;
	
	// 반환될 결과값
	private String resultComment = "";
	
	// 독자대상 기호 값 카운트 리스트
	private Map<String, Integer> ReaderSignCntMap;
	// 내용분류1 기호 값 카운트 리스트
	Map<String, Integer> contentsSignCntMap;

	
	// 분할된 독자대상 기호 저장 리스트
	List<String> ReaderSignLst;
	// 분할된 내용분류1 기호 저장 리스트
	List<String> contentsSignLst;
	// 쿼리결과로 받아온 사용자의 책정보 리스트
	List<UsrBookInfo> usrBookLst;
	//최대 기호값이 저장될 Map Entry
	Map.Entry<String, Integer> maxReaderSignEntry = null;
	Map.Entry<String, Integer> maxContentsSignEntry = null;
	
	public TendsAnalysisService() {
		ReaderSignCntMap = new HashMap<String, Integer>();
		contentsSignCntMap = new HashMap<String, Integer>();
		
		ReaderSignLst = new ArrayList<String>();
		contentsSignLst = new ArrayList<String>();
		
		}
	
	
	@Override
	public void setUsrBookLst(List<UsrBookInfo> usrBookLst, BfuMember member) {
		this.usrBookLst = usrBookLst;
		this.member = member;
		System.out.println(member.getAge());
		//System.out.println(usrBookLst);
		divideLst();
	}
	
	
	@Override
	public void divideLst() {
		for(UsrBookInfo usr : usrBookLst) {
			ReaderSignLst.add(usr.getAddcode().substring(0,1));
			contentsSignLst.add(usr.getAddcode().substring(2,3));
		}
		
		setSignCntMap();
	}
	
	@Override
	public void setSignCntMap() {

		for(String reader : ReaderSignLst) {
			ReaderSignCntMap.put(reader,ReaderSignCntMap.getOrDefault(reader, 0)+1);
		}
		
		for(String reader : contentsSignLst) {
			contentsSignCntMap.put(reader,contentsSignCntMap.getOrDefault(reader, 0)+1);
		}
		
		System.out.println(ReaderSignCntMap);
		System.out.println(contentsSignCntMap);
		
		calMaxSignValue();
	}
	
	@Override
	public void calMaxSignValue() {		
		for(Map.Entry<String, Integer> entry : ReaderSignCntMap.entrySet()) {
			if(maxReaderSignEntry == null || entry.getValue().compareTo(maxReaderSignEntry.getValue())>0) {
				maxReaderSignEntry = entry;
			}
		}
		
		for(Map.Entry<String, Integer> entry : contentsSignCntMap.entrySet()) {
			if(maxContentsSignEntry == null || entry.getValue().compareTo(maxContentsSignEntry.getValue())>0) {
				maxContentsSignEntry = entry;
			}
		}
		
		System.out.println("가장많은 독자대상 기호 =" +maxReaderSignEntry.getKey());
		System.out.println("가장많은 내용분류 기호 =" +maxContentsSignEntry.getKey());
		
		//System.out.println(getResult());
	}
	
	
	@Override
	public BfuMember getResult(List<UsrBookInfo> usrBookLst, BfuMember member) {
		
		System.out.println("getResult호출");
		setUsrBookLst(usrBookLst, member);
		
		resultComment = "";
		switch (maxReaderSignEntry.getKey()) {
		// 교양 서적을 가장 많이 봤을 때
		case "0":
			// 나이가 20대 이하 일때
			if(this.member.getAge() < 20)
				resultComment += A01;
			else 
				resultComment += A00;
			break;
		// 실용도서를 가장 많이 봤을때 
		case "1":
			resultComment += A10;
			break;
		//청소년 도서를 가장 많이 봤을 때
		case "4":
			// 청소년 도서를 가장 많이 본 사람중 나이가 20대 이상인 경우
			if(member.getAge() >=20)
				resultComment += A41;
			else
				resultComment += A40;
			
			break;
		// 초등 또는 중고등 참고서를 많이 봤을 때
		case "5":case "6":
			// 40대 이상일때
			if(member.getAge() >= 40)
				resultComment += A51;
			//20대에서 
			else if(20 <= member.getAge() && member.getAge() <= 30 )
				resultComment += A52;
			else
				resultComment += A50;
			break;
		// 아동 도서를 많이 봤을 때
		case "7":
			resultComment += A70;
			break;
		// 전문도서를 많이 봤을 때
		case "9":
			if(member.getAge() < 20) 
				resultComment += A91;
			else
				resultComment += A90;
			break;
		default:
			break;
		}
		
		resultComment +="<br/>그리고  ";
		
		switch (maxContentsSignEntry.getKey()) {
		case "0":	
			resultComment += B00;
			break;
		case "1":	
			// 연령 비교해서 확인 하고 추가
			if(member.getAge() <20)
				resultComment += B11;
			else
				resultComment += B10;
			break;
		case "2":	
			resultComment += B20;
			break;
		case "3":case"4":case"5":
			resultComment += B30;
			break;
		case "6":	
			resultComment += B60;
			break;
		case "7":case"8":	
			resultComment += B70;
			break;
		case "9":	
			resultComment += B90;
			break;
		default:
			break;
		}
		
		// 도출된 가장 많은 카운트의 기호값과 결과로 보내질 성향분석 코멘트를 세션 객체에 저장하고 반환
		member.setTendsResult(resultComment);
		member.setMaxReaderSign(maxReaderSignEntry.getKey());
		member.setMaxContentsSign(maxContentsSignEntry.getKey());
		
		return this.member;
	}
	
	

}
