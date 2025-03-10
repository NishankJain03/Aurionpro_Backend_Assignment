package com.aurionpro.bankapp.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DocumentDto {
    private String name;
    private MultipartFile file;
}
