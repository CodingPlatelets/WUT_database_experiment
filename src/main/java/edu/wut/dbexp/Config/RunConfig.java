package edu.wut.dbexp.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author wenkan
 * @date 2021/5/21 10:06
 */
@Configuration
public class RunConfig implements CommandLineRunner {
    @Value("${openProject.isOpen}")
    private boolean isOpen;

    @Value("${openProject.web.openUrl}")
    private String openUrl;

    @Value("${openProject.cmd}")
    private String cmd;
    @Override
    public void run(String... args){
        if(isOpen){
            String runCmd = cmd + " " + openUrl ;
            System.out.println("运行的命令: " + runCmd);
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(runCmd);
                System.out.println("启动浏览器打开项目成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("启动项目自动打开浏览器失败");
            }
        }
    }
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}

