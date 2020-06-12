package com.front.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.front.entity.ColorData;
import com.front.util.HibernateUtil;

@Repository
public class ColorDaoImpl implements ColorDao{
	@Override
	public ColorData getColorData(Integer id) {
		Session session = HibernateUtil.getSession();
		ColorData data = (ColorData) session.get(ColorData.class, id);
		return data;
	}

	
	
	

	@Override
	public List<ColorData> getColorDatas() {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(ColorData.class);
		List<ColorData> list = criteria.list();
		return list;
	}

}
