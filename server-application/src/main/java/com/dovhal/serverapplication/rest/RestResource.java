//package com.dovhal.serverapplication.rest;
//
//import org.springframework.http.MediaType;
//
//@Path("/")
//public class RestResource {
//
//    //	@GET
////	@Path("hello")
////    @Produces(MediaType.APPLICATION_JSON)
////    public LoginUserRequest sayHello() {
////		return new LoginUserRequest("Hello world");
////    }
//    private UserManager userManager;
//    @GET
//    @Path("kek")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String kekrekrere() {
//        System.out.println("KEK");
//        return "Omae wa";
//    }
//
//    @POST
//    @Path("login")
//    @Produces(MediaType.APPLICATION_JSON)
//    public User login(LoginUserRequest request){
//        System.out.println("LOGIN REQUEST");
//        final User loggedInUser = userManager.login(request.getLogin(), request.getPassword());
//        System.out.println("Logged in user: " + loggedInUser.getLogin());
//        return loggedInUser;
//    }
//
//
//    @POST
//    @Path("registry")
//    @Produces(MediaType.APPLICATION_JSON)
//    public User registry(RegistryUserRequest request){
//        System.out.println("REGISTRY REQUEST");
//        final User registeredUser = userManager.registry(request.getLogin(),request.getPassword(), request.getFullName(), request.getEmail());
//        System.out.println("Registered!");
//        return registeredUser;
//    }
//
//    public HelloWorldResource() {
//        userManager = new UserManager();
//    }
//}