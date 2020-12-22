package com.capgemini.addressbookapp.persondto;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
public @Data class ResponseDTO {
	public String msg;
	public Object obj;
}

