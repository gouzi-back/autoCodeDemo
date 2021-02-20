package cn.code.util;

import cn.code.model.Column;
import cn.code.model.Table;
import cn.code.util.PropertiesUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by zezhong.shang on 17-6-5.
 */
public class TableUtils {

    private static String DBDRIVER = PropertiesUtils.get("database.properties", "driver");

    private static String DBURL = PropertiesUtils.get("database.properties", "url");

    private static String DBUSER = PropertiesUtils.get("database.properties", "user");

    private static String DBPASS = PropertiesUtils.get("database.properties", "password");

    private static Connection connection;

    private static DatabaseMetaData dbmd;

    static {
        //1.获取数据库的连接
        try {
            Class.forName(DBDRIVER);
            connection =DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            //2.获取meteData
            dbmd=connection.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取数据库的表名
    public static List<Table> getTable(){
        List<Table> tableList=new ArrayList<Table>();
        try {

            //3.获取所有表名的结果集
            ResultSet resultSet= dbmd.getTables(null,null,null,new String[]{"TABLE"});
            //4.遍历结果集
            while(resultSet.next()){
                Table table=new Table();
                String tablename=resultSet.getString("TABLE_NAME");
                table.setTableName(tablename);//app_info改成AppInfo
                table.setClassName(StringUtils.captureName(StringUtils.putOffUnderline(tablename)));
                table.setColumns(getColumns(tablename));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableList;
    }

    //获取表中的列名
    public static  List<Column> getColumns(String tableName){
        List<Column> columnList=new ArrayList<Column>();
        try {
            ResultSet resultSet= dbmd.getColumns(null,"%",tableName,"%");
            while (resultSet.next()){
                Column column=new Column();

                String columnName=resultSet.getString("COLUMN_NAME");
                String columnType=resultSet.getString("TYPE_NAME");
                String remarks=resultSet.getString("REMARKS");

                column.setColumnName(columnName);
                column.setColumnType(columnType);
                column.setRemarks(remarks);

                column.setFileName(columnName);
                column.setJavaType(StringUtils.switchType(columnType));
                column.setUpperFileName(StringUtils.captureName(columnName));
                columnList.add(column);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return columnList;
    }
    public static void main(String[] args) {
        //getTable();
        getColumns("app_info");
    }
}
