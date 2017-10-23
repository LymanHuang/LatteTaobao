package com.zyx.latte.net.rx;

import android.content.Context;

import com.zyx.latte.LatteLoader;
import com.zyx.latte.LoaderStyle;
import com.zyx.latte.net.HttpMethod;
import com.zyx.latte.net.RestClientBuilder;
import com.zyx.latte.net.RestCreator;
import com.zyx.latte.net.RestService;
import com.zyx.latte.net.callback.IError;
import com.zyx.latte.net.callback.IFailure;
import com.zyx.latte.net.callback.IRequest;
import com.zyx.latte.net.callback.ISuccess;
import com.zyx.latte.net.callback.RequestCallback;
import com.zyx.latte.net.download.DownloadHandler;


import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by zyx on 2017/8/8.
 */

public class RxRestClient {

    private final String URL;
    private WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private final RequestBody BODY;
    private final File FILE;
    private LoaderStyle LOADER_STYLE;
    private Context CONTEXT;


    public RxRestClient(String URL,
                        Map<String, Object> params,
                        RequestBody body,
                        File file,
                        Context context,
                        LoaderStyle loaderStyle) {
        this.URL = URL;
        this.PARAMS = PARAMS;
        this.BODY = body;
        this.FILE = file;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
    }

    public static RxRestClientBuilder builder(){
        return new RxRestClientBuilder();
    }


    private Observable<String> request(HttpMethod method){
        final RxRestService service = RestCreator.getRxRestService();
        Observable<String> observable = null;


        if (LOADER_STYLE!=null){
            LatteLoader.showLoading(CONTEXT,LOADER_STYLE);
        }

        switch (method){
            case GET:
                observable = service.get(URL,PARAMS);
                break;
            case POST:
                observable = service.post(URL,PARAMS);
                break;
            case POST_RAW:
                observable =service.postRaw(URL,BODY);
            case PUT:
                observable = service.put(URL,PARAMS);
                break;
            case PUT_RAW:
                observable  = service.put(URL,PARAMS);
                break;
            case DELETE:
                observable = service.delete(URL,PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()),FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file",FILE.getName(),requestBody);
                observable = service.upload(URL,body);
                break;
            default:
                break;
        }
       return observable;
    }


    public final Observable<String> get(){
        return request(HttpMethod.GET);
    }

    public final Observable<String> post(){
        if (BODY == null) {
            return request(HttpMethod.POST);
        }else {
            if (!PARAMS.isEmpty()){
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.POST_RAW);
        }

    }

    public final Observable<String> put(){
        if (BODY == null) {
           return request(HttpMethod.PUT);
        }else {
            if (!PARAMS.isEmpty()){
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.PUT_RAW);
        }
    }

    public final Observable<String> delete(){
        return request(HttpMethod.DELETE);
    }

    public final Observable<ResponseBody>  download(){
      final Observable<ResponseBody> responseBodyObservable = RestCreator.getRxRestService().download(URL,PARAMS);
      return responseBodyObservable;
    }
}
