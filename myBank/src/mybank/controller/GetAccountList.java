package mybank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mybank.model.AccountList;

//API 명세서_등록계좌조회 API_서블릿

@WebServlet("/GetAccountList")
public class GetAccountList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAccountList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_seq_no = "1100766738";
		String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzY2NzM4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MTQ4Mjc2MDgsImp0aSI6ImI1NTVmZmU0LTQxYTUtNDhiMi04OTFhLTQ1YTdkNWZmYmVhMCJ9.teYW_diJDcpAxKUJ0K8BonjnwPqGF-lQH6Yx0FKgJ8E";
		String result = OpenBank.getAccountList(user_seq_no, access_token);
		
		System.out.println(result);
		
		Gson gson = new Gson();
		AccountList accountList = gson.fromJson(result, AccountList.class); // result값을 AccountList형식에 맞게 변환.
		request.setAttribute("account_list", accountList.get_res_list());	
		// Account값만  "account_list"에 담아 보낸다.->jsp에 보내는 EL안의 파라미터명.
		
		request.getRequestDispatcher("accountList.jsp").forward(request, response);		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
