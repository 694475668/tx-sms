package com.ratta;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

/**
 * @author 刘明
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String[] params = {"5678"};
            String[] phoneNumbers = {"17775677919"};
            SmsSingleSender ssender = new SmsSingleSender(1400378619, "63b913b0aed7498cf574622e80771475");
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    620961, params, "金晶的个人主页", "", "");
            System.out.println(result);
        } catch (Exception e) {
            // JSON 解析错误
            e.printStackTrace();
        }
    }
}
