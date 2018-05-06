/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesortedscanner.controllers;

import filesortedscanner.setting.Setting;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Класс для выполнения сортировки и создания нового файла в отдельном потоке
 * @author Александр Купш
 * @version 1.0
 */
public class FileSorterTask implements Callable<Object> {
    /**Объект для сортировки файла*/
    private FileSorter fileSorter;

    public FileSorterTask(FileSorter fileSorter) {
        this.fileSorter = fileSorter;
    }

    public FileSorterTask(File file, Setting setting) {
        fileSorter = new FileSorter(file, setting);
    }

    public FileSorter getFileSorter() {
        return fileSorter;
    }

    public void setFileSorter(FileSorter fileSorter) {
        this.fileSorter = fileSorter;
    }
    
    @Override
    public Boolean call() throws Exception {
        return fileSorter.sortedFile();
    }
    
}
