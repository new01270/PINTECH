package mybank.model;

import java.util.ArrayList;

public class WithDrawResponseVO {
	String wd_account_num_masked;
	String wd_account_holder_name;

	ArrayList<WithDrawResListVO> res_list;
	public ArrayList<WithDrawResListVO> get_res_list() {
		return res_list;
	}
}
