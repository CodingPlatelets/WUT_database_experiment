package edu.wut.dbexp.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenka
 * @date 2021/5/2110:06
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
}

