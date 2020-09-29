package com.example.chuckjokes.presenter

import com.example.chuckjokes.fragments.JokeView
import com.example.chuckjokes.rest.InstanceApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class JokePresenter : MvpPresenter<JokeView>() {

    fun loadJokes(count: Long) {
        viewState.showError()
        InstanceApi.getApi().getJokes()
            .flatMap { res -> Observable.fromIterable(res.value)}
            .take(count)
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result ->
                run {
                    viewState.showJokes(result)
                }
            }, { throwable ->
                run {
                    viewState.showError()
                }
            })
    }

}
