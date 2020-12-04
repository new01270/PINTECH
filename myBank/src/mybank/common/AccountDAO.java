package mybank.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mybank.model.Account;

public class AccountDAO extends DAO{
	PreparedStatement psmt;
	ResultSet rs;
	
	private final String select_all = "SELECT * FROM user_account";
	private final String insert = "INSERT INTO user_account VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	
	public ArrayList<Account> selectAll() {
		ArrayList<Account> list = new ArrayList<Account>();
		Account acc;
		try {
			psmt = conn.prepareStatement(select_all);
			rs = psmt.executeQuery();
			while(rs.next()) {
				acc = new Account();			
				acc.setUser_seq_no(rs.getString("USER_SEQ_NO"));
				acc.setAccount_num(rs.getString("ACCOUNT_NUM"));
				acc.setFintech_use_num(rs.getString("FINTECH_USE_NUM"));
				acc.setAccount_alias(rs.getString("ACCOUNT_ALIAS"));
				acc.setBank_code_std(rs.getString("BANK_CODE_STD"));
				acc.setBank_name(rs.getString("BANK_NAME"));
				acc.setAccount_type(rs.getString("ACCOUNT_TYPE"));
				acc.setAccount_state(rs.getString("ACCOUNT_STATE"));
				acc.setInquiry_agree_yn(rs.getString("INQUIRY_AGREE_YN"));
				acc.setTransfer_agree_yn(rs.getString("TRANSFER_AGREE_YN"));
				list.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(Account acc) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, acc.getUser_seq_no());
			psmt.setString(2, acc.getAccount_num());
			psmt.setString(3, acc.getFintech_use_num());
			psmt.setString(4, acc.getAccount_alias());
			psmt.setString(5, acc.getBank_code_std());
			psmt.setString(6, acc.getBank_name());
			psmt.setString(7, acc.getAccount_num());
			psmt.setString(8, acc.getAccount_type());
			psmt.setString(9, acc.getAccount_state());
			psmt.setString(10, acc.getInquiry_agree_yn());
			psmt.setString(11, acc.getTransfer_agree_yn());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 추가되었습니다.");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
