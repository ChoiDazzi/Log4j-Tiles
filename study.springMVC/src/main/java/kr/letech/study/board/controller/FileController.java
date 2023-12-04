package kr.letech.study.board.controller;

import kr.letech.study.board.service.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
@RequiredArgsConstructor
public class FileController {

    @Value("${file.directory}")
    private String directory;



}
