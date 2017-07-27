package dyspring.mvc.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dyspring.mvc.data.entities.HitCounter;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HitCounter hitCounter;
	
	public GlobalInterceptor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		this.hitCounter.setHits(this.hitCounter.getHits() + 1);
		System.out.println("Hits=" + this.hitCounter.getHits());
//		request.setAttribute("currentTime", new Date());
		return super.preHandle(request, response, handler);
	}
}
