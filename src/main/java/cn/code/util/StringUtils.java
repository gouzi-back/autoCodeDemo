package cn.code.util;

import cn.code.model.Column;
import cn.code.model.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:haha
 * @Date:2021/2/20 - 02 - 20 15:37
 * @Description:cn.code.util
 * @Version: 1.0
 */
public class StringUtils {



    public static String putOffUnderline(String columnName) {
        StringBuffer fieldNameBuffer = null;
        String tempNameArray[] = columnName.split("_");
        for (int i = 0; i < tempNameArray.length; i++) {
            if (i == 0) {
                fieldNameBuffer = new StringBuffer(tempNameArray[i]);
            } else {
                fieldNameBuffer.append(captureName(tempNameArray[i]));
            }
        }
        return fieldNameBuffer.toString();
    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    public static String switchType(String cloumnType){
        String javaType=null;

        if(cloumnType.equals("VARCHAR")){
            javaType="String";
        }else if(cloumnType.equals("BIGINT")){
            javaType="Long";
        }else if(cloumnType.equals("INT")){
            javaType="Integer";
        }else if(cloumnType.equals("DATETIME")){
            javaType="Date";
        }else{
            javaType="String";
        }
        return javaType;
    }



    public static void main(String args[]){

    }
}
