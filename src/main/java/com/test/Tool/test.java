package com.test.Tool;

import com.test.Tool.InsertByExcel;
import com.test.model.T_admin;
import com.test.model.T_class;
import com.test.model.T_student;
import com.test.model.T_teacher;
import com.test.model.Task;
import com.test.server.AdminImpl;
import com.test.server.StudentImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext.xml"})
@WebAppConfiguration
public class test {

  @Autowired
  private AdminImpl adminService;
  @Autowired
  private StudentImpl studentService;

//  @Test
//  public void testqueryCustomerbyid() {
//    T_admin t_admin = new T_admin("1001", "123");
//    boolean f = adminService.login(t_admin);
//    System.out.println(f);
//  }

  @Test
  public void queryCustomerbyid() {
    List<T_admin> list = adminService.queryAdmin_InfoByAno("1001");
    for (T_admin t : list) {
      System.out.println(t.getName() + " " + t.getAno());
    }
  }

  @Test
  public void updatePsdById() {
    T_admin t_admin = adminService.queryadminById("1001");
    boolean f = adminService.updatePsd(t_admin, "12");
    System.out.println(f);
  }

  @Test
  public void str() {
    String str = "blob:http://localhost:8080/21f9cf5d-bc9e-47fc-b152-d5a5e527bf9a";
    String realfilepath = str.substring(5, str.length() - 1);
    System.out.println(realfilepath);
  }

      @Test
    public void insertFile() throws IOException {
        File file = new File("C:/mybatisgen/stu.xlsx");
        ArrayList<ArrayList<Object>> result = InsertByExcel.readExcel(file);
        for (int i = 0; i < result.size(); i++) {
          System.out.printf("\n");
          for (int j = 0; j < result.get(i).size(); j++) {
            System.out.printf(result.get(i).get(j).toString());
            System.out.printf("\t");
          }
        }
      }
  @Test
  public void queryTeaInfo() {
    List<T_teacher> list = adminService.queryAllTeacher_Info();
    for (T_teacher t : list) {
      System.out.println(t.getTname() + " " + t.getTno());
    }
  }

  @Test
  public void queryStuInfo() {
    List<T_student> list = adminService.queryAllStudent_Info();
    for (T_student t : list) {
      System.out.println(t.getSname() + " " + t.getSno());
    }
  }

  @Test
  public void queryTeaInfoByTno() {
    T_teacher t = adminService.selectByTeacher_PrimaryKey("10020");
    System.out.println(t.getTname());
  }

  @Test
  public void queryStuInfoByTno() {
    List<T_teacher> list=adminService.queryStudent_TeachersBySno("16201401");
    for(T_teacher tt : list){
      System.out.println(tt.getTno()+"@@@@@@@");
    }
  }

  @Test
  public void queryTeaInfoBySno() {
    List<T_student> list= adminService.queryTeacher_StudentsByTno("10025");
    for(T_student tt : list){
      System.out.println(tt.getSname()+"@@@@@@@");
    }
  }
  @Test
  public void queryClassInfoByCno() {
    T_class t = adminService.queryClass_InfoByCno("162014");
    List<T_student> list = t.getStudentList();
    for(T_student tt : list){
      System.out.println(tt.getSname()+"@@@@@@@");
    }
  }
  @Test
  public void queryClassInfoByPrimaryKey() {
    T_class t = adminService.selectByClass_PrimaryKey("162014");
    System.out.println("#########"+t.getCprofession());
  }

  /*
  *
  * **********************************************************************
  * 以下是学生test
  * */

  @Test
  public void queryStudentMissionBySno() {
    List<Task> t= studentService.queryMissionBySno("16201401");
    System.out.println("#########"+t);
  }
}