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

import mybank.model.TransactionListVO;
import mybank.model.TransactionReqVO;

//API 명세서_거래내역조회 API_서블릿

@WebServlet("/TransactionList")
public class TransactionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransactionList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long randId = System.currentTimeMillis();
		String randIdStr = Long.toString(randId);
		String randNine = randIdStr.substring(randIdStr.length()-9, randIdStr.length());
		
		Date today = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatStr = dateformat.format(today);
		
		//잔액조회
		TransactionReqVO vo = new TransactionReqVO();
		vo.setBank_tran_id("T991676710" + "U" + randNine);
		vo.setFintech_use_num("199167671057888646711668");
		vo.setInquiry_type("A");
		vo.setInquiry_base("D");
		vo.setFrom_date("20201201");
		vo.setTo_date("20201204");
		vo.setSort_order("D");
		vo.setTran_dtime(formatStr);
		vo.setAccess_token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzY2NzM4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MTQ4Mjc2MDgsImp0aSI6ImI1NTVmZmU0LTQxYTUtNDhiMi04OTFhLTQ1YTdkNWZmYmVhMCJ9.teYW_diJDcpAxKUJ0K8BonjnwPqGF-lQH6Yx0FKgJ8E");		
		
		String result = OpenBank.getTransactionList(vo);
		
		System.out.println(result);
		
		//result를 list<Transaction>에 담아 view.
		Gson gson = new Gson();
		TransactionListVO transactionList = gson.fromJson(result, TransactionListVO.class);
		request.setAttribute("transaction_list", transactionList.get_res_list());
		
		request.getRequestDispatcher("transactionList.jsp").forward(request, response);
		
		
	}

	

}
