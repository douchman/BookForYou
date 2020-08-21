package com.proj.bookforyou.Recommend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

// �쑀�� �꽦�뼢 遺꾩꽍 媛앹껜

@Service
public class TendsAnalysis implements ITendsAnalysis {

	private final String [] readerTxtLst= {"援먯뼇","�떎�슜","泥��냼�뀈","以묎퀬�벑李멸퀬�꽌","珥덈벑李멸퀬�꽌","�븘�룞","�쟾臾�"};
	private final String [] publishTxtLst= {"臾멸퀬蹂�","�궗�쟾","�떊�꽌�뙋","�떒�뻾蹂�","�쟾吏�","�쟾�옄異쒗뙋臾�","�룄媛�","留뚰솕","�샎�빀�옄猷�"};
	private final String [][] contentsClassLst = {
			{"而댄벂�꽣怨쇳븰","�룄�꽌�븰","臾명뿄","諛깃낵�궗�쟾","媛뺤뿰吏�","媛꾪뻾臾�","諛뺣Ъ愿�","�떊臾�","珥앹꽌","�뼢�넗�옄猷�"},
			{"泥좏븰","�삎�씠�긽�븰","�씤媛꾪븰","泥좏븰泥닿퀎","�궗�꽌","�룞�뼇泥좏븰","�꽌�뼇泥좏븰","�끉由ы븰","�떖由ы븰","�쑄由ы븰"},
			{"醫낃탳","鍮꾧탳醫낃탳�븰","遺덇탳","泥쒖＜援�","�룄援�","泥쒕룄援�","","�엺�몢援�","�씠�뒳�엺援�","湲고�醫낃탳"},
			{"�궗�쉶怨쇳븰","�넻怨꾪븰","寃쎌쁺�븰","�궗�쉶�븰","�젙移섑븰","�뻾�젙�븰","踰뺥븰","援먯쑁�븰","�뭾�냽","援곗궗�븰"},
			{"�옄�뿰怨쇳븰","�닔�븰","臾쇰━�븰","�솕�븰","泥쒕Ц�븰","吏�援ш낵�븰","愿묐Ъ�븰","�깮紐낃낵�븰","�떇臾쇳븰","�룞臾쇳븰"},
			{"湲곗닠怨쇳븰","�쓽�븰","�냽�븰","怨듯븰","嫄댁텞怨듯븰","湲곌퀎怨듯븰","�쟾湲곌났�븰","�솕�븰怨듯븰","�젣議곗뾽","�깮�솢怨쇳븰"},
			{"","議고삎�삁�닠","�옣�떇誘몄닠","�꽌�삁","�쉶�솕","�궗吏꾩삁�닠","�쓬�븙","怨듭뿰�삁�닠","�뒪�룷痢�"},
			{"�븳援��뼱","以묎뎅�뼱","�븘�떆�븘�뼱","�쁺�뼱","�룆�씪�뼱","�봽�옉�뒪�뼱","�뒪�럹�씤�뼱","�씠�깉由ъ븘�뼱","湲고��뼵�뼱"},
			{"�븳援�臾명븰","以묎뎅臾명븰","�븘�떆�븘臾명븰","�쁺誘몃Ц�븰","�룆�씪臾명븰","�봽�옉�뒪臾명븰","�뒪�럹�씤臾명븰","�씠�깉由ъ븘臾명븰","湲고�臾명븰"},
			{"�븘�떆�븘�뿭�궗","�쑀�읇�뿭�궗","�븘�봽由ъ뭅�뿭�궗","遺곸븘硫붾━移댁뿭�궗","�궓�븘硫붾━移댁뿭�궗","�삤�꽭�븘�땲�븘�뿭�궗","","吏�由�","�쟾湲�"}
	};
	// �룆�옄���긽 湲고샇媛� ���옣
	List<Map<String, Integer>> ReaderSignLst;
	// 諛쒗뻾�삎�깭 湲고샇媛� ���옣
	List<Map<String, Integer>> PublishSignLst;
	// �궡�슜遺꾨쪟1 湲고샇媛�
	List<Map<String, Integer>> contentsSignLstA;
	// �궡�슜遺꾨쪟2 湲고샇媛�
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
	
	
	// �뜲�씠�꽣瑜� 媛�怨듯븯�뿬 遺꾩꽍�븳 �꽦�뼢 寃곌낵瑜� �뼱�뼸寃� �쟾�떖�븷源�?
	

}
