package com.sunzw.common.net;

import android.util.Log;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author sunzw
 * 拦截器
 */
public class ResponseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        // 以下两句还有点问题
        MediaType mediaType = response.body().contentType();
        // 获取网页源码
        String content = response.body().string();

        try {

            Log.d("flag--", "intercept(ResponseInterceptor.java:39)-->>" + content);
            // check(response);
            convertedData(content);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }

    public void convertedData(String data) {

    }

}
