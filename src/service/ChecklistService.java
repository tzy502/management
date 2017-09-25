package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IChecklistDao;

import model.BeanChecklist;
import serviceI.IChecklistService;
import util.BaseException;
@Service
public class ChecklistService implements IChecklistService {
	@Resource
	private IChecklistDao cd;
	@Override
	public void addChecklist(BeanChecklist Checklist) throws BaseException {
		// TODO Auto-generated method stub
		cd.addChecklist(Checklist);
	}

	@Override
	public BeanChecklist SearchChecklist(int ChecklistId) throws BaseException {
		// TODO Auto-generated method stub
		return cd.SearchChecklist(ChecklistId);
	}

	@Override
	public List<BeanChecklist> loadAllChecklist() throws BaseException {
		// TODO Auto-generated method stub
		return cd.loadAllChecklist();
	}

	@Override
	public void modifryChecklist(BeanChecklist Checklist) throws BaseException {
		// TODO Auto-generated method stub
			cd.modifryChecklist(Checklist);
	}

	@Override
	public void DelChecklist(int ChecklistId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelChecklist(ChecklistId);
		
	}

	@Override
	public List<BeanChecklist> loadChecklist(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		return cd.loadChecklist(StationId);
	}

}
