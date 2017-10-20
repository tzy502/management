package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanMaterial;
import util.BaseException;
@Component
public interface IMaterialService {
	public void addMaterial(BeanMaterial Material)throws BaseException;
	
	public BeanMaterial SearchMaterial(int MaterialId)throws BaseException;
	
	public List<BeanMaterial> loadAllMaterial()throws BaseException;
	
		
	public void modifryMaterial(BeanMaterial Material,String userId)throws BaseException;
	
	public void DelMaterial(int MaterialId)throws BaseException;

}
