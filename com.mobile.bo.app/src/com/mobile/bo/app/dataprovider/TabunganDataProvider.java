package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.DetailTabunganData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.database.app.entities.DETAILTABUNGAN;
import com.mobile.database.app.entities.TABUNGAN;

public class TabunganDataProvider extends BaseDataProvider{
	
	/*public ArrayList<TabunganData> getAllTabungan() {
		ArrayList<TabunganData> retVal = new ArrayList<TabunganData>();
		List<TABUNGAN> qResult = null;
		
		if (isDaoTABUNGANExist()) {
			try {
				qResult = getDaoTABUNGAN().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (TABUNGAN rowData : qResult) {
					retVal.add(new TabunganData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public int getAllTabunganCount() {
		int retVal=0;
		
		if (isDaoTABUNGANExist()) {
			try {
				retVal = getDaoTABUNGAN().queryForAll().size();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		return retVal;
	}
	
	public TabunganData getTabungan(String id) {
		TabunganData retData = null;
		TABUNGAN qData = null;
		if (isDaoTABUNGANExist()) {
			try {
				qData = getDaoTABUNGAN().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new TabunganData(qData);
			}
		}
		return retData;
	}
	
	public ArrayList<TabunganData> getTabunganByDebitur(String debitur) {
		ArrayList<TabunganData> retVal = new ArrayList<TabunganData>();
		List<TABUNGAN> qResult = null;
		if (isDaoTABUNGANExist()) {
			try {
				qResult = getDaoTABUNGAN().queryBuilder().
						  where().like("NAMADEBITUR", "%"+debitur+"%").
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (TABUNGAN rowData : qResult) {
					retVal.add(new TabunganData(rowData));
				}
			}
		}
		return retVal;
	}
	
	public int updateTabungan(TabunganData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoTABUNGANExist()) {
			try {
				result = getDaoTABUNGAN().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	public void deleteTabunganById(String id) throws Exception{
		if (isDaoTABUNGANExist()) {
			DeleteBuilder<TABUNGAN, String> deleteBuilder = null;
			deleteBuilder = getDaoTABUNGAN().deleteBuilder();
			deleteBuilder.where().eq("NOMORREKENING", id);
			deleteBuilder.delete();
		}
	}
	
	public DetailTabunganData getDetailTabungan(String notabungan){
		DetailTabunganData retData = null;
		DETAILTABUNGAN qData = null;
		if (isDaoDetailTabunganExist()) {
			try {
				qData = getDaoDETAILTABUNGAN().queryForId(notabungan);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new DetailTabunganData(qData);
			}
		}
		return retData;
	}
	
	public ArrayList<DetailTabunganData> getDetailTabunganByCif(String cif) {
		ArrayList<DetailTabunganData> retVal = new ArrayList<DetailTabunganData>();
		List<DETAILTABUNGAN> qResult = null;
		
		if (isDaoTABUNGANExist()) {
			try {
				qResult = getDaoDETAILTABUNGAN().queryBuilder().				
						  where().like("CIF", cif).
						  query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (DETAILTABUNGAN rowData : qResult) {
					retVal.add(new DetailTabunganData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	
	public int updateDetailTabungan(DetailTabunganData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoDetailTabunganExist()) {
			try {
				result = getDaoDETAILTABUNGAN().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteAllTabungan(){
		if (isDaoTABUNGANExist()) {
			DeleteBuilder<TABUNGAN, String> dBuilder1 = getDaoTABUNGAN().deleteBuilder();
			try {
				dBuilder1.where().isNotNull("NOMORREKENING").prepare();
				dBuilder1.delete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dBuilder1 = null;
		}
	}*/
}
