package mybank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*--------------------------------------------
API 명세서_계좌등록확인 API(p18)
1.response code -> redirect_uri CallBack.java
-------------------------------------------*/

@WebServlet("/AuthAccount")
public class AuthAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthAccount() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "https://testapi.openbanking.or.kr/oauth/2.0/authorize_account";
		String response_type = "code";
		String client_id = "6Y2QQh8lyuIXTDJKP3NMp3avlHUbmXN41pMuaIa7";
		String redirect_uri = "http://localhost/myBank/Callback";
		String scope = "login inquiry transfer";
		String state = "12345678901234567890123456789012";
		String auth_type = "0";
		
		StringBuilder qstr = new StringBuilder();
		qstr.append("response_type=" + response_type)
			.append("&client_id=" + client_id)
			.append("&redirect_uri=" + redirect_uri)
			.append("&scope=" + scope)
			.append("&state=" + state)
			.append("&auth_type=" + auth_type);
		response.sendRedirect(url + "?" + qstr.toString());

	}

// 인증 후
	
	/*아래와 같이 서수연님의 계좌가 등록되어 있습니다.
	아래 계좌에 대해서 서수연의 TestAPP 서비스가 출금/조회을(를) 이용하는데 동의하시겠습니까?*/

			
	
}
