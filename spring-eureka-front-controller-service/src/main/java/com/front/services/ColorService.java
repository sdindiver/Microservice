package com.front.services;

import java.util.List;

import com.front.DTO.ColorDTO;


public interface ColorService {
	
	public ColorDTO getColorData(Integer id);
	public List<ColorDTO> getColorDatas();


}
