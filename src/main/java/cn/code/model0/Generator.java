package cn.code.model0;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:haha
 * @Date:2021/2/19 - 02 - 19 13:44
 * @Description:cn.code
 * @Version: 1.0
 */
public class Generator {
    private Configuration configuration;
    private static final String TEMPLATE_PATH = "src/main/resources";
    public  void  init() throws Exception {
        //1.完成环境初始化
        //Configuration实例化
        configuration=new Configuration(Configuration.getVersion());
        //设置模板所在路径
        //String path=this.getClass().getClassLoader().getResource("").getPath();
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
    }

    public  void  init1(String path) throws Exception {
        //1.完成环境初始化
        //Configuration实例化
        configuration=new Configuration(Configuration.getVersion());
        //设置模板所在路径
        //String path=this.getClass().getClassLoader().getResource("").getPath();
        configuration.setDirectoryForTemplateLoading(new File(path));
    }

    public void process(String tempName,String savePath) throws Exception {
        //获取模板对应实例
        Template template=configuration.getTemplate(tempName);
        //组装数据
        Map param=new HashMap();
        //1.输出基本数据类型
        param.put("name","单独赋值");//单独赋值
        //2.输出对象
        User user =new User();
        user.setUsername("当赋值为一个对象时的赋值方法");
        param.put("user",user);//当赋值为一个对象时的赋值方法
        //3.输出集合
        List<User> userList =new ArrayList<User>();
        User user1 =new User();
        user1.setUsername("hhhh");

        User user2 =new User();
        user2.setUsername("zzzz");

        userList.add(user1);
        userList.add(user2);

        param.put("userList",userList);


        //初始化保存路径
        FileOutputStream stream = new FileOutputStream(savePath);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(stream);
        //传参生成数据
        template.process(param,outputStreamWriter);
    }


    public void process1(String tempName,String savePath,Map<String,Object> param) throws Exception {
        //获取模板对应实例
        Template template=configuration.getTemplate(tempName);
        //组装数据
        //初始化保存路径
        FileOutputStream stream = new FileOutputStream(savePath);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(stream);
        //传参生成数据
        template.process(param,outputStreamWriter);
    }

    public static void main(String[] args) {
       Generator generator =new Generator();
        try {
            generator.init();
            generator.process("hello.ftl","E://testDownload//test.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
