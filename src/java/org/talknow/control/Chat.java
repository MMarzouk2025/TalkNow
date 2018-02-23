package org.talknow.control;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.talknow.model.Message;
import org.talknow.model.User;

public class Chat extends HttpServlet {

    public Vector<User> chatUsers = new Vector<>();
    public Vector<Message> messages = new Vector<>();

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        chatUsers.add(new User("Marzouk", "123456", "Marzouk@gmail.com"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Gson messagesJsonBuilder = new Gson();
        String messagesJson = messagesJsonBuilder.toJson(messages);
        writer.write(messagesJson);
        /*
        Gson usersJsonBuilder = new Gson();
        String usersJson = usersJsonBuilder.toJson(chatUsers);
        writer.write(usersJson);
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String action = request.getParameter("action");
        if  (action.equals("register")){
            String username = request.getParameter("userName");
            String userEmail = request.getParameter("userEmail");
            String userPassword = request.getParameter("userPassword");
            User newUser = new User(username, userPassword, userEmail);
            chatUsers.add(newUser);
        } else if (action.equals("login")) {
            if (checkLoginParameters(request)) {
                HttpSession mSession = request.getSession();
                String userEmail = request.getParameter("userEmail");
                String username = "";
                for (User user : chatUsers) {
                    if (user.getEmail().equals(userEmail)) {
                        username = user.getUserName();
                    }
                }
                mSession.setAttribute("userName", username);
                writer.write("valid");
            } else {
                writer.write("invalid");
            }
        } else if (action.equals("message")) {
            String senderUser = request.getParameter("user");
            String messageText = request.getParameter("msg");
            Message msg = new Message(senderUser, messageText);
            messages.add(msg);
        }

    }

    private boolean checkLoginParameters(HttpServletRequest request) {
        boolean result = false;
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPass");
        for (User u : chatUsers) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                result = true;
            }
        }
        return result;
    }

}
