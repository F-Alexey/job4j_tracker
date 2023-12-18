package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public void errorInfo() {
        if (active) {
            System.out.println("Соединение активно.");
        } else {
            System.out.println("Соединение не активно.");
        }
        System.out.println("Статус: " + status);
        System.out.println("Вам письмо: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error firstMessage = new Error();
        Error secondMessage = new Error(true, 404, "Page Not Found");
        Error thirdMessage = new Error(false, 502, "Bad Gateway");
        firstMessage.errorInfo();
        secondMessage.errorInfo();
        thirdMessage.errorInfo();
    }
}
