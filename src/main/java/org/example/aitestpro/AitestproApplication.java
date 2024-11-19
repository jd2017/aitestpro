package org.example.aitestpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("org.example.aitestpro.dao") // 替换为你的 Mapper 接口所在的包
public class AitestproApplication {

    public static void main(String[] args) {
        SpringApplication.run(AitestproApplication.class, args);
    }

}
