package com.ratta;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @author 刘明
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey，见《创建secretId和secretKey》小节
            Credential cred = new Credential("AKIDAA0QZrqc6IDiyx5z20lJtFNFm3C4oFZb", "vb0HH3pKo3JIYcQUJr85l9rIgmZ6Rotg");

            // 实例化要请求产品(以cvm为例)的client对象
            ClientProfile clientProfile = new ClientProfile();

            clientProfile.setSignMethod(ClientProfile.SIGN_TC3_256);

            SmsClient smsClient = new SmsClient(cred, "ap-chongqing");//第二个ap-chongqing 填产品所在的区

            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setSmsSdkAppid("1400378619");//appId ,见《创建应用》小节
            String[] phones = {"+8617775677919"};  //发送短信的目标手机号，可填多个。
            sendSmsRequest.setPhoneNumberSet(phones);
            sendSmsRequest.setTemplateID("620961");  //模版id,见《创建短信签名和模版》小节
            String[] templateParam = {"124567"};//模版参数，从前往后对应的是模版的{1}、{2}等,见《创建短信签名和模版》小节
            sendSmsRequest.setTemplateParamSet(templateParam);
            sendSmsRequest.setSign("金晶的个人主页"); //签名内容，不是填签名id,见《创建短信签名和模版》小节
            SendSmsResponse sendSmsResponse = smsClient.SendSms(sendSmsRequest); //发送短信
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }
}
