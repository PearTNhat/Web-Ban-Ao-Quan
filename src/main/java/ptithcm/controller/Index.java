package ptithcm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	@RequestMapping("/")
	public String index(ModelMap model) {
//		String serverName = "PHUONG-HPLAP";
		String serverName = "NHAT-PC\\SERVER01";
        String portNumber = "1433";
        String databaseName = "QLSV";
        String username = "sa";
//        String password = "kc";
        String password = "12";
        String connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";" + "databaseName="
                + databaseName + ";username=" + username + ";password=" + password + ";";

        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection con = DriverManager.getConnection(connectionUrl);
        	model.addAttribute("connStatus", "Connected to database!");
        } catch (SQLException | ClassNotFoundException e) {
			model.addAttribute("connStatus", "Cannot connect to SQL Server =((");
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping("/footer")
	public String Footer  () {
		return "com/footer";
	}
	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "page/forgotPassword/sentMail";
	}
	
}
