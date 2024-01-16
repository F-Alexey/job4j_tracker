package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                result = users[i];
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.getValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return user.getValid();
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Al", true), new User("Alex", true), new User("Alexey", false)
            };
            User user = findUser(users, "Alexey");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println(ui.getMessage());
        } catch (UserNotFoundException un) {
            System.out.println(un.getMessage());
        }
    }
}
