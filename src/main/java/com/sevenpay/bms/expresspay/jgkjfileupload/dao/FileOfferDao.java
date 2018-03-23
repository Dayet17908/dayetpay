package com.sevenpay.bms.expresspay.jgkjfileupload.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.expresspay.jgkjfileupload.bean.FileOffer;
import com.sevenpay.bms.expresspay.jgkjfileupload.mapper.FileOfferMapper;

@Repository
public class FileOfferDao {
	@Autowired
	private FileOfferMapper fileOfferMapper;

	@Page
	public List<FileOffer> selectByBean(FileOffer queryBean) {

		return fileOfferMapper.selectByBean(queryBean);
	}
}
