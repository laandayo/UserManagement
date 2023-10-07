package DataAccess;

import Common.Validation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class UserDao {

    public UserDao() {
        List<User> userList = new ArrayList<>();
    }
    private static UserDao instance = null;

    public static UserDao instance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }
    public void createNewAccount() {
        if (!Validation.checkFileExist()) {
            return;
        }
        String username = Validation.checkInputUsername();
        String password = Validation.checkInputPassword();
        if (!Validation.checkUsernameExist(username)) {
            System.err.println("Username exists.");
            System.out.println("\n");
            return;
        }
        addAccountData(username, password);
    }
    public void loginSystem() {
        if (!Validation.checkFileExist()) {
            return;
        }
        String username = Validation.checkInputUsername();
        String password = Validation.checkInputPassword();
        if (Validation.checkUsernameExist(username)) {
            System.err.println("User not exist");
        }
        if (!Validation.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Password incorrect.");
            }
            else System.err.println("Login success.");
        }
        System.out.println("\n");
    }
    public static void addAccountData(String username, String password) {
        File file;
        file = new File("user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Create Successfully.");
            System.out.println("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String passwordByUsername(String username) {
        File file;
        file = new File("user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}