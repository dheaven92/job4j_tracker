package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User foundUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                foundUser = user;
            }
        }
        if (foundUser == null) {
            throw new UserNotFoundException("No user found with login: " + login);
        }
        return foundUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");

            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("This user has no access");
        } catch (UserNotFoundException e) {
            System.out.println("No user found");
        }
    }
}
