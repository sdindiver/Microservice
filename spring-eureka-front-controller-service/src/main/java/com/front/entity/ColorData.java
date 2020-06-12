package com.front.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="color_data")
public class ColorData {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
     
    @Column(name="name")
    private String name;
     
    @Column(name="color")
    private String color;
    
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ColorData> childColorData;
    
    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn(name="parentid", nullable=false)
    private ColorData parent;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public List<ColorData> getChildColorData() {
		return childColorData;
	}


	public void setChildColorData(List<ColorData> childColorData) {
		this.childColorData = childColorData;
	}


	public ColorData getParent() {
		return parent;
	}


	public void setParent(ColorData parent) {
		this.parent = parent;
	}
     
    
    
    

}