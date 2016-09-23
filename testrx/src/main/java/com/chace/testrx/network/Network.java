package com.chace.testrx.network;

import com.chace.testrx.network.api.ZBApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chacewang on 16/9/23.
 */
public class Network {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static ZBApi sZBApi;

    public static ZBApi getZBApi() {
        if (sZBApi == null) {
            synchronized (ZBApi.class) {
                Retrofit retrofit = new Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl("http://zhuangbi.info/")
                        .addConverterFactory(gsonConverterFactory)
                        .addCallAdapterFactory(rxJavaCallAdapterFactory)
                        .build();
                sZBApi = retrofit.create(ZBApi.class);
            }
        }
        return sZBApi;
    }
}
