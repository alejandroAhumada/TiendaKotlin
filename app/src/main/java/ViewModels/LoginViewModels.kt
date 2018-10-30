package ViewModels

import Interface.IonClick
import Library.Validate
import Models.LoginModels
import android.app.Activity
import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.alejandro.tiendakotlin.R
import com.alejandro.tiendakotlin.VerificarPassword
import com.alejandro.tiendakotlin.databinding.ActivityVerificarEmailBinding
import com.alejandro.tiendakotlin.databinding.ActivityVerificarPasswordBinding

class LoginViewModels(activity: Activity, bindingEmail: ActivityVerificarEmailBinding?, bindingPassword: ActivityVerificarPasswordBinding?) : LoginModels(), IonClick {

    private var _activity : Activity? = null
    private var _bindingEmail : ActivityVerificarEmailBinding? = null
    private var _bindingPassword : ActivityVerificarPasswordBinding? = null

    init {
        _activity = activity;
        _bindingEmail = bindingEmail
        _bindingPassword = bindingPassword
    }

    override fun onClick(view: View) {
        verificarEmail()
    }

    private fun verificarEmail(){

        var cancel = false
        var focusView: View? = null

        _bindingEmail!!.email.error = null

        if(TextUtils.isEmpty(emailUI.getValue())){
            _bindingEmail!!.email.error = _activity!!.getString(R.string.error_field_required)
            focusView = _bindingEmail!!.email
            cancel = true
        }else if(!isEmailvalid(emailUI.getValue())){
            _bindingEmail!!.email.error = _activity!!.getString(R.string.error_invalid_email)
            focusView = _bindingEmail!!.email
            cancel = true
        }
        if(cancel){
            focusView!!.requestFocus()
        }else{
            _activity!!.startActivity(Intent(_activity, VerificarPassword::class.java))
            _activity!!.overridePendingTransition(R.anim.left_in, R.anim.left_out)
            //Toast.makeText(_activity, emailUI.getValue(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun isEmailvalid(email : String) : Boolean {
        return Validate.isEmail(email)
    }
}