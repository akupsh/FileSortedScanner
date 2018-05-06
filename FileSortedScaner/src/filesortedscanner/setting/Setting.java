package filesortedscanner.setting;

/**
 * Настройки проекта
 * @author Александр Купш
 * @version 1.0
 */
public class Setting {
    /** Директория для сканирования*/
    private String scanDirectory;
    /** Тип сортировки*/
    private Boolean sortedType;
    /** Префик для созданных файлов*/
    private String outPrefix;
    /** Тип содержимого файлов*/
    private String contentType;

    public Setting(String scanDirectory, Boolean sortedType, String outPrefix, String contentType) {
        this.scanDirectory = scanDirectory;
        this.sortedType = sortedType;
        this.outPrefix = outPrefix;
        this.contentType = contentType;
    }

    public String getScanDirectory() {
        return scanDirectory;
    }

    public void setScanDirectory(String scanDirectory) {
        this.scanDirectory = scanDirectory;
    }

    public Boolean getSortedType() {
        return sortedType;
    }

    public void setSortedType(Boolean sortedType) {
        this.sortedType = sortedType;
    }

    public String getOutPrefix() {
        return outPrefix;
    }

    public void setOutPrefix(String outPrefix) {
        this.outPrefix = outPrefix;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
