package com.ycw.service.impl;

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ycw.dao.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycw.entity.Diary;
import com.ycw.entity.DiaryExample;
import com.ycw.service.DiaryService;
import com.ycw.util.ResponseData;
import com.ycw.util.UtilAll;
import redis.clients.jedis.Jedis;

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
	public ResponseData getById(int id) {
		String key = "user-" + id;
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功："+jedis.ping());
		boolean hasKey = jedis.exists(key);
		if(hasKey){
			String aa = jedis.get(key);
			System.out.println("获取本地缓存aa:"+aa);
			Diary a = dm.selectByPrimaryKey(id);
			return ResponseData.markSuccess(a);
		}else{
			Diary a = dm.selectByPrimaryKey(id);
			String aaa = jedis.set(key,a+"");
			System.out.println("本地缓存插入数据aaa:"+aaa);
			return ResponseData.markSuccess(a);
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
