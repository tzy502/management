package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanStation;
import util.BaseException;
@Component
public interface IStationService {
	public void addStation( BeanStation bs)throws BaseException;
	public BeanStation SearchStation(int StationId)throws BaseException;
	public List<BeanStation> loadAllStation()throws BaseException;
	public void modifryStation(BeanStation bs)throws BaseException;
	public void DelStation(int StationId)throws BaseException;
}
