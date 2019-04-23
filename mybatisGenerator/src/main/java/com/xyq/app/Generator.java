package com.xyq.app;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {

        try {

			  /*List<String> warnings = new ArrayList<String>();
			   boolean overwrite = true;
			   File configFile = new File("D:/workspace_06/mybatisGenerator/src/main/resources/config.xml");
			   ConfigurationParser cp = new ConfigurationParser(warnings);
			   Configuration config = cp.parseConfiguration(configFile);
			   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			   myBatisGenerator.generate(null);
			   */

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            //E:\workspace_05\mybatisGenerator\src\main\resources\config.xml
            // 指定逆向工程配置文件
            File configFile = new File(System.getProperty("user.dir")+"/mybatisGenerator/src/main/resources/config.xml");
            System.out.println(System.getProperty("user.dir")+"/mybatisGenerator/src/main/resources/config.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);

            System.out.println("===================");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
