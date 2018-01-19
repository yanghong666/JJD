package com.example.myfileup.net;

import com.example.myfileup.HttpData;
import com.example.myfileup.User;
import com.example.myfileup.bean.HttpResult;
import com.example.myfileup.modlel.Goods;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by 杨洪 on 2018/1/12.
 */

public interface API {

    @GET("avatars_subjects")
    Observable<HttpResult<List<Goods>>> avatarsSubjects();

    @FormUrlEncoded
    @POST
    Observable<HttpData<User>> login(@Url String url,
                                     @Field("mobile")String mobile,
                                     @Field("password")String password);


    /**
     * 文件上传
     * @param url
     * @param uid
     * @param token
     * @param img_part
     * @return
     */
    @Multipart //上传文件的注解
    @POST
    Observable<HttpData> upload(@Url String url,//动态Host URL
                                @Part("uid") RequestBody uid,//用户ID
                                @Part("token") RequestBody token,//用户令牌
                                @Part MultipartBody.Part img_part);//图片文件
}
