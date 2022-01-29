package dbs;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
	
	Connection c;
	Order o;
	public void placeOrder()
	{
		

		Order o = new Order();
		
		o.order_type=txtorder_type.getText();
		o.price=txtprice.getText();
		o.stock_name=txtname.getText();
		o.quantity=txtquantity.getText();
		
		
	}
	
	public void actionPerformed(ActionEvent e) throws SQLException {
		
		if(Admin.flag)
		{
		 c = ConnectionSetup.getCon();
		 
		 String query = "insert into Book values(null,"+o.stock_name+","+o.quantity+","+o.order_type+",0,"+o.price+",placed,CURDATE);";
		 
		 Statement s = c.createStatement();
		 
		 s.executeQuery(query);
		}
	}
}
