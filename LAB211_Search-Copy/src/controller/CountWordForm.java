/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.File;
import java.io.IOException;
import model.FileFinder;

/**
 *
 * @author dotha
 */
public class CountWordForm extends Form{
    @Override
    public void setup() {

    }

    @Override
    public EXIT_OPTION update() {

        System.out.println("------------------ Count Word ---------------------");
        String path = null;
        while (true) {
            try {
                path = Input.inputString("Enter path: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File is not exist!");
            return EXIT_OPTION.LOOP_EXIT;
        }

        if (file.isDirectory()) {
            System.out.println("File is a directory.");
            return EXIT_OPTION.LOOP_EXIT;
        }

        String word = null;
        while (true) {
            try {
                word = Input.inputString("Enter word: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        FileFinder finder = new FileFinder(file);

        System.out.println("Bout: " + finder.occurrence(word));

        return EXIT_OPTION.LOOP_EXIT;
    }
}