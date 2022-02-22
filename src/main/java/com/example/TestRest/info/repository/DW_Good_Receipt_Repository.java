package com.example.TestRest.info.repository;

import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_Good_Receipt_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager txManager;

    
    @Bean
    public PlatformTransactionManager DW_Good_Receipt_transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    
	public DW_Good_Receipt_Repository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;
		this.txManager = DW_Good_Receipt_transactionManager(dataSource);
	}

	//PO 조회 - PO 번호
	public List<DW_Good_Receipt_Res_Param> ordList(DW_Good_Receipt_Req_Param req_param){

		DW_Good_Receipt_Sql.SELECT_QUERY(req_param );
		log.debug("ordList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Res_Param.class));
		return res;
	}


	//PO 상세조회
	public List<DW_Good_Receipt_Detail_Search_Res_Param> detailList(DW_Good_Receipt_Detail_Search_Req_Param req_param){

		DW_Good_Receipt_Sql.SELECT_Ord_Detail_QUERY(req_param );
		log.debug("detailList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Detail_Search_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Detail_Search_Res_Param.class));
		return res;
	}


	//바코드 스캔
	public List<DW_Good_Receipt_Scan_Res_Param> scanList(DW_Good_Receipt_Scan_Req_Param req_param){

		DW_Good_Receipt_Sql.SCAN_QUERY(req_param );
		log.debug("scanList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Scan_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Scan_Res_Param.class));
		return res;
	}


	//PO 입고
	public List<DW_Return_Message> saveList(String req_param){

		log.debug("saveList -----------------------> 0");
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		td.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		td.setTimeout(10);
		TransactionStatus code = txManager.getTransaction(td);
		
		log.debug("saveList -----------------------> 1");
			
		List<DW_Return_Message> return_msg = null;

		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[data] = {}", jsonObject.get("data"));

			JSONArray jsonData = jsonObject.getJSONArray("data");
			log.debug("[Data Count] = {}", jsonData.length());

			String strEndofline = "N";

			for(int i=0; i<jsonData.length(); i++) {
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[barno] = {}", dtlObject.get("barno"));

				if (i == jsonData.length()-1) {
					strEndofline = "Y";
				}

				DW_Good_Receipt_Sql.SELECT_Ord_Save_QUERY(
					  Util.GetData(jsonObject.get("i_lang")), Util.GetData(jsonObject.get("i_werks")), Util.GetData(jsonObject.get("i_userid"))
					, Util.GetData(dtlObject.get("ebeln")), Util.GetData(dtlObject.get("ebelp")), Util.GetData(dtlObject.get("barno"))
					, Util.GetData(dtlObject.get("matnr")), Util.GetData(dtlObject.get("qty")), Util.GetData(jsonObject.get("i_device")), Util.GetData(jsonObject.get("i_ipaddress"))
					, Util.GetData(jsonObject.get("i_model")), Util.GetData(jsonObject.get("i_osversion")), strEndofline
				);

				log.debug("saveList query = {}", DW_Good_Receipt_Sql.SELECT);

				return_msg = this.jdbcTemplate.query( DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Return_Message.class));

				log.debug("[process status] = {}", return_msg.get(0).code);
				if (!return_msg.get(0).code.equals("OK")) {
					log.debug("[process status] = {}", "NG");
					log.debug("[process msg] = {}", return_msg.get(0).message);
					break;
				}
				else{
					log.debug("[process status] = {}", "OK");
					log.debug("[process msg] = {}", return_msg.get(0).message);
				}
			}
			
			if (return_msg.get(0).code.equals("OK") && strEndofline.equals("Y"))
				txManager.commit(code);
			else
				txManager.rollback(code);
				
		} catch(Exception e) {
			txManager.rollback(code);
		}
		
		return return_msg;
	}
}
