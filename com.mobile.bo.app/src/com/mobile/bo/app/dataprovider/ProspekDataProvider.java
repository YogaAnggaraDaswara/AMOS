package com.mobile.bo.app.dataprovider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mobile.bo.app.datatype.ProspekData;
import com.mobile.bo.app.datatype.StateHistoryData;
import com.mobile.database.app.entities.PROSPEK;
import com.mobile.database.app.entities.STATEHISTORY;

public class ProspekDataProvider extends BaseDataProvider{
/*	private String PROSPEK_TYPE = "T01";
	private String RELEASED_TYPE = "T05";
	private String DELETED_TYPE = "T08";
	
	public ArrayList<ProspekData> getAllProspeks() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryForAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (PROSPEK rowData : qResult) {
					retVal.add(new ProspekData(rowData));
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<String> getAllProspekId(String stage) {
		ArrayList<String> retVal = new ArrayList<String>();
		List<PROSPEK> qResult = null;
		
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("STAGE", stage).and()
						  .eq("ISBLACKBOX", "0").and()
						  .eq("ISBLACKBOXFROMSERVER", "0")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (PROSPEK rowData : qResult) {
					retVal.add(rowData.getID().toString());
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<String> getAllNonBlackboxProspeks() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<PROSPEK> qResult = null;
		
		List<String> stagesToIgnore=new ArrayList<String>();
		stagesToIgnore.add(RELEASED_TYPE);
		stagesToIgnore.add(DELETED_TYPE);
		
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where().notIn("STAGE", stagesToIgnore).and()
						  .eq("ISBLACKBOX", "0").and()
						  .eq("ISBLACKBOXFROMSERVER", "0").and()
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				for (PROSPEK rowData : qResult) {
					retVal.add(rowData.getID().toString());
				}
			}
		}
		
		return retVal;
	}
	
	public ArrayList<String> getProspekById(String Id) {
		ArrayList<String> retVal = new ArrayList<String>();
		PROSPEK qData = null;
		
		if (isDaoPROSPEKExist()) {
			try {
				qData = getDaoPROSPEK().queryForId(Id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
					retVal.add(qData.getID().toString());
			}
		}
		
		return retVal;
	}
	
	public ProspekData getProspekDetail(String id) {
		ProspekData retData = null;
		PROSPEK qData = null;
		if (isDaoPROSPEKExist()) {
			try {
				qData = getDaoPROSPEK().queryForId(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qData != null) {
				retData = new ProspekData(qData);
			}
		}
		return retData;		
	}
	
	public void updateBlackbox(ArrayList<String> arrId) throws Exception{		
		if (isDaoPROSPEKExist()) {			
			for (int i=0;i<arrId.size();i++){
				ProspekData prospekData=getProspekDetail(arrId.get(i));
				prospekData.setISBLACKBOXFROMSERVER(false);
				prospekData.setISBLACKBOX(false);
				prospekData.setISPENDINGUPLOADED(false);
				updateProspek(prospekData);
				if (prospekData.getSTAGE().equalsIgnoreCase(PROSPEK_TYPE)){
					prospekData.setDATE(new Date());
					prospekData.setSUBMITDATE(null);
					prospekData.setPREVIOUSSTAGE(prospekData.getSTAGE());
				}
				else{
					prospekData.setSUBMITDATE(new Date());
					prospekData.setPREVIOUSSTAGE(prospekData.getSTAGE());
				}
				
				//StateHistoryData data=new StateHistoryData(prospekData.getAPREQNO(), arrId.get(i), prospekData.getSTAGE(), prospekData.getSUBMITDATE(), null);
				//updateStateHistory(data);
				
//				UpdateBuilder<PROSPEK, String> updatebuilder= null;
//				updatebuilder = getDaoPROSPEK().updateBuilder();
//				updatebuilder.updateColumnValue("ISBLACKBOXFROMSERVER", "0");
//				updatebuilder.updateColumnValue("ISBLACKBOX", "0");
//				updatebuilder.updateColumnValue("ISUPLOADED", "0");
//				updatebuilder.setWhere(updatebuilder.where().eq("ID", arrId.get(i).toString()));
//				updatebuilder.update();		
			}	
		}			
	}
	
	public ArrayList<ProspekData> getBlackboxFromServer() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("ISBLACKBOXFROMSERVER", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData));
					}
				}
			}
		}
		return retVal;
	}
	
	public ArrayList<ProspekData> getPendingUploadedBlackbox() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("ISBLACKBOX", "1").and()
						  .eq("ISBLACKBOXFROMSERVER", "0").and()
						  .eq("ISPENDINGUPLOADED", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData));
					}
				}
			}
		}
		return retVal;
	}
	
	public ArrayList<ProspekData> getPendingUploadedSubmittedProspek() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("ISBLACKBOX", "0").and()
						  .eq("ISBLACKBOXFROMSERVER", "0").and()
						  .eq("ISPENDINGUPLOADED", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData));
					}
				}
			}
		}
		return retVal;
	}
	
	public ArrayList<ProspekData> getPendingUploadedSubmittedProspekKenalanPendekatan() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("ISBLACKBOX", "0").and()
						  .eq("ISBLACKBOXFROMSERVER", "0").and()
						  .eq("ISPENDINGUPLOADED", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData));
					}
				}
			}
		}
		return retVal;
	}
	
	public ArrayList<ProspekData> getPendingUploadedDeletedProspek() {
		ArrayList<ProspekData> retVal = new ArrayList<ProspekData>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("STAGE", "T08").and()
						  .eq("ISPENDINGUPLOADED", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData));
					}
				}
			}
		}
		return retVal;
	}
	
	public ArrayList<String> getIdsPendingUpdatedProspek() {
		ArrayList<String> retVal = new ArrayList<String>();
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("ISPENDINGUPDATEDTOSERVER", "1")
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					for (PROSPEK rowData : qResult) {
						retVal.add(new ProspekData(rowData).getID());
					}
				}
			}
		}
		return retVal;
	}
	
	
	public ProspekData searchProspekAnd(String namaUsaha,String namaDebitur,String jenisUsaha,String jenisPembiayaan,String stage) {
		ProspekData retData = null;
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .like("NAMAUSAHA", "%"+namaUsaha+"%").and()
						  .like("NAMADEBITUR", "%"+namaDebitur+"%").and()
						  .eq("JENISUSAHA", jenisUsaha).and()
						  .eq("JENISPEMBIAYAAN", jenisPembiayaan).and()
						  .eq("ISBLACKBOXFROMSERVER", "0")
						  .eq("ISBLACKBOX", "0")
						  .like("STAGE", stage)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retData = new ProspekData(qResult.get(0));
				}
			}
		}
		return retData;
	}
	
	public ProspekData searchProspekOr(String namaUsaha,String namaDebitur,String jenisUsaha,String jenisPembiayaan,String stage) {
		ProspekData retData = null;
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						.like("NAMAUSAHA", "%"+(namaUsaha.equalsIgnoreCase("")?"NULL":namaUsaha)+"%").or()
						.like("NAMADEBITUR","%"+(namaDebitur.equalsIgnoreCase("")?"NULL":namaDebitur)+"%").or()
						.eq("JENISUSAHA", jenisUsaha.equalsIgnoreCase("")?"NULL":jenisUsaha).or()
						.eq("JENISPEMBIAYAAN", jenisPembiayaan.equalsIgnoreCase("")?"NULL":jenisPembiayaan).and()
						.eq("ISBLACKBOXFROMSERVER", "0").and()
						.eq("ISBLACKBOX", "0").and()
						.like("STAGE", stage)
						.query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retData = new ProspekData(qResult.get(0));
				}
			}
		}
		return retData;
	}
	
	public ProspekData getProspekByProspekId(String prospekid) {
		ProspekData retData = null;
		List<PROSPEK> qResult = null;
		if (isDaoPROSPEKExist()) {
			try {
				qResult = getDaoPROSPEK().queryBuilder().where()
						  .eq("PROSPEKID", prospekid)
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retData = new ProspekData(qResult.get(0));
				}
			}
		}
		return retData;
	}
	
	public int updateProspek(ProspekData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoPROSPEKExist()) {
			try {
				result = getDaoPROSPEK().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public void deleteProspekById(String id) throws Exception{
		if (isDaoPROSPEKExist()) {
			DeleteBuilder<PROSPEK, String> deleteBuilder = null;
			deleteBuilder = getDaoPROSPEK().deleteBuilder();
			deleteBuilder.where().eq("ID", id);
			deleteBuilder.delete();
		}
	}
	
	public void deleteProspekBlackbox() throws Exception{
		if (isDaoPROSPEKExist()) {
			DeleteBuilder<PROSPEK, String> deleteBuilder = null;
			deleteBuilder = getDaoPROSPEK().deleteBuilder();
			deleteBuilder.where().eq("ISBLACKBOXFROMSERVER", "1");
			deleteBuilder.delete();
		}
	}
	
	public int updateStateHistory(StateHistoryData data) {
		CreateOrUpdateStatus result;
		int retVal = 0;
		if (isDaoSTATEHISTORYExist()) {
			try {
				result = getDaoSTATEHISTORY().createOrUpdate(data.toRowData());
				retVal = result.getNumLinesChanged();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return retVal;		
	}
	
	public StateHistoryData searchStateHistoryData(String idProspek,String stage) {
		StateHistoryData retData = null;
		List<STATEHISTORY> qResult = null;
		if (isDaoSTATEHISTORYExist()) {
			try {
				qResult = getDaoSTATEHISTORY().queryBuilder().where()
						  .eq("PROSPEKIDLOCAL", idProspek).and()
						  .eq("STAGE", stage).and()
						  .query();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (qResult != null) {
				if (qResult.size() > 0){
					retData = new StateHistoryData(qResult.get(0));
				}
			}
		}
		return retData;
	}
	*/
}
