package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface FridgeMapper {

	  @Select("SELECT no,ingre_name "
			 +"FROM fridge_ingredient "
			 +"WHERE ingre_name LIKE '%'||#{ingre_name}||'%'")
	  public List<FridgeVO> fridge_ingre_search(String ingre_name);
}
