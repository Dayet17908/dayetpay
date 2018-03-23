package com.sevenpay.bms.accounting.unionpayQuery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqual;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqualBean;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqualExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultException;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultExceptionBean;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultExceptionExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpayUnionResultException;
import com.sevenpay.bms.accounting.unionpayQuery.bean.UnionpayImpeathExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.UnionpayUnionResultExceptionBean;
import com.sevenpay.bms.accounting.unionpayQuery.dao.UnionpayDAO;
import com.sevenpay.bms.accounting.unionpayQuery.mapper.UnionpayResultMapper;

@Service
public class UnionpayService {

		
	@Autowired
	private UnionpayDAO unionpayDAO;
	
	@Autowired
	private UnionpayResultMapper UnionpayResultMapper;
	
	/**
	 * 银联存疑列表
	 * @param BalUnionpayUnionResultException
	 * @return
	 */
	public List<BalUnionpayUnionResultException> selectImpeachList(UnionpayUnionResultExceptionBean unionpayUnionResultExceptionBean){
		return unionpayDAO.selectImpeachList(unionpayUnionResultExceptionBean);
	}
	
	/**
	 * 银联存疑导出
	 * @param unionpayUnionResultExceptionBean
	 * @return
	 */
	public List<UnionpayImpeathExport> selectImpeachListExport(UnionpayUnionResultExceptionBean unionpayUnionResultExceptionBean){
		return UnionpayResultMapper.selectImpeachListExport(unionpayUnionResultExceptionBean);
	}
	
	/**
	 * 七分钱存疑列表
	 * @param balUnionpaySevenResultExceptionBean
	 * @return
	 */
	public List<BalUnionpaySevenResultException> selectQfqImpeachList(BalUnionpaySevenResultExceptionBean balUnionpaySevenResultExceptionBean){
		return unionpayDAO.selectQfqImpeachList(balUnionpaySevenResultExceptionBean);
	}
	
	/**
	 * 七分钱存疑导出
	 * @param requestBean
	 * @return
	 */
	public List<BalUnionpaySevenResultExceptionExport> selectQfqImpeachExport(BalUnionpaySevenResultExceptionBean requestBean) {
		return UnionpayResultMapper.selectQfqImpeachExport(requestBean);
	}
	
	/**
	 * 差错报表
	 * @param balUnionpaySevenResultExceptionBean
	 * @return
	 */
	public List<BalUnionpaySevenResultException> selectSlipList(BalUnionpaySevenResultExceptionBean balUnionpaySevenResultExceptionBean){
		return unionpayDAO.selectSlipList(balUnionpaySevenResultExceptionBean);
	}
	
	/**
	 * 导出差错报表
	 * @param requestBean
	 * @return
	 */
	public List<BalUnionpaySevenResultExceptionExport> selectSlipExport(
			BalUnionpaySevenResultExceptionBean requestBean) {
		return UnionpayResultMapper.selectSlipExport(requestBean);
	}
	
	/**
	 * 一致报表
	 * @param balUnionpaySevenResultEqualBean
	 * @return
	 */
	public List<BalUnionpaySevenResultEqual> selectFitList(BalUnionpaySevenResultEqualBean balUnionpaySevenResultEqualBean){
		return unionpayDAO.selectFitList(balUnionpaySevenResultEqualBean);
	}
	
	/**
	 * 导出一致报表
	 * @param balUnionpaySevenResultEqualBean
	 * @return
	 */
	public List<BalUnionpaySevenResultEqualExport> selectFitexport(BalUnionpaySevenResultEqualBean balUnionpaySevenResultEqualBean){
		return UnionpayResultMapper.selectFitexport(balUnionpaySevenResultEqualBean);
	}

}
