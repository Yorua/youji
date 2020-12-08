package com.travelElf.youji.constant;

public interface MessageConstant {
    /**上传图片失败**/
    int UPLOAD_IMAGE_FAIL = 1001;

    /**保存失败**/
    int SAVE_FAIL = 1002;

    /**用户账号不存在*/
    int USER_NAME_NOT_EXIST = 2001;

    /**用户密码错误**/
    int USER_PWD_FAIL = 2002;

    /**用户账号已存在*/
    int USER_NAME_REPEAT = 2010;

    /**获取验证码失败**/
    int GET_SMS_CODE_FAIL = 2003;

    /**验证码错误**/
    int SMS_CODE_FAIL = 2004;

    /**注册失败,系统错误**/
    int REGIST_FAIL = 2005;

    /**邮箱已被注册**/
    int EMAIL_IS_REGIST = 2006;

    /**找回密码失败,系统错误**/
    int RETRIEVE_PASSWORD_FAIL = 2007;

    /**该手机号没有注册**/
    int MOBILE_IS_NOT_REGIST = 2008;

    /**登录失败,系统错误**/
    int LOGIN_FAIL = 2009;

    /**用户定位失败**/
    int GET_USER_LOCATION_FAIL = 3001;

    /**获取行政区域数据失败**/
    int GET_DISTRICT_FAIL = 3002;
}
