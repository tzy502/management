package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IMaterialLogDao;
import model.BeanMaterialLog;
import serviceI.IMaterialLogService;
import util.BaseException;
@Service
public class MaterialLogService implements IMaterialLogService {
	@Resource
	private IMaterialLogDao mdl;
	@Override
	public void addMaterialLog(BeanMaterialLog MaterialLog) throws BaseException {
		// TODO Auto-generated method stub
			mdl.addMaterialLog(MaterialLog);
		
		
	}

	@Override
	public BeanMaterialLog SearchMaterialLog(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanMaterialLog bc=mdl.SearchMaterialLog(compayid);
		return bc;
	}

	@Override
	public List<BeanMaterialLog> loadAllMaterialLog() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanMaterialLog> resutl =mdl.loadAllMaterialLog();
		return resutl;
	}

	@Override
	public void modifryMaterialLog(BeanMaterialLog MaterialLog) throws BaseException {
		// TODO Auto-generated method stub

			mdl.modifryMaterialLog(MaterialLog);
		
	}

	@Override
	public void DelMaterialLog(int MaterialLogId) throws BaseException {
		// TODO Auto-generated method stub
		mdl.DelMaterialLog(MaterialLogId);
	}

	@Override
	public List<BeanMaterialLog> loadUserMaterialLog(String userId) {
		// TODO Auto-generated method stub
		return mdl.loadUserMaterialLog(userId);
	}

	@Override
	public List<BeanMaterialLog> loadMaterialMaterialLog(int MaterialId) {
		// TODO Auto-generated method stub
		return mdl.loadMaterialMaterialLog(MaterialId);
	}
	
}
