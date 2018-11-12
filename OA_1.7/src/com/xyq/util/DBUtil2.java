package com.xyq.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DBUtil2 {
	
	//连接参数
	private static String Driver;
	private static String Url;
	private static String UserName;
	private static String PassWord;
	
	static {
		//读取配置文件
		Properties p = new Properties();
		InputStream is = DBUtil2.class.getResourceAsStream("/db.properties");
		try {
			//加载配置文件
			p.load(is);
			Driver = p.getProperty("Driver");
			Url = p.getProperty("Url");
			UserName = p.getProperty("UserName");
			PassWord = p.getProperty("PassWord");
			//加载驱动
			Class.forName(Driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//使用ThreadLocal确保每次线程是一个唯一的	Connection，保证事务是同一个事务
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	//获取连接
	public static Connection getConnection() {
		Connection conn = threadLocal.get();
		try {
			if(conn == null){
				conn = DriverManager.getConnection(Url, UserName, PassWord);
				threadLocal.set(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//关闭资源
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt != null){
				stmt.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//封装增删改
	public static void executeDML(String sql, Object...obj) {
		//jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//获取连接
			conn = getConnection();
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			for(int i=0; i<obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			//执行sql
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyException(e1.getMessage());
			}
			throw new MyException(e.getMessage());
		}finally {
			//关闭资源
			closeAll(null, ps, null);
		}
	}
	//封装查询
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> executeSelect(String sql, T t, Object...obj) {
		//创建集合
		ArrayList<T> ls = new ArrayList<T>();
		//jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = getConnection();
			//创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			for(int i=0; i<obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			//执行sql
			rs = ps.executeQuery();
			//获取表结构
			ResultSetMetaData metaData = rs.getMetaData();
			//获取字段数
			int count = metaData.getColumnCount();
			//遍历
			while(rs.next()) {
				Class<? extends Object> cla = t.getClass();
				Object o = cla.newInstance();
				//获得字段名称(通过遍历表字段来获取)
				for(int i=0; i<count; i++) {
					//获取字段名
					String columnName = metaData.getColumnName(i+1);
					//获得方法名称（通过字段名称拼接）
					String methodName = "set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1).toLowerCase();
					//获取每个字段的类型
					String columnType = metaData.getColumnClassName(i+1);
					//获得方法对象
					Method method = cla.getMethod(methodName, Class.forName(columnType));
					//执行方法
					method.invoke(o, rs.getObject(columnName));
				}
				ls.add((T) o);
			}
			//返回
			return ls;
		} catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//关闭资源
		closeAll(conn, ps, rs);
		return null;
		
	}
	
	//封装查询总个数
	public static int getCount(String sql) {

		//jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = getConnection();
			//创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//执行sql
			rs = ps.executeQuery();
			rs.next();
			int num = rs.getInt(1);
			return num;
			
		} catch (SQLException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		//关闭资源
		closeAll(conn, ps, rs);
		return -1;
	}
	
	//封装查询根据单个条件查
	@SuppressWarnings("unchecked")
	public static <T> T executeT(String sql, T t, Object...obj) {
		//jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = getConnection();
			//创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			for(int i=0; i<obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			//执行sql
			rs = ps.executeQuery();
			//获取表结构
			ResultSetMetaData metaData = rs.getMetaData();
			//获取字段数
			int count = metaData.getColumnCount();
			//遍历
			while(rs.next()) {
				Class<? extends Object> cla = t.getClass();
				Object o = cla.newInstance();
				//获得字段名称(通过遍历表字段来获取)
				for(int i=0; i<count; i++) {
					//获取字段名
					String columnName = metaData.getColumnName(i+1);
					//获得方法名称（通过字段名称拼接）
					String methodName = "set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
					//获取每个字段的类型
					String columnType = metaData.getColumnClassName(i+1);
					//获得方法对象
					Method method = cla.getMethod(methodName, Class.forName(columnType));
					//执行方法
					method.invoke(o, rs.getObject(columnName));
				}
				//返回
				return (T) o;
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//关闭资源
		closeAll(conn, ps, rs);
		return null;
	}
}
