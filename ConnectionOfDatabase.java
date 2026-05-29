package bank.management.system;

import java.sql.*;

public class ConnectionOfDatabase{
Connection  connection;
Statement statement;
    ConnectionOfDatabase(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
     connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSystem" ,"root","sayalihon@2006");
     statement =connection.createStatement();


    }catch (Exception e){
        e.printStackTrace();
    }

}


}
