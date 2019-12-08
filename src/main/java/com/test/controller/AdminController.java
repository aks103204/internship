package com.test.controller;


import com.test.model.T_admin;
import com.test.model.T_file;
import com.test.server.AdminImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(name = "admin",value = {"/admin"})
public class AdminController {
    static {
        System.out.println("进入controller");
    }
    @Autowired
    private AdminImpl adminService;

    @RequestMapping(value = "/login/{ano}/{password}")
    public ResponseEntity<Void> login(@PathVariable("ano") String ano,
                                      @PathVariable("password") String psd) {
        T_admin t_admin = new T_admin(ano,psd);
        boolean flag=adminService.login(t_admin);
        if(flag){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/admin_Info/{ano}")
    public ResponseEntity<List<T_admin>> login(@PathVariable("ano") String ano) {
        List<T_admin> list=adminService.queryAdmin_InfoByAno(ano);
            return new ResponseEntity<List<T_admin>>(list,HttpStatus.OK);
    }
    @RequestMapping(value = "/admin_Update_Info/{ano}/{name}/{phone}/{qq}")
    public ResponseEntity<Void> admin_Update_Info(@PathVariable("ano") String ano,
                                                  @PathVariable("name") String name,
                                                  @PathVariable("phone") String phone,
                                                  @PathVariable("qq") String qq) {
        T_admin t_admin = new T_admin(ano,name,phone,qq);
        boolean flag=adminService.update(t_admin);
        if(flag){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/admin_Update_Psd/{ano}/{old_psd}/{new_psd}")
    public ResponseEntity<Void> admin_Update_Psd(@PathVariable("ano") String ano,
                                      @PathVariable("old_psd") String psd,
                                      @PathVariable("new_psd") String npsd) {
        T_admin t_admin = new T_admin(ano,psd);
        boolean flag=adminService.login(t_admin);
        if(flag){
            if(adminService.updatePsd(t_admin,npsd)==true){
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(value = "/admin_Insert_Info")
    public ResponseEntity<Void> admin_Insert_Info(@RequestParam (value = "file",required = false) CommonsMultipartFile uploadFile,
                                                  HttpServletRequest request,
                                                  @RequestParam(value="type",required = false) String type) throws FileNotFoundException {
        if(adminService.addFile(uploadFile,request,type)==1){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

}
}
