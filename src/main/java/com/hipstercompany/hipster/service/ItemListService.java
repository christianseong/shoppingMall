package com.hipstercompany.hipster.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hipstercompany.hipster.dao.ItemListDao;

@Service
public class ItemListService {
	@Autowired ItemListDao listdao;
	
	public HashMap<String, Object>getTopMain(){
		return listdao.getTopMain();
	}
}
