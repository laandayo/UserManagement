package Controller;
import Repository.UserRepository;
import View.Menu;

public class UserController extends Menu {
    private final UserRepository UserRepository;
    static String[] options = {"Create a new account","Login system","Exit"};

    public UserController() {
        super("====== USER MANAGEMENT SYSTEM ======", options);
        UserRepository = new UserRepository();
    }


    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                UserRepository.addUser();
                break;
            case 2:
                UserRepository.UserSystem();
                break;
            case 3:
                System.out.println("Exit.");
                break;
            default:
                System.out.println("Invalid!");
        }
    }

}
