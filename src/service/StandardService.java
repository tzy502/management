package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IStandardDao;
import model.BeanStandard;
import serviceI.IStandardService;
import util.BaseException;
@Service
public class StandardService implements IStandardService {
	@Resource
	private IStandardDao iss;
	@Override
	public void addStandard(BeanStandard bs) throws BaseException {
		// TODO Auto-generated method stub
			iss.addStandard(bs);
	}

	@Override
	public List<BeanStandard> loadStandard(int Station) throws BaseException {
		// TODO Auto-generated method stub
		
		return iss.loadStandard(Station);
	}

	@Override
	public void modifryStandard(BeanStandard bs) throws BaseException {
		// TODO Auto-generated method stub
		iss.modifryStandard(bs);
	}

	@Override
	public void delStandard(int StandardId) throws BaseException {
		// TODO Auto-generated method stub
		BeanStandard bs =new BeanStandard();
		bs.setStandardid(StandardId);
		iss.delStandard(bs);
	}

	@Override
	public BeanStandard SearchStandard(int StandardId) throws BaseException {
		// TODO Auto-generated method stub
		return iss.SearchStandard(StandardId);
	}

}
