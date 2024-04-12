package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

//@Controller
@RestController
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	//리스트
	//@ResponseBody --> Method가 GET == GetMapping 그만
	@GetMapping(value="/api/guests")
	public List<GuestbookVo> list() {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> guestbookList = guestbookService.exeGuestList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	//저장 & 1명 데이터 불러오기 --> Method가 POST == PostMapping
	//@ResponseBody
	@PostMapping(value="/api/guests")
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		System.out.println(guestbookVo);
		GuestbookVo guestVo = guestbookService.exeGuestAdd(guestbookVo);
		System.out.println(guestVo);
		return guestVo;
	}
	
	//삭제 --> Method가 DELETE == DeleteMapping
	//@ResponseBody
	@DeleteMapping(value="/api/guests/{no}")
	public String remove(@PathVariable("no") int no, @RequestBody GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.remove()");
		guestbookVo.setNo(no);
		System.out.println(guestbookVo);
		int count = guestbookService.exeRemove(guestbookVo);
		String result = "{\"count\": " + count + "}";
		System.out.println(result);
		return result;
	}
	
}
