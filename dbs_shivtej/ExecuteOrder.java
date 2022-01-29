package dbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExecuteOrder {
	Connection c;
	
	public void ExeOrder(int execution_price, int execution_quantity, String stock_name ) throws SQLException
	{
		
		c = ConnectionSetup.getCon();
		
		Statement s = c.createStatement();
		
		String query = "Select * from Book where sname='"+stock_name+",";
		
		String query2 = "Select * from Book where order_status = 'ACCEPTED' ";
		
		String accepted_update = "Update Book SET order_set = ACCEPTED";
		
		String rejected_update = "Update Book SET order_set = REJECTED";
		
		ResultSet rs = s.executeQuery(query);
		
		int c=0; 
		
		while(rs.next())
		{
			int p=rs.getRow();
			if(stock_name.equals("LIMIT"))
			{
				
				if(rs.getInt("price") > execution_price)
				{
					
					s.executeQuery("Update Book SET order_set = ACCEPTED where sno ="+p+" ;");
				
				}
				else
				{
					s.executeQuery("Update Book SET order_set = REJECTED where sno ="+p+" ;");
					c++;
				}
			}
			else
			{
				s.executeQuery("Update Book SET order_set = REJECTED where sno ="+p+" ;");
				c++;
			}
			
		}
		
		int potential = execution_price / c;
		
		ResultSet r = s.executeQuery(query2);
		
		while(r.next())
		{
			
			int p=rs.getRow();
			int current_price = r.getInt("exe_qty");
			current_price+=potential;
			s.executeQuery("Update Book SET exe_qty = " + current_price +" where sno ="+p+" ;");
			
		}
			
	}
	
}
