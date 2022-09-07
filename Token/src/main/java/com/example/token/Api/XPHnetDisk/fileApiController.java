package com.example.token.Api.XPHnetDisk;

import com.alibaba.fastjson.JSONObject;
import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.netdisk.FileInfoBO;
import com.example.token.Utils.feign.SettingServiceFeign;
import com.example.token.Utils.file.FileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/XPHnetDisk")
public class fileApiController {
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private CommonServiceFeign userUtil;
    @Resource
    SettingServiceFeign settingServiceFeign;

    @UserLoginToken
    @GetMapping("/getFileList")
    @ApiOperation("获取网盘文件列表")
    @AspectLogAnnptation
    public ArrayList<Object> getFileList (String url) {
        int userid=userUtil.getCurrentUserInfo().getId();
        if(url==null){
            url=settingServiceFeign.getSettingCodeByName("NetDiskPath")+userid;
        }else {
            url = settingServiceFeign.getSettingCodeByName("NetDiskPath") + userid + url;
        }
        FileInfoBO fileInfoBO=new FileInfoBO();
        fileInfoBO.setF_pathloc(url);
        fileInfoBO.setF_userid(userid);
        ArrayList<Object> jsonObjects=new ArrayList<>();
        List<FileInfoBO> getFileList= fileUtil.getfileList(fileInfoBO);
        if(ObjectUtils.isEmpty(getFileList)){
            log.info("用戶"+userid+" 网盘"+url+" 路径下为空....");
            return jsonObjects;
        }else{
            for(FileInfoBO item:getFileList){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("F_id",item.getF_id());
                jsonObject.put("F_namesvr",item.getF_namesvr());
                jsonObject.put("F_fdTask",item.getF_fdtask());
                jsonObjects.add(jsonObject);
            }
        }
        return jsonObjects;
    }

    @PostMapping("/uploadFile")
    @ApiOperation("上传文件")
    @ResponseBody
    @AspectLogAnnptation
    public String upload(@RequestParam("file") MultipartFile file,@RequestParam("url") String url) throws Exception{
        int userid=userUtil.getCurrentUserInfo().getId();
        if(file.isEmpty()){
            return "文件不能为空";
        }
        if(url.isEmpty()){
            return "路径不能为空";
        }
        fileUtil.uploadFile(file,settingServiceFeign.getSettingCodeByName("NetDiskPath")+userid+url,userid);
        return "上传成功！";
    }

    @GetMapping("/addFilePath")
    @ApiOperation("网盘路径新建")
    @ResponseBody
    @AspectLogAnnptation
    public String addFilePath(@RequestParam String currentPath,@RequestParam String name) throws IOException {
        int userid=userUtil.getCurrentUserInfo().getId();
        if(name.isEmpty()){
            return "文件名不能为空";
        }
        try {
            fileUtil.addFilePath(settingServiceFeign.getSettingCodeByName("NetDiskPath") + userid + currentPath, name, userid);
        }catch (Exception e){
            return "新建失败！！！文件已存在";
        }
        return "新建成功！";
    }

    @UserLoginToken
    @GetMapping("/downloadFile")
    @ApiOperation("下载文件")
    @AspectLogAnnptation
    public void downloadFile (@RequestParam("url") String url, String fileID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userid=userUtil.getCurrentUserInfo().getId();
        FileInfoBO fileInfoBO=new FileInfoBO();
        fileInfoBO.setF_pathloc(settingServiceFeign.getSettingCodeByName("NetDiskPath")+userid+url);
        fileInfoBO.setF_id(fileID);
        fileInfoBO.setF_userid(userid);
        List<FileInfoBO> fileInfoBOList=fileUtil.getfileList(fileInfoBO);
        if(!fileInfoBOList.isEmpty()) {
            String downPath=settingServiceFeign.getSettingCodeByName("NetDiskPath")+userid+url+"/"+fileInfoBOList.get(0).getF_namesvr();
            log.info("下载文件："+downPath);
            try {
                File file = new File(downPath);
                // 取得文件名。
                String filename = file.getName();
                if (!file.exists()) {
                    throw new IOException(url + "文件不存在");
                }
                // 取得文件的后缀名。
                String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

                // 获取文件的MIME类型
                ServletContext servletContext = request.getServletContext();
                String mimeType = servletContext.getMimeType(fileInfoBOList.get(0).getF_namesvr());
                // 将文件读入内存
                FileInputStream fis = new FileInputStream(downPath);
                // 设置相应头类型
                response.setHeader("content-type",mimeType);
                response.setHeader("content-disposition","attachment;filename="+fileInfoBOList.get(0).getF_namesvr());
                // 将文件写出浏览器
                ServletOutputStream outputStream = response.getOutputStream();
                int len;
                byte[] by = new byte[1024*8];
                while((len = fis.read(by)) != -1){
                    outputStream.write(by,0,len);
                }
                outputStream.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
