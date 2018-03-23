package com.sevenpay.bms.bal.filereceive.mapper;

import java.util.List;

import com.sevenpay.bms.bal.filereceive.bean.FileReceive;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;




/**
 * 
 * @author li.shi
 * @date 2017年2月23日
 *
 */

@MapperScanCombinedmaster 
public interface FileReceiveMapper {
	
	List<FileReceive> selectFileReceiveList(FileReceive queryBean);

	FileReceive selectByFileName(FileReceive queryBean);

	int updateFile(FileReceive updateBean);

	int insertFile(FileReceive insertBean);
	
	/*public List<AgentMerInfo> selectAgentMerInfo(AgentMerInfo agentMerInfo);*/
	
}
