package mybank.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mybank.model.WithDrawReqVO;

/*
출금이체 요청(고객 → 이용기관)
API_명세서(66p)
129p 참고
*/

@WebServlet("/WithDraw")
public class WithDraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WithDraw() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date today = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatStr = dateformat.format(today);

		WithDrawReqVO vo = new WithDrawReqVO();
		vo.setBank_tran_id(""); // 은행거래고유번호
		vo.setCntr_account_type("N"); // 일반적으로 계좌(N)사용
		vo.setCntr_account_num(""); // 약정계좌번호
		vo.setDps_print_content(""); // 입금계좌인자내역
		vo.setTran_amt("50000"); // 거래금액
		vo.setTran_dtime(formatStr);
		vo.setReq_client_name(""); // 요청고객성명
		vo.setReq_client_num(""); // 요청고객회원번호
		vo.setTransfer_purpose("TR"); // TR:송금 (이체용도)

		String result = OpenBank.getWithDraw(vo);
		
		Gson gson = new Gson();
		WithDrawReqVO withDrawResponse = gson.fromJson(result, WithDrawReqVO.class);
		request.setAttribute("withDraw_content", withDrawResponse);
		request.getRequestDispatcher("withDrawContent.jsp").forward(request, response);
		
	}

}
