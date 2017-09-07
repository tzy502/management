package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanRole;
import util.BaseException;
@Component
public interface IRoleService {
	public void addRole( String roleName,String roleIntroduction,int level)throws BaseException;
	public BeanRole SearchRole(int roleId)throws BaseException;
	public List<BeanRole> loadAllRole()throws BaseException;
	public void modifryRole(int roleId,String roleName,String roleIntroduction,int level)throws BaseException;
	public void DelRole(int roleId)throws BaseException;
}
