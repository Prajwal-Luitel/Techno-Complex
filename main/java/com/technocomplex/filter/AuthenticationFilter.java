package com.technocomplex.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.technocomplex.util.CookieUtil;
import com.technocomplex.util.SessionUtil;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
	// User
	private static final String LOGIN = "/login";
	private static final String REGISTER = "/register";
	private static final String HOME = "/home";
	private static final String FLAT = "/flat";
	private static final String CONTACT = "/contact";
	private static final String ABOUT = "/about";
	private static final String PROFILE = "/profile";
	private static final String ROOT = "/";
	// Admin
	private static final String DASHBOARD = "/dashboard";
	private static final String MANAGEFLAT = "/manageflat";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if required
	}

	/**
	 * Filters incoming HTTP requests based on user authentication and role.
	 * 
	 * This method checks whether a user is logged in and determines their role
	 * (either "user" or "admin"). Based on the role, it allows or restricts access
	 * to specific URL paths. If a user is not logged in and attempts to access
	 * protected resources, they will be redirected to the login page.
	 *
	 * @param request  the ServletRequest object, cast to HttpServletRequest
	 * @param response the ServletResponse object, cast to HttpServletResponse
	 * @param chain    the FilterChain for invoking the next filter or resource
	 * @throws IOException      if an I/O error occurs during filtering
	 * @throws ServletException if a servlet error occurs during filtering
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		// Allow access to resources
		if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css")) {
			chain.doFilter(request, response);
			return;
		}

		boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
		String userRole = CookieUtil.getCookie(req, "role") != null ? CookieUtil.getCookie(req, "role").getValue()
				: null;

		if ("admin".equals(userRole)) {
			// Admin is logged in
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
				res.sendRedirect(req.getContextPath() + DASHBOARD);
			} else if (uri.endsWith(DASHBOARD) || uri.endsWith(MANAGEFLAT) || uri.endsWith(ROOT)
					|| uri.endsWith(HOME) || uri.endsWith(ABOUT) || uri.endsWith(CONTACT)
					|| uri.endsWith(FLAT) || uri.endsWith(PROFILE)){
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + DASHBOARD);
			}
		} else if ("user".equals(userRole)) {
			// User is logged in
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
				res.sendRedirect(req.getContextPath() + HOME);
			} else if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT) || uri.endsWith(CONTACT)
					|| uri.endsWith(FLAT) || uri.endsWith(PROFILE)) {
				chain.doFilter(request, response);
			} else if (uri.endsWith(DASHBOARD) || uri.endsWith(MANAGEFLAT)) {
				res.sendRedirect(req.getContextPath() + HOME);
			} else {
				res.sendRedirect(req.getContextPath() + HOME);
			}
		} else {
			// Not logged in
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(HOME) || uri.endsWith(ROOT)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + LOGIN);
			}
		}
	}

	@Override
	public void destroy() {
		// Cleanup logic, if required
	}
}
