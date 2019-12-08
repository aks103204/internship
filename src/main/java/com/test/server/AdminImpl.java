package com.test.server;


import com.test.Tool.InsertByExcel;
import com.test.mapper.T_adminMapper;
import com.test.mapper.T_studentMapper;
import com.test.model.T_admin;
import com.test.model.T_adminExample;
import com.test.model.T_file;
import com.test.model.T_student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("adminService")
public class AdminImpl {
    @Autowired
    T_adminMapper adminDao;
    @Autowired
    T_studentMapper studentDao;

    public List<T_admin> queryAdmin_InfoByAno(String ano){
        T_adminExample T_adminExample =new T_adminExample();
        T_adminExample.createCriteria().andAnoEqualTo(ano);
        return adminDao.selectByExample(T_adminExample);
    }
    public boolean login(T_admin t_admin){
        T_adminExample T_adminExample =new T_adminExample();
        T_adminExample.createCriteria().andPsdEqualTo(t_admin.getPsd()).andAnoEqualTo(t_admin.getAno());
        return adminDao.selectByExample(T_adminExample).size()>0;
    }
    public T_admin queryadminById(String ano){
        return adminDao.selectByPrimaryKey(ano);
    }
    public String getPasswordById(String ano){
        T_adminExample T_adminExample =new T_adminExample();
        T_adminExample.createCriteria().andAnoEqualTo(ano);
        T_admin t_admin=adminDao.selectByPrimaryKey(ano);
        return t_admin.getPsd();
    }
    public boolean update(T_admin t_admin) {
            t_admin.setPsd(getPasswordById(t_admin.getAno()));
            T_adminExample T_adminExample =new T_adminExample();
            T_adminExample.createCriteria().andAnoEqualTo(t_admin.getAno());
            boolean flag=false;
            if(adminDao.selectByPrimaryKey(t_admin.getAno())!=null){
                adminDao.updateByExample(t_admin,T_adminExample);
                flag=true;
            }
            return flag;
    }

    public boolean updatePsd(T_admin t_admin, String npsd) {
        T_adminExample T_adminExample =new T_adminExample();
        T_adminExample.createCriteria().andAnoEqualTo(t_admin.getAno());
        t_admin.setPsd(npsd);
        boolean flag=false;
        if(adminDao.selectByPrimaryKey(t_admin.getAno())!=null){
            adminDao.updateByExampleSelective(t_admin,T_adminExample);
            flag=true;
        }
        return flag;
    }
    public int addFile(CommonsMultipartFile file, HttpServletRequest request, String type){
            /*
             * 错误类型 flag默认为0
             * flag=1 学生信息插入数据库成功
             * flag=2 老师信息插入数据库成功
             * flag=3 上传文件类型错误
             * flag=4 上传文件为空
             */
            T_student t_student = new T_student();
            int flag = 0;
            String testphone = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
            String testname = "^[\u4E00-\u9FA5A-Za-z]+$";
            String testsid = "^[0-9]*$/";
            if (file.isEmpty()) {
                flag=4;
           }else if(file.getOriginalFilename().indexOf("xlsx") < 0 || file.getOriginalFilename().indexOf("xls") < 0) {
                flag=3;//文件类型错误
           } else {
                String path = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();
                try {
                    file.transferTo(new File(path));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                File file1 = new File(path);
                ArrayList<ArrayList<Object>> result = InsertByExcel.readExcel(file1);
                for (int i = 0; i < result.size(); i++) {
                    for (int j = 0; j < result.get(i).size(); j++) {
                        String cno =  ((String) result.get(i).get(0));
                        String psd =  ((String) result.get(i).get(1));
                        String name = ((String) result.get(i).get(4));
                        String phone = ((String) result.get(i).get(6));
                        String qq = ((String) result.get(i).get(8));
                        boolean rsphone = phone.matches(testphone);
                        boolean rsname = name.matches(testname);
                        boolean rssid = cno.matches(testsid);
                        //不符合输出标准的数据，不进行插入并且终止，提醒用户
                        if(studentDao.selectByPrimaryKey(t_student.getSno())!=null) {
                            flag =4; //学生已经存在
                            break;
                        }else if (rssid && rsname &&  rsphone && phone != null &&
                                cno != null && psd != null && name != null){
                            t_student.setCno(cno);
                            t_student.setPsd(psd);
                            t_student.setName(name);
                            t_student.setPhone(phone);
                            t_student.setQq(qq);
                            studentDao.insert(t_student);
                            flag=1; //学生信息导入成功
                        }
                    }
                }
            }
            return flag;
        }
    }
