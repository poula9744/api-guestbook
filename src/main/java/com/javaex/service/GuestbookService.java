package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	//리스트 가져오기
	public List<GuestbookVo> exeGuestList(){
		System.out.println("GuestbookService.exeGuestList()");
		List<GuestbookVo> guestbookList = guestbookDao.guestbookSelectList();
		return guestbookList;
	}
	
	//저장
	public GuestbookVo exeGuestAdd(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeGuestAdd()");
		
		//저장
		guestbookDao.insertSelectKey(guestbookVo);
		
		//한 명 정보 가져오기
		GuestbookVo guestVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());
		
		return guestVo;
	}
	
	//삭제
	public int exeRemove(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeRemove()");
		
		int count = guestbookDao.guestbookRemove(guestbookVo);
		return count;
	}
}
