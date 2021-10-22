package com.bird.bird.controller;

import com.bird.bird.Service.BirdVoiceService;
import com.bird.bird.entity.Bird_img;
import com.bird.bird.entity.Bird_information;
import com.bird.bird.Service.BirdImgService;
import com.bird.bird.Service.BirdInformationService;
import com.bird.bird.entity.Bird_voice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/birdInfo")
public class BirdInformationController {
    @Autowired
    BirdInformationService birdInformationService;
    @Autowired
    BirdImgService birdImgService;
    @Autowired
    BirdVoiceService birdVoiceService;
    @GetMapping("/findAll")
    public Page<Bird_information> findAll(){
        Pageable pageable = PageRequest.of(0, 8);
        return birdInformationService.getAllBirds(pageable);
    }

    @ResponseBody
    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("summary") String summary,
                       @RequestParam("bcharacter") String bcharacter, @RequestParam("identify") String identify,
                       @RequestParam("lifehabit") String lifehabit, @RequestParam("reproduction") String reproduction,
                       @RequestParam("birds") String birds, @RequestParam("department") String department, @RequestParam("file1") MultipartFile[] imageList,
                       @RequestParam("file2") MultipartFile[] voiceList){
        /*根据传递过来的表单创建Bird_information对象*/
        Bird_information bird = new Bird_information();
        bird.setBird_birds(birds);
        bird.setBird_bcharacter(bcharacter);
        bird.setBird_department(department);
        bird.setBird_identify(identify);
        bird.setBird_name(name);
        bird.setBird_lifehabit(lifehabit);
        bird.setBird_reproduction(reproduction);
        bird.setBird_summary(summary);
        boolean result1 = birdInformationService.save(bird);
        if(imageList.length == 0){

            return "error";
        }

        /**
         * 文件信息保存
         */
        Bird_img birdImg = new Bird_img();
        Bird_voice birdVoice = new Bird_voice();
        String imageType = ".jpg";
        String voiceType = ".wav";
        OutputStream os = null;
        InputStream inputStream = null;
        String path = "src/main/resources/static/BirdInfo/" + name;
        File srcFile = new File(path);

        if (!srcFile.exists()) {
            srcFile.mkdirs();  //如果目录不存在则创建目录
        }
        /*图片文件保存*/
        // 上传文件/图像到指定文件夹（这里可以改成你想存放地址的相对路径）
        String saveSrc = path + "/" + "images";
        File saveFile = new File(saveSrc);
        if (!saveFile.exists()) {
            saveFile.mkdirs();  //如果目录不存在则创建目录
        }
        for(int i = 0; i < imageList.length; ++i){
            os = null;
            inputStream = null;
            try {
                inputStream = imageList[i].getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流保存到本地文件
                os = new FileOutputStream(saveFile.getPath() + File.separator + name + (i+1) + imageType);
                // 开始读取
                while ((len = inputStream.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                String savePath = saveSrc + "/" + name + (i+1) + imageType;
                birdImg.setBird(bird);
                birdImg.setImg_path(savePath);
                birdImgService.save(birdImg);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*保存音频文件*/
        // 上传文件/图像到指定文件夹（这里可以改成你想存放地址的相对路径）
        saveSrc = path + "/" + "voices";
        saveFile = new File(saveSrc);
        if (!saveFile.exists()) {
            saveFile.mkdirs();  //如果目录不存在则创建目录
        }
        for(int i = 0; i < voiceList.length; ++i){
            os = null;
            inputStream = null;
            try {
                inputStream = voiceList[i].getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流保存到本地文件
                os = new FileOutputStream(saveFile.getPath() + File.separator + name + (i+1) + voiceType);
                // 开始读取
                while ((len = inputStream.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                String savePath = saveSrc + "/" + name + (i+1) + voiceType;
                birdVoice.setBird(bird);
                birdVoice.setBirdVoice(savePath);
                birdVoiceService.save(birdVoice);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 完毕，关闭所有链接
        try {
            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        if(result1){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/searchByName")
    public List SearchByName(@RequestBody SearchInfo searchInfo){
        return birdInformationService.searchByName(searchInfo.searchName);
    }
}
