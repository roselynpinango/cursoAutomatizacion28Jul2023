package  Edit.EducacionIT_64249;		
import  java.sql.Connection;		
import  java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import  java.sql.ResultSet;
import java.sql.SQLException;
import  java.sql.DriverManager;		

public class  AccesoABaseDeDatosTest {				
    	@Test
    	public void testBaseDeDatos() throws ClassNotFoundException, SQLException {
    		
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
            String dbUrl = "jdbc:mysql://localhost:3306/inventariodb";					

			//Database Username		
			String username = "root";	
                
			//Database Password		
			String password = "rose";				

			//Query to Execute		
			String query = "select count(1) from producto;";
			//query = "select count(1) from clientes where DNI = " + dniUtilizado;
                
         	//Load mysql jdbc driver		
           	Class.forName("com.mysql.jdbc.Driver");			
           
           	//Create Connection to DB		
            Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          	//Create Statement Object		
        	Statement stmt = con.createStatement();					
       
       		// Execute the SQL Query. Store results in ResultSet		
         	ResultSet rs= stmt.executeQuery(query);							
         
         	int count = 0;
         		
         	// While Loop to iterate through all data and print results		
			while (rs.next()){
				count = rs.getInt(1); // obtener número entero
				
				// select nombre, edad, fechaNacimiento from clientes;
				//nombre = rs.getString(1);
				//edad = rs.getInt(2);
				//fechaNacimiento = rs.getDate(3);
            }		
		
				
			System.out.println("Resultados de la Consulta a la Base de Datos");
			System.out.println("Número de Productos en Base de Datos: " + count);
			Assert.assertTrue(count > 0);
			//Assert.assertEquals(count > 0, true);
				
      		// closing DB Connection		
      		con.close();			
		}
}