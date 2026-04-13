package vn.iotstar.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");
            request.setAttribute("user", user);

            int roleID = user.getRoleID();
            // 1=ADMIN, 2=SELLER, 3=USER, 4=SHIPPER (theo DB)
            String requestURI = request.getRequestURI();

            if (requestURI.startsWith("/admin") && roleID != 1) {
                response.sendRedirect("/login");
                return false;
            }
            if (requestURI.startsWith("/seller") && roleID != 2) {
                response.sendRedirect("/login");
                return false;
            }
            if (requestURI.startsWith("/shipper") && roleID != 4) {
                response.sendRedirect("/login");
                return false;
            }
        } else {
            // Kiểm tra khi không có session, không cho phép truy cập vào các đường dẫn của user từ Admin/Seller/Shipper
            String requestURI = request.getRequestURI();
            // Nếu không có session, không cho phép vào bất kỳ trang nào ngoại trừ login và register
            if (requestURI.startsWith("/user")) {
                response.sendRedirect("/login"); // Nếu không có session, chuyển hướng về trang login
                return false;
            }
            
            // Kiểm tra các đường dẫn login và register
            if (!requestURI.startsWith("/login") && !requestURI.startsWith("/register")) {
                response.sendRedirect("/login"); // Chuyển hướng nếu chưa đăng nhập
                return false;
            }
        }

        return true; // Tiếp tục request nếu không có vấn đề
    }
}
