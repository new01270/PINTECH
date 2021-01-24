package mybank.model;

public class WithDrawResVO {
	String api_tran_id; // 거래고유번호
	String api_tran_dtm; // 거래일시(밀리세컨드)
	String dps_bank_name; // 입금기관명
	String dps_account_num_masked; // 입금계좌번호(출력용)
	String dps_print_content; // 입금계좌인자내역
	String dps_account_holder_name; // 수취인성명
	String bank_tran_date; // 거래일자(참가은행)
	String fintech_use_num; // 출금계좌핀테크이용번호
	String bank_name; // 출금기관명
	String account_num_masked; // 출금계좌번호(출력용)
	String print_content; // 출금계좌인자내역
	String account_holder_name; // 송금인성명
	String tran_amt; // 거래금액
	String wd_limit_remain_amt; // 출금한도잔여금액
}
