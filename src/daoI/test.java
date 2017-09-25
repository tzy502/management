package daoI;

import java.util.ArrayList;
import java.util.List;

import dao.ChecklistDao;
import model.BeanChecklist;
import model.BeanCompany;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChecklistDao cd =new ChecklistDao();
		List<BeanChecklist> result =new ArrayList<BeanChecklist>();
		result=cd.loadChecklist(0);
	}
}
