package cn.code.model;

/**
 * @Auther:haha
 * @Date:2021/2/20 - 02 - 20 15:04
 * @Description:cn.code.model
 * @Version: 1.0
 */
public class Column {
    private String columnName;

    private String fileName;

    private String upperFileName;

    private String columnType;

    private String javaType;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;//备注

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUpperFileName() {
        return upperFileName;
    }

    public void setUpperFileName(String upperFileName) {
        this.upperFileName = upperFileName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}
