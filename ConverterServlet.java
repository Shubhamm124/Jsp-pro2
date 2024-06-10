package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import app2code.Converter;

/**
 * Servlet implementation class ConverterServlet
 */
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConverterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String value = request.getParameter("mycurrencies");
		String currency = request.getParameter("currency");

		float fvalue = Float.parseFloat(value);

		Converter ccon = new Converter();

		float convertedValue = 0;
		

		switch (currency) {
		case "USD":
			convertedValue = ccon.dollarToInr(fvalue);
			break;
		case "YEN":
			convertedValue = ccon.yenToInr(fvalue);
			break;
		case "Gbp":
			convertedValue = ccon.gbpToInr(fvalue);
			break;
		default:
			break;
		}

		HttpSession session = request.getSession();
		session.setAttribute("value", value);
		session.setAttribute("currency", currency);
		session.setAttribute("conValue", convertedValue);
		response.sendRedirect("displayCurrency.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
