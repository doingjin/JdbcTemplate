package model.common;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.client.ClientService;
import model.client.ClientVO;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("BoardService");
		ClientService cs=(ClientService)factory.getBean("ClientService");
		
		BoardVO bvo=new BoardVO();
		ClientVO cvo=new ClientVO();
		
		// 게시글 작성 & 회원가입
		System.out.println("------------------------insert");
		
		bvo.setTitle("4th post");
		bvo.setCid("jj");
		bvo.setContent("진짜 마지막~!");
		bs.insertB(bvo);
		
		System.out.println();
		
		
		
		cvo.setCid("jay");
		cvo.setCname("제이");
		cvo.setPassword("1212");
		cs.insertC(cvo);
		
		System.out.println();
		
		// get 메서드 사용
		System.out.println("------------------------get");
		
		List<ClientVO> list=cs.getCList();
		for(ClientVO vo:list) {
			System.out.println(vo);
		}
		
		System.out.println();
		
		// 제목으로 검색--get-->
		bvo.setTitle("post");
		List<BoardVO> datas=bs.getBList(bvo);
		// System.out.println(datas.isEmpty());
		if(datas.isEmpty()) {
			System.out.println("'"+bvo.getTitle()+"'로 검색된 정보가 없습니다.");
		} else {
			for(BoardVO vo:datas) {
				System.out.println(vo);
			}
		}
		
		System.out.println();
		
		// 로그인
		System.out.println("------------------------login");
		cvo.setCid("jay");
		cvo.setPassword("1212");
		if(cs.login(cvo)!=null) {
			System.out.println(cvo.getCid()+": 🔥 LogIn SUCCESS 🔥");
		} else {
			System.out.println("❌ FAILED to login ❌");
		}
		System.out.println();
		
		
		
		factory.close();
	}
}
