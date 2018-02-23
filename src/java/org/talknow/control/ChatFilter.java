package org.talknow.control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // to do action here
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // check session here
        
        HttpSession mSession = ((HttpServletRequest)request).getSession(false);
        if (mSession != null) {
            String user = (String) mSession.getAttribute("userName");
            if (user != null || !user.isEmpty())
                chain.doFilter(request,response);
            else
                ((HttpServletResponse)response).sendRedirect("http://localhost:9030/TalkNow/home.html");
        } else {
            ((HttpServletResponse)response).sendRedirect("http://localhost:9030/TalkNow/home.html");
        }
    }

    @Override
    public void destroy() {
        // to do action here
    }
    
}
