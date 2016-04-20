package com.mobile.services.app.services;
import org.json.JSONException;
import org.json.JSONObject;

import com.mobile.bo.app.datatype.ProspekData;

public class JSONTestTemporary {

	public static JSONObject getLogin() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'USERID':'budi','PASSWORD':'budi','NAME':'Budi Darmawan','POSITION':'Mitra A','LOCATION':'Cianjur','IMEI':'863352028342765','UNIT':'Cianjur'}");				
		
		return new JSONObject("{'result':{'RESULTS':["+sb.toString()+"],'STATUS':1}}");
	}
	
	public static JSONObject getLov() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'ID':'1','CODE':'1','DESCRIPTION':'Telepon','GROUP':'01','ORDERNUM':'1'},");
		sb.append("{'ID':'2','CODE':'2','DESCRIPTION':'SMS','GROUP':'01','ORDERNUM':'2'},");
		sb.append("{'ID':'3','CODE':'3','DESCRIPTION':'Kunjungan','GROUP':'01','ORDERNUM':'3'},");

		sb.append("{'ID':'3','CODE':'1','DESCRIPTION':'Rencana','GROUP':'02','ORDERNUM':'1'},");
		sb.append("{'ID':'4','CODE':'2','DESCRIPTION':'Realisasi','GROUP':'02','ORDERNUM':'2'},");

		sb.append("{'ID':'5','CODE':'1','DESCRIPTION':'<3 KM','GROUP':'03','ORDERNUM':'1'},");
		sb.append("{'ID':'6','CODE':'2','DESCRIPTION':'<5 KM','GROUP':'03','ORDERNUM':'2'},");
		sb.append("{'ID':'7','CODE':'3','DESCRIPTION':'<=10 KM','GROUP':'03','ORDERNUM':'3'},");
		sb.append("{'ID':'8','CODE':'4','DESCRIPTION':'>10 KM','GROUP':'03','ORDERNUM':'4'},");

		sb.append("{'ID':'9','CODE':'1','DESCRIPTION':'Dalam Pasar','GROUP':'04','ORDERNUM':'1'},");
		sb.append("{'ID':'10','CODE':'2','DESCRIPTION':'Sekitar Pasar','GROUP':'04','ORDERNUM':'2'},");

		sb.append("{'ID':'11','CODE':'1','DESCRIPTION':'Kelontong','GROUP':'05','ORDERNUM':'1'},");
		sb.append("{'ID':'12','CODE':'2','DESCRIPTION':'Daging','GROUP':'05','ORDERNUM':'2'},");
		sb.append("{'ID':'13','CODE':'3','DESCRIPTION':'Warung','GROUP':'05','ORDERNUM':'3'},");

		sb.append("{'ID':'14','CODE':'1','DESCRIPTION':'Minna/Reguler','GROUP':'06','ORDERNUM':'1'},");
		sb.append("{'ID':'15','CODE':'2','DESCRIPTION':'Kios Tipe A','GROUP':'06','ORDERNUM':'2'},");
		sb.append("{'ID':'16','CODE':'3','DESCRIPTION':'Kebun','GROUP':'06','ORDERNUM':'3'},");

		sb.append("{'ID':'17','CODE':'1','DESCRIPTION':'Prospek','GROUP':'07','ORDERNUM':'1'},");
		sb.append("{'ID':'18','CODE':'2','DESCRIPTION':'Kenalan','GROUP':'07','ORDERNUM':'2'},");
		sb.append("{'ID':'19','CODE':'3','DESCRIPTION':'Pendekatan','GROUP':'07','ORDERNUM':'3'},");
		sb.append("{'ID':'20','CODE':'4','DESCRIPTION':'Closing','GROUP':'07','ORDERNUM':'4'},");

		sb.append("{'ID':'20','CODE':'1','DESCRIPTION':'Unit','GROUP':'08','ORDERNUM':'1'},");
		sb.append("{'ID':'21','CODE':'2','DESCRIPTION':'Direksi','GROUP':'08','ORDERNUM':'2'}");
		
		return new JSONObject("{'result':{'RESULTS':["+sb.toString()+"],'STATUS':1}}");
	}
	
	public static JSONObject getTabungan() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'NOMORREKENING':'123456789','NAMADEBITUR':'John Petrak','ALAMAT':'Brisbane','JENISTABUNGAN':'Tipe 1'},");
		sb.append("{'NOMORREKENING':'234567894','NAMADEBITUR':'Daniel Walder','ALAMAT':'Sidney','JENISTABUNGAN':'Tipe 2'},");
		sb.append("{'NOMORREKENING':'345678956','NAMADEBITUR':'Frans Juanda','ALAMAT':'Jakarta','JENISTABUNGAN':'Tipe 3'}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getTagihan() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'ID':'1','NOMORREKENING':'123456789','NAMADEBITUR':'John Petrak','ALAMAT':'Brisbane','JENISPINJAMAN':'Tipe 1','TENOR':'12 bulan','TANGGALCAIR':'16-9-2014','POKOKPINJAMAN':'28500000','BUNGAPINJAMAN':'1500000','TOTALPINJAMAN':'30000000','TOTALCICILAN':'22500000','SISAPINJAMAN':'7500000','TAGIHAN':'2500000'},");
		sb.append("{'ID':'2','NOMORREKENING':'234567890','NAMADEBITUR':'Daniel Walder','ALAMAT':'Sidney','JENISPINJAMAN':'Tipe 2','TENOR':'6 bulan','TANGGALCAIR':'16-9-2014','POKOKPINJAMAN':'28500000','BUNGAPINJAMAN':'1500000','TOTALPINJAMAN':'30000000','TOTALCICILAN':'22500000','SISAPINJAMAN':'7500000','TAGIHAN':'2500000'},");
		sb.append("{'ID':'3','NOMORREKENING':'345678967','NAMADEBITUR':'Frans Juanda','ALAMAT':'Jakarta','JENISPINJAMAN':'Tipe 3','TENOR':'3 bulan','TANGGALCAIR':'16-9-2014','POKOKPINJAMAN':'28500000','BUNGAPINJAMAN':'1500000','TOTALPINJAMAN':'30000000','TOTALCICILAN':'22500000','SISAPINJAMAN':'7500000','TAGIHAN':'2500000'}");		
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getBlackboxRetrieval() throws JSONException{
		StringBuilder sb = new StringBuilder();
    	
		for (int i=1;i<=4;i++){
			String type="T0"+(i);
			sb.append("{'USERID':'Budi','LATITUDE':'100.20788','LONGITUDE':'200.678847','DATE':'16-9-2014'," +
						"'TIME':'9:30:20','NAMAUSAHA':'USAHA "+(i)+"','ALAMATUSAHA':'JALAN KEBAGUSAN NO 1',"+
						"'JENISUSAHA':'1','RADIUS':'1','KOMUNITAS':'1','NAMADEBITUR':'SURYADI'," +
						"'TGLLAHIR':'21-08-1985','JENISPEMBIAYAAN':'1','HANDPHONE':'02174774774','FOTOLOKASI':''," +
						"'TELEPONRUMAH':'09857757','ALAMATRUMAH':'KEBAYORAN BARU NO 1','PLAFOND':'300000','KTP':'67885555'," +
						"'NPWP':'09857757','SIUPSKU':'s01','PROSPEKID':'123_"+(i)+"','SUBMITDATE':'67885555'," +
						"'STAGE':'"+type+"','ISBLACKBOX':'1','ISUPLOADED':'0',"+
						"'FOLLOWUP':[{'STATUS':'1','CATATAN':'catatan 1','ISEDITABLE':'1','ACTION':'1',NEXTFOLLOWUP:'18-9-2014'}]}");
			if (i<4){
				sb.append(",");
			}
		}
    	
    	return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
    }
	
	public static JSONObject getStatistikData() throws JSONException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("{'TANGGAL':'15-9-2014','TARGETPROSPEK':'20','TARGETKENALAN':'30','TARGETPENDEKATAN':'40','TARGETCLOSING':'50',");
		sb.append("'AKTUAL':[{'TANGGAL':'01-9-2014','JUMLAHPROSPEK':'5','JUMLAHKENALAN':'7','JUMLAHPENDEKATAN':'2','JUMLAHCLOSING':'3','JUMLAHBLACKBOX':'2','USERID':'BUDI'},");
		sb.append("{'TANGGAL':'01-9-2014','JUMLAHPROSPEK':'6','JUMLAHKENALAN':'7','JUMLAHPENDEKATAN':'3','JUMLAHCLOSING':'4','JUMLAHBLACKBOX':'3','USERID':'BUDI'},");
		sb.append("{'TANGGAL':'02-9-2014','JUMLAHPROSPEK':'7','JUMLAHKENALAN':'8','JUMLAHPENDEKATAN':'9','JUMLAHCLOSING':'10','JUMLAHBLACKBOX':'4','USERID':'BUDI'},");
		sb.append("{'TANGGAL':'02-9-2014','JUMLAHPROSPEK':'2','JUMLAHKENALAN':'8','JUMLAHPENDEKATAN':'3','JUMLAHCLOSING':'15','JUMLAHBLACKBOX':'5','USERID':'BUDI'},");
		sb.append("{'TANGGAL':'02-9-2014','JUMLAHPROSPEK':'7','JUMLAHKENALAN':'7','JUMLAHPENDEKATAN':'4','JUMLAHCLOSING':'16','JUMLAHBLACKBOX':'6','USERID':'BUDI'}]}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getMotionTrackerData() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'TANGGAL':'15-9-2014',");
		sb.append("'AKTUAL':[{'USERID':'BUDI','JUMLAHPROSPEK':'6','JUMLAHKENALAN':'7','JUMLAHPENDEKATAN':'3','JUMLAHCLOSING':'4',");
		sb.append("'MAP':[{'ID':'1','LATITUDE':'-18.142','LONGITUDE':'178.431'},{'ID':'2','LATITUDE':'-33.866','LONGITUDE':'151.195'},{'ID':'3','LATITUDE':'-18.142','LONGITUDE':'178.431'}]},");
		sb.append("{'USERID':'SARAH','JUMLAHPROSPEK':'6','JUMLAHKENALAN':'7','JUMLAHPENDEKATAN':'3','JUMLAHCLOSING':'4',");
		sb.append("'MAP':[{'ID':'1','LATITUDE':'21.291','LONGITUDE':'-157.821'},{'ID':'2','LATITUDE':'37.423','LONGITUDE':'-122.091'}]}]}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getMitra() throws JSONException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("{'USERID':'Budi','NAME':'Budi Darmawan'},");
		sb.append("{'USERID':'Sarah','NAME':'Sarah Sechan'},");
		sb.append("{'USERID':'Andi','NAME':'Andi Setiawan'},");
		sb.append("{'USERID':'Dini','NAME':'Dini Aminarti'}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getCashPickup() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'TOTALTABUNGAN':'400000','TOTALTAGIHAN':'7250000','TOTALCASHPICKUP':'7650000',");
		sb.append("'TABUNGAN':[{'NOMORREKENING':'123456','NAMADEBITUR':'John Petrak','JUMLAHTABUNGAN':'250000'},{'NOMORREKENING':'234567','NAMADEBITUR':'Daniel Walder','JUMLAHTABUNGAN':'450000'},{'NOMORREKENING':'345678','NAMADEBITUR':'Frans Simanjuntak','JUMLAHTABUNGAN':'550000'}],");
		sb.append("'TAGIHAN':[{'NOMORREKENING':'57890','NAMADEBITUR':'Renato Saksanni','TAGIHAN':'650000'},{'NOMORREKENING':'789012','NAMADEBITUR':'Harta Pangestu','TAGIHAN':'150000'},{'NOMORREKENING':'679046','NAMADEBITUR':'Aryo James','TAGIHAN':'110000'}]}");
				
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getMessages() throws JSONException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("{'ID':'1','FROM':'Budi','SUBJECT':'Follow Up 1','MESSAGE':'Ini sebuah pesan singkat 1','DATE':'15-9-2014'},");
		sb.append("{'ID':'2','FROM':'Noni','SUBJECT':'Follow Up 2','MESSAGE':'Ini sebuah pesan singkat 2','DATE':'30-9-2014'}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	public static JSONObject getNews() throws JSONException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("{'ID':'1','FROM':'Budi','SUBJECT':'Follow Up 1','MESSAGE':'Ini sebuah pesan singkat 1','DATE':'15-9-2014'},");
		sb.append("{'ID':'2','FROM':'Noni','SUBJECT':'Follow Up 2','MESSAGE':'Ini sebuah pesan singkat 2','DATE':'30-9-2014'}");
		
		return new JSONObject("{'result':["+sb.toString()+"],'status':1}");
	}
	
	// post data
	public static JSONObject getStatusUploadProspek(ProspekData prospekData) throws JSONException{
		StringBuilder sb = new StringBuilder();
		String prospekidlocal = prospekData.getID().toString();
		String prospekid = "5635_"+prospekidlocal;
		sb.append("{'PROSPEKID':"+prospekid+",'ID':"+prospekidlocal+",'STATUS':'1'}");
    	
    	return new JSONObject("result:{'RESULTS':["+sb.toString()+"],'STATUS':1}}");
	}
		
	public static JSONObject uploadDataProspekResponseSuccess(ProspekData prospekData) throws JSONException{
		String prospekidlocal = prospekData.getID().toString();
		String prospekid = "5635_"+prospekidlocal;
		String obj = "{'PROSPEKID':"+prospekid+",'ID':"+prospekidlocal+",'STATUS':'1'}";
    	
    	return new JSONObject(obj);	
	}
	
	public static JSONObject uploadDataProspekResponseFailed(ProspekData prospekData) throws JSONException{
		String prospekidlocal = prospekData.getID().toString();
		String prospekid = "5635_"+prospekidlocal;
		String obj = "{'PROSPEKID':"+prospekid+",'ID':"+prospekidlocal+",'STATUS':'0'}";
    	
    	return new JSONObject(obj);	
	}
	
	public static JSONObject getStatusResponse() throws JSONException{
		StringBuilder sb = new StringBuilder();
	
    	return new JSONObject("{result:{'RESULTS':["+sb.toString()+"],'STATUS':0}}");
	}
	
	public static JSONObject getScheduler() throws JSONException{
		StringBuilder sb = new StringBuilder();
		
		sb.append("{'ID':'1','TYPE':'1','INTERVAL':'60000','START':'07:00','END':'23:00'},");
		sb.append("{'ID':'2','TYPE':'1','INTERVAL':'60000','START':'07:01','END':'23:01'},");
		sb.append("{'ID':'3','TYPE':'1','INTERVAL':'60000','START':'07:02','END':'23:02'},");
		sb.append("{'ID':'4','TYPE':'1','INTERVAL':'60000','START':'07:03','END':'23:03'},");
		sb.append("{'ID':'5','TYPE':'1','INTERVAL':'60000','START':'07:04','END':'23:04'},");
		sb.append("{'ID':'6','TYPE':'1','INTERVAL':'60000','START':'07:05','END':'23:05'},");
		sb.append("{'ID':'7','TYPE':'1','INTERVAL':'60000','START':'07:06','END':'23:06'},");
		sb.append("{'ID':'8','TYPE':'1','INTERVAL':'60000','START':'07:07','END':'23:07'},");
		sb.append("{'ID':'9','TYPE':'1','INTERVAL':'60000','START':'07:08','END':'23:08'},");
		sb.append("{'ID':'10','TYPE':'1','INTERVAL':'60000','START':'07:09','END':'23:09'}");

		
		return new JSONObject("{'result':{'RESULTS':["+sb.toString()+"],'STATUS':1}}");
	}
}
