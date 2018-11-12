 package com.bjsxt.util;

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
import java.util.List;
import java.util.Properties;

public class DBUtils {
	private static String driver;//导入jar包的类名
	private static String url;//路径
	private static String username;//数据库用户名
	private static String password;//数据库密码
	
	//静态块加载连接数据库
	static{
		Properties p = new Properties();
		InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");		
	}
	
	//获取Connection对象
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//获取PrepareStatement对象
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	//关闭查询语句的所有流资源
	public static void closeAll(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭增删改语句的所有流资源
	public static void closeAll(Statement stat,Connection conn){
		try {
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//增删改语句模板
	public static int executeDML(String sql,Object...obj){
		Connection conn = null;
		PreparedStatement ps = null;		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = getPreparedStatement(conn, sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
			int i = ps.executeUpdate();
			if(i>0){
				conn.commit();
				return i;
			}
			conn.rollback();
		} catch (SQLException e1) {

		} finally {
			closeAll(ps, conn);
		}
		return -1;
	}
	
	//查询语句模板(需要传入SQL语句，以及查询结果返回的对象类型和查询条件)
	public static <T> List<T> executeSelect(String sql,T t,Object...obj){
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			while(rs.next()){
				Class<? extends Object> cla = t.getClass();
				@SuppressWarnings("unchecked")
				T tt = (T)cla.newInstance();
				for(int i=0;i<count;i++){
					String columnName = rm.getColumnName(i+1);
					String methodName="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
					String columnClassName = rm.getColumnClassName(i+1);
					Method method = cla.getMethod(methodName, Class.forName(columnClassName));
					method.invoke(tt, rs.getObject(columnName));
				}
				list.add(tt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
}