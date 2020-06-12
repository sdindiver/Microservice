package com.front.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.front.DTO.ColorDTO;
import com.front.dao.ColorDao;
import com.front.entity.ColorData;
import com.front.util.HibernateUtil;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;

	@Override
	public ColorDTO getColorData(Integer id) {
		HibernateUtil.openSession();
		ColorData colorData = colorDao.getColorData(id);
		ColorDTO dto = new ColorDTO();
		dto.setColor(colorData.getColor());
		dto.setName(colorData.getName());
		intializeObject(colorData, dto);
		HibernateUtil.closeSession();
		return dto;
	}

	public List<ColorDTO> getColorDatas() {
		HibernateUtil.openSession();
		List<ColorData> list = colorDao.getColorDatas();
		List<ColorDTO> dtoList = new ArrayList<>();
		for (ColorData data : list) {
			ColorDTO dto = new ColorDTO();
			dto.setColor(data.getColor());
			dto.setName(data.getName());
			intializeObject(data, dto);
			dtoList.add(dto);
		}
		HibernateUtil.closeSession();
		return dtoList;
	}

	private void intializeObject(ColorData data, ColorDTO dto) {
		List<ColorData> list = data.getChildColorData();
		if (list != null) {
			for (ColorData colorData : list) {
				if (colorData != null) {
					ColorDTO dto1 = new ColorDTO();
					dto1.setColor(colorData.getColor());
					dto1.setName(colorData.getName());
					dto.addChildColorData(dto1);
					intializeObject(colorData, dto1);

				}
			}
		}

	}
}