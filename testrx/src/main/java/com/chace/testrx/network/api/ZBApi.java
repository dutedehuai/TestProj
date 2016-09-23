package com.chace.testrx.network.api;

import com.chace.testrx.model.ZBImageInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chacewang on 16/9/23.
 */
public interface ZBApi {
    @GET("search")
    Observable<List<ZBImageInfo>> search(@Query("q") String query);
}
