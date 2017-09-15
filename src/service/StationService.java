package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.BeanStation;
import daoI.IStationDao;
import serviceI.IStationService;
import util.BaseException;
@Service
public class StationService implements IStationService {
	@Resource
	private IStationDao isd;
	@Override
	public void addStation(BeanStation bs) throws BaseException {
		// TODO Auto-generated method stub
		isd.addStation(bs);
	}

	@Override
	public BeanStation SearchStation(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		BeanStation bs =new BeanStation();
		bs=isd.SearchStation(StationId);
		return bs;
	}

	@Override
	public List<BeanStation> loadAllStation() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanStation> result =new ArrayList<BeanStation>();
		result=isd.loadAllStation();
		return result;
	}

	@Override
	public void modifryStation(BeanStation bs) throws BaseException {
		// TODO Auto-generated method stub
		isd.modifryStation(bs);
	}

	@Override
	public void DelStation(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		
		BeanStation bs =new BeanStation();
		bs.setStationid(StationId);
		isd.DelStation(bs);
	}

	@Override
	public boolean checkStation(BeanStation bs) throws BaseException {
		// TODO Auto-generated method stub
		return false;
	}

}
