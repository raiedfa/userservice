package com.example.classProject.repository;

import com.example.classProject.mapper.UserMapper;
import com.example.classProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private final static String USERS = "users";

    public User save(User user){
        try {
            String sql = "INSERT INTO users ( first_name , last_name , email , age , address , join_date ) VALUES (?,?,?,?,?,?)";
            jdbcTemplate.update(sql  , user.getFirstName(), user.getLastName() , user.getEmail(), user.getAge(), user.getAddress() , LocalDate.now());
            return getByEmailHelper(user.getEmail());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public User update(User user){
        try {
            String sql = "UPDATE users SET first_name =? , last_name=? , email=? , age=? , address=?, join_date=? WHERE id=?";
            jdbcTemplate.update(sql  , user.getFirstName(), user.getLastName() , user.getEmail(), user.getAge(), user.getAddress(),LocalDate.now(), user.getId());
            return getUserById(user.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteUserById(int id){
        try {
            String sql = "DELETE FROM users WHERE id=? ";
            jdbcTemplate.update(sql,id);
            return "The user with id:" + id + "deleted successfully ";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public User getUserById(int id){
        try {
            String sql ="SELECT * FROM users WHERE id=? " ;
            User user = jdbcTemplate.queryForObject(sql, new UserMapper(),id);
            return user;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public List<User> getAll(){
        try {
            String sql = "SELECT * FROM users";
            List<User> users = jdbcTemplate.query(sql, new UserMapper());
            return users;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> getUsersEmailByFirstName(String firstName) {
        try {
            String sql = "SELECT email FROM users WHERE first_name = ?";
          return   jdbcTemplate.queryForList(sql, String.class, firstName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    public int getIdByEmail(String email){
        try {
            String sql = "SELECT id FROM users WHERE email=?";
            return jdbcTemplate.queryForObject(sql, Integer.class,email);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public User getByEmailHelper(String email){
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            return jdbcTemplate.queryForObject(sql, new UserMapper(),email);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
