package com.demo.zptst.common;

import com.demo.zptst.common.Constants;
import com.demo.zptst.common.Result;

public class ResultGenerator {
	    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
	    private static final String DEFAULT_FAIL_MESSAGE = "操作失败";

	    public static Result genSuccessResult() {
	        Result result = new Result();
	        result.setResultCode(Constants.ResultCodeType.RESULT_CODE_SUCCESS.value);
	        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
	        return result;
	    }

	    public static Result genSuccessResult(String message) {
	        Result result = new Result();
	        result.setResultCode(Constants.ResultCodeType.RESULT_CODE_SUCCESS.value);
	        result.setMessage(message);
	        return result;
	    }

	    public static Result genSuccessResult(Object data) {
	        Result result = new Result();
	        result.setResultCode(Constants.ResultCodeType.RESULT_CODE_SUCCESS.value);
	        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
	        result.setData(data);
	        return result;
	    }

	    public static Result genNullResult(String message) {
	        Result result = new Result();
	        result.setResultCode(Constants.ResultCodeType.RESULT_CODE_RESULTNULL.value);
	        result.setMessage(message);
	        return result;
	    }

	    public static Result genFailedResult(int code, String message) {
	        Result result = new Result();
	        result.setResultCode(Constants.ResultCodeType.RESULT_CODE_FAILED.value);
	        result.setMessage(message);
	        return result;
	    }
	   
	    public static Result genErrorResult(int code, String message) {
	        Result result = new Result();
	        result.setResultCode(code);
	        result.setMessage(message);
	        return result;
	    }
}
