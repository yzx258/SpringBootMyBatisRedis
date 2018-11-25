package com.ycw.service;

import com.ycw.entity.Diary;
import com.ycw.util.ResponseData;

public interface DiaryService {

	/**
	 * 1.获取全部数据
	 * @return ResponseWrapper
	 */
	public abstract ResponseData getAll();
	
	/**
	 * 2.根据id删除数据
	 * @return ResponseData
	 */
	public abstract ResponseData delete(int id);
	
	/**
	 * 3.根据Diary修改数据
	 * @param d
	 * @return ResponseData
	 */
	public abstract ResponseData update(Diary d);
	
	/**
	 * 3.1 根据id修改数okstatus状态
	 * @param d
	 * @return ResponseData
	 */
	public abstract ResponseData updateOkstatus(Diary d);
	
	/**
	 * 4.新增一笔数据
	 * @param d
	 * @return ResponseData
	 */
	public abstract ResponseData add(Diary d);
	
}
