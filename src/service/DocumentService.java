package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IDocumentDao;
import model.BeanDocument;
import serviceI.IDocumentService;
import util.BaseException;
@Service
public class DocumentService implements IDocumentService {
	@Resource
	private IDocumentDao idd;
	@Override
	public void addDocument(String DocumentName, String path, int level) throws BaseException {
		// TODO Auto-generated method stub
		BeanDocument bd=new BeanDocument();
		bd.setDocumentname(DocumentName);
		bd.setPath(path);
		bd.setlevel(level);
		idd.addDocument(bd);
	}

	@Override
	public BeanDocument SearchDocument(int DocumentId) throws BaseException {
		// TODO Auto-generated method stub
		BeanDocument bd=new BeanDocument();
		bd=idd.SearchDocument(DocumentId);
		return bd;
	}

	@Override
	public List<BeanDocument> loadAllDocument() throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanDocument> bd =new ArrayList<BeanDocument>();
		 bd=idd.loadAllDocument();
		return bd;
	}

	@Override
	public List<BeanDocument> loadDocument(String DocumentName) throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanDocument> bd =new ArrayList<BeanDocument>();
		 bd=idd.loadDocument(DocumentName);
		return bd;
	}

	@Override
	public List<BeanDocument> loadDocument(int level) throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanDocument> bd =new ArrayList<BeanDocument>();
		 bd=idd.loadDocument(level);
		return bd;
	}
	@Override
	public void modifryDocument(int DocumentId, String DocumentName, String path, int level) throws BaseException {
		// TODO Auto-generated method stub
		BeanDocument bd=new BeanDocument();
		bd.setDocumentid(DocumentId);
		bd.setDocumentname(DocumentName);
		bd.setPath(path);
		bd.setlevel(level);
		idd.modifryDocument(bd);
	}

	@Override
	public void DelDocument(int DocumentId) throws BaseException {
		// TODO Auto-generated method stub
		BeanDocument bd=new BeanDocument();
		bd.setDocumentid(DocumentId);
		idd.delDocument(bd);
	}
}
