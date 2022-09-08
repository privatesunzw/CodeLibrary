package com.sunzw.common.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitProvider {
    private lateinit var retrofit: Retrofit

    fun provideRetrofit(): Retrofit {
        if (!this::retrofit.isInitialized) {
            synchronized(ProvideRetrofit::class) {
                if (!this::retrofit.isInitialized) {
                    val builder = OkHttpClient.Builder()
                    // 估计是一种加密后续了解
                    // SSLSocketFactoryUtils.keyVerify(builder)
                    ////////////
                    builder.connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                    //    .cache()                                              缓存
                    //           .addInterceptor(HttpBaseUrlInterceptor())     url拦截器
                    //           .addInterceptor(loggingInterceptor)            日志
                    //           .addInterceptor(ResponseActionIntercepter())   token失效拦截器
                    val okHttpClient = builder.build()

                    retrofit = Retrofit.Builder()
                        .baseUrl("http://qt.gtimg.cn/")       //主url拼接前半段
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava框架
                        .addConverterFactory(GsonConverterFactory.create())//json解析
                        .client(okHttpClient)
                        .build()
                }

            }

        }
        return retrofit
    }
}