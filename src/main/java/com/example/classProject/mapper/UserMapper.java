package com.example.classProject.mapper;

import com.example.classProject.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setAge(rs.getString("age"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setJoinDate(rs.getDate("join_date").toLocalDate());
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));

        return user;
    }
}
