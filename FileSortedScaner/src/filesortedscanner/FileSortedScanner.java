package filesortedscanner;

import filesortedscanner.controllers.FileSorterTasksStarter;
import filesortedscanner.setting.ExeptionMessages;
import filesortedscanner.setting.Setting;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Приложение по сортировке файлов в директории
 * @author Александр Купш
 * @version 1.0
 */
public class FileSortedScanner {
    /**
     * Точка входа для приложения по сортировке файлов в директории
     * @param args Параметры передаваемые в приложение
     */
    public static void main(String[] args)  {
        
        try {
            Setting setting = scanParameters(args);
            File directory = new File(setting.getScanDirectory());
            File[] files = directory.listFiles();
            FileSorterTasksStarter starter =new FileSorterTasksStarter(setting);
            starter.start(files);
            System.out.println("Сортировка выполнена успешно!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Функция сканирования параметров
     * @param args Параметры передаваемые в приложение
     * @return настройки проекта Setting
     * @throws java.lang.Exception Ошибки сканирования параметров
     */
    public static Setting scanParameters(String[] args) throws Exception{
        if(args==null)
            throw new Exception(ExeptionMessages.ParametersNofFound);

        if(args.length!=4)  
            throw new Exception(ExeptionMessages.ParametersErrorCount);
        
        String scanDirectory =  args[0] ;
        if(!Files.exists(Paths.get(scanDirectory)))
            throw new Exception(ExeptionMessages.DirectoryNotFound);
        
        String[]  outPrefixString =  args[1].split("=");
        if(outPrefixString.length!=2 
           || !outPrefixString[0].equalsIgnoreCase("--out-prefix"))
            throw new Exception(ExeptionMessages.OutPrefixError);
        String outPrefix = outPrefixString[1];
        
        String[]  contentTypeString =  args[2].split("=");
        if(contentTypeString.length!=2 
           || !contentTypeString[0].equalsIgnoreCase("--content-type") 
           || (!contentTypeString[1].equalsIgnoreCase("i") && !contentTypeString[1].equalsIgnoreCase("s")))
            throw new Exception(ExeptionMessages.ContentTypeError);  
        String contentType= contentTypeString [1];
        
        String[]  sortedTypeString =  args[3].split("=");
        if(contentTypeString.length!=2 
           || !sortedTypeString[0].equalsIgnoreCase("--sort-mode") 
           || (!sortedTypeString[1].equalsIgnoreCase("a") && !sortedTypeString [1].equalsIgnoreCase("d")))
            throw new Exception(ExeptionMessages.SortedTypeError);  
        boolean sortedType =  (sortedTypeString[1].equalsIgnoreCase("a"));
        
        Setting setting = new Setting(scanDirectory, sortedType, outPrefix, contentType);
        return setting;
    }
    
    
}
