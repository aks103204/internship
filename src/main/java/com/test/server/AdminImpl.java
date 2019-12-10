package com.test.server;


import com.test.Tool.InsertByExcel;
import com.test.mapper.T_adminMapper;
import com.test.mapper.T_fileMapper;
import com.test.mapper.T_studentMapper;
import com.test.mapper.T_teacherMapper;
import com.test.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("adminService")
public class AdminImpl {

  @Autowired
  T_adminMapper adminDao;
  @Autowired
  T_studentMapper studentDao;
  @Autowired
  T_fileMapper fileDao;
  @Autowired
  T_teacherMapper teacherDao;

  public List<T_admin> queryAdmin_InfoByAno(String ano) {
    T_adminExample T_adminExample = new T_adminExample();
    T_adminExample.createCriteria().andAnoEqualTo(ano);
    return adminDao.selectByExample(T_adminExample);
  }

  public boolean login(T_admin t_admin) {
    T_adminExample T_adminExample = new T_adminExample();
    T_adminExample.createCriteria().andPsdEqualTo(t_admin.getPsd()).andAnoEqualTo(t_admin.getAno());
    return adminDao.selectByExample(T_adminExample).size() > 0;
  }

  public T_admin queryadminById(String ano) {
    return adminDao.selectByPrimaryKey(ano);
  }

  public String getPasswordById(String ano) {
    T_adminExample T_adminExample = new T_adminExample();
    T_adminExample.createCriteria().andAnoEqualTo(ano);
    T_admin t_admin = adminDao.selectByPrimaryKey(ano);
    return t_admin.getPsd();
  }

  public boolean update(T_admin t_admin) {
    t_admin.setPsd(getPasswordById(t_admin.getAno()));
    T_adminExample T_adminExample = new T_adminExample();
    T_adminExample.createCriteria().andAnoEqualTo(t_admin.getAno());
    boolean flag = false;
    if (adminDao.selectByPrimaryKey(t_admin.getAno()) != null) {
      adminDao.updateByExample(t_admin, T_adminExample);
      flag = true;
    }
    return flag;
  }

  public boolean updatePsd(T_admin t_admin, String npsd) {
    T_adminExample T_adminExample = new T_adminExample();
    T_adminExample.createCriteria().andAnoEqualTo(t_admin.getAno());
    t_admin.setPsd(npsd);
    boolean flag = false;
    if (adminDao.selectByPrimaryKey(t_admin.getAno()) != null) {
      adminDao.updateByExampleSelective(t_admin, T_adminExample);
      flag = true;
    }
    return flag;
  }

  public String insertInfoByFile(MultipartFile file, ArrayList<ArrayList<Object>> result,
      String infoType) throws UnsupportedEncodingException {
    /*
     * 错误类型 flag默认为0
     * flag=1x 代表学生信息 flag=2x代表老师信息       flag=0x代表文件操作
     * flag=x1 插入数据库成功                         flag=x1 插入数据库成功
     * flag=x2 姓名或者电话不合法                     flag=x2 文件为空
     * flag=x3 插入数据已经存在                       flag=x3 文件类型错误
     * flag=x4
     * flag=x5
     * flag=x6
     */
    String flag = null;
    String testphone = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
    String testname = "^[\u4E00-\u9FA5A-Za-z]+$";
    String testsid = "^[0-9]*$/";
    if (file.isEmpty()) {
      flag = "02";
    } else if (file.getOriginalFilename().indexOf("xlsx") < 0
        || file.getOriginalFilename().indexOf("xls") < 0) {
      flag = "03";//文件类型错误
    } else if (infoType.equals("student")) {
      T_student t_student = new T_student();
      for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result.get(i).size(); j++) {
          String sno = ((String) result.get(i).get(0)).split("\\.")[0];
          String cno = ((String) result.get(i).get(1)).split("\\.")[0];
          String psd = ((String) result.get(i).get(2)).split("\\.")[0];
          String name = ((String) result.get(i).get(3));
          String phone = ((String) result.get(i).get(4)).split("\\.")[0];
          String qq = ((String) result.get(i).get(5)).split("\\.")[0];
          boolean rsphone = phone.matches(testphone);
          boolean rsname = name.matches(testname);
          //boolean rssid = cno.matches(testsid);
          //不符合输出标准的数据，不进行插入并且终止，提醒用户
          if (rsname == false || rsphone == false) {
            flag = "12";
          }
          if (studentDao.selectByPrimaryKey(t_student.getSno()) != null) {
            flag = "13"; //学生已经存在
            break;
          } else if (rsname && rsphone && phone != null &&
              cno != null && psd != null && name != null) {
            t_student.setSno(sno);
            t_student.setCno(cno);
            t_student.setPsd(psd);
            t_student.setName(name);
            t_student.setPhone(phone);
            t_student.setQq(qq);
            studentDao.insert(t_student);
            flag = "11"; //学生信息导入成功
            break;
          }
        }
      }
    } else if (infoType.equals("teacher")) {
      T_teacher t_teacher = new T_teacher();
      for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result.get(i).size(); j++) {
          String tno = ((String) result.get(i).get(0)).split("\\.")[0];
          String psd = ((String) result.get(i).get(1)).split("\\.")[0];
          String name = ((String) result.get(i).get(2));
          String phone = ((String) result.get(i).get(3)).split("\\.")[0];
          String qq = ((String) result.get(i).get(4)).split("\\.")[0];
          String profession = ((String) result.get(i).get(5)).split("\\.")[0];
          boolean rsphone = phone.matches(testphone);
          boolean rsname = name.matches(testname);
          //boolean rssid = cno.matches(testsid);
          //不符合输出标准的数据，不进行插入并且终止，提醒用户
          if (rsname == false || rsphone == false) {
            flag = "22";
          }
          if (studentDao.selectByPrimaryKey(t_teacher.getTno()) != null) {
            flag = "23"; //老师已经存在
            break;
          } else if (rsname && rsphone && phone != null &&
              tno != null && psd != null && name != null) {
            t_teacher.setTno(tno);
            t_teacher.setPsd(psd);
            t_teacher.setName(name);
            t_teacher.setPhone(phone);
            t_teacher.setQq(qq);
            t_teacher.setProfession(profession);
            teacherDao.insert(t_teacher);
            flag = "21"; //学生信息导入成功
            break;
          }
        }
      }
    }
    return flag;
  }

  public String[] addFile(MultipartFile file, String infoType) throws IOException {
    String result[] = new String[2];
    result[0] = null;
    result[1] = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String path = "E:\\weishushu\\IdeaPro\\internship\\src\\main\\webapp\\WEB-INF\\file\\" + file
        .getOriginalFilename();
    try {
      File file1 = new File(path);
      if (file1.exists()) {
        file1.delete();
      } else {
        file.transferTo(file1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    File file1 = new File(path);
    String OwePerno = null;
    ArrayList<ArrayList<Object>> list = InsertByExcel.readExcel(file1);
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.get(i).size(); j++) {
        OwePerno = ((String) list.get(i).get(0));
      }
    }
    T_file t_file = new T_file();
    t_file.setFilename(file.getOriginalFilename());
    t_file.setFiletype(file.getOriginalFilename().split("\\.")[1]);
    t_file.setTime(df.format(new Date()));
    t_file.setTaskNo(null);
    t_file.setOwePerno(OwePerno.split("\\.")[0]);

    if (fileDao.insert(t_file) == (-2147482646)) {
      result[0] = "01";
    }
    result[1] = insertInfoByFile(file, list, infoType);
    return result;
  }

  public List<T_teacher> queryAllTeacher_Info() {
    return teacherDao.queryAllTeacherInfo();
  }

  public Boolean updateTeacher_InfoByTno(T_teacher t_teacher) {
    T_teacherExample t_teacherExample = new T_teacherExample();
    t_teacherExample.createCriteria().andTnoEqualTo(t_teacher.getTno());
        if(teacherDao.updateByExampleSelective(t_teacher,t_teacherExample)==(-2147482646)){
         return true;
        }
    return false;
  }

  public T_teacher queryTeacher_InfoByTno(String tno) {
    return teacherDao.selectByPrimaryKey(tno);
  }

  public List<T_student> queryAllStudent_Info() {
    return studentDao.queryAllStudentInfo();
  }

  public Boolean updateStudent_InfoBySno(T_student t_student) {
    T_studentExample t_studentExample = new T_studentExample();
    t_studentExample.createCriteria().andSnoEqualTo(t_student.getSno());
        if(studentDao.updateByExampleSelective(t_student, t_studentExample) == (-2147482646)){
         return true;
        }
    return false;
  }

  public T_student queryStudent_InfoBySno(String sno) {
    return studentDao.selectByPrimaryKey(sno);
  }

  public Boolean addStudent_InfoBySno(T_student t_student) {
    if(studentDao.insert(t_student) == (-2147482646)){
      return true;
    }
    return false;
  }

  public Boolean addTeacher_InfoByTno(T_teacher t_teacher) {

    if(teacherDao.insert(t_teacher) == (-2147482646)){
      return true;
    }
    return false;
  }

  public boolean deleteStudent_InfoBySno(String sno) {
    if(studentDao.deleteByPrimaryKey(sno)== (-2147482646)){
      return true;
    }
    return false;
  }

  public Boolean deleteTeacher_InfoBySno(String tno) {
    if(teacherDao.deleteByPrimaryKey(tno)== (-2147482646)){
      return true;
    }
    return false;
  }
}
