package filesortedscanner.controllers;

import filesortedscanner.setting.Setting;
import filesortedscanner.structures.SortedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Класс для сортировки файла
 * @author Александр Купш
 * @version 1.0
 */
public class FileSorter {
    /** настройки проекта*/
    private Setting setting;
    /** файл для сортировки*/
    private File file;

    public FileSorter( File file,Setting setting) {
        this.setting = setting;
        this.file = file;
    }

    /**
     * Сортировка файла и создание нового файла
     * @return true если сортировка и создание нового файла прошла успешно, false если не успешно
     * @throws FileNotFoundException Файл не найден или доступ к файлу запрещен
     */
    public boolean sortedFile() throws FileNotFoundException    {
        boolean result = false;
        Scanner scanner  = new Scanner(file);
        if(setting.getContentType().equalsIgnoreCase("i")){
            SortedList<Integer> list =new SortedList<>(setting.getSortedType());
            while(scanner.hasNext()){
                int item = scanner.nextInt();
                list.add(item);
            }
            result = createSortedFile(list,file);
        }
        
        if(setting.getContentType().equalsIgnoreCase("s")){
            SortedList<String> list =new SortedList<>(setting.getSortedType());
            while(scanner.hasNext()){
                String item = scanner.nextLine();
                list.add(item);
            }

            result = createSortedFile(list,file);
        }
        scanner.close();
        
        return result;
    }
    /**
     * Сортировка файла и создание нового файла
     * @return true если создание нового файла прошло успешно, false если не успешно
     * @throws FileNotFoundException Файл не получилось создать
     */
    private boolean createSortedFile(SortedList list,File file) throws FileNotFoundException{
        File newFile = new File(  setting.getScanDirectory() +  setting.getOutPrefix() + file.getName());
        PrintWriter writer = new PrintWriter(newFile);
        list.forEach((item) -> {
            writer.println(item);
        });
        writer.close();
        return true;
    }


    
    
    
    
}
