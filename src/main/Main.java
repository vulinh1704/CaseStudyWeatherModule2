package main;

import weathermenu.HandleMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HandleMenu handleMenu = new HandleMenu();
        try {
            handleMenu.handleMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
