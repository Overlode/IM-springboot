package com.IM.springboot_mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class Updates {
    private String version;
    private String content;
    private String androidUrl;
    private String iosUrl;
    private String date;
}
