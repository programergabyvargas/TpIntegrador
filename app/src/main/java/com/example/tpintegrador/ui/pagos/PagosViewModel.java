package com.example.tpintegrador.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PagosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PagosViewModel() {
        mText = new MutableLiveData<>();
    //    mText.setValue("This is Pagos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}