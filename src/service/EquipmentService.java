package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IEquipmentDao;
import model.BeanEquipment;
import serviceI.IEquipmentService;
import util.BaseException;
@Service
public class EquipmentService implements IEquipmentService {
	@Resource
	private IEquipmentDao ied;
	@Override
	public void addEquipment(BeanEquipment Equipment) throws BaseException {
		// TODO Auto-generated method stub
		ied.addEquipment(Equipment);
	}

	@Override
	public BeanEquipment SearchEquipment(int Equipmentid) throws BaseException {
		// TODO Auto-generated method stub
		return ied.SearchEquipment(Equipmentid);
	}

	@Override
	public List<BeanEquipment> loadAllEquipment(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		return ied.loadAllEquipment(StationId);
	}

	@Override
	public void modifryEquipment(BeanEquipment Equipment) throws BaseException {
		// TODO Auto-generated method stub
			ied.modifryEquipment(Equipment);
	}

	@Override
	public void DelEquipment(int EquipmentId) throws BaseException {
		// TODO Auto-generated method stub
		BeanEquipment be=new BeanEquipment();
		be.setEquipmentid(EquipmentId);
		ied.DelEquipment(be);
		System.out.println(EquipmentId+"s");
	}

}
