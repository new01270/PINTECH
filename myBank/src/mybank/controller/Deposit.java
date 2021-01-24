package mybank.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mybank.model.DepositReqListVO;
import mybank.model.DepositReqVO;

/*
입금이체 요청(이용기관 → 고객)
API_명세서(75p)
129p 참고
*/

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deposit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date today = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatStr = dateformat.format(today);

		ArrayList<DepositReqListVO> reqList = new ArrayList<DepositReqListVO>();
		DepositReqListVO req = new DepositReqListVO();
		req.setTran_no("1"); // 거래순번
		req.setBank_tran_id(""); // 은행거래고유번호
		req.setFintech_use_num(""); // 핀테크이용번호
		req.setPrint_content("충전금 인출");
		req.setTran_amt("10000"); // 거래금액
		req.setReq_client_name(""); // 요청고객성명
		req.setReq_client_num(""); // 요청고객회원번호
		req.setTransfer_purpose("TR"); // TR:송금 (이체용도)
		reqList.add(req);

		DepositReqVO vo = new DepositReqVO();
		vo.setCntr_account_type("N"); // 일반적으로 계좌(N)사용
		vo.setCntr_account_num(""); // 약정계좌번호
		vo.setWd_pass_phrase("NONE"); // (테스트 환경) 기본값 "NONE"를 세팅
		vo.setWd_print_content("충전금 인출"); // 내역
		vo.setName_check_option("on"); // 수취인성명 검증 여부
		vo.setTran_dtime(formatStr);
		vo.setReq_cnt("1"); // 입금요청건수 (default :1)
		vo.setReq_list(reqList);
		
		String result = OpenBank.getDeposit(vo);
		
		Gson gson = new Gson();
		DepositReqVO depositResponse = gson.fromJson(result, DepositReqVO.class);
		request.setAttribute("depositContent", depositResponse.get_res_list());
		
		request.getRequestDispatcher("depositContent.jsp").forward(request, response);
		
		

	}

}
