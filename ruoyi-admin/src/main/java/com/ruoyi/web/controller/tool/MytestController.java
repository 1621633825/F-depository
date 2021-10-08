package com.ruoyi.web.controller.tool;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author liangliang
 * @date 2020/12/18 10:56
 */
@RestController
@RequestMapping("/myTest")
public class MytestController {

    private final static String BAI_DU_AK = "DiwbQ33zVAQWzkNpG0cbL1lGo7ibdtfF";
    private final static String BAI_DU_API = "http://api.map.baidu.com/location/ip";

    /**
     * 读取
     *
     * @param rd
     * @return
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * 创建链接
     *
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return JSONObject.parseObject(jsonText);
        } finally {
            is.close();
        }
    }

    /**
     * 百度获取城市信息
     * @ip ip地址，如果没有传参数则是发送请求的本机IP
     * @throws JSONException
     * @throws IOException
     */
    @GetMapping("/location")
    public JSONObject getIpAndLocation(HttpServletRequest request, String ip, String ak)
            throws JSONException, IOException {
        String url = BAI_DU_API + "?ak=" + BAI_DU_AK;
        System.out.println(url);
        // 这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        return readJsonFromUrl(url);
    }


}
