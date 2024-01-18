package ru.job4j.early;

public class PasswordValidator {
    public static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        int len = password.length();
        if (len < 8 || len > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean isOneUppercase = false;
        boolean isOneLowercase = false;
        boolean isOneDigit = false;
        boolean isOneSign = false;
        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                isOneUppercase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                isOneLowercase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                isOneDigit = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                isOneSign = true;
            }
        }
        if (!isOneUppercase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isOneLowercase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isOneDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isOneSign) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        StringBuilder checkForbidden = new StringBuilder(password.toLowerCase());
        for (int i = 0; i < PasswordValidator.FORBIDDEN.length; i++) {
            if (checkForbidden.indexOf(PasswordValidator.FORBIDDEN[i]) > 0) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
