package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanProject;
import util.BaseException;
@Component
public interface IProjectService {
	public void addProject(BeanProject Project)throws BaseException;
	
	public BeanProject SearchProject(int compayid)throws BaseException;
	
	public List<BeanProject> loadAllProject()throws BaseException;
	
		
	public void modifryProject(BeanProject Project)throws BaseException;
	
	public void DelProject(int ProjectId)throws BaseException;
	public boolean check(BeanProject Project) throws BaseException;
}
