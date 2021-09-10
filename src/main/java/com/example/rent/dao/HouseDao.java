package com.example.rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.rent.entity.Category;
import com.example.rent.entity.House;
import com.example.rent.util.BaseDao;

public interface HouseDao {



        /**
         * 查询房屋信息
         */
        public List<House> select(String sql, Object[] arr);

        /**
         * 查询图书信息
         */
        public House selectHouse(String sql, Object[] arr);

        /**
         * 根据房屋编号进行查询
         */
        public House getHouse(Integer houseid);


        /**
         * 房屋新增
         */
        public boolean addHouse(House house);

        /**
         * 房屋修改
         */
        public boolean updateHouse(House house);

        /**
         * 房屋图书
         */
        public boolean deleteHouse(Integer hosueid);

        /**
         * 根据category查询总记录数
         */
        public static int findTotalCount() {
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                        // 1.连接数据库
                        con = BaseDao.getConnection();
                        // 2.预编译
                        String sql = "";

                        int bedroom_num=0;
                        int price_down=0;
                        int price_up=0;

                        String city_select = Category.getCcity();
                        String price_select = Category.getCprice();
                        String type_bedroom_select = Category.getCtype_bedroom();
                        String houseToward_select = Category.getChouseToward();

                        if(!price_select.equals("不限")){
                                price_down=Integer.parseInt(price_select.split("-")[0]);
                                price_up=Integer.parseInt(price_select.split("-")[1]);
                                System.out.println(price_down);
                                System.out.println(price_up);
                        }



                        if(!type_bedroom_select.equals("不限")){
                                if(type_bedroom_select.equals("一室")){
                                        bedroom_num=1;
                                }else if(type_bedroom_select.equals("二室")){
                                        bedroom_num=2;
                                }else if(type_bedroom_select.equals("三室")){
                                        bedroom_num=3;
                                }else if (type_bedroom_select.equals("三室以上")){
                                        bedroom_num=4;
                                }
                        }

                        System.out.println(city_select);
                        System.out.println(price_down);
                        System.out.println(price_up);
                        System.out.println(bedroom_num);
                        System.out.println(houseToward_select);

                        //判断 select count(*) from House where city=?
                        if(!city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where city=? and price between ? and ? and type_bedroom=? and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,bedroom_num);
                                        ps.setObject(5,houseToward_select);

                                }else{
                                        sql="select count(*) from House where city=? and price between ? and ? and type_bedroom>3 and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,houseToward_select);
                                }
                        }else if (city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where price between ? and ? and type_bedroom=? and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,bedroom_num);
                                        ps.setObject(4,houseToward_select);
                                }else{
                                        sql="select count(*) from House where price between ? and ? and type_bedroom>3 and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,houseToward_select);
                                }
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where city=? and type_bedroom=? and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,bedroom_num);
                                        ps.setObject(3,houseToward_select);
                                }else{
                                        sql="select count(*) from House where city=? and type_bedroom>3 and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,houseToward_select);
                                }
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select count(*) from House where city=? and price between ? and ?  and houseToward=?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,price_down);
                                ps.setObject(3,price_up);
                                ps.setObject(4,houseToward_select);
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where city=? and price between ? and ? and type_bedroom=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,bedroom_num);
                                }else{
                                        sql="select count(*) from House where city=? and price between ? and ? and type_bedroom>3";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                }
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where type_bedroom=? and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,bedroom_num);
                                        ps.setObject(2,houseToward_select);
                                }else{
                                        sql="select count(*) from House where type_bedroom>3 and houseToward=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,houseToward_select);
                                }
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select count(*) from House where price between ? and ? and houseToward=?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,price_down);
                                ps.setObject(2,price_up);
                                ps.setObject(3,houseToward_select);
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where price between ? and ? and type_bedroom=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,bedroom_num);
                                }else{
                                        sql="select count(*) from House where price between ? and ? and type_bedroom>3";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                }
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select count(*) from House where city=? and houseToward=?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,houseToward_select);
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where city=? and type_bedroom=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,bedroom_num);
                                }else{
                                        sql="select count(*) from House where city=? and type_bedroom>3";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                }
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                sql = "select count(*) from House where city=? and price between ? and ?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,price_down);
                                ps.setObject(3,price_up);
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select count(*) from House where city=?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select count(*) from House where price between ? and ?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,price_down);
                                ps.setObject(2,price_up);
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select count(*) from House where type_bedroom=?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,bedroom_num);
                                }else{
                                        sql="select count(*) from House where type_bedroom>3";
                                        ps = con.prepareStatement(sql);
                                }
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")) {
                                sql = "select count(*) from House where houseToward=?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,houseToward_select);
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select count(*) from House";
                                ps = con.prepareStatement(sql);
                        }

                        // 3.执行sql
                        rs = ps.executeQuery();

                        // 4.保存查询出来的数据
                        rs.next();
                        int count = rs.getInt(1);
                        //System.out.println(count);
                        return count;
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        // 关闭资源，避免出现异常
                        BaseDao.close(con, ps, rs);
                }
                return 0;
        }
        static List<House> findRightPage() {
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                List<House> list = new ArrayList<>();
                try {
                        // 1.连接数据库
                        con = BaseDao.getConnection();
                        // 2.预编译
                        String sql = "Select * from House limit 0,5";
                        ps = con.prepareStatement(sql);
                        // 3.执行sql
                        rs = ps.executeQuery();

                        while (rs.next()){
                                House house = new House();
                                house.setHouseId(rs.getInt("houseId"));
                                house.setUserId(rs.getInt("userId"));
                                house.setManagerId(rs.getInt("managerId"));
                                house .setCity(rs.getString("city"));
                                house .setDistrict(rs.getString("district"));
                                house .setVillage(rs.getString("village"));
                                house .setAddress(rs.getString("address"));
                                house .setFloor(rs.getInt("floor"));
                                house .setFloor_sum(rs.getInt("floor_sum"));
                                house .setFloor_lift(rs.getInt("floor_lift"));
                                house .setPrice(rs.getInt("price"));
                                house .setType_bedroom(rs.getInt("type_bedroom"));
                                house .setType_livingroom(rs.getInt("type_livingroom"));
                                house .setType_bathroom(rs.getInt("type_bathroom"));
                                house .setArea(rs.getString("area"));
                                house .setDescription(rs.getString("description"));
                                house .setHouseToward(rs.getString("houseToward"));
                                house .setFacilities(rs.getString("facilities"));
                                house.setRequirement(rs.getString("requirement"));
                                house.setPersonnum(rs.getInt("personnum"));
                                house.setHouseImg(rs.getString("houseImg"));
                                house.setPayMethod(rs.getString("payMethod"));
                                list.add(house);
                        }
                        return list;
                } catch (SQLException e) {
                        e.printStackTrace();
                }finally {
                        // 关闭资源，避免出现异常
                        BaseDao.close(con,ps,rs);
                }
                return null;
        }

        /**
         * 根据category，start,pageSize查询当前页的数据集合
         */
        public static List<House> findByPage(int start, int pageSize) {
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                try {
                        // 1.连接数据库
                        con = BaseDao.getConnection();
                        // 2.预编译

                        String sql = "";

                        int bedroom_num=0;
                        int price_down=0;
                        int price_up=0;

                        String city_select = Category.getCcity();
                        String price_select = Category.getCprice();
                        String type_bedroom_select = Category.getCtype_bedroom();
                        String houseToward_select = Category.getChouseToward();

                        if(!price_select.equals("不限")){
                                price_down=Integer.parseInt(price_select.split("-")[0]);
                                price_up=Integer.parseInt(price_select.split("-")[1]);
                                System.out.println(price_down);
                                System.out.println(price_up);
                        }

                        if(!type_bedroom_select.equals("不限")){
                                if(type_bedroom_select.equals("一室")){
                                        bedroom_num=1;
                                }else if(type_bedroom_select.equals("二室")){
                                        bedroom_num=2;
                                }else if(type_bedroom_select.equals("三室")){
                                        bedroom_num=3;
                                }else if (type_bedroom_select.equals("三室以上")){
                                        bedroom_num=4;
                                }
                        }

                        //判断 select * from House where city=?
                        if(!city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where city=? and price between ? and ? and type_bedroom=? and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,bedroom_num);
                                        ps.setObject(5,houseToward_select);
                                        ps.setObject(6,start);
                                        ps.setObject(7,pageSize);

                                }else{
                                        sql="select * from House where city=? and price between ? and ? and type_bedroom>3 and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,houseToward_select);
                                        ps.setObject(5,start);
                                        ps.setObject(6,pageSize);

                                }
                        }else if (city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where price between ? and ? and type_bedroom=? and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,bedroom_num);
                                        ps.setObject(4,houseToward_select);
                                        ps.setObject(5,start);
                                        ps.setObject(6,pageSize);

                                }else{
                                        sql="select * from House where price between ? and ? and type_bedroom>3 and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,houseToward_select);
                                        ps.setObject(4,start);
                                        ps.setObject(5,pageSize);

                                }
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where city=? and type_bedroom=? and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,bedroom_num);
                                        ps.setObject(3,houseToward_select);
                                        ps.setObject(4,start);
                                        ps.setObject(5,pageSize);
                                }else{
                                        sql="select * from House where city=? and type_bedroom>3 and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,houseToward_select);
                                        ps.setObject(3,start);
                                        ps.setObject(4,pageSize);
                                }
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select * from House where city=? and price between ? and ?  and houseToward=? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,price_down);
                                ps.setObject(3,price_up);
                                ps.setObject(4,houseToward_select);
                                ps.setObject(5,start);
                                ps.setObject(6,pageSize);
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where city=? and price between ? and ? and type_bedroom=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,bedroom_num);
                                        ps.setObject(5,start);
                                        ps.setObject(6,pageSize);
                                }else{
                                        sql="select * from House where city=? and price between ? and ? and type_bedroom>3 limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,price_down);
                                        ps.setObject(3,price_up);
                                        ps.setObject(4,start);
                                        ps.setObject(5,pageSize);
                                }
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where type_bedroom=? and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,bedroom_num);
                                        ps.setObject(2,houseToward_select);
                                        ps.setObject(3,start);
                                        ps.setObject(4,pageSize);
                                }else{
                                        sql="select * from House where type_bedroom>3 and houseToward=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,houseToward_select);
                                        ps.setObject(2,start);
                                        ps.setObject(3,pageSize);

                                }
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select * from House where price between ? and ? and houseToward=? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,price_down);
                                ps.setObject(2,price_up);
                                ps.setObject(3,houseToward_select);
                                ps.setObject(4,start);
                                ps.setObject(5,pageSize);
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where price between ? and ? and type_bedroom=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,bedroom_num);
                                        ps.setObject(4,start);
                                        ps.setObject(5,pageSize);
                                }else{
                                        sql="select * from House where price between ? and ? and type_bedroom>3 limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,price_down);
                                        ps.setObject(2,price_up);
                                        ps.setObject(3,start);
                                        ps.setObject(4,pageSize);
                                }
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")){
                                sql="select * from House where city=? and houseToward=? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,houseToward_select);
                                ps.setObject(3,start);
                                ps.setObject(4,pageSize);
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where city=? and type_bedroom=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,bedroom_num);
                                        ps.setObject(3,start);
                                        ps.setObject(4,pageSize);
                                }else{
                                        sql="select * from House where city=? and type_bedroom>3 limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1, city_select);
                                        ps.setObject(2,start);
                                        ps.setObject(3,pageSize);
                                }
                        }else if(!city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")){
                                sql = "select * from House where city=? and price between ? and ? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,price_down);
                                ps.setObject(3,price_up);
                                ps.setObject(4,start);
                                ps.setObject(5,pageSize);
                        }else if(!city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select * from House where city=? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1, city_select);
                                ps.setObject(2,start);
                                ps.setObject(3,pageSize);
                        }else if(city_select.equals("不限")&&!price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select * from House where price between ? and ? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,price_down);
                                ps.setObject(2,price_up);
                                ps.setObject(3,start);
                                ps.setObject(4,pageSize);
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&!type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                if(bedroom_num!=0&&bedroom_num!=4){
                                        sql="select * from House where type_bedroom=? limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,bedroom_num);
                                        ps.setObject(2,start);
                                        ps.setObject(3,pageSize);
                                }else{
                                        sql="select * from House where type_bedroom>3 limit ?,?";
                                        ps = con.prepareStatement(sql);
                                        ps.setObject(1,start);
                                        ps.setObject(2,pageSize);
                                }
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&!houseToward_select.equals("不限")) {
                                sql = "select * from House where houseToward=? limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,houseToward_select);
                                ps.setObject(2,start);
                                ps.setObject(3,pageSize);
                        }else if(city_select.equals("不限")&&price_select.equals("不限")&&type_bedroom_select.equals("不限")&&houseToward_select.equals("不限")) {
                                sql = "select * from House limit ?,?";
                                ps = con.prepareStatement(sql);
                                ps.setObject(1,start);
                                ps.setObject(2,pageSize);
                        }

                        // 3.执行sql
                        rs = ps.executeQuery();
                        // 4.保存查询出来的数据到list
                        List<House> list = new ArrayList<>();
                        while (rs.next()) {
                                House house = new House();
                                house.setHouseId(rs.getInt("houseId"));
                                house.setUserId(rs.getInt("userId"));
                                house.setManagerId(rs.getInt("managerId"));
                                house .setCity(rs.getString("city"));
                                house .setDistrict(rs.getString("district"));
                                house .setVillage(rs.getString("village"));
                                house .setAddress(rs.getString("address"));
                                house .setFloor(rs.getInt("floor"));
                                house .setFloor_sum(rs.getInt("floor_sum"));
                                house .setFloor_lift(rs.getInt("floor_lift"));
                                house .setPrice(rs.getInt("price"));
                                house .setType_bedroom(rs.getInt("type_bedroom"));
                                house .setType_livingroom(rs.getInt("type_livingroom"));
                                house .setType_bathroom(rs.getInt("type_bathroom"));
                                house .setArea(rs.getString("area"));
                                house .setDescription(rs.getString("description"));
                                house .setHouseToward(rs.getString("houseToward"));
                                house .setFacilities(rs.getString("facilities"));
                                house.setRequirement(rs.getString("requirement"));
                                house.setPersonnum(rs.getInt("personnum"));
                                house.setHouseImg(rs.getString("houseImg"));
                                house.setPayMethod(rs.getString("payMethod"));
                                list.add(house);
                        }
                        return list;
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        // 关闭资源，避免出现异常
                        BaseDao.close(con, ps, rs);
                }
                return null;
        }

        /**
         * 根据managerid查询总记录数
         */
        public int findTotalCountByManager(int managerid);

        int findTotalCountBySearch(String searchContent);

        List<House> findBySearch(String searchContent, int start, int pageSize);



        /**
         * 根据managerid，start,pageSize查询当前页的数据集合
         */
        List<House> findByPageByManager(int managerid ,int start,int pageSize);
}
