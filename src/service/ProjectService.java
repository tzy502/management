package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IProjectDao;
import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;
@Service
public class ProjectService implements IProjectService {
	@Resource
	private IProjectDao cd;
	@Override
	public void addProject(BeanProject Project) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Project)){
			cd.addProject(Project);
		}
		
	}

	@Override
	public BeanProject SearchProject(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanProject bc=cd.SearchProject(compayid);
		return bc;
	}

	@Override
	public List<BeanProject> loadAllProject() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanProject> resutl =cd.loadAllProject();
		return resutl;
	}

	@Override
	public void modifryProject(BeanProject Project) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Project)){
			cd.modifryProject(Project);
		}
	}

	@Override
	public void DelProject(int ProjectId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelProject(ProjectId);
	}
	public boolean check(BeanProject Project) throws BaseException{

		return true;
	}
}
