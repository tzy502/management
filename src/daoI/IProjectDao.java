package daoI;

import java.util.List;

import model.BeanProject;

public interface IProjectDao {
	public void addProject(BeanProject Project);

	public BeanProject SearchProject(int ProjectId);

	public List<BeanProject> loadAllProject();

	public void modifryProject(BeanProject Project);

	public void DelProject(int ProjectId);

}
