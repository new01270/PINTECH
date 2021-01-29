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
import mybank.model.WithDrawResVO;

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

		long randId = System.currentTimeMillis();
		String randIdStr = Long.toString(randId);
		String randNine = randIdStr.substring(randIdStr.length() - 9, randIdStr.length());

		Date today = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatStr = dateformat.format(today);

		WithDrawReqVO vo = new WithDrawReqVO();
		vo.setBank_tran_id("T991676710" + "U" + randNine); // 은행거래고유번호
		vo.setCntr_account_type("N"); // 일반적으로 계좌(N)사용
		vo.setCntr_account_num("2105853150"); // 약정계좌번호
		vo.setDps_print_content("충전금"); // 입금계좌인자내역
		vo.setTran_amt("50000"); // 거래금액
		vo.setTran_dtime(formatStr);
		vo.setReq_client_name("회원1"); // 요청고객성명
		vo.setReq_client_num("001"); // 요청고객회원번호
		vo.setTransfer_purpose("TR"); // TR:송금 (이체용도)
		vo.setFintech_use_num("199167671057888646711668");
		vo.setAccess_token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzY2NzM4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MTkzMTk4MDksImp0aSI6ImE1MWY3YmMwLWNmMWEtNGQxNi1hZWJkLWYwM2Q5OGQ1YWE0ZSJ9.L4ByHz_o1kkMBob8xqlKalqDq2ec6VIgjImNML1GKRs");
		//vo.setReq_client_account_num("123456789"); // 요청고객계좌번호 (산업은행)
		vo.setReq_client_fintech_use_num("199167671057888646711668"); // 요청고객핀테크이용번호
		String result = OpenBank.getWithDraw(vo);

		Gson gson = new Gson();
		WithDrawResVO withDrawContent = gson.fromJson(result, WithDrawResVO.class);
		request.setAttribute("withDrawContent", withDrawContent);
		request.getRequestDispatcher("withDrawContent.jsp").forward(request, response);

	}

}
