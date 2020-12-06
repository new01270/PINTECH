package mybank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/Callback")
public class Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Callback() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//redirect_uri 에 있는 코드
		String code = request.getParameter("code"); // 오픈뱅킹에서 휴대폰인증 후 임시토큰을 받음.->access토큰을 받아올 수 있음.
		System.out.println("code : " + code);

		// access token 발급받기
		String result = OpenBank.getAccessToken(code);

		JSONObject obj = JSONObject.fromObject(result);
		String access_token = obj.getString("access_token");
		String refresh_token = obj.getString("refresh_token");
		String user_seq_no = obj.getString("user_seq_no");

		request.getSession().setAttribute("access_token", access_token);
		request.getSession().setAttribute("refresh_token", refresh_token);
		request.getSession().setAttribute("user_seq_no", user_seq_no);

		// DB에 저장(accessToken, refreshToken, user_no)

		// 받아온 모든 파라미터 값을 보여줌.
		request.getRequestDispatcher("/authAccount.jsp").forward(request, response);
	}

}
