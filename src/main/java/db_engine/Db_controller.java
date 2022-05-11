package db_engine;

import user.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class Db_controller extends Configs {
    Connection db_connect;
    public Connection getDb_connect() throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift-true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        db_connect = DriverManager.getConnection(connection, dbUser, dbPass);
        return db_connect;
    }

    public void sing_up_user(String login, String pass){
        String insert_auth= String.format("INSERT INTO %s(%s,%s)VALUES(?,?)", Constants.AUTH_TABLE, Constants.AUTH_LOGIN, Constants.AUTH_PASSWORD);
        try{
            PreparedStatement ps_auth = getDb_connect().prepareStatement(insert_auth);
            ps_auth.setString(1, login);
            ps_auth.setString(2, pass);
            ps_auth.executeUpdate();
            ps_auth.close();
        }catch (Exception e){
            System.out.println("Проблема добавление в бд");
        }
    }

    public void sing_up_other(String name, String surname, String school, int degree, double avr_point){
        String insert_user = String.format("INSERT INTO %s(%s,%s,%s,%s,%s)VALUES(?,?,?,?,?)", Constants.USER_TABLE, Constants.USER_NAME, Constants.USER_SURNAME, Constants.USER_SCHOOL, Constants.USER_DEGREE, Constants.USER_AVR_POINT);
        try{
            PreparedStatement ps_user = getDb_connect().prepareStatement(insert_user);
            ps_user.setString(1, name);
            ps_user.setString(2, surname);
            ps_user.setString(3, school);
            ps_user.setInt(4, degree);
            ps_user.setDouble(5, avr_point);
            ps_user.executeUpdate();
            ps_user.close();
        }catch (Exception e){
            System.out.println("Проблема добавление в бд");
        }
    }

    public ArrayList<User> get_users(){
        ArrayList<User> items = new ArrayList<>();
        try{
           String select_user = "SELECT * FROM " + Constants.USER_TABLE;
           PreparedStatement ps_user = getDb_connect().prepareStatement(select_user);
           ResultSet resultSet_user = ps_user.executeQuery();
           while (resultSet_user.next()){
               int id = resultSet_user.getInt(Constants.USER_ID);
               String name = resultSet_user.getString(Constants.USER_NAME);
               String surname = resultSet_user.getString(Constants.USER_SURNAME);
               String school = resultSet_user.getString(Constants.USER_SCHOOL);
               int degree = resultSet_user.getInt(Constants.USER_DEGREE);
               double avr_point = resultSet_user.getDouble(Constants.USER_AVR_POINT);
               items.add(new User(id,name,surname,school,degree,avr_point));
           }
           ps_user.close();
       }catch (Exception e){
           System.out.println("Проблема в получений информаций из бд");
       }
        return items;
    }

    public void delete_user(int id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try{
            String delete_user = String.format("DELETE FROM %s WHERE %s = ?", Constants.USER_TABLE, Constants.USER_ID);
            PreparedStatement ps_user = getDb_connect().prepareStatement(delete_user);
            ps_user.setInt(1, id);
            ps_user.executeUpdate();
            ps_user.close();
        }catch (Exception e){
            System.out.println("Проблема в удалений, не удаляется");
        }
    }

    public boolean check_login(String login, String pass) {
        boolean isTrue = false;
        String check = "SELECT * FROM " +  Constants.AUTH_TABLE + " WHERE " + Constants.AUTH_LOGIN + "=? AND " + Constants.AUTH_PASSWORD+"=?";
        try {
            PreparedStatement ps = getDb_connect().prepareStatement(check);
            ps.setString(1,login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            isTrue = rs.next();
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ошибка в запросе в бд, или подключение в бд");
        }
        return isTrue;
    }
}
