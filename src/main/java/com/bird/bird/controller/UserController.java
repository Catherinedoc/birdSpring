package com.bird.bird.controller;


import com.bird.bird.entity.AddUnitInfo;
import com.bird.bird.entity.Unit_user;
import com.bird.bird.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/findAll")
    public Page<Unit_user> findAll(){
        Pageable pageable = PageRequest.of(0,8);
        return userService.getAllUsers(pageable);
    }

    @ResponseBody
    @PostMapping("/save")
    public String save(@RequestParam("fileImage") MultipartFile file, @RequestParam("user_name") String name,@RequestParam("user_password") String password, @RequestParam("user_account") String account, @RequestParam("fileType") String fileType){
        //处理user成Unit_user对象
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);  //创建日期，String类型
        Unit_user unit_user = new Unit_user(account,password,name,dateNowStr);
        //将file数据以图片形式保存到指定目录下,并返回相对路径
        OutputStream os = null;
        InputStream inputStream = null;
        //String fileName = null;
        try {
            inputStream = file.getInputStream();
            //fileName = file.getOriginalFilename();
            //log.info("fileName="+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 上传文件/图像到指定文件夹（这里可以改成你想存放地址的相对路径）
            String path = "src/main/resources/static/userImages";

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + name + fileType);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            String savePath = path + "/" + name + fileType;
            unit_user.setUser_image(savePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(name);

        String result = userService.save(unit_user);
        if(result == "success"){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/searchByName")
    public List SearchByName(@RequestBody SearchInfo searchInfo){
        return userService.searchByName(searchInfo.searchName);
    }

    @PostMapping("/uploadImage")
    public void ImageUrl(@RequestBody String imageUrl){
        System.out.println(imageUrl);
    }

}
