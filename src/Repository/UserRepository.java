package Repository;
import DataAccess.UserDao;

public class UserRepository implements IUserRepository {
    private UserDao data = new UserDao();

    @Override
    public void addUser() {
        data.createNewAccount();
    }

    @Override
    public void UserSystem() {
        data.loginSystem();
    }
}
