
package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC4 {
	//requried=true (필수입력)상황에서 미입력시 예외처리 
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//MyDate 객체 생성하여 호출 
    @RequestMapping("/getYoilMVC4") // http://localhost/ch2/getYoilMVC
    public String main(MyDate date, Model model) {
 
        // 1. ��ȿ�� �˻�
    	//if(!isValid(year, month, day)) 
    		//return "yoilError";  // ��ȿ���� ������, /WEB-INF/views/yoilError.jsp�� �̵�
    	
        // 2. ó��
    	char yoil = getYoil(date);

        // 3. Model�� �۾� ��� ����
        model.addAttribute("myDate", date);
        
        model.addAttribute("yoil", yoil);
        
        // 4. �۾� ����� ������ View�� �̸��� ��ȯ
        return "yoil"; // /WEB-INF/views/yoil.jsp
        
    }
    
    private char getYoil(MyDate date) {
        Calendar cal = Calendar.getInstance();
        cal.set(date.getYear(), date.getMonth() - 1, date.getDay());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(MyDate date) {    
    	if(date.getYear()==-1 || date.getMonth()==-1 || date.getDay()==-1) 
    		return false;
    	
    	return (1<=date.getYear() && date.getMonth()<=12) && (1<=date.getDay() && date.getDay()<=31); // ������ üũ 
    }
}