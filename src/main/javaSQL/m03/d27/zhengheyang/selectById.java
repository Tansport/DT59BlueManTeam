
public void selectById() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 连接数据库;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "root");
		// 书写sql语句;
		String sql = "select uid,uname,upassword,htid,htname from sys_user a inner join hos_type b on a.`uid`=b.`htid`";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int uid = rs.getInt("uid");
			String uname = rs.getString("uname");
			String upassword = rs.getString("upassword");
			int htid = rs.getInt("HTID");
			String htname = rs.getString("HTName");
			// 打印输出;
			System.out.println(
					"uid=" + uid + " uname=" + uname + " upassword=" + upassword + " htid" + htid + " HTName" + htname);
		}
		// 关闭连接;
		conn.close();
	}
