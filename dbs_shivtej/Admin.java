package dbs;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {

	int execution_price ;
	int execution_quantity ;
	static boolean flag ;
	String from_date;
	String to_date;
	String select_stock;
	
	Connection c;
	
	excution_price = txtexecution_price.getInt();
	execution_quantity = txtexecution_quantity.getInt();
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == b1) {
			flag = true;
		}
		
		if(e.getSource() == b2) {
			flag = false;
		}
		
		
		
	    if(e.getSource() == ShowOrders)
	    {
	    	
	    	c = ConnectionSetup.getCon();
	    	
	    	select_stock=txtstock.getText();
	    	
	    	
	    	String query = "select * from Book WHERE sname='"+ select_stock+"'and order_date>"+from_date+"and order_date<"+to_date+";";
	    	
	    	Statement s = c.createStatement();
	    	
	    	ResultSet rs = s.executeQuery(query);
	    	
	    	while(rs.next()) {
	    		
	    	.setText()	= rs.getInt("sno");
	    	.setText()	= rs.getInt("sname");
	    	.setText()	= rs.getInt("order_qty");
	    	.setText()	= rs.getInt("order_type");
	    	.setText()	= rs.getInt("exe_qty");
	    	.setText()	= rs.getInt("price");
	    	.setText()	= rs.getInt("order_status");
	    	.setText()	= rs.getInt("order_date");
	    	
	    		
	    	}
	    	
	    }
	    
	    if(e.getSource()==execute_button)
	    {
	    	
	    	select_stock=txtstock.getText();
	    	new ExecuteOrder().ExeOrder(execution_price,execution_quantity,select_stock);
	    }
		
	}
	
	
	
	
	
}
