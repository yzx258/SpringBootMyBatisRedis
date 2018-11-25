package com.ycw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycw.dao.DiaryMapper;
import com.ycw.entity.Diary;
import com.ycw.entity.DiaryExample;
import com.ycw.service.DiaryService;
import com.ycw.util.ResponseData;
import com.ycw.util.UtilAll;
@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private DiaryMapper dm;
	
	@Override
	public ResponseData getAll() {
		DiaryExample example = new DiaryExample();
		example.createCriteria().andContentEqualTo("");
		List<Diary> list = dm.selectByExample(null);
		if(list.size()>0) {
			return ResponseData.markSuccess(list);
		}else{
			return ResponseData.markSuccessButNoData();
	}
	}

	@Override
	public ResponseData delete(int id) {
		int i = dm.deleteByPrimaryKey(id);
		//List<Diary> list = dm.selectByExample(null);
		if(i==1) {
			List<Diary> list = dm.selectByExample(null);
			return ResponseData.markSuccess(list);
		}else {
			return ResponseData.markCustom(false, "0", "删除数据失败", i);
		}
	}

	@Override
	public ResponseData update(Diary d) {
		d.setOkstatus(1);
		int i = dm.updateByPrimaryKeySelective(d);
		if(i==1) {
			List<Diary> list = dm.selectByExample(null);
			return ResponseData.markSuccess(list);
		}else {
			return ResponseData.markCustom(false, "0", "修改数据失败", i);
		}
	}

	@Override
	public ResponseData add(Diary d) {
		d.setCtime(UtilAll.getTime(0));
		int i = dm.insertSelective(d);
		if(i==1) {
			List<Diary> list = dm.selectByExample(null);
			return ResponseData.markSuccess(list);
		}else {
			return ResponseData.markCustom(false, "0", "新增数据失败", i);
		}
	}

	@Override
	public ResponseData updateOkstatus(Diary d) {
		d.setOkstatus(0);
		int i = dm.updateByPrimaryKeySelective(d);
		if(i==1) {
			List<Diary> list = dm.selectByExample(null);
			return ResponseData.markSuccess(list);
		}else {
			return ResponseData.markCustom(false, "0", "修改数据失败", i);
		}
	}
}
