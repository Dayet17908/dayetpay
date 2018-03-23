package com.sevenpay.bms.basemanager.photo.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.photo.bean.CertificateAuth;
import com.sevenpay.bms.basemanager.photo.mapper.PhotoMapper;

@Repository
public class PhotoDAO {

	@Autowired
	private PhotoMapper photoMapper;
	
	/**
	 * 分页记录
	 * @param photo
	 * @return
	 */
	@Page
	public List<CertificateAuth> list(CertificateAuth queryBean){
		
		return photoMapper.list(queryBean);
	}
}
