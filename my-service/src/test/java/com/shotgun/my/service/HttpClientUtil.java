package com.shotgun.my.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * http utils
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class); // 日志记录

    private static RequestConfig requestConfig = null;

    private static final  String CONTENT_TYPE_JSON = "application/json";
    private static final  String DEFAULT_CHARSET = "UTF-8";
/*    public static void main(String[] args) {
//        String json = getJsonContent("https://dev9.zhixueyun.com/api/v1/system/setting", null, null);
//        System.out.println(json);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");

        Map<String, String> params = new HashMap<>();
        params.put("appId","FSAID_1317a2c");
        params.put("appSecret","451f4fde18a0407b855c30e702415f99");
        params.put("permanentCode","DF7C3B95B1C952F6244C6BC3187529B5");
//        String json = postJsonContent("https://open.fxiaoke.com/cgi/corpAccessToken/get/V2", headers, params);
//        System.out.println(json);

        JSONObject jsonResult = JSONObject.parseObject("{\"headers\":{\"params\":\"451f4fde18a0407b855c30e702415f99\"},\"params\":{\"params\":\"451f4fde18a0407b855c30e702415f99\"},\"permanentCode\":\"DF7C3B95B1C952F6244C6BC3187529B5\"}");
        Map<String, String> headers1 = jsonResult.getObject("headers", Map.class);
        Map<String, String> params1 = jsonResult.getObject("params", Map.class);

        System.out.println(headers1.toString()+"----1");
        System.out.println(params1.toString()+"----2");

    }*/

    private static final int CONNECT_REQUEST_TIME_OUT = 50000;
    private static final int CONNECT_TIME_OUT = 500000;
    private static final int SOCKET_TIME_OUT = 800000;

    private static final Logger LOGGER = LoggerFactory.getLogger(
            HttpClientUtil.class);


    public static String getJsonContent(String url, Map<String, String> headers, Map<String, String> params) {
        LOGGER.info("get Url:{}", url);

        if (params == null) {
            params = new HashMap<>();
        }

        if (headers == null) {
            headers = new HashMap<>();
        }


        CloseableHttpClient httpclient = HttpClients.createDefault();
        String json = "";
        try {
            URIBuilder builder = new URIBuilder(url);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.setParameter(entry.getKey(), entry.getValue());
            }

            HttpGet httpget = new HttpGet(builder.build());

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpget.setHeader(entry.getKey(), entry.getValue());
            }

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(CONNECT_REQUEST_TIME_OUT)
                    .setConnectTimeout(CONNECT_TIME_OUT)
                    .setSocketTimeout(SOCKET_TIME_OUT)
                    .build();
            httpget.setConfig(requestConfig);


            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                LOGGER.info("statusLine:" + response.getStatusLine());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    json = EntityUtils.toString(entity, DEFAULT_CHARSET);
                    LOGGER.debug("entity json:" + json);
                }
            } catch (Exception e) {
                LOGGER.error("get response error", e);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            LOGGER.error(e.getMessage());
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("get remote url error", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    public static void main2(String[] args) throws Exception {
        //远洋亿家

        final String token = "dcae2703-be1b-4733-b6a7-1a207c6f66b0";
        final int totalCount = 9981;
        final int pageSize = 50;
        final int startAt = 0;

        //当前游标位置
        int curAt = 0;

        List<Runnable> runnables = new ArrayList<>();
        while (curAt < totalCount) {

            final int curAtF = curAt;

            runnables.add(() -> {
                try {
                    //get  curAt,pagesize
                    HashMap<String, String> paramMap = new HashMap<>();
                    paramMap.put("access_token", "dcae2703-be1b-4733-b6a7-1a207c6f66b0");
                    paramMap.put("start", curAtF + "");
                    paramMap.put("limit", pageSize + "");

                    String jsonContent = getJsonContent(
                            "https://yj.oceanhomeplus.com/api/application/enterprise/account/all", null,
                            paramMap);


                    writeToFile(curAtF, jsonContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            curAt += pageSize;

//            if (curAt>3000){
//                break;
//            }

        }

        //异步批量处理
        long count = runnables.parallelStream().map(runnable -> {
            runnable.run();
            return null;
        }).count();

        System.out.println("处理完毕总数:" + count);


    }

    public static void main(String[] args) throws Exception {
        //华侨城

        //分页页数方式

        final String token = "6441dce2-6af3-4b13-ba9e-1cfcf7a8ca5a";
        final int totalCount = 5458;
        final int pageSize = 100;

        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();

        headers.put("Authorization", "Bearer" + token);

        params.put("appId", "20190911094529757-05C3-24C397BC1");
        params.put("pageSize", pageSize + "");


        List<Runnable> runnables = new ArrayList<>();

        int count = 0;
        int curPage = 0;
        while (count < totalCount) {
            int sum = count + pageSize;

            params.put("pageNum", curPage + "");


            Map<String, String> tmap = new HashMap<>();
            tmap.putAll(params);
            final int tPage = curPage;

            runnables.add(() -> {
                try {
                    String content = postJsonContent(
                            "https://auth.chinaoct.com/api/oap/v1/app/list_auth_account", headers, tmap);

                    writeToFile(tPage, content);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

//            System.out.println(x);

//            if (curPage==1){
//                return;
//            }
            count = sum;
            curPage++;
        }

        //异步批量处理
        long doCount = runnables.parallelStream().map(runnable -> {
            runnable.run();
            return null;
        }).count();

        System.out.println("处理完毕总数:" + doCount);

    }

    private static void writeToFile(int tPage, String content) throws IOException {
        File file = new File("D:/wocao/wocao" + tPage + ".txt");
        file.delete();

        FileWriter fw = new FileWriter(file);

        fw.append("\r\n\r\n");

        String x = "curPage:" + tPage + ",,结果：" + content;
        fw.append(x);

        fw.close();
    }

    public static String postJsonContent(String url, Map<String, String> headers, Map<String, String> params) {
        LOGGER.info("post Url:{}", url);

        if (params == null) {
            params = new HashMap<>();
        }

        if (headers == null) {
            headers = new HashMap<>();
        }

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String json = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(CONNECT_REQUEST_TIME_OUT)
                    .setConnectTimeout(CONNECT_TIME_OUT)
                    .setSocketTimeout(SOCKET_TIME_OUT)
                    .build();
            httpPost.setConfig(requestConfig);

            if ( null != headers.get("Content-Type") && headers.get("Content-Type").equals(CONTENT_TYPE_JSON) ){
                StringEntity s;
                if (null != headers.get("Parse_Json")) {
                    s = new StringEntity(JSONObject.toJSONString(params), ContentType.APPLICATION_JSON);
                } else {
                    s = new StringEntity(params.toString(), ContentType.APPLICATION_JSON);
                }
                httpPost.setEntity(s);
                //增加头部设置参数 by:ganyouxian 2019-07-25
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            } else {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }

                if (!params.isEmpty()) {
                    List<NameValuePair> nvps = new ArrayList<>();
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                    }
                    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                }
            }

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                // 获取响应实体
                LOGGER.info("statusLine:" + response.getStatusLine());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    json = EntityUtils.toString(entity, DEFAULT_CHARSET);
                    LOGGER.debug("entity json:" + json);
                }
            } catch (Exception e) {
                LOGGER.error("post response error", e);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            LOGGER.error(e.getMessage());
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("post remote url error", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return json;
    }

    /**
     * post请求传输json参数
     *
     * @param url
     *            url地址
     *            参数
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try {
            if (null != jsonParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     *
     * @param url
     *            url地址
     * @param strParam
     *            参数
     * @return
     */
    public static JSONObject httpPost(String url, String strParam) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            if (null != strParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * post请求传输Map参数
     *
     * @param url
     *            url地址
     * @param param
     *            参数
     * @return
     */
    public static JSONObject httpPost(String url, Map<String, Object> param) {

        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try {
            if (null != param) {
                List<BasicNameValuePair> paramList = param.entrySet().stream().map (entry ->
                        new BasicNameValuePair(entry.getKey(), entry.getValue().toString())
                ).collect(Collectors.toList());
                // 解决中文乱码问题
                StringEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * 发送get请求
     *
     * @param url
     *            路径
     * @return
     */
    public static JSONObject httpGet(String url) {
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            request.releaseConnection();
        }
        return jsonResult;
    }

    public static String doGet(String url, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String getDomainName(HttpServletRequest request) {
        StringBuffer url=request.getRequestURL();
        String tempContextUrl=url.delete(url.length()- request.getRequestURI().length(),url.length()).append("/").toString();
        return tempContextUrl;
    }

}
