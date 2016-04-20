package com.mobile.bo.app.dataprovider;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.DataType_Amos_Debitur_Int;
import com.mobile.database.app.entities.AMOS_ENTRY_DEBITUR_INT;
import com.mobile.framework.common.DateFormatter;

public class Amos_Entry_Debitur extends BaseDataProvider {
	public ArrayList<DataType_Amos_Debitur_Int> getAllAmos_Entry_Debitur(String userid) {
		ArrayList<DataType_Amos_Debitur_Int> retVal = new ArrayList<DataType_Amos_Debitur_Int>();
		List<AMOS_ENTRY_DEBITUR_INT> qResult = null;
		
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().eq("USERID", userid).query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_ENTRY_DEBITUR_INT rowData : qResult) {
					//retVal=(new DataType_Amos_Debitur_Int(rowData));
					
					retVal.add(new DataType_Amos_Debitur_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<DataType_Amos_Debitur_Int> getAllAmos_Entry_Debitur_Filter(String namaDebitur, String tglLhrDebitur) {
		ArrayList<DataType_Amos_Debitur_Int> retVal = new ArrayList<DataType_Amos_Debitur_Int>();
		List<AMOS_ENTRY_DEBITUR_INT> qResult = null;
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				
				if(!tglLhrDebitur.equalsIgnoreCase("")) {
					String tglLhr = DateFormatter.formatStringYYYYMMdd(DateFormatter.formatDate(tglLhrDebitur), false);
					
					Object[] tglLhr_sptt = tglLhr.split("/");
					
					StringBuilder joinS = new StringBuilder();
					
					for(int con = 0; con < tglLhr_sptt.length; con ++) {
						
						joinS.append(tglLhr_sptt[con]);
					}
					tglLhrDebitur = joinS.toString();
				}
				
				if(!namaDebitur.equalsIgnoreCase("") && tglLhrDebitur.equalsIgnoreCase("")) 
				{
					qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().like("CU_FULLNM", "%"+(namaDebitur.equalsIgnoreCase("")?"NULL":namaDebitur)+"%").query();
				} else if(namaDebitur.equalsIgnoreCase("") && !tglLhrDebitur.equalsIgnoreCase(""))
				{
					qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().eq("CU_BORNDATE", tglLhrDebitur).query();
				} else 
				{
					qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().like("CU_FULLNM", "%"+(namaDebitur.equalsIgnoreCase("")?"NULL":namaDebitur)+"%").and()
							.eq("CU_BORNDATE", tglLhrDebitur).query();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_ENTRY_DEBITUR_INT rowData : qResult) {
					//retVal=(new DataType_Amos_Debitur_Int(rowData));
					
					retVal.add(new DataType_Amos_Debitur_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public DataType_Amos_Debitur_Int getAllAmos_Entry_Debitur_by_seq(String ID) {
		DataType_Amos_Debitur_Int retVal = new DataType_Amos_Debitur_Int();
		List<AMOS_ENTRY_DEBITUR_INT> qResult = null;
		
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().eq("ID", ID).and().query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_ENTRY_DEBITUR_INT rowData : qResult) {
					retVal=(new DataType_Amos_Debitur_Int(rowData));
					
					//retVal.add(new DataType_Amos_Debitur_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	public ArrayList<DataType_Amos_Debitur_Int> getAllAmos_Entry_Debitur_list(String ID) {
		ArrayList<DataType_Amos_Debitur_Int> retVal = new ArrayList<DataType_Amos_Debitur_Int>();
		List<AMOS_ENTRY_DEBITUR_INT> qResult = null;
		
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().where().eq("ID", ID).and().query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_ENTRY_DEBITUR_INT rowData : qResult) {
					retVal.add(new DataType_Amos_Debitur_Int(rowData));
				}
			}
		}
		
		return retVal;
	}
	public int getAllAmos_Entry_Debitur_by_MaxSeq(String COL_ID) {
		DataType_Amos_Debitur_Int retVal = new DataType_Amos_Debitur_Int();
		List<AMOS_ENTRY_DEBITUR_INT> qResult = null;
		
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				qResult = getAMOS_ENTRY_DEBITUR_INT().queryBuilder().orderByRaw("SEQ desc").query();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (AMOS_ENTRY_DEBITUR_INT rowData : qResult) {
					retVal=(new DataType_Amos_Debitur_Int(rowData));
					break;
					//retVal.add(new DataType_Amos_Debitur_Int(rowData));
				}
			}
		}
		
		try{
			return Integer.parseInt(retVal.getSEQ().toString()) +1 ;
		}
		catch(Exception ex){
			
			return 1 ;
		}
		
		
	}
	
	public int updateData(DataType_Amos_Debitur_Int data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			try {
				result = getAMOS_ENTRY_DEBITUR_INT().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteTransaksiById(String id) throws Exception{
		if (isDaoAMOS_ENTRY_DEBITUR_INTExist()) {
			DeleteBuilder<AMOS_ENTRY_DEBITUR_INT, String> deleteBuilder = null;
			deleteBuilder = getAMOS_ENTRY_DEBITUR_INT().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}

}
