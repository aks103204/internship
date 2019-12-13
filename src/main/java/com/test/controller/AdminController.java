package com.test.controller;


import com.test.model.T_admin;
import com.test.model.T_class;
import com.test.model.T_file;
import com.test.model.T_student;
import com.test.model.T_teacher;
import com.test.server.AdminImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(name = "admin", value = {"/admin"})
public class AdminController {

  static {
    System.out.println("进入controller");
  }

  @Autowired
  private AdminImpl adminService;
  @Autowired
  private HttpServletRequest request;

  @RequestMapping(value = "/login/{ano}/{password}")
  public ResponseEntity<Void> login(@PathVariable("ano") String ano,
      @PathVariable("password") String psd) {
    T_admin t_admin = new T_admin();
    t_admin.setPsd(psd);
    t_admin.setAno(ano);
    boolean flag = adminService.login(t_admin);
    if (flag) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/admin_Info/{ano}")
  public ResponseEntity<List<T_admin>> admin_Info(@PathVariable("ano") String ano) {
    List<T_admin> list = adminService.queryAdmin_InfoByAno(ano);
    return new ResponseEntity<List<T_admin>>(list, HttpStatus.OK);
  }

  @RequestMapping(value = "/admin_Update_Info/{ano}/{name}/{phone}/{qq}")
  public ResponseEntity<Void> admin_Update_Info(@PathVariable("ano") String ano,
      @PathVariable("name") String name,
      @PathVariable("phone") String phone,
      @PathVariable("qq") String qq) {
    T_admin t_admin = new T_admin();
    t_admin.setAno(ano);
    t_admin.setName(name);
    t_admin.setPhone(phone);
    t_admin.setQq(qq);
    boolean flag = adminService.update(t_admin);
    if (flag) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/admin_Update_Psd/{ano}/{old_psd}/{new_psd}")
  public ResponseEntity<Void> admin_Update_Psd(@PathVariable("ano") String ano,
      @PathVariable("old_psd") String psd,
      @PathVariable("new_psd") String npsd) {
    T_admin t_admin = new T_admin();
    t_admin.setAno(ano);
    t_admin.setPsd(psd);
    boolean flag = adminService.login(t_admin);
    if (flag) {
      if (adminService.updatePsd(t_admin, npsd) == true) {
        return new ResponseEntity<Void>(HttpStatus.OK);
      } else {
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
      }
    } else {
      return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @RequestMapping(value = "/admin_Insert_Info")
  public ResponseEntity<String> admin_Insert_Info(
      @RequestParam(value = "file", required = false) MultipartFile uploadFile,
      @RequestParam(value = "type", required = false) String type) throws IOException {
//        String realfilepath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\file\\"
//                + uploadFile.getOriginalFilename();//文件存储路径
    String[] flag = new String[2];

    /*
     * 错误类型 flag默认为0
     * flag=1x 代表学生信息 flag=2x代表老师信息       flag=0x代表文件操作
     * flag=x1 插入数据库成功                         flag=x1 插入数据库成功
     * flag=x2 姓名或者电话不合法                     flag=x2 文件为空
     * flag=x3 插入数据已经存在                       flag=x3 文件类型错误
     */
    try {
      flag = adminService.addFile(uploadFile, type);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    System.out.println(flag[0] + " " + flag[1]);
    String str = null;
    if (("11".equals(flag[1]) || "21".equals(flag[1])) && "01".equals(flag[0])) {
      return new ResponseEntity<String>(HttpStatus.OK);
    } else {
      if (!"01".equals(flag[0])) {
        str = "文件上传失败";
      } else if ("02".equals(flag[0])) {
        str = "文件为空";
      } else if ("03".equals(flag[0])) {
        str = "文件类型错误";
      } else if ("01".equals(flag[0]) && ("12".equals(flag[1]) | "22".equals(flag[1]))) {
        str = "文件上传成功，但基本信息不合法,请以正确格式编辑表格后重新上传！";
      } else if ("01".equals(flag[0]) && ("13".equals(flag[1]) || "23".equals(flag[1]))) {
        str = "文件上传成功，但基本信息不合法,请以正确格式编辑表格后重新上传！";
      }
      return new ResponseEntity<String>(str, HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/teacher_Info")
  public ResponseEntity<List<T_teacher>> teacher_Info() {
    List<T_teacher> list = adminService.queryAllTeacher_Info();
    return new ResponseEntity<List<T_teacher>>(list, HttpStatus.OK);
  }

  @RequestMapping(value = "/teacher_Info_Update/{tno}/{password}/{name}/{phone}/{profession}/{qq}")
  public ResponseEntity<Void> teacher_Info_Update(@PathVariable("tno") String tno,
      @PathVariable("password") String password,
      @PathVariable("name") String name,
      @PathVariable("phone") String phone,
      @PathVariable("profession") String profession,
      @PathVariable("qq") String qq) {
    T_teacher t_teacher = new T_teacher();
    t_teacher.setTno(tno);
    t_teacher.setTpsd(password);
    t_teacher.setTname(name);
    t_teacher.setTphone(phone);
    t_teacher.setTqq(qq);
    t_teacher.setTprofession(profession);
    Boolean flag = adminService.updateTeacher_InfoByTno(t_teacher);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/teacher_InfoById/{tno}")
  public ResponseEntity<T_teacher> teacher_InfoById(@PathVariable("tno") String tno) {
    T_teacher t = adminService.selectByTeacher_PrimaryKey(tno);
    return new ResponseEntity<T_teacher>(t, HttpStatus.OK);
  }

  @RequestMapping(value = "/student_Info")
  public ResponseEntity<List<T_student>> student_Info() {
    List<T_student> list = adminService.queryAllStudent_Info();
    return new ResponseEntity<List<T_student>>(list, HttpStatus.OK);
  }

  @RequestMapping(value = "/student_Info_Update/{sno}/{cno}/{password}/{name}/{phone}/{qq}")
  public ResponseEntity<Void> student_Info_Update(@PathVariable("sno") String sno,
      @PathVariable("cno") String cno,
      @PathVariable("password") String password,
      @PathVariable("name") String name,
      @PathVariable("phone") String phone,
      @PathVariable("qq") String qq) {
    T_student t_student = new T_student();
    t_student.setSno(sno);
    t_student.setCno(cno);
    t_student.setSpsd(password);
    t_student.setSname(name);
    t_student.setSphone(phone);
    t_student.setQq(qq);
    Boolean flag = adminService.updateStudent_InfoBySno(t_student);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/student_InfoById/{sno}")
  public ResponseEntity<T_student> student_InfoById(@PathVariable("sno") String sno) {
    T_student t = adminService.queryStudent_InfoBySno(sno);
    return new ResponseEntity<T_student>(t, HttpStatus.OK);
  }
  @RequestMapping(value = "/student_Add_Info/{sno}/{cno}/{password}/{name}/{phone}/{qq}")
  public ResponseEntity<Void> student_Add_Info(@PathVariable("sno") String sno,
      @PathVariable("cno") String cno,
      @PathVariable("password") String password,
      @PathVariable("name") String name,
      @PathVariable("phone") String phone,
      @PathVariable("qq") String qq) {
    T_student t_student = new T_student();
    t_student.setSno(sno);
    t_student.setCno(cno);
    t_student.setSpsd(password);
    t_student.setSname(name);
    t_student.setSphone(phone);
    t_student.setQq(qq);
    Boolean flag = adminService.addStudent_InfoBySno(t_student);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

  }

  @RequestMapping(value = "/teacher_Add_Info/{tno}/{password}/{name}/{phone}/{profession}/{qq}")
  public ResponseEntity<Void> teacher_Add_Info(@PathVariable("tno") String tno,
      @PathVariable("password") String password,
      @PathVariable("name") String name,
      @PathVariable("phone") String phone,
      @PathVariable("profession") String profession,
      @PathVariable("qq") String qq) {
    T_teacher t_teacher = new T_teacher();
    t_teacher.setTno(tno);
    t_teacher.setTpsd(password);
    t_teacher.setTname(name);
    t_teacher.setTphone(phone);
    t_teacher.setTqq(qq);
    t_teacher.setTprofession(profession);
    Boolean flag = adminService.addTeacher_InfoByTno(t_teacher);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/student_Info_Delete/{sno}")
  public ResponseEntity<Void> student_Info_Delete(@PathVariable("sno") String sno) {
    Boolean flag = adminService.deleteStudent_InfoBySno(sno);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }
  @RequestMapping(value = "/teacher_Info_Delete/{tno}")
  public ResponseEntity<Void> teacher_Info_Delete(@PathVariable("tno") String tno) {
    Boolean flag = adminService.deleteTeacher_InfoBySno(tno);
    if(flag){
      return new ResponseEntity<Void>(HttpStatus.OK);
    }else {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/class_Info")
  public ResponseEntity<List<T_class>> class_Info() {
    List<T_class> list = adminService.queryAllClass_Info();
    return new ResponseEntity<List<T_class>>(list, HttpStatus.OK);
  }
  @RequestMapping(value = "/class_InfoById/{cno}")
  public ResponseEntity<List<T_student>> class_InfoById(@PathVariable("cno") String cno) {
    List<T_student> t = adminService.queryClass_StudentsByCno(cno);
    return new ResponseEntity<List<T_student>>(t, HttpStatus.OK);
  }

  @RequestMapping(value = "/student_Teacher_Details/{sno}")
  public ResponseEntity <List<T_teacher>> student_Teacher_Details(@PathVariable("sno") String sno) {
    List<T_teacher> t = adminService.queryStudent_TeachersBySno(sno);
    return new ResponseEntity<List<T_teacher>>(t, HttpStatus.OK);
  }

  @RequestMapping(value = "/teacher_Student_Details/{tno}")
  public ResponseEntity <List<T_student>> teacher_Student_Details(@PathVariable("tno") String tno) {
    List<T_student> t = adminService.queryTeacher_StudentsByTno(tno);
    return new ResponseEntity<List<T_student>>(t, HttpStatus.OK);
  }
}
