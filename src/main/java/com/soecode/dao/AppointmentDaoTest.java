package com.soecode.dao;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.BaseTest;
import com.soecode.entity.Appointment;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("bookId", bookId);
        param.put("studentId", studentId);
        int insert = appointmentDao.insertAppointment(param);
        System.out.println("insert=" + insert);
    }

    @Test
    public void testQueryByKeyWithBook() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
    
    @Test  
    public void test01() throws Exception {  
        String plainText = "Hello , world !";  
        MessageDigest md5 = MessageDigest.getInstance("md5");  
        byte[] cipherData = md5.digest(plainText.getBytes());  
        StringBuilder builder = new StringBuilder();  
        for(byte cipher : cipherData) {  
            String toHexStr = Integer.toHexString(cipher & 0xff);  
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);  
        }  
        System.out.println(builder.toString());  
        //c0bb4f54f1d8b14caf6fe1069e5f93ad  
    }  

}