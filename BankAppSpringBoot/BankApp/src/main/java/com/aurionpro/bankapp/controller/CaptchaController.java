package com.aurionpro.bankapp.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/bankapplication")
public class CaptchaController {
	
	private final DefaultKaptcha defaultKaptcha;
	
	@Autowired
    public CaptchaController(DefaultKaptcha defaultKaptcha) {
        this.defaultKaptcha = defaultKaptcha;
    }
	
	@GetMapping("/generate")
    public void getCaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);

        request.getSession().setAttribute("captcha", text);

        response.setContentType("image/jpeg");
        OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			ImageIO.write(image, "jpg", outputStream);
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			outputStream.close();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
