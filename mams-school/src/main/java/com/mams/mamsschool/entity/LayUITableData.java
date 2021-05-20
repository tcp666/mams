package com.mams.mamsschool.entity;

import lombok.Data;
import java.util.List;

@Data
public class LayUITableData<T> {
	List<T> data;
	private String code;
	private String msg;
	private Integer count;
}



