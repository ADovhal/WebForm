package com.dovhal.serverapplication.service;

import com.dovhal.serverapplication.controller.UserController;
import com.dovhal.serverapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;


@Service
public class UserManager {


    public User login(String username, String password){
        try{
//            final String passwordHash = Base64.getEncoder().encodeToString(password.getBytes());
            String query = "SELECT * FROM \"Users\" WHERE \"Login\" = '" + username + "' AND \"Password\" = '" + password + "'";

            final ResultSet userSet = DatabaseConnector.getInstance().Query(query);
            userSet.next();
            final User user = new User();
            user.setId(userSet.getInt("Id"));
            user.setFullName(userSet.getString("Full_Name"));
            user.setPassword(userSet.getString("Password"));
            user.setUsername(userSet.getString("Username"));
            user.setEmail(userSet.getString("Email"));
            user.setDate_of_reg(userSet.getString("Date_Of_Reg"));
            return user;
        }catch(Exception e){
            throw new RuntimeException("Error with Log In!");
        }

    }

    public User registry(String username, String password, String fullName, String email, String dateOfReg){
        try{
            String query =  "INSERT INTO \"Users\" (\"Full_Name\",\"Username\",\"Password\",\"Email\", \"Date_Of_Reg\")" +
                    "VALUES ('" + fullName + "','" +username+ "','" +password+ "','" +email+ ",'" +dateOfReg+
                    "') RETURNING (\"Id\",\"Full_Name\",\"Username\",\"Password\",\"Email\",\"Date_Of_Reg\")";
            final User registeredUser = new User();
            final ResultSet registrySet = DatabaseConnector.getInstance().Query(query);
            registeredUser.setId(registrySet.getInt("Id"));
            registeredUser.setFullName(registrySet.getString("Full_Name"));
            registeredUser.setUsername(registrySet.getString("Username"));
            registeredUser.setPassword(registrySet.getString("Password"));
            registeredUser.setEmail(registrySet.getString("Email"));
            registeredUser.setDate_of_reg(registrySet.getString("Date_Of_Reg"));
            System.out.println("User created!");
            return registeredUser;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

//    public User update(String username, String changedUsername, String password, String changedPassword, String email, String changedEmail){
//        try {
//            String query = "";
//        }catch(Exception e){
//            throw new RuntimeException("Error with updating");
//        }
//        return user;
//    }

//    public boolean delete(Integer id, String username){
//        try{
//            String query = "DELETE FROM \"Users\" WHERE Username = '" + username + "' AND Id = '" + id + "'";
//            final ResultSet deleteSet = DatabaseConnector.getInstance().Query(query);
////            deleteSet.
//            System.out.println("User has been deleted!");
//        }catch (Exception e){
//            throw new RuntimeException("Error while deleting");
//        }
//        return true;
//    }
}