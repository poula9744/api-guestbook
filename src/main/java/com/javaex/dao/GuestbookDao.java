package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트 가져오기
	public List<GuestbookVo> guestbookSelectList() {
		System.out.println("GuestbookDao.guestbookSelectList()");
		List<GuestbookVo> guesbooktList = sqlSession.selectList("guestbook.list");
		return guesbooktList;
	}

	// 저장
	public int insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertSelectKey()");

		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);

		return count;
	}

	// 데이터 하나 가져오기: no주면 한 명 데이터 가져오기
	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");

		GuestbookVo guestVo = sqlSession.selectOne("guestbook.selectOne", no);

		return guestVo;
	}
	
	//삭제
	public int guestbookRemove(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestbookRemove()");
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		return count;
	}
}
