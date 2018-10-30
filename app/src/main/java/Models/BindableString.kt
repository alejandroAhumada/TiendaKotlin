package Models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import java.util.*

class BindableString : BaseObservable() {

    private var value : String? = null

    @Bindable
    fun getValue() : String {
        return if(value != null) value!! else ""
    }

    fun setValue(value: String){
        if(!Objects.equals(this.value, value)){
            this.value = value
            notifyPropertyChanged(BR.value)
        }
    }

}