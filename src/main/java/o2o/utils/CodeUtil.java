package o2o.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-16 17:11
 * description
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        System.out.println(verifyCodeActual+"        "+verifyCodeExpected);
        System.out.println(verifyCodeActual==null||!verifyCodeActual.equals(verifyCodeExpected));
        if (verifyCodeActual==null||!verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        else{
            return true;
    }}
}
