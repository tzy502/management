package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanDocument;
import util.BaseException;
@Component
public interface IDocumentService {
	public void addDocument(String DocumentName, String path, int level)throws BaseException;
	
	public BeanDocument SearchDocument(int DocumentId)throws BaseException;
	
	public List<BeanDocument> loadAllDocument()throws BaseException;
	
	public List<BeanDocument> loadDocument(String DocumentName) throws BaseException;
	
	public List<BeanDocument> loadDocument(int level)throws BaseException;
	
	
	public void modifryDocument(int DocumentId, String DocumentName, String path, int level)throws BaseException;
	
	public void DelDocument(int DocumentId)throws BaseException;
}
