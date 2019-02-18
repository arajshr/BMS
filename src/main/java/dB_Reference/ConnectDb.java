package dB_Reference;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import basic_Config.Constants;

public class ConnectDb {
		

	// Create a variable for the connection string.
	
	
	// Declare the JDBC objects.
	Connection connection = null;
	Statement statement = null;
	//PreparedStatement preparedStatement;
	ResultSet resultSet = null;
	
	public ConnectDb()
	{
		try
		{
			connection = DriverManager.getConnection(Constants.connectionUrl,Constants.dbUserName,Constants.dbPassword);
			System.out.println("Connection opened");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void close() 
	{
		if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
		if (statement != null) try { statement.close(); } catch(Exception e) {}
		//if (preparedStatement != null) try { preparedStatement.close(); } catch(Exception e) {}
		if (connection != null) try { connection.close(); } catch(Exception e) {}
	}
	
	
	public boolean get_AccountsToQC()
	{
		try
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("{call dbo.uspQCAllocation}");	
			
			
			resultSet.next();
			int iCount = Integer.parseInt(resultSet.getString("QcAccountsCount"));	            
			
			if(iCount>0)
				return true;
			else
				return false;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public List<String> get_Employee(String sNTLG)
	{
		try
		{
			List<String> lstUsers = new ArrayList<>();
			String sQuery = "select EmpID, EmpName from EmpMaster where EmpNtlg = '"+sNTLG+"'";
			
			statement = connection.createStatement();			
			resultSet = statement.executeQuery(sQuery);
			
			while (resultSet.next()) 
			{
				lstUsers.add(resultSet.getString("EmpID"));
				lstUsers.add(resultSet.getString("EmpName"));
			}
			
			
			return lstUsers;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, Integer> get_ARTrailBalanceReport(String sPractice) 
	{
		try 
		{
			HashMap<String, Integer> report = new HashMap<>();
			
			String sQuery = "SELECT ins.PayerName, count(UID) as iCount from inventory inv \r\n" +
					 		"JOIN insurances  ins on ins.InsuranceID = inv.Primary_Insurance_ID "+
				 			"join ClientHierarchyMapping chm on inv.chmapid = chm.chmapid \r\n" +
					 		"join Practices pr on pr.PracticeID = chm.PracticeID \r\n" +
					 		"WHERE pr.PracticeName = '"+ sPractice +"' \r\n" +
					 		"GROUP BY ins.payerName";
			
			
			
			  /*select ins.payerName, count(UID) as iCount from inventory inv
			  join insurances  ins on ins.InsuranceID = inv.Primary_Insurance_ID
			  join ClientHierarchyMapping chm on inv.chmapid = chm.chmapid
			  --join Clients cl on cl.ClientID = chm.chmapid
			  --join Locations lo on lo.LocationID = chm.LocationID
			  join Practices pr on pr.PracticeID = chm.PracticeID
			  where pr.PracticeName = 'ATI Aetna' --cl.ClientName = 'ATI' and lo.LocationName = 'ATI' and 
			  group by ins.payerName*/
			
			
			
			statement = connection.createStatement();			
			resultSet = statement.executeQuery(sQuery);
			
			while (resultSet.next()) 
			{
				report.put(resultSet.getString("payerName"), Integer.parseInt(resultSet.getString("iCount")));
			}
			return report;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}

}
