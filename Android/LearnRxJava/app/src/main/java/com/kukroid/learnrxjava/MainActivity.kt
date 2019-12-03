package com.kukroid.learnrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    val TAG = "RXDemo"
    var greetingMessage = "Hello from RxJava"
    var greetingMessage1 = "Hello from RxJava first time"
    var greetingMessage2 = "Hello from RxJava second time"
    lateinit var greetingObservable: Observable<String>
    lateinit var greetingObservableLong: Observable<Long>
    lateinit var disposable: Disposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetingObservable = Observable.just(greetingMessage, greetingMessage1 , greetingMessage2)
        disposable = greetingObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            greetingText.setText(it)
            Log.d(TAG,"onNext Called" + it)
        }, {
            Log.d(TAG,"OnError Called" + error(it))
        },{
            Log.d(TAG,"onComplete Called")
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}


fun Disposable.addTo(compositeDisposable: CompositeDisposable): Disposable
        = apply { compositeDisposable.add(this) }

