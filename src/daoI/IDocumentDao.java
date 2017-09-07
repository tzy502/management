package daoI;

import java.util.List;

import model.BeanDocument;

public interface IDocumentDao {
	public void addDocument(BeanDocument Document);
	//添加角色
	public BeanDocument SearchDocument(int DocumentId);
	//搜索角色
	public List<BeanDocument> loadDocument(String DocumentName);
	//搜索角色
	public List<BeanDocument> loadDocument(int roleID);
	public List<BeanDocument> loadAllDocument();
	//搜索角色
	public void modifryDocument(BeanDocument Document);
	//修改角色
	public void delDocument(BeanDocument Document);
	//删除角色
}
