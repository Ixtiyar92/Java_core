package ru.geekbrains.core.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {
    private final String source;
    public Backup(String source) {
        this.source = source;
    }
    private final String backup = "./backup";

    /**
     * копирует файлы из текущей папки в папку "./backup"
     * @throws IOException
     */
    public void copy() throws IOException {
        File folder = new File(this.source);
        File bckupfolder = new File(this.backup);
        if(!bckupfolder.exists())
        {
            Path path = Files.createDirectories(Paths.get(this.backup));
            System.out.printf("Директория %s создана\n", path.toString());
        }
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                Files.copy(Paths.get(file.getName()),
                        Paths.get(bckupfolder+"/"+file.getName()),
                        REPLACE_EXISTING);
                System.out.printf("Файл %s скопирован.\n", file.getName());
            }
        }
    }
}
