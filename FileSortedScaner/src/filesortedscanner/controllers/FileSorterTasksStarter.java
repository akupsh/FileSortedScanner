/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesortedscanner.controllers;

import filesortedscanner.setting.Setting;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс для организации параллельного сканирования файлов
 * @author Александр Купш
 * @version 1.0
 */
public class FileSorterTasksStarter {
    /** настройки проекта*/
    private Setting setting;
    /** сервис по организации пула потоков для параллельного выполнения сканирования файлов*/
    private ExecutorService threadPool;
    
    public FileSorterTasksStarter(Setting setting) {
        threadPool = Executors.newCachedThreadPool();
        this.setting = setting;
    }
    
    /**
     * Метод запускающий параллельное сканирование файлов
     * @param files Список файлов для сортировки
     * @throws InterruptedException  ошибка выполнения потока
     */
    public void start(File[] files) throws InterruptedException {
        List<FileSorterTask> list = new LinkedList<>();
        for (File file : files) {
             FileSorterTask sorter = new FileSorterTask(file,setting);
             list.add(sorter);
        }
        threadPool.invokeAll(list);
        threadPool.shutdown();
    }
}
