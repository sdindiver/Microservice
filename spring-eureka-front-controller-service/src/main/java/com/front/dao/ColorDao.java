package com.front.dao;

import java.util.List;

import com.front.entity.ColorData;


public interface ColorDao {
	
	public ColorData getColorData(Integer id);
	public List<ColorData> getColorDatas();


}
