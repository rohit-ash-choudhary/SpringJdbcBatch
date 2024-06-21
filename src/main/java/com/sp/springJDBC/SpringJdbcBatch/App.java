package com.sp.springJDBC.SpringJdbcBatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.resource.JavaConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
      
      JdbcTemplate  jbt=context.getBean(JdbcTemplate.class);
      // ---------------------Way 1--------------------------------
//      String query1="insert into account values(105,'a','b',340)";
//      String query2="insert into account values(109,'x','y',3670)";
//      String query3="insert into account values(107,'u','v',370)";
//      int[] count=jbt.batchUpdate(query1,query2,query3);
      
   // ---------------------Way 2----------------------------------
      String query1="insert into account values(105,'a','b',340)";
      String query2="insert into account values(109,'x','y',3670)";
  	 String query3="insert into account values(107,'u','v',370)";
      String[] query={query1,query2,query3};
      int[] count=jbt.batchUpdate(query);
      
      
      for(int i: count)
      {
    	  System.out.println(i +": success");
      }
      
    }
}
