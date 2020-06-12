package com.front.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;




public class ColorDTO {
 
   
    private String name;
     
    private String color;
    
    @JsonInclude(Include.NON_NULL)
    private List<ColorDTO> childColorData;
    


	public List<ColorDTO> getChildColorData() {
		return childColorData;
	}


	public void setChildColorData(List<ColorDTO> childColorData) {
		this.childColorData = childColorData;
	}
	
	public void addChildColorData(ColorDTO childDTO) {
		if(childColorData == null) {
			childColorData  = new ArrayList<ColorDTO>();
		}
		childColorData.add(childDTO);
	}


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


    

}