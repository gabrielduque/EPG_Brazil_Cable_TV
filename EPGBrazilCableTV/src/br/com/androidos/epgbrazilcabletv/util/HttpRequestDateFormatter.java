package br.com.androidos.epgbrazilcabletv.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import com.google.inject.Singleton;

@Singleton
public class HttpRequestDateFormatter {
	@SuppressLint("SimpleDateFormat")
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Date startingDate;
	private Date endingDate;
	
	public HttpRequestDateFormatter(){
		
	}

	public HttpRequestDateFormatter(Date startingDate, Date endingDate) {
		this.startingDate = (Date)startingDate.clone();
		this.endingDate = (Date) endingDate.clone();

	}
	
	public String getStartingDate() {
		return getFormattedStartingDate();
	}
	
	public String getEndingDate() {
		return getFormattedEndingDate();
	}
	
	private String getFormattedStartingDate(){
		return String.format("%sT00:30:00Z TO %sT23:59:00Z", dateFormat.format(this.startingDate), dateFormat.format(this.startingDate));
	}
	
	private String getFormattedEndingDate(){
		return String.format("%sT00:31:00Z TO %sT00:00:00Z", dateFormat.format(this.startingDate), dateFormat.format(this.endingDate));
	}
	
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

}