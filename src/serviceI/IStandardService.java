package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanStandard;
import util.BaseException;
@Component
public interface IStandardService {
	public void addStandard( BeanStandard bs)throws BaseException;
	public List<BeanStandard> loadStandard(int StandardId)throws BaseException;
	public BeanStandard SearchStandard(int StandardId)throws BaseException;
	public void modifryStandard(BeanStandard bs)throws BaseException;
	public void delStandard(int StandardId)throws BaseException;
	public boolean checkStandard(BeanStandard bs)throws BaseException;
}
