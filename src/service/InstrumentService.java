package service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IInstrumentDao;
import model.BeanInstrument;
import serviceI.IInstrumentService;
import util.BaseException;
@Service
public class InstrumentService implements IInstrumentService {
	@Resource
	private IInstrumentDao id;
	@Override
	public void addInstrument(BeanInstrument Instrument) throws BaseException {
		// TODO Auto-generated method stub
		id.addInstrument(Instrument);


	}

	@Override
	public BeanInstrument SearchInstrument(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanInstrument bc=id.SearchInstrument(compayid);
		return bc;
	}

	@Override
	public List<BeanInstrument> loadAllInstrument() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanInstrument> resutl =id.loadAllInstrument();
		return resutl;
	}

	@Override
	public void modifryInstrument(BeanInstrument Instrument) throws BaseException {
		// TODO Auto-generated method stub
		id.modifryInstrument(Instrument);
	}

	@Override
	public void modifryInstrumentover(BeanInstrument Instrument) throws BaseException {
		// TODO Auto-generated method stub

		id.modifryInstrument(Instrument);

	}

	@Override
	public void DelInstrument(int InstrumentId) throws BaseException {
		// TODO Auto-generated method stub
		id.DelInstrument(InstrumentId);
	}



}
