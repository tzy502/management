//package timer;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import model.BeanGas;
//import model.BeanStandard;
//import model.BeanWater;
//import serviceI.IDataService;
//import serviceI.IStandardService;
//import util.BaseException; 
//
//
//
//@Component("MonitorData") 
//public class MonitorData { 
//	@Autowired
//	private IDataService ids;
//	@Autowired
//	private IStandardService iss;
//    @Scheduled(cron = "0 * * * * ?") 
//    public void job1() { 
//    	long startTime = System.currentTimeMillis(); 
//    	
//    	List<BeanWater> water =new ArrayList<BeanWater>();
//    	List<BeanGas> gas =new ArrayList<BeanGas>();
//    	List<BeanStandard>  waterStandard=new ArrayList<BeanStandard>();
//    	List<BeanStandard>  gasStandard=new ArrayList<BeanStandard>();
//		try {
//			water=ids.loadnewwaterdata();
//			gas=ids.loadnewgasdata();
//			for(int j=0;j<50;j++){
//				
//			
//			for(int i=0;i<water.size();i++){
//				waterStandard=iss.loadStandard(water.get(i).getStationId());
//				
//				switch(waterStandard.get(i).getInfectid()) {  
//				
//				case "011":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getW011()){
//						System.out.println("1");
//					}
//					break;  
//				case "001":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getW001()){
//						System.out.println("1");
//					}
//					break;
//				case "B01":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getwB01()){
//						System.out.println("1");
//					}
//					break;
//				case "060":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getW060()){
//						System.out.println("1");
//					}
//					break;
//				case "065":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getW065()){
//						System.out.println("1");
//					}
//					break;
//				case "42":  
//					if(waterStandard.get(i).getVaule()<water.get(i).getW42()){
//						
//					}
//					break;
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
//				default:  
//					System.out.println("default");  
//				}  
//			}
//			}
//		} catch (BaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		long endTime = System.currentTimeMillis();  
//		
//		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
//    } 
//}
