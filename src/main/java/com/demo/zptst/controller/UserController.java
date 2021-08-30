package com.demo.zptst.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.zptst.common.Constants;
import com.demo.zptst.common.Result;
import com.demo.zptst.common.ResultGenerator;
import com.demo.zptst.entity.User;
import com.demo.zptst.utils.PageUtil;
import com.demo.zptst.utils.StringUtils;
import com.demo.zptst.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService UserService;
	
	/***
	 * 获取用户列表信息
	 * @param params 获取分页参数
	 * @return
	 */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result get(@RequestParam Map<String, Object> params) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());

    	if (StringUtils.isEmpty(params.get("page")) ||  StringUtils.isEmpty(params.get("limit"))) {
        	logger.error("分页参数异常！");
            return ResultGenerator.genErrorResult(Constants.ResultCodeType.RESULT_CODE_PARAM_ERROR.value, "分页参数异常！");
        }
    	params.put("userid", "");
        PageUtil pageUtil = new PageUtil(params);
        return ResultGenerator.genSuccessResult(UserService.getUsers(pageUtil));
    }

    /**
     * 根据用户ID获取粉丝数
     * @param params
     * @return
     */
    @RequestMapping(value = "/getFollowers")
    public Result getFollowers(@RequestParam Map<String, Object> params) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());

    	if (StringUtils.isEmpty(params.get("page")) ||  StringUtils.isEmpty(params.get("limit"))||
    			StringUtils.isEmpty(params.get("userid").toString())) {
        	logger.error("参数异常！");
            return ResultGenerator.genErrorResult(Constants.ResultCodeType.RESULT_CODE_PARAM_ERROR.value, "参数异常！");
        }
        PageUtil pageUtil = new PageUtil(params);
        return ResultGenerator.genSuccessResult(UserService.getFollowers(pageUtil));
    }
  
    /**
     * 根据用户名查询附近朋友
     * @param params
     * @return
     */
    @RequestMapping(value = "/getNearByFriends")
    public Result getNearByFriends(@RequestParam Map<String, Object> params) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());

    	if (StringUtils.isEmpty(params.get("username"))) {
        	logger.error("用户名不能为空！");
            return ResultGenerator.genErrorResult(Constants.ResultCodeType.RESULT_CODE_PARAM_ERROR.value, "用户名不能为空！");
        }
        /***
         * 查询附近朋友思路:
         * 
         * 拿到用户名后，找到用户坐标经纬度lati，longi 根据经纬度计算出附近查询范围内的用户列表
         */
        return ResultGenerator.genSuccessResult("拿到用户名后，找到用户坐标经纬度lati，longi 根据经纬度计算出附近查询范围内的用户列表");
    }
    
    /**
     * 新增用户信息
     * @param user 
     * @return 
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody User user) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());

    	if (StringUtils.isEmpty(user.getName())) {
            return ResultGenerator.genFailedResult(Constants.ResultCodeType.RESULT_CODE_PARAMNULL.value, "用户名不能为空！");
        }
        
        User oggUser = UserService.getByUserName(user.getName());
        if (oggUser != null) {
            return ResultGenerator.genFailedResult(Constants.ResultCodeType.RESULT_CODE_USER_EXIST.value, "用户名已存在勿重复添加！");
        }

        if (UserService.create(user) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailedResult( Constants.ResultCodeType.RESULT_CODE_FAILED.value,"添加失败");
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody User user) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());
    	User oggUser = UserService.selectById(user.getId());
        if (oggUser == null) {
            return ResultGenerator.genFailedResult(Constants.ResultCodeType.RESULT_CODE_RESULTNULL.value, "无此用户信息！");
        }
        
        if (UserService.updateUser(user)> 0) {
            return ResultGenerator.genSuccessResult();
	    } else {
	        return ResultGenerator.genFailedResult( Constants.ResultCodeType.RESULT_CODE_FAILED.value,"修改用户信息失败");
	    }
    }

    /**
     * 删除用户信息
     * @param ids 单个或多个用户ID,一维数组
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result delete(@RequestBody Integer[] ids) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("isAuthenticated:{},name:{}", authentication.isAuthenticated(), authentication.getName());

        if (ids.length < 1) {
        	logger.error("用户ID参数异常！");
            return ResultGenerator.genFailedResult(Constants.ResultCodeType.RESULT_CODE_PARAM_ERROR.value, "用户ID参数异常！");
        }
        
        if (UserService.deleteUsers(ids) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailedResult(Constants.ResultCodeType.RESULT_CODE_FAILED.value,"删除失败");
        }
    }
}
