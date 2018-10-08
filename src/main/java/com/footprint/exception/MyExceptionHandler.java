package com.footprint.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
        logger.error("ex -- "+ex.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("error");
        try {
//            response.sendRedirect(request.getContextPath()+"/error");
            request.getRequestDispatcher("/error").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
}
