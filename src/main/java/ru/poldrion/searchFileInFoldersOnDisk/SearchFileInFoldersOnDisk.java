package ru.poldrion.searchFileInFoldersOnDisk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFileInFoldersOnDisk {

    private static final String FORMAT = ".jpg";
    private static final String PATH_NAME = "d:\\";


    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        searchFiles(new File(PATH_NAME), fileList);

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Все файлы из " + PATH_NAME + " в формате " + FORMAT.split("\\.")[1].toUpperCase());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();

        fileList.stream().map(File::getName).forEach(System.out::println);
    }

    public static void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getAbsoluteFile());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(FORMAT)) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
