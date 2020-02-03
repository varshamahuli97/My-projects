package com.employee.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.employee.util.EmployeeUtility;

public class EmployeeService {
	
	 private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
   

	public void ReadCredentials() throws GeneralSecurityException, IOException {
	
		final String spreadsheetId = "13IKvwaXjyuVrpsmm5zZlYAs7c8U1Z5Sv6Nyp69ek_Ps";
	    final String range = "A2:E6";
	    System.out.println(spreadsheetId);
	    Sheets service = EmployeeUtility.getSheetService();
	    ValueRange result = service.spreadsheets().values().get(spreadsheetId, range).execute();
	    int numRows = result.getValues() != null ? result.getValues().size() : 0;
	    System.out.printf("%d rows retrieved.", numRows);
	    /*ValueRange response = service.spreadsheets().values()
        //.get(spreadsheetId, range)
          
            .execute();
  List<List<Object>> values = response.getValues();
    if (values == null || values.isEmpty()) {
        System.out.println("No data found.");s
    } else {
      System.out.println("Name, Major");
      for (List row : values) {
          // Print columns A and E, which correspond to indices 0 and 4.
           System.out.printf("%s, %s\n", row.get(0), row.get(4));
    }
   }*/
	}
}
