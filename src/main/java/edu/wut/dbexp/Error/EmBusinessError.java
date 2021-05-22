package edu.wut.dbexp.Error;

/**
 * @author 多喝岩浆
 */

public enum EmBusinessError implements CommonError
{
    UNKNOWN_ERROR("00000","unknown_error"),

    PARAMETER_VALIDATION_ERROR("00001","invalid_param"),
    LOGIN_FAILED("50001","password is wrong"),

    USER_NOT_EXIST("10001","user_not_exist"),
    INVALID_MAIL("10002","invalid_mail"),
    INVALID_MAIL_FORMAT("10003","invalid_email_format"),
    MAIL_ALREADY_REGISTERED("10004","mail_already_registered"),
    VCODE_NOT_MATCH("10005","vcode_not_match"),
    MULTIPLE_USERS_EXIST("10006","multiple_users_exist"),
    LACK_INFO("10007","lack_info"),
    OPENID_NOT_MATCH("10008","openid_not_match"),

    USER_NOT_MATCH("20001","user_not_match"),
    GOOD_NOT_EXIST("20002","good_not_exist"),
    CANT_LIGHTEN_TWICE_A_DAY("20003","cant_lighten_twice_a_day"),
    CANT_LIGHTEN_IN_24_HOURS("20004","cant_lighten_in_24_hours"),

    PURCHASE_NOT_EXIST("30001","purchase_not_exist"),

    ALREADY_EXIST("40001","already_exist"),

    ;

    private EmBusinessError(String errCode,String errMsg)
    {
        this.errCode=errCode;
        this.errMsg=errMsg;
    }

    private String errCode;

    private String errMsg;

    @Override
    public String getErrCode()
    {
        return errCode;
    }

    @Override
    public String getErrMsg()
    {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg)
    {
        this.errMsg=errMsg;
        return this;
    }
}
