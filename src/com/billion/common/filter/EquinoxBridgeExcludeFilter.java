/**
 * 
 */
package com.billion.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author stlv
 * 
 */
public class EquinoxBridgeExcludeFilter extends StrutsPrepareAndExecuteFilter {
	private String excludePattern = null;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		String eqbUrl = req.getRequestURI();
		if (!eqbUrl.startsWith(excludePattern))
			super.doFilter(arg0, arg1, arg2);
		else
			arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String contextPath = arg0.getServletContext().getContextPath();
		String initParamValue = arg0.getInitParameter("excludeUrlPattern");
		initParamValue = initParamValue.replaceAll("%0", contextPath);
		excludePattern = initParamValue.substring(0,
				initParamValue.length() - 1);
		super.init(arg0);
	}

}
