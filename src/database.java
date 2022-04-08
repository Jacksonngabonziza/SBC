import java.sql.*;
public class database { 
    
  
        
  
    
    database(){
    
         try {
            Class.forName("com.mysql.jdbc.Driver");
            
     
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/SBC","root","");
           //if(conCp!=null){jdbc:mysql:
//           System.out.println("Ok.......");
//           }
//           else{
//              System.out.println("byanze.......");
//            }
//            
            

 
        } catch (ClassNotFoundException | SQLException exx) {
            System.out.println("check:::::"+exx);
        }
        
    
    }
    
    public static Connection data1(){
       
        
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            
            
            
       // Connection con1=DriverManager.getConnection("jdbc:mysql://"+connectionString,"evisitors_evisitor","Rwanda123!");
        Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/SBC","root","");
       return con1; 
        } catch (ClassNotFoundException | SQLException exx) {
           System.out.println("check:::::"+exx);
        }
    
    
return null;}

public static void main(String args[]){
    
    new database();
}

}


/*

*/