package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springapp.domain.LoginInfo;

public class LoginInfoValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return LoginInfo.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		LoginInfo loginInfo = (LoginInfo)obj;
		if(loginInfo==null){
			 errors.rejectValue("loginInfo", "error.not-specified", null, "Value required.");
		}else{
			if(loginInfo.getUserName()!=null||loginInfo.getUserName().equals("")){
				 errors.rejectValue("userName", "error.not-specified","User name required.");
			}
			if(loginInfo.getPassword()!=null||loginInfo.getPassword().equals("")){
				 errors.rejectValue("password", "error.not-specified","Password required.");
			}
		}	
	}
}
