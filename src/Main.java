import menu.HandleMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HandleMenu handleMenu = new HandleMenu();
        try {
            handleMenu.handleMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
