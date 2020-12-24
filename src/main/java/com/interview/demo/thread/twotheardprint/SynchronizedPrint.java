package com.interview.demo.thread.twotheardprint;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedPrint {

    Object lock = new Object();

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static boolean isPass = false;

    public void testPrint(){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (lock) (
//
//                        if(isPass){
//
//                        }else {
//
//                        }
//
//                )
            }
        }).start();
    }

    
    public static void main(String[] args) {

//        buzId： sgmAlert
//        templateId: sgmAlert1001
//        signKey: vbnHJKyuijuhtfre
//        Url: 172.16.40.76:8085/sendSmsMessage
//                ====
//        短信模版内容：  【数字人民币试点】&{content}
//        15225578747

        String content = "TEST;";
        String mobile = "15225578747;";

        String buzId = "sgmAlert;";
        String templateId = "sgmAlert1001;";
        String signKey = "vbnHJKyuijuhtfre;";
        String messageId = "UWC_1437;";

        String params = "content="+content;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("buzId", buzId);
        jsonObject.put("templateId", templateId);
        jsonObject.put("messageId", messageId);
        jsonObject.put("params", params);
        jsonObject.put("mobile", mobile);

        StringBuffer sb = new StringBuffer();
        sb.append("buzId=" + buzId);
        sb.append("&messageId=" + messageId);
        sb.append("&params=" + params);
        sb.append("&mobile=" + mobile);
        sb.append("&templateId=" + templateId);
        sb.append("&key=" + signKey);

        String s = DigestUtils.sha256Hex(sb.toString());
        jsonObject.put("sign", s);
        System.out.println(jsonObject.toJSONString());

        sign();


    }

    public static void sign(){
        String content = "name=深金院;vcode=123456;time=1";
        String mobile = "13331071613";

        String buzId = "wallet";
        String templateId = "tmp002";
        String signKey = "!Qaz@Wsx#Edc$R02";
        String messageId = "2020051514150100100000000017";

        String params = "content="+content;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("buzId", buzId);
        jsonObject.put("templateId", templateId);
        jsonObject.put("messageId", messageId);
        jsonObject.put("params", content);
        jsonObject.put("mobile", mobile);

        if (true){
            TreeMap<String, Object> treeMap = new TreeMap<>();
            treeMap.put("buzId", buzId);
            treeMap.put("templateId", templateId);
            treeMap.put("messageId", messageId);
            treeMap.put("params", content);
            treeMap.put("mobile", mobile);
            StringBuffer sbTree = new StringBuffer();
            treeMap.keySet().stream().forEach( item -> {
                sbTree.append(item).append("=").append(treeMap.get(item)).append("&");
            });
            sbTree.append("key=" + signKey);
            String si = DigestUtils.sha256Hex(sbTree.toString());
            jsonObject.put("sign2", si);

        }

        StringBuffer sb = new StringBuffer();
        sb.append("buzId=" + buzId);
        sb.append("&messageId=" + messageId);
        sb.append("&mobile=" + mobile);
        sb.append("&params=" + content);
        sb.append("&templateId=" + templateId);
        sb.append("&key=" + signKey);

        String s = DigestUtils.sha256Hex(sb.toString());
        jsonObject.put("sign", s);
        System.out.println(jsonObject.toJSONString());


        HashMap<String, Object> hashMap = new HashMap<>();

    }
}
