package cc.xiaobaicz.safe.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cc.xiaobaicz.safe.util.Restore
import cc.xiaobaicz.safe.util.SafeHelper
import cc.xiaobaicz.safe.util.TipsHelper
import kotlinx.coroutines.launch

class InfoConfigViewModel : BaseObservableViewModel() {

    /**
     * 保存结果
     */
    val save by lazy {
        MutableLiveData<Exception>()
    }

    /**
     * 密码
     */
    val etPassword1 by lazy {
        MutableLiveData<String>()
    }

    /**
     * 确认密码
     */
    val etPassword2 by lazy {
        MutableLiveData<String>()
    }

    /**
     * 密码提示
     */
    val etTips by lazy {
        MutableLiveData<String>()
    }

    /**
     * 保存信息
     */
    fun save(function: Restore) {
        if (check(etPassword1.value ?: "", etPassword2.value ?: "")) {
            viewModelScope.launch {
                SafeHelper.setPassword(etPassword1.value!!)
                TipsHelper.setTips(etTips.value ?: "")
                save.postValue(null)
                function()
            }
        } else {
            function()
        }
    }

    //内容校验
    private fun check(pw1: String, pw2: String): Boolean {
        if (pw1 != pw2) {
            save.postValue(Exception("密码不一致"))
            return false
        }
        if (pw1.length < 6 || pw2.length < 6) {
            save.postValue(Exception("密码长度最少6位"))
            return false
        }
        return true
    }

}