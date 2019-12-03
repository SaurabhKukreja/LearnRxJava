package com.kukroid.learnrxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ObservableFrom: AppCompatActivity() {

    val TAG = "TAG"
    lateinit var myObservable: Observable<String>
    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myObservable = Observable.fromArray("Hello A, Hello B , Hello C")
        disposable = myObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe() { it ->
                Log.d(TAG, it)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}