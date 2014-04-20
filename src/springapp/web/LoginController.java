package springapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.LoginInfo;

public class LoginController extends SimpleFormController{
	
	static final String WARNING = "Error with your username or password.Please try again!";
	
	private LoginInfo loginInfo;

	protected final Log logger = LogFactory.getLog(getClass());

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) throws ServletException {
		logger.info("LoginController onSubmit:");
		String userName = ((LoginInfo)command).getUserName();
		String password = ((LoginInfo)command).getPassword();
		String validationCode = ((LoginInfo)command).getValidationCode();
		String vcode = (String)request.getSession().getAttribute("vcode");
		if (userName.equals(loginInfo.getUserName())
				&& password.equals(loginInfo.getPassword())
				&& validationCode.equals(vcode)) {
			logger.info("LoginController onSubmit:userName " + userName
					+ " login");
			return new ModelAndView(new RedirectView(getSuccessView()));
		} else {
			logger.info("LoginController onSubmit: login failed ");
			LoginInfo loginInfo = new LoginInfo();
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("loginInfo", loginInfo);
			myModel.put("warning", WARNING);
			return new ModelAndView(this.getFormView(), myModel);
		}
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		LoginInfo loginInfo = new LoginInfo();
		return loginInfo;
	}
	
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
}
