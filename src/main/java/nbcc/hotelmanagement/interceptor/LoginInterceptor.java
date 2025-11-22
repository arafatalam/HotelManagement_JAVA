package nbcc.hotelmanagement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nbcc.hotelmanagement.services.LoginService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final LoginService loginService;

    public LoginInterceptor(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler
            ) throws Exception {

        if(loginService.isLoggedIn()){
            return true;
        }

        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }
}
