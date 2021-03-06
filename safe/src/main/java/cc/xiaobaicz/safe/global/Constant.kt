package cc.xiaobaicz.safe.global

/**
 * 常量池
 * @author BoCheng
 * @date 2019/12/05
 */
object Constant {

    /**
     * 密码有效期超时时间 2分钟
     */
    const val PASSWORD_TIME_OUT = 2 * 60 * 1000L

    /**
     * 密码校验错误超时时间 2分钟
     */
    const val CHECK_TIME_OUT = 2 * 60 * 1000L

    /**
     * 密码超时时间
     */
    const val KEY_TIME_OUT = "key_time_out"

    /**
     * AES算法
     */
    const val AES_ALGORITHM = "AES/CBC/PKCS5Padding"

    /**
     * 生成 AES Key 因子
     */
    const val KEY_PASSWORD_HMD5 = "password_hmd5"

    /**
     * 密码提示
     */
    const val KEY_TIPS = "key_tips"

    /**
     * 是否通过指纹打开，密码框，默认否
     */
    const val KEY_FINGERPRINT = "key_fingerprint"

    /**
     * 密码
     */
    const val KEY_PASSWORD = "key_password"

    /**
     * 本地密码HmacMD5因子
     */
    const val KEY_LOCAL_HMD5 = "local_hmd5"

}