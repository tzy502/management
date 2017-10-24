package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanInstrument;
import util.BaseException;
@Component
public interface IInstrumentService {
	public void addInstrument(BeanInstrument Instrument)throws BaseException;
	
	public BeanInstrument SearchInstrument(int InstrumentId)throws BaseException;
	
	public List<BeanInstrument> loadAllInstrument()throws BaseException;
	
		
	public void modifryInstrumentover(BeanInstrument Instrument)throws BaseException;
	
	public void modifryInstrument(BeanInstrument Instrument)throws BaseException;
	
	public void DelInstrument(int InstrumentId)throws BaseException;

}
