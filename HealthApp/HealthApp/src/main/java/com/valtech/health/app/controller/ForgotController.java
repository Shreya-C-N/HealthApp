package com.valtech.health.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ForgotController {
    

    @RequestMapping("/forgot")
    public String openEmailForm(){
        return "forgotpassword";
    }


    @PostMapping("/send-otp")
    public String sendOTP(@RequestParam("email") String email){


        System.out.println("EMAIL "+email);

//        Random random = new Random(1000);
//        
//        int otp = random.nextInt(999999);

        int otp = (int) Math.floor(Math.random()*1000000);

        System.out.println("OTP "+otp);


//        String subject = "OTP From HCE";
//        String message = "<h1> OTP ="+otp+" </h1>";
//        String to=email;
//        
//        boolean flag = this.emailService.sendEmail(subject,message,to);
//        
//        if(flag) {
//            
//        }

        return "verify_otp";
    }

}
