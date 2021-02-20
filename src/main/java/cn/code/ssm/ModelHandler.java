package cn.code.ssm;

import cn.code.model.Table;
import cn.code.model0.Generator;
import cn.code.util.TableUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:haha
 * @Date:2021/2/20 - 02 - 20 16:21
 * @Description:cn.code.ssm
 * @Version: 1.0
 * 生成实体类
 */
public class ModelHandler {
    private Generator generator=new Generator();
    private static final String TEMPLATE_PATH = "src/main/resources/info";
    //private String tempPath =this.getClass().getClassLoader().getResource("").getPath()+"\\info\\";
    private String savePath="E:\\testDownload";
    public void  exectue() throws Exception {
        //获取到table对应的实例
        List<Table> tableList= TableUtils.getTable();
        Map<String,Object> param=new HashMap<String,Object>();

        for (Table table:tableList){
           param.put("table",table);
           generator.init1(TEMPLATE_PATH);
            generator.process1("AppInfo.ftl",savePath+"\\"+table.getClassName()+".java",param);
        }



    }

    public static void main(String[] args) throws Exception {
        ModelHandler modelHandler=new ModelHandler();
        modelHandler.exectue();
    }
}
