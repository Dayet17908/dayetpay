package com.sevenpay.bms.accounting.unionpayQuery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqual;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqualBean;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultEqualExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultException;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultExceptionBean;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpaySevenResultExceptionExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.BalUnionpayUnionResultException;
import com.sevenpay.bms.accounting.unionpayQuery.bean.UnionpayImpeathExport;
import com.sevenpay.bms.accounting.unionpayQuery.bean.UnionpayUnionResultExceptionBean;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface UnionpayResultMapper {


	/**
	 * 银联存疑列表
	 * @param unionpayUnionResultExceptionBean
	 * @return
	 */
	public List<BalUnionpayUnionResultException> selectImpeachList(UnionpayUnionResultExceptionBean unionpayUnionResultExceptionBean);
	
	/**
	 * 银联存疑导出数据
	 * @param unionpayUnionResultExceptionBean
	 * @return
	 */
	public List<UnionpayImpeathExport> selectImpeachListExport(UnionpayUnionResultExceptionBean unionpayUnionResultExceptionBean);
	
	/**
	 * 七分钱存疑列表
	 * @param balUnionpaySevenResultExceptionBean
	 * @return
	 */
	public List<BalUnionpaySevenResultException> selectQfqImpeachList(BalUnionpaySevenResultExceptionBean balUnionpaySevenResultExceptionBean);
	
	/**
	 * 七分钱存疑导出
	 * @param balUnionpaySevenResultExceptionBean
	 * @return
	 */
	public List<BalUnionpaySevenResultExceptionExport> selectQfqImpeachExport(BalUnionpaySevenResultExceptionBean balUnionpaySevenResultExceptionBean);
	
	/**
	 * 差错报表数据
	 * @param balUnionpaySevenResultExceptionBean
	 * @return
	 */
	public List<BalUnionpaySevenResultException> selectSlipList(BalUnionpaySevenResultExceptionBean balUnionpaySevenResultExceptionBean);
	
	/**
	 * 导出差错报表
	 * @param requestBean
	 * @return
	 */
	public List<BalUnionpaySevenResultExceptionExport> selectSlipExport(BalUnionpaySevenResultExceptionBean requestBean);
	
	
	/**
	 * 一致报表
	 * @param balUnionpaySevenResultEqualBean
	 * @return
	 */
	public List<BalUnionpaySevenResultEqual> selectFitList(BalUnionpaySevenResultEqualBean balUnionpaySevenResultEqualBean);
	
	/**
	 * 导出一致报表
	 * @param balUnionpaySevenResultEqualBean
	 * @return
	 */
	public List<BalUnionpaySevenResultEqualExport> selectFitexport(BalUnionpaySevenResultEqualBean balUnionpaySevenResultEqualBean);

}
