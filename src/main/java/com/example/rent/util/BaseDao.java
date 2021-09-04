package com.example.rent.util;

import java.sql.*;


public class BaseDao {

    // private static String driver = "com.mysql.jdbc.Driver";
    // private static String url = "jdbc:mysql://bj-cynosdbmysql-grp-n1ox8dpy.sql.tencentcdb.com:23867/rentingSystem?useUnicode=true&characterEncoding=utf-8";
    // private static String user = "admin";
    // private static String password = "Ad123456";

    // /**
    //  * 连接数据库的方法n
    //  */
    // public static Connection getConnection() throws ClassNotFoundException, SQLException {
    //     // 加载数据库驱动
    //     Class.forName(driver);
    //     Connection con = DriverManager.getConnection(url,user,password);
    //     return con;
    // }


    private static DruidDataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            // 读取druid.properties 属性配置文件
            InputStream inputStream =
                    ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败，有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库的方法
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        // 关闭资源，避免出现异常
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置增删改的方法
     */
    public static boolean addUpdateDelete(String sql,Object[] arr){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 第一步：连接数据库
            con = BaseDao.getConnection();
            // 第二步：预编译
            ps = con.prepareStatement(sql);
            // 第三步：设置值
            if(arr != null && arr.length !=0){
                for (int i = 0; i < arr.length; i++) {
                    ps.setObject(i+1,arr[i]);
                }
            }
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){
        try {
            BaseDao.getConnection();
            System.out.println("---测试数据库链接成功---");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}