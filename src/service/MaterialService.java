package service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IMaterialDao;
import daoI.IMaterialLogDao;
import model.BeanMaterial;
import model.BeanMaterialLog;
import serviceI.IMaterialService;
import util.BaseException;
@Service
public class MaterialService implements IMaterialService {
	@Resource
	private IMaterialDao md;
	@Resource
	private IMaterialLogDao mdl;
	@Override
	public void addMaterial(BeanMaterial Material) throws BaseException {
		// TODO Auto-generated method stub
		md.addMaterial(Material);


	}

	@Override
	public BeanMaterial SearchMaterial(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanMaterial bc=md.SearchMaterial(compayid);
		return bc;
	}

	@Override
	public List<BeanMaterial> loadAllMaterial() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanMaterial> resutl =md.loadAllMaterial();
		return resutl;
	}

	@Override
	public void modifryMaterial(BeanMaterial Material,String userId) throws BaseException {
		// TODO Auto-generated method stub
		int oldnum=md.SearchMaterial(Material.getMaterialId()).getMaterialover();
		BeanMaterialLog bml=new BeanMaterialLog();
		bml.setMaterialId(Material.getMaterialId());
		bml.setNum(oldnum-Material.getMaterialover());
		Timestamp date = new Timestamp(System.currentTimeMillis()); 
		bml.setDate(date);
		bml.setUserId(userId);
		mdl.addMaterialLog(bml);
		md.modifryMaterial(Material);

	}

	@Override
	public void DelMaterial(int MaterialId) throws BaseException {
		// TODO Auto-generated method stub
		md.DelMaterial(MaterialId);
	}



}
