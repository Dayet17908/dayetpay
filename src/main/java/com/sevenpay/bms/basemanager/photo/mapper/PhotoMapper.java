package com.sevenpay.bms.basemanager.photo.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.photo.bean.CertificateAuth;
import com.sevenpay.bms.basemanager.photo.bean.Photo;

/**
 * 照片持久层
 * 
 * @author dayet
 * @date 2015.5.18
 */

@MapperScan
public interface PhotoMapper {

	/**
	 * 照片信息展现
	 * 
	 * @param photo
	 * @return
	 */
	public List<CertificateAuth> list(CertificateAuth photo);

	/**
	 * 查看用户证件详情
	 * 
	 * @param authId
	 * @return
	 */
	public Photo selectCustCertificate(int authId);
	/**
	 * 审核更新
	 * @param photo
	 * @return
	 */
	int update(CertificateAuth certificate);

}
