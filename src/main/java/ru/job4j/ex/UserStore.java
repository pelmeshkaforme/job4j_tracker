package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = new User();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
                break;
            }
        }
        if (user.getUsername() == null) {
            throw new UserNotFoundException("User not found.");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            rsl = false;
            throw new UserInvalidException("User does not have access.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("masha", true),
                new User("sasha", false),
                new User("kot", true)
        };
        try {
            findUser(users, "kot");
            validate(findUser(users, "kot"));
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
