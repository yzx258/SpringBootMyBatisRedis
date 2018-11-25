package com.ycw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycw.entity.Diary;
import com.ycw.service.DiaryService;
import com.ycw.util.ResponseData;

@Controller
@RequestMapping("/Diary")
public class DiaryController {

	@Autowired
	private DiaryService service;
	
	@ResponseBody
	@RequestMapping(path="/getAll",method=RequestMethod.GET)
	public ResponseData getAll() {
		return service.getAll();
	}
	
	@ResponseBody
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ResponseData add(@Valid Diary d) {
		System.out.println(d.getContent());
		System.out.println(d.getCtime());
		return service.add(d);
	}
	
	@ResponseBody
	@RequestMapping(path="/delete",method=RequestMethod.DELETE)
	public ResponseData delete(String id) {
		System.out.println(id);
		return service.delete(Integer.parseInt(id));
	}
	
	@ResponseBody
	@RequestMapping(path="/update",method=RequestMethod.PUT)
	public ResponseData update(@Valid Diary d) {
		System.out.println(d);
		return service.update(d);
	}
	
	@ResponseBody
	@RequestMapping(path="/updateOkstatus",method=RequestMethod.PUT)
	public ResponseData updateOktatus(@Valid Diary d) {
		System.out.println(d);
		return service.updateOkstatus(d);
	}
}
