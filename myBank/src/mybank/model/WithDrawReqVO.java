package mybank.model;

import java.util.ArrayList;

public class WithDrawReqVO {
	String cntr_account_type;
	String cntr_account_num;
	String wd_pass_phrase;
	String wd_print_content;
	String name_check_option;
	String tran_dtime;
	String req_cnt;

	ArrayList<WithDrawReqListVO> req_list;
	
	public ArrayList<WithDrawReqListVO> get_res_list() {
		return req_list;
	}
}
