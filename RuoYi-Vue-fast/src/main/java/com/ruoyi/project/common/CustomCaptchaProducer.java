package com.ruoyi.project.common;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.Properties;

@Component
public class CustomCaptchaProducer implements Producer {
    private DefaultKaptcha kaptcha;

    public CustomCaptchaProducer() {
        this.kaptcha = new DefaultKaptcha();
        // 设置验证码图片属性，例如字体、字号、颜色等
        Properties props = new Properties();
        props.put("kaptcha.textproducer.font.names", "Arial");
        props.put("kaptcha.textproducer.font.size", "40");
        props.put("kaptcha.textproducer.font.color", "0,0,0");
        props.put("kaptcha.background.clear.from", "255,255,255");
        props.put("kaptcha.background.clear.to", "255,255,255");
        Config config = new Config(props);
        this.kaptcha.setConfig(config);
    }

    @Override
    public BufferedImage createImage(String text) {
        // 使用自定义方式生成验证码图片，例如调用其他图形库或者绘图方式
        // 这里只是一个示例，你可以根据自己的需求来实现
        BufferedImage image = kaptcha.createImage(text);
        // 添加自定义样式，例如添加边框、背景图片等
        return image;
    }

    @Override
    public String createText() {
        return kaptcha.createText();
    }
}
