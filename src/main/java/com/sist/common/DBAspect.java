package com.sist.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sist.dao.DBConnection;

@Aspect
@Component
public class DBAspect {
   @Autowired
   private DBConnection dbCon;
   
   @Before("execution(* com.sist.dao.CBoardDAO.board*(..))||execution(* com.sist.dao.CBoardDAO.reply*(..))")
   public void before()
   {
	   System.out.println("DBAspect:"+dbCon);
	   dbCon.getConnection();
   }
   @After("execution(* com.sist.dao.CBoardDAO.board*(..))||execution(* com.sist.dao.CBoardDAO.reply*(..))")
   public void after()
   {
	   dbCon.disConnection();
   }
   @AfterThrowing(value="execution(* com.sist.dao.CBoardDAO.board*(..))||execution(* com.sist.dao.CBoardDAO.reply*(..))",throwing="ex")
   public void afterThrowing(Throwable ex)
   {
	   ex.printStackTrace();
   }
   @AfterReturning(value="execution(* com.sist.dao.CBoardDAO.board*(..))||execution(* com.sist.dao.CBoardDAO.reply*(..))",returning="obj")
   public void afterReturning(Object obj)
   {
	   System.out.println("obj="+obj);
   }
}