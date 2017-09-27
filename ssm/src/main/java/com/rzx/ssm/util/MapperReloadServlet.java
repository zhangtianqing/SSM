package com.rzx.ssm.util;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * Servlet implementation class MapperReloadServlet
 *
 * when mybatis files changed,reload them 
 */
public class MapperReloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapperReloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    public void init()throws ServletException
    {
      Logger logger = LoggerFactory.getLogger(this.getClass());
      logger.info("The mapper reload timer starting... ");
       
      try {
        new SqlSessionCache().refreshMapper();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }       
    }
}