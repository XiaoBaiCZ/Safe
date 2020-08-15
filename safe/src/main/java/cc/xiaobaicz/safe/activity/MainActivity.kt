package cc.xiaobaicz.safe.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import cc.xiaobaicz.safe.R
import cc.xiaobaicz.safe.model.MainGlobalViewModel
import cc.xiaobaicz.utils.statusbar.SystemUiHelper

class MainActivity : BaseActivity() {

    private val vm by viewModels<MainGlobalViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.systemUiSize.observe(this, Observer {
            //获取窗口安全区域大小后再加载导航组件
            setContentView(R.layout.activity_main)
        })

        //超时重新登陆
        vm.timeout.observe(this, Observer {
            findNavController(R.id.fragment).navigate(R.id.action_global_verifyFragment)
        })

        vm.getSystemUiSize(SystemUiHelper.get(this@MainActivity))
    }

}