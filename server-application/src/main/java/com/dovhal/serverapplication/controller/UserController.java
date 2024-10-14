package com.dovhal.serverapplication.controller;

import com.dovhal.serverapplication.model.LoginUserRequest;
import com.dovhal.serverapplication.model.RegistryUserRequest;
import com.dovhal.serverapplication.model.User;
import com.dovhal.serverapplication.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserManager userService;
    @Autowired
    public UserController(UserManager userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public User login(@RequestBody LoginUserRequest loginUserRequest){
        System.out.println("LOGIN REQUEST");
        final User loggedInUser = userService.login(loginUserRequest.getUsername(),loginUserRequest.getPassword());
        System.out.println("Logged in user: " + loggedInUser.getUsername());
        return loggedInUser;
    }

    @PostMapping("/registry")
    public User create(@RequestBody RegistryUserRequest registryUserRequest){
        //userService.create(user);
        System.out.println("REGISTRY REQUEST");
        final User registeredUser = userService.registry(registryUserRequest.getFullName(), registryUserRequest.getUsername(), registryUserRequest.getPassword(),  registryUserRequest.getEmail(), registryUserRequest.getDateOfReg());
        System.out.println("Registered!");
        return registeredUser;
        //return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @PutMapping("/update")
//    public ResponseEntity<?> update( @RequestBody User user){
//        final boolean updated = userService.update(user);
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//    @DeleteMapping ("/delete")
//    public ResponseEntity<User> delete(@PathVariable (name = "id") int id, @PathVariable (name = "username") String username){
//        System.out.println("DELETE REQUEST");
//        final boolean deleted = userService.delete(id, username);
//        System.out.println("USER DELETED");
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}
