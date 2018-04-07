package service;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Decoder.BASE64Encoder;
import daoI.IUserDao;
import daoI.IMissionDao;
import model.BeanAssess;
import model.BeanUser;
import serviceI.IUserService;
import util.BaseException;

@Service
public class UserService implements IUserService{
	@Resource
	private IUserDao IUserDao;
	@Resource
	private IMissionDao IMissionDao;
	public UserService(){
		System.out.println("UserService Constructor...\n\n\n\n\n\n");
	}
	@Override
	public void register(String userId, String password, String userName, int roleId, String userPhone,String userMail)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanUser user = new BeanUser();
		user.setUserId(userId);
		user.setPassword(password);
		user.setRoleId(roleId);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		user.setUserMail(userMail);
		IUserDao.addUser(user);
	}


	//登陆
	@Override
	public BeanUser login(String userId, String password) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		if(user == null){
			throw new BaseException("用户名不存在!");
		}
		
		try {
	
			if(checkPassword(password,user.getPassword()) != true){
				throw new BaseException("密码错误！");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//修改密码
	@Override
	public void changePassword(String userId, String oldPassword, String newPassword) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		try {
			if(checkPassword(oldPassword,user.getPassword()) == true){
				user.setPassword(newPassword);
				IUserDao.modifryUser(user);
			}
			else{
				throw new BaseException("原密码错误！");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	//重置密码
	@Override
	public void resetPassword(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
			user.setPassword("123456");
		IUserDao.modifryUser(user);
	}
//dfsgasdfgsdfg
	

	//修改用户
	@Override
	public void updateUser(String userId, String userName, int roleId, String userPhone,String userMail) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		user.setUserId(userId);
		user.setRoleId(roleId);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		user.setUserMail(userMail);
		IUserDao.modifryUser(user);

	}
//asda
	//删除用户
	@Override
	public void delUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		IUserDao.delUser(user);
	}

	//查询用户
	@Override
	public BeanUser searchUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.SearchUser(userId);
	}

	//导出所有用户
	@Override
	public List<BeanUser> loadAllUser() throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.loadAllUser();
	}

	//模糊查询用户
	@Override
	public List<BeanUser> loadUser(String userName) throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.loadUser(userName);
	}


	//密码验证
	public static boolean checkPassword(String newPassword, String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(newPassword.equals(oldPassword))
			return true;
		else
			return false;
	}
	@Override
	public BeanAssess AssessUser(String userId,int year,int data){
		// TODO Auto-generated method stub
		String start = null;
		String end = null;
		
		if(data>0 && data<12){
			start=""+year+"-"+data+"-1 00:00:00";
			int enddata=data+1;
			end=""+year+"-"+enddata+"-1 00:00:00";
		}else if(data==12){
			start=""+year+"-"+data+"-1 00:00:00";
			int enddata=year+1;
			end=""+enddata+"-1-1 00:00:00";
		}
		else if(data==0){
				start=""+year+"-1-1 00:00:00";
				int enddata=year+1;
				end=""+enddata+"-1-1 00:00:00";
			}
		 else{
			switch (data) {
			case -1:
			{
				start=""+year+"-1-1 00:00:00";
				end=""+year+"-3-1 00:00:00";
			}
				break;
			case -2:
			{
				start=""+year+"-4-1 00:00:00";
				end=""+year+"-6-1 00:00:00";
			}
				break;
			case -3:
			{
				start=""+year+"-7-1 00:00:00";
				end=""+year+"-9-1 00:00:00";
			}
				break;
			case -4:
			{
				start=""+year+"-10-1 00:00:00";
				end=""+year+"-12-1 00:00:00";
			}
				break;
			default:
				break;
			}
		}
		
		BeanAssess result=new BeanAssess(userId,start,end);
		return result;
	}



	


}
