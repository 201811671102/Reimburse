package com.cs.base.path;

import org.springframework.web.multipart.MultipartFile;

public class Path {
    public static final String RHOSPITALINVOICE = "E:/校医院报销/src/main/resources/static/img/rHospitalInvoice/";
    public static final String RMONEYINVOICE = "E:/校医院报销/src/main/resources/static/img/rMoneyInvoice/";
    public static final String RPROVEINVOICE = "E:/校医院报销/src/main/resources/static/img/rProveInvoice/";
    public static final String STUDENTIDFRONT = "E:/校医院报销/src/main/resources/static/img/StudentIDFront/";
    public static final String STUDENTIDREVERSE = "E:/校医院报销/src/main/resources/static/img/studentIDReverse/";
    public static final String WORKERIDFRONT = "E:/校医院报销/src/main/resources/static/img/workerIDFront/";
    public static final String WORKERIDREVERSE = "E:/校医院报销/src/main/resources/static/img/workerIDReverse/";
    public static String getFileType(MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return null;
        }else{
            int begin = multipartFile.getOriginalFilename().indexOf(".");
            int end = multipartFile.getOriginalFilename().length();
            return multipartFile.getOriginalFilename().substring(begin,end);
        }
    }
}
