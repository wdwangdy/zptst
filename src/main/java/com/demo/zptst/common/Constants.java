package com.demo.zptst.common;

public class Constants {
	public static enum ResultCodeType {  
		RESULT_CODE_SUCCESS(200),
		RESULT_CODE_NOT_LOGIN(402), 
		RESULT_CODE_USER_EXIST(101),
		RESULT_CODE_FAILED(505), 
		RESULT_CODE_PASSERROR(111),
		RESULT_CODE_PARAM_ERROR(406),
		RESULT_CODE_RESULTNULL(999),
		RESULT_CODE_PARAMNULL(199);
		public int value;

		private ResultCodeType(int value){
			this.value=value;
		}
	} 
}
