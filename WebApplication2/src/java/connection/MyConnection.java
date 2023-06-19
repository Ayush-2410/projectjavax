 
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import utils.SystemConstants;


public class MyConnection {
    
    static Connection con = null; 
    
    public static Connection myConnection()
  {
    try
    {
       Class.forName(SystemConstants.DRIVER);
       con = DriverManager.getConnection(SystemConstants.URL,SystemConstants.DBUSERNAME,SystemConstants.DBPASSWORD); 
    }
    catch(Exception ex)
    {
       System.out.println("Connection Exception : "+ex.toString());
    }
      return con;
   }
}
