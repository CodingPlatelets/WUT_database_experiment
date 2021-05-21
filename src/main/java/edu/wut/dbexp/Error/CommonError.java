package edu.wut.dbexp.Error;

public interface CommonError
{
    String getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String errMsg);
}
