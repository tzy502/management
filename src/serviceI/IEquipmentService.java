package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanEquipment;
import util.BaseException;
@Component
public interface IEquipmentService {
	public void addEquipment(BeanEquipment Equipment)throws BaseException;
	
	public BeanEquipment SearchEquipment(int Equipmentid)throws BaseException;
	
	public List<BeanEquipment> loadAllEquipment(int StationId)throws BaseException;
	
		
	public void modifryEquipment(BeanEquipment Equipment)throws BaseException;
	
	public void DelEquipment(int EquipmentId)throws BaseException;
}
