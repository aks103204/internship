package com.test.mapper;

import com.test.Tool.InsertByExcel;
import com.test.model.T_admin;
import com.test.model.T_student;
import com.test.model.T_teacher;
import com.test.server.AdminImpl;
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

  @Test
  public void testqueryCustomerbyid() {
    T_admin t_admin = new T_admin("1001", "123");
    boolean f = adminService.login(t_admin);
    System.out.println(f);
  }

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

  //    @Test
//    public void insertFile() throws IOException {
//        File file = new File("C:/mybatisgen/stu.xlsx");
//        ArrayList<ArrayList<Object>> result = InsertByExcel.readExcel(file);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.printf("\n");
//            for (int j = 0; j < result.get(i).size(); j++) {
//                System.out.printf(result.get(i).get(j).toString());
//                System.out.printf("\t");
//            }
  @Test
  public void queryTeaInfo() {
    List<T_teacher> list = adminService.queryAllTeacher_Info();
    for (T_teacher t : list) {
      System.out.println(t.getName() + " " + t.getTno());
    }
  }

  @Test
  public void queryStuInfo() {
    List<T_student> list = adminService.queryAllStudent_Info();
    for (T_student t : list) {
      System.out.println(t.getName() + " " + t.getSno());
    }
  }

  @Test
  public void queryTeaInfoByTno() {
    T_teacher t = adminService.queryTeacher_InfoByTno("10020");
    System.out.println(t.getName());
  }

  @Test
  public void queryStuInfoByTno() {
    T_student t = adminService.queryStudent_InfoBySno("16201433");
    System.out.println(t.getName());
  }
//    @Test
//    public void testQueryUserByUserId() {
//        String userId = "aks123";
//        int n = userService.queryUserByUserName(userId);
//        System.out.println(n);
//    }
//    @Test
//    public void insert(){
//        userService.register("123","123");
//    }
//    @Test
//    public void update(){
//        System.out.println(customerService.updateById(12,"橘子","asd","12121",1));
//    }
//    @Test
//    public void queryLike(){
//        List<Customer> l = customerService.queryLike(1,"笔");
//        System.out.println(l.size());
//        System.out.println(l.size());
//        System.out.println(l.size());
//        System.out.println(l.size());
//        for(Customer customer :l){
//            System.out.println(customer.getName());
//        }
//    }

}