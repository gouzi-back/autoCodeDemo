package cn.code.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:haha
 * @Date:2021/2/20 - 02 - 20 15:01
 * @Description:cn.code.model
 * @Version: 1.0
 */
public class Table {
    private String tableName;

    private String className;
    

    List<Column> columns= new ArrayList<Column>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
