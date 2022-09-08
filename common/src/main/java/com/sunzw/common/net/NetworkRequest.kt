package com.sunzw.common.net

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import javax.inject.Inject

class NetworkRequest @Inject constructor() {
     private var  serviceApi: IServiceApi = RetrofitProvider.provideRetrofit().create(IServiceApi::class.java)

    fun getStock(code: String) : Observable<ResponseBody> {
        return serviceApi.getStockData(code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

}